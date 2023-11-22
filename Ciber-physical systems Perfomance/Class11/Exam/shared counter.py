from multiprocessing import Process, Value, Semaphore

def down(vazio):
    vazio.acquire()

def up(vazio):
    vazio.release()
def A(vazio, vc):

    down(vazio)
    for _ in range(1000000):
        vc.value += 1

    up(vazio)

def B(vazio, vc):

    down(vazio)
    for _ in range(1000000):
        vc.value += 1

    up(vazio)

def main():

    vc = Value('i', 0)
    vazio = Semaphore(1)

    p1 = Process(target=A, args=[vazio, vc])
    p2 = Process(target=B, args=[vazio, vc])

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print(f"Valor final: {vc.value}")
    print("Terminado!")

if __name__ == "__main__":
    main()