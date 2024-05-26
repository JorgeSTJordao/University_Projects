#app_controller.py

#Trabalha com a regra de negócios
import json
from flask import Flask, render_template, request, jsonify
from models.db import db, instance
from controllers.sensors_controller import sensor_
from controllers.actuators_controller import actuator_
from controllers.reads_controller import read
from controllers.writes_controller import write
from models.iot.sensors import Sensor
from models.iot.actuators import Actuator
from models.iot.read import Read
from models.iot.write import Write
from flask_mqtt import Mqtt

#direcionada para o app.py, responsável por configurar todos os arquivos
def create_app():
    app = Flask(
        __name__,
        template_folder="./views/",
        static_folder="./static/",
        root_path="./")


    #armazena as páginas em html
    app.register_blueprint(sensor_, url_prefix='/')
    app.register_blueprint(actuator_, url_prefix='/')
    app.register_blueprint(read, url_prefix='/')
    app.register_blueprint(write, url_prefix='/')

    #configura o banco de dados
    app.config['TESTING'] = False
    app.config['SECRET_KEY'] = 'generated-secret-key'
    app.config['SQLALCHEMY_DATABASE_URI'] = instance
    db.init_app(app)

    app.config['MQTT_BROKER_URL'] = 'mqtt-dashboard.com'
    app.config['MQTT_BROKER_PORT'] = 1883
    app.config['MQTT_USERNAME'] = ''  # Set this item when you need to verify username and password
    app.config['MQTT_PASSWORD'] = ''  # Set this item when you need to verify username and password
    app.config['MQTT_KEEPALIVE'] = 5000  # Set KeepAlive time in seconds
    app.config['MQTT_TLS_ENABLED'] = False  # If your broker supports TLS, set it True

    mqtt_client = Mqtt()
    mqtt_client.init_app(app)

    topic_subscribe = "dht22/state"

    @mqtt_client.on_connect()
    def handle_connect(client, userdata, flags, rc):
        if rc == 0:
            print('Broker Connected successfully')
            mqtt_client.subscribe(topic_subscribe) #subscribe topic
        else:
            print('Bad connection. Code:', rc)

    @mqtt_client.on_disconnect()
    def handle_disconnect(client, userdata, rc):
        print("Disconnected from broker")

    @app.route('/publish_message', methods=['GET', 'POST'])
    def publish_message():
        request_data = request.get_json()
        print(request_data)
        publish_result = mqtt_client.publish(request_data['topic'], request_data['message'])

        try:
            Write.save_write(request_data['topic'], request_data['message'])
        except:
            pass

        return jsonify(publish_result)

    @mqtt_client.on_message()
    def handle_mqtt_message(client, userdata, message):
        if(message.topic==topic_subscribe):
            js = json.loads(message.payload.decode())
            print(js["sensor"])
            print(js["valor"])
            try:
                with app.app_context():
                    Read.save_read(js["sensor"], js["valor"])
            except:
                pass


    #página home
    @app.route('/')
    def index():
        return render_template("home.html")

    #outra também
    @app.route('/home')
    def home():
        return render_template("home.html")

    return app
