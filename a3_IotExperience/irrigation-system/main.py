from machine import Pin, ADC
from time import sleep

#Micropython - Sensor de umidade
#https://www.elec-cafe.com/esp32-with-soil-moisture-sensor-and-lcd-using-micropython/

#Portas analógicas
#https://randomnerdtutorials.com/esp32-esp8266-analog-readings-micropython/

#Bomba d'água 
#https://www.elec-cafe.com/esp32-with-soil-moisture-sensor-and-lcd-using-micropython/

bomba = Pin(25, Pin.OUT)
bomba.off()

sensor_solo = ADC(Pin(15))
m = 100

min_umidade = 0
max_umidade = 4095

sensor_solo.atten(ADC.ATTN_11DB) #Máximo de umidade 3.3V
sensor_solo.width(ADC.WIDTH_12BIT) #0 a 4095 de bits

print("Iniciando...")
sleep(3)
print("Iniciou")

while True:
    bomba.value(1)
    sleep(2)
    bomba.value(0)
    sleep(2)
    #try:
        #umidade_atual = sensor_solo.read()
        #Qtde em porcentagem
        #umidade_porc = (max_umidade - umidade_atual)*100/(max_umidade - min_umidade)
        #print("Umidade do solo: {:.1f} %".format(umidade_porc))
        #sleep(2)
    #except:
        #pass
