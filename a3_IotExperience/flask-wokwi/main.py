# app.py
from flask import Flask, render_template, request
#from login import login
#from sensors import sensor_
#from actuators import actuator_
from flask_mqtt import Mqtt
import json

app= Flask(__name__)

app.config['MQTT_BROKER_URL'] = 'mqtt-dashboard.com'
app.config['MQTT_BROKER_PORT'] = 1883
app.config['MQTT_USERNAME'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_PASSWORD'] = ''  # Set this item when you need to verify username and password
app.config['MQTT_KEEPALIVE'] = 1500  # Set KeepAlive time in seconds
app.config['MQTT_TLS_ENABLED'] = False  # If your broker supports TLS, set it True

#Objeto MQTT
mqtt_client= Mqtt()
mqtt_client.init_app(app)

estado_verde = "0"
bits = {}
i = 0

#https://stackoverflow.com/questions/19794695/flask-python-buttons

topic_subscribe = "led/publish"

@app.route("/")
def home():
    return render_template("home.html")

@app.route("/sensores")
def sensores():
    return render_template("sensores.html", bits=bits)


@app.route("/atuadores")
def atuadores():
    return render_template("atuadores.html")


@mqtt_client.on_connect()
def handle_connect(client, userdata, flags, rc):
    if rc == 0:
        print('Broker Connected successfully')
        mqtt_client.publish("led/subscribe", "Conectado!")
        mqtt_client.subscribe(topic_subscribe) # subscribe topic
    else:
        print('Bad connection. Code:', rc)

@mqtt_client.on_disconnect()
def handle_disconnect(client, userdata, rc):
    print("Disconnected from broker")


#o cliente aqui publica o valor, ou seja, ativa o botão
@app.route("/publish_data", methods=['GET', 'POST'])
def publish_data():
    global estado_verde
    if request.method == 'POST':
        if request.form.get("activate_btn") == "0":
            estado_verde = "1"
            request.form["activate_btn"] = "1"
        else:
            estado_verde = "0"
            request.form["activate_btn"] = "0"

    print(estado_verde)
    mqtt_client.publish(topic = 'led/subscribe', payload = bytes(estado_verde, "utf-8"))

    return render_template("atuadores.html")

#recebe o valor e imprime na tabela
@mqtt_client.on_message()
def handle_mqtt_message(client, userdata, message):
    global bits
    global i
    js = json.loads(message.payload.decode())
    print(js)

    i += 1
    bits[i] = str(js)


#Esse código só vai rodar abaixo será executado somente se o nome do arquivo for igual a __main__
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8080, debug=False)