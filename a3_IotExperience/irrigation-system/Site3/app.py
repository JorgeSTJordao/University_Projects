from flask import Blueprint, Flask, render_template, request ,url_for
from flask_mqtt import Mqtt
from gestao import gestao
import json



app = Flask(__name__)
app.register_blueprint(gestao, url_prefix='/')  

app.config['MQTT_BROKER_URL'] = 'mqtt-dashboard.com'
app.config['MQTT_BROKER_PORT'] = 1883
app.config['MQTT_USERNAME'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_PASSWORD'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_KEEPALIVE'] = 1000  # Set KeepAlive time in seconds
app.config['MQTT_TLS_ENABLED'] = False  # If your broker supports TLS, set it True

#Objeto MQTT
mqtt_client= Mqtt()
mqtt_client.init_app(app)

estado = "0"
bits = {}
i = 0

topic_subscribe = "led/publish"  #subscribe  /publish


@app.route('/')
def index():
    global bits
    return render_template("login.html",bits=bits)



@mqtt_client.on_connect()
def handle_connect(client, userdata, flags, rc):
    if rc == 0:
        print('Broker Connected successfully')
        mqtt_client.publish("Funcionou!")
        mqtt_client.subscribe(topic_subscribe) # subscribe topic
    else:
        print('Bad connection. Code:', rc)

@mqtt_client.on_disconnect()
def handle_disconnect(client, userdata, rc):
    print("Disconnected from broker")

@mqtt_client.on_message()
def handle_mqtt_message(client, userdata, message):
    global bits
    js = json.loads(message.payload.decode())
    print(js)
    bits[''] = js



if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8080, debug=True)