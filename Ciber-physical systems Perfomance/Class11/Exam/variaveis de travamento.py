from multiprocessing import Process, Value
from time import sleep


def A(vc):

    while vc.value: pass
    vc.value = True
    for _ in range(10):
        sleep(0.5)
        print(f"A: {_+1}")

    vc.value = False

    print("FIM")

def B(vc):

    while vc.value: pass
    vc.value = True
    for _ in range(10):
        sleep(0.5)
        print(f" B: {_+1}")

    vc.value = False

    print("FIM")

def main():

    vc = Value('i', False)

    p1 = Process(target=A, args=[vc])
    p2 = Process(target=B, args=[vc])

    p2.start()
    p1.start()


    p1.join()
    p2.join()

    print("Terminado!")

if __name__ == "__main__":
    main()