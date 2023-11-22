from multiprocessing import Process, Value

def conta(n, vc):
    for i in range(n):
        vc.value += 1

def main():
    #Sharing a integer data/variable
    vc = Value("i", 0, lock=False)

    filho1 = Process(target=conta, args=[1000000, vc])
    filho2 = Process(target=conta, args=[1000000, vc])

    filho1.start() # First process starts
    filho2.start() # Second process starts

    print("aguardando filho")

    filho1.join() # Lock o first process
    filho2.join() # Lock o second process

    print("pai terminou {}".format(vc.value))

if __name__ == '__main__':
    main()