# A diferença entre o paralelismo e threads é que a última executa variadas instruções de uma só vez
# Revisão sobre semaforos
from time import time, sleep
from os import getpid, getppid
from multiprocessing import Process, Value

# vc: variável compartilhada
# n: até onde conta
def conta(n, vc):
    for i in range(n):
        vc.value += 1

def main():
    vc = Value("i", 0, lock=False)

    # O processo filho vai contar até 15
    filho1 = Process(target=conta, args=[1000000, vc])
    filho2 = Process(target=conta, args=[1000000, vc])

    filho1.start() # Só a partir daqui é executado
    filho2.start() # Só a partir daqui é executado

    print("aguardando filho") # Começa a executar em conjunto

    filho1.join() # Bloqueia o processo1
    filho2.join() # Bloqueia o processo2

    print("pai terminou {}".format(vc.value))

# Vários processos podem ocupar espaço, por isso o tempo de execução varia
# Será criado dois processos, considerando que cada um deve ser executado em paralelo
if __name__ == '__main__':
    main()