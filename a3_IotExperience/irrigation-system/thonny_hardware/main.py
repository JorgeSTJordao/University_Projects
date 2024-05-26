from machine import Pin, ADC
from hcsr04 import HCSR04
from umqtt.simple import MQTTClient
import time
import network
import json

# Configurao MQTT
MQTT_CLIENT_ID = "conect demo"
MQTT_BROKER = "broker.mqttdashboard.com"
MQTT_TOPIC_SEND = "irrigacao/enviar"
MQTT_TOPIC_RECEIVE = "irrigacao/receber"


# Funo de callback para recebimento de mensagens MQTT
def callback(topic, msg):
    mensagem = msg.decode()
    mensagem_list = json.loads(mensagem)
    
    if len(mensagem_list) != 0 and len(mensagem_list) % 2 == 0:
        tempo_espera = mensagem_list[0]
        tempo_atividade = mensagem_list[1]
        if  tempo_espera > 0:
            desligar_bomba()
            print("Aguarda ", tempo_espera, " segundos")
            time.sleep(tempo_espera)
            
            ligar_bomba()
            print("Executa por ", tempo_atividade, " segundos")
            time.sleep(tempo_atividade)
            desligar_bomba()
        

# Conexo  rede Wi-Fi
wifi = network.WLAN(network.STA_IF)
wifi.active(True)

while not wifi.isconnected():
    try:
        wifi.connect("VISITANTES", "")
        time.sleep(1)
    except:
        pass

print("Conectado a rede")

# Configurao do cliente MQTT
client = MQTTClient(MQTT_CLIENT_ID, MQTT_BROKER)
client.set_callback(callback)

# Conexo e subscrio aos tpicos MQTT
client.connect()
client.subscribe(MQTT_TOPIC_RECEIVE)

#sensor de umidade (sensor)
moisture = ADC(Pin(32))
moisture.atten(moisture.ATTN_11DB)
moisture.width(moisture.WIDTH_12BIT)

#sensor ultrassnico (sensor)
sensor_ultrassonico = HCSR04(trigger_pin=33, echo_pin=25, echo_timeout_us=1000000)

#bomba e rele (2 atuadores)
pino_rele = Pin(26, Pin.OUT)

# leitura do quo mido est o solo
def read_moisture_percentage():
    
    #ler os dados do sensor
    moisture_value = moisture.read()

    #ajusta no valor de bits
    inverted_moisture_value = 4095 - moisture_value
    
    #converte para porcentagem
    moisture_percentage = (inverted_moisture_value / 4095) * 100
    
    if (moisture_percentage < 20):
        ligar_bomba()
        print("SECO: ")
        client.publish(MQTT_TOPIC_SEND, str(moisture_percentage))
    else:
        desligar_bomba()
        print("ÚMIDO: ")
        client.publish(MQTT_TOPIC_SEND, str(moisture_percentage))
    
    return moisture_percentage

# Funo bomba
def ligar_bomba():
    # 1 - ativada
    pino_rele.value(1) 

def desligar_bomba():
    #0 - desativada
    pino_rele.value(0) 

# Funo sensor ultrassnico
def medir_distancia():
    #distncia
    distancia_cm = sensor_ultrassonico.distance_cm()  
    
    return distancia_cm


desligar_bomba()
DISTANCIA_TOTAL = 9.52

try:
    while True:       
        moisture_percentage = read_moisture_percentage()
        print("Umidade do solo:", moisture_percentage, "%")

        client.check_msg()

        #distncia
        distancia = medir_distancia()
        
        #por enquanto permanece a mesma
        print("Distancia: {:.2f} cm".format(abs(distancia - DISTANCIA_TOTAL)))
        
        time.sleep(1)
        print("---------------------")

except KeyboardInterrupt:
    desligar_bomba()
    print("Programa encerrado pelo usuário")