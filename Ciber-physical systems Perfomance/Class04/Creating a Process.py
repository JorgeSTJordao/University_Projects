from time import time, sleep
from os import getpid, getppid
from multiprocessing import Process

def conta(n):
    for i in range(n):
        print("PID: {} {} | Parent PID: {} {}".format(i+1, getpid(), i+1, getppid()))
        sleep(0.2)

def main():
    filho = Process(target=conta, args=[15])
    filho.start() # Só a partir daqui é executado

    conta(10)
    print("aguardando filho") # Começa a executar em conjunto
    filho.join() # Bloqueia o processo
    print("pai terminou")


if __name__ == '__main__':
    main()
