# Atenção: É necessário instalar o pacote pycryptodome (!pip install pycryptodome)
# Criptografia AES 128 usando a biblioteca pycryptodome

from base64 import b64encode, b64decode
import hashlib
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
import time

# Key size
total = 7

def encrypt(plain_text, password):
    # generate a random salt
    salt = get_random_bytes(AES.block_size)

    # use the Scrypt KDF to get a private key from the password
    # N: cost factor
    # R: block size
    # P: parellelization factor
    private_key = hashlib.scrypt(
        password.encode(), salt=salt, n=2 ** 14, r=total, p=1, dklen=32)

    print("Private key: {}".format(private_key))

    # create cipher config
    cipher_config = AES.new(private_key, AES.MODE_GCM)

    # return a dictionary with the encrypted text
    cipher_text, tag = cipher_config.encrypt_and_digest(bytes(plain_text, 'utf-8'))
    return {
        'cipher_text': b64encode(cipher_text).decode('utf-8'),
        'salt': b64encode(salt).decode('utf-8'),
        'nonce': b64encode(cipher_config.nonce).decode('utf-8'),
        'tag': b64encode(tag).decode('utf-8')
    }


def decrypt(enc_dict, password):
    # decode the dictionary entries from base64
    salt = b64decode(enc_dict['salt'])
    cipher_text = b64decode(enc_dict['cipher_text'])
    nonce = b64decode(enc_dict['nonce'])
    tag = b64decode(enc_dict['tag'])

    # generate the private key from the password and salt
    private_key = hashlib.scrypt(
        password.encode(), salt=salt, n=2 ** 14, r=total, p=1, dklen=32)

    # create the cipher config
    cipher = AES.new(private_key, AES.MODE_GCM, nonce=nonce)

    # decrypt the cipher text
    decrypted = cipher.decrypt_and_verify(cipher_text, tag)
    #print("teste..........",decrypted)
    #print("\n")
    return decrypted


def main():
    plaintext = "RSA: algoritmo dos professores do MIT: Rivest, Shamir e Adleman"

    password = "12345"

    # First let us encrypt secret message
    encrypted = encrypt(plaintext, password)

    print("Cifrado: ")
    print(encrypted)

    # Let us decrypt using our original password
    decrypted = decrypt(encrypted, password)
    print("Decifrado: ")
    print(bytes.decode(decrypted))



start = time.time()

main()

stop = time.time()
print("Time: {}".format(round(stop - start, 4)))
