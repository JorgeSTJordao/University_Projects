from abc import abstractmethod
import sys
from math import log2
class IO:
    def __init__(self, entrada = sys.stdin, saida=sys.stdout):
        # saída-padrão = tela (stdout)
        self.entrada = entrada
        self.saida = saida
    def output(self, s):
        print(s, end='', file=self.saida)

class EnderecoInvalido(Exception):
    def __init__(self, ender):
        self.ender = ender
class Memoria:
    def read(self, endereco):
        pass

    def write(self, endereco, valor):
        pass
    
class RAM(Memoria):
    def __init__(self, tamanho):
        self.tamanho = tamanho
        self.memoria = [0] * tamanho

    def read(self, endereco):
        if endereco < 0 or endereco >= self.tamanho:
            # raise EnderecoInvalido(endereco)
            pass
        else:
            return self.memoria[endereco]
    
    def write(self, endereco, valor):
        if endereco < 0 or endereco >= self.tamanho:
            # raise EnderecoInvalido(endereco)
            pass
        else:
            self.memoria[endereco] = valor

class Cache(Memoria):
    def __init__(self, tamanho_total, tamanho_linha, ram):
        self.tamanho_total = tamanho_total # uma das palavras da cache line
        self.tamanho_linha = tamanho_linha # índice da cache line
        self.ram = ram
        self.num_linhas = tamanho_total // tamanho_linha
        self.linhas = [{"flag": False, "tag": None, "data": [0] * tamanho_linha} for _ in range(self.num_linhas)]

    def calc_bits(self, valor):
        return int(log2(valor))
    def read(self, endereco):
        w = endereco % self.tamanho_linha # uma das palavras da cache line
        r = (endereco // self.tamanho_linha) % self.num_linhas # índice da cache line
        t = endereco // (self.tamanho_linha * self.num_linhas) # tag formada dos bits restantes de x

        linha = self.linhas[r]
        if linha["flag"] and linha["tag"] == t: # verifica se t é igual ao tag t' contido na linha r da cache line
            # print(f"HIT: {endereco}")
            return linha["data"][w]
        else:
            print(f"MISS: {endereco} [{w}..{w + self.tamanho_linha-1}]->L{r}") # Imprime endereco cache miss
            self.update_cache_line(r, t)
            return linha["data"][w]

    def write(self, endereco, valor):
        w = endereco % self.tamanho_linha # especifica uma das K palavras de uma cache line ou bloco de memória
        r = (endereco // self.tamanho_linha) % self.num_linhas # especifica o índice do cache line
        t = endereco // (self.tamanho_linha * self.num_linhas) # é a etiqueta (tag) que corresponde aos bits restantes do endereço e serve para identificar qual o bloco que memória principal que se encontra atualmente na cache line
        
        linha = self.linhas[r]
        if linha["flag"] and linha["tag"] == t: # verifica se t é igual ao tag t' contido na linha r da cache line
            # print(f"HIT: {endereco}")
            linha["data"][w] = valor
        else:
            print(f"MISS: {endereco} [{w}..{w + self.tamanho_linha-1}]->L{r}") # Imprime endereco cache miss
            self.update_cache_line(r, t)    
            linha["data"][w] = valor
            self.ram.write(endereco, valor)

    def update_cache_line(self, r, t):
        if self.linhas[r]["flag"]:
            # Verifica se a linha da cache foi modificada
            if any(x != 0 for x in self.linhas[r]["data"]):
                # Se foi modificada, escreve de volta na RAM
                endereco_ram = (self.linhas[r]["tag"] << (self.tamanho_linha * self.num_linhas)) | (r << self.tamanho_linha) # corresponde à concatenação dos bits de t e r e representa o número do bloco de memória principal onde está a palavra à qual se deseja acessar
                for i in range(self.tamanho_linha):
                    self.ram.write(endereco_ram + i, self.linhas[r]["data"][i])

        # Lê um novo bloco da RAM para a linha da cache
        endereco_ram = (t << (self.tamanho_linha * self.num_linhas)) | (r << self.tamanho_linha) # corresponde à concatenação dos bits de t e r e representa o número do bloco de memória principal onde está a palavra à qual se deseja acessar
        for i in range(self.tamanho_linha):
            self.linhas[r]["data"][i] = self.ram.read(endereco_ram + i)

        self.linhas[r]["tag"] = t
        self.linhas[r]["flag"] = True

class CPU:
    def __init__(self, mem, io):
        self.mem = mem
        self.io = io
        self.PC = 0
        self.A = self.B = self.C = 0
    def run(self, ender):
        self.PC = ender
        self.A = self.mem.read(self.PC)
        self.PC += 1
        self.B = self.mem.read(self.PC)
        self.PC += 1
        self.C = 1
        while self.A <= self.B:
            self.mem.write(self.A, self.C)
            self.io.output(f'> {self.A} = {self.C}\n')
            self.C += 1
            self.A += 1
    def reset(self):
        self.PC = 0
        self.A = self.B = self.C = 0

def main():
    try:
        io = IO()
        ram = RAM(2**22)  # 4M de RAM
        cache = Cache(4 * 2**10, 64, ram)  # total cache = 4K, cacheline = 64
        cpu = CPU(cache, io)

        inicio = 0

        print("Programa 1")
        ram.write(inicio, 118)
        ram.write(inicio + 1, 130)
        cpu.run(inicio)

        print("\nPrograma 2")
        cache.write(inicio, 4155)
        cache.write(inicio + 1, 4165)
        cpu.run(inicio)
    except EnderecoInvalido as e:
        print("Endereco inválido:", e.ender)

if __name__ == '__main__':
    main()

