from multiprocessing import Process, Semaphore
from time import sleep

def down(vazio):
    vazio.acquire()

def up(vazio):
    vazio.release()
def A(vazio):

    for _ in range(5):
        sleep(0.5)
        print(f"A: {_+1}")

    up(vazio)
    down(vazio)
    print("FIM")

def B(vazio):

    for _ in range(6):
        sleep(0.5)
        print(f" B: {_+1}")

        if _+1 == 3:
            down(vazio)

    up(vazio)
    print("FIM")


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