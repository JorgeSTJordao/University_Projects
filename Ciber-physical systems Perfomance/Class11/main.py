import multiprocessing
from time import sleep

capacidade = 4

def down(s):
    s.acquire()


def up(s):
    s.release()


# PASSAGEIRO
def passageiro(p, np, embarque, mutex, cheio, desembarque, vazio):
    print(f"O passageiro {p} está aguardando a liberação")

    down(embarque) # Aguarda para embarcar
    embarcar(p, np, cheio, mutex) # Embarca

    down(desembarque) # Aguarda para desembarcar
    print(f"O passageiro {p} está aguardando liberação do desembarque")
    desembarcar(p, np, vazio, mutex) # Desembarca


def embarcar(p, np, cheio, mutex):

    print(f"O Passageiro {p} está embarcando")

    down(mutex)
    np.value += 1
    if np.value == capacidade:
        up(cheio) # Carrinho Cheio
    else:
        up(cheio)
    up(mutex)


def desembarcar(p, np, vazio, mutex):
    # Aguarda a liberação para desembarcar
    print(f"O Passageiro {p} está desembarcando")

    down(mutex)
    np.value -= 1
    if np.value == 0:
        up(vazio) # Carrinho Vazio
    up(mutex)


# CARRINHO
def carrinho(n, embarque, cheio, mutex, desembarque, vazio):
    etapa = 0
    while True:
        sleep(0.1)
        libera_embarque(embarque, mutex)
        down(cheio)  # Espera até ficar cheio

        print("Cheio!")
        faz_volta()

        libera_desembarque(desembarque, mutex)
        print("Vazio!")
        down(vazio)  # Espera até ficar vazio

        etapa += 1
        sleep(2)
        print((20 * "-") + str(etapa) + "ª Rodada Terminada" + (20 * "-"))

        n -= capacidade

        if n < capacidade:
            if n == 0:
                print("Nenhum passageiro faltou!")
            else:
                print(f"Faltou {n} passageiro(s)")
            break


def libera_embarque(embarque, mutex):
    sleep(1) 
    print("Embarque liberado!")
    print("Vamos entrando...")

    for _ in range(capacidade):
        up(embarque) # Liberado para embarque
        up(mutex)
        sleep(1)

def faz_volta():
    print("Iniciando o passeio", end="")
    for _ in range(40):
        print(".", end="", flush=True)
        sleep(0.2)
    print("Terminando o passeio")

def libera_desembarque(desembarque, mutex):
    sleep(1)
    print("Desembarque liberado!") # Liberado para desembarque
    print("Vamos saindo...")

    for _ in range(capacidade):
        up(desembarque) # Liberado para embarque
        up(mutex)
        sleep(1)

#-------------------------------------------------------
def main(n):
    np = multiprocessing.Value('i', 0, lock=False)
    passageiros = []

    embarque = multiprocessing.Semaphore(0)
    mutex = multiprocessing.Semaphore(0)
    cheio = multiprocessing.Semaphore(0)
    vazio = multiprocessing.Semaphore(0)
    desembarque = multiprocessing.Semaphore(0)


    carrinhoP = multiprocessing.Process(target=carrinho, args=[n, embarque, cheio, mutex, desembarque, vazio])

    for i in range(n):
        passageiroI = multiprocessing.Process(target=passageiro, args=[i + 1, np, embarque, mutex, cheio, desembarque, vazio])
        passageiros.append(passageiroI)

    carrinhoP.start()

    for passageiroI in passageiros:
        passageiroI.start()

    carrinhoP.join()
    for passageiroI in passageiros:
        passageiroI.join()

    print("Passeio finalizado!")

if __name__ == "__main__":
    main(8)
