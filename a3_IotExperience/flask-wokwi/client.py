import paho.mqtt.client as mqtt

# Configuração MQTT
MQTT_BROKER = "broker.mqttdashboard.com"
MQTT_TOPIC_SEND = "led/publish"
MQTT_TOPIC_RECEIVE = "led/subscribe"

# Callback executado quando uma mensagem MQTT é recebida
def on_message(client, userdata, message):
    print("Frase recebida: ", message.payload.decode())
    client.publish(MQTT_TOPIC_RECEIVE, "é isso ai")  # Envia "ok" como resposta


# Configuração do cliente MQTT
client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2, "Jodie2")
client.on_message = on_message

# Conexão ao broker MQTT e subscrição aos tópicos
client.connect(MQTT_BROKER)
client.subscribe(MQTT_TOPIC_SEND)

print("Certo")

#Caso eu queria algo semelhante ao while true da ESP32
while True:
    client.loop(timeout=0.1)