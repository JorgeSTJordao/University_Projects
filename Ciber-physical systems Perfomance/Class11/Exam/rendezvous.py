from multiprocessing import Process, Semaphore
from time import sleep

def down(vazio):
    vazio.acquire()

def up(vazio):
    vazio.release()

def a1():
    sleep(5)
    print("a1 ok!")

def a2():
    print("a2 ok!")

def A(vazio):
    a1()
    up(vazio)
    down(vazio)
    a2()

def b1():
    sleep(2)
    print("b1 ok!")

def b2():
    print("b2 ok!")

def B(vazio):
    b1()
    up(vazio)
    down(vazio)
    b2()
def main():

    vazio = Semaphore(0)

    p1 = Process(target=A, args=[vazio])
    p2 = Process(target=B, args=[vazio])

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print("Terminado!")
if __name__ == "__main__":
    main()