from time import time, sleep
# Operating System
from os import getpid, getppid

def conta(n1):
    for i in range(n1):
        print("PID: {} {} | Parent PID: {} {}".format(i+1, getpid(), i+1, getppid()))
        sleep(0.2)

def main():
    start = time()
    conta(10)
    period = time() - start
    print("Time: {} secs".format(round(period, 5)))

main()