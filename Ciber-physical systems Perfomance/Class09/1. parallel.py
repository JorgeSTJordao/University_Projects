from time import time, sleep
from os import getpid, getppid

def conta(n):
    for i in range(n):
        print("PID: {} {} | Parent PID: {} {}".format(i+1, getpid(), i+1, getppid()))

        sleep(0.2)

def main():
    start = time()
    conta(10)
    period = time() - start
    print("Time: {} secs".format(round(period, 5)))

# Vários processos podem ocupar espaço, por isso o tempo de execução varia
# Será criado dois processos, considerando que cada um deve ser executado em paralelo
main()