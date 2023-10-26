# Suport video: https://youtu.be/YOhrIov7PZA?si=3kJZr2Az01_uJTX-
# A diferença entre o paralelismo e threads é que a última executa variadas instruções de uma só vez
from time import time, sleep
from os import getpid, getppid
from multiprocessing import Process

def conta(n):
    for i in range(n):
        print("PID: {} {} | Parent PID: {} {}".format(i+1, getpid(), i+1, getppid()))
        sleep(0.2)

def main():
    # O processo filho vai contar até 15
    filho = Process(target=conta, args=[15])
    filho.start() # Só a partir daqui é executado

    conta(10)
    print("aguardando filho") # Começa a executar em conjunto
    filho.join() # Bloqueia o processo
    print("pai terminou")

# Vários processos podem ocupar espaço, por isso o tempo de execução varia
# Será criado dois processos, considerando que cada um deve ser executado em paralelo

if __name__ == '__main__':
    main()
