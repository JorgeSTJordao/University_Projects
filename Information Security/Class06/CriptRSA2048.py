# Reference video: https://youtu.be/n0uJsqFGO4k?si=UMyAIts2NIU9BD8k
# You'll have to install rsa package

from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii
import time

# Recording in progress
start = time.time()

keyPair = RSA.generate(2048)

pubKey = keyPair.publickey()
print(f"Chave Pública:  (n={hex(pubKey.n)}, e={hex(pubKey.e)})")
pubKeyPEM = pubKey.exportKey()
print(pubKeyPEM.decode('ascii'))

print(f"Chave Privada: (n={hex(pubKey.n)}, d={hex(keyPair.d)})")
privKeyPEM = keyPair.exportKey()
print(privKeyPEM.decode('ascii'))

plaintext = input("Mensagem a ser criptografada: ")
msg = bytes(plaintext,'utf-8')
encryptor = PKCS1_OAEP.new(pubKey)
encrypted = encryptor.encrypt(msg)
print("Cifrado: ", binascii.hexlify(encrypted))

decryptor = PKCS1_OAEP.new(keyPair)
decrypted = decryptor.decrypt(encrypted)
print('Decifrado: ', decrypted)

stop = time.time()
print(round(stop - start, 4))