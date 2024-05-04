import paho.mqtt.client as mqtt

# Configuração MQTT
MQTT_BROKER = "broker.mqttdashboard.com"
TEMPERATURE_TOPIC = "dht/temperature"

# Callback executado quando uma mensagem MQTT é recebida
def on_message(client, userdata, message):
    temperatura = round(float(message.payload.decode()), 2)

    if (temperatura > 32.0):
        diferenca_temp = round(temperatura - 32, 2)
        print(f"Temperatura muito alta: {temperatura}ºC. Uma diferença de {diferenca_temp}ºC", )
    else:
        print(f"Temperatura {temperatura}ºC")

# Configuração do cliente MQTT
client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2, "Jodie2")
client.on_message = on_message

# Conexão ao broker MQTT e subscrição aos tópicos
client.connect(MQTT_BROKER)
client.subscribe(TEMPERATURE_TOPIC)

#Caso eu queria algo semelhante ao while true da ESP32
while True:
    client.loop(timeout=0.1)