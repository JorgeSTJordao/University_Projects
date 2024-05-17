from flask import Flask, render_template, request,redirect, url_for,jsonify
from flask_mqtt import Mqtt
import json

app= Flask(__name__)

app.config['MQTT_BROKER_URL'] = 'mqtt-dashboard.com'
app.config['MQTT_BROKER_PORT'] = 1883
app.config['MQTT_USERNAME'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_PASSWORD'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_KEEPALIVE'] = 3  # Set KeepAlive time in seconds
app.config['MQTT_TLS_ENABLED'] = False  # If your broker supports TLS, set it True
app.config['TEMPLATES_AUTO_RELOAD'] = True

mqtt_client = Mqtt()
mqtt_client.init_app(app)

topic_publish = "irrigacao/receber"
topic_subscribe = "irrigacao/enviar"

i = 0
bits = {}


@app.route('/')
def index():
    return render_template("home.html")


@app.route("/sensor")
def sensor():
    global bits
    return render_template("sensor.html", bits=bits)


@app.route("/atuador")
def atuador():
    return render_template("atuador.html")


@app.route('/publish_message', methods=['GET','POST'])
def publish_message():
    request_data = request.get_json()
    publish_result = mqtt_client.publish(request_data['topic'], request_data['message'])
    return jsonify(publish_result)


@mqtt_client.on_message()
def handle_mqtt_message(client, userdata, message):
    global i
    global bits

    valor = json.loads(message.payload.decode())
    i += 1
    bits[i] = valor


@mqtt_client.on_connect()
def handle_connect(client, userdata, flags, rc):
    if rc == 0:
        print('Broker Connected successfully')
        mqtt_client.subscribe(topic_subscribe)
    else:
        print('Bad connection. Code:', rc)


@mqtt_client.on_disconnect()
def handle_disconnect(client, userdata, rc):
    print("Disconnected from broker")


if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0')
