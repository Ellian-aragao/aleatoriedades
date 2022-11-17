import rsa

encode_type = 'UTF-8'

hash_function = 'SHA-512'


def encrypt(message, key, encode=encode_type):
    return rsa.encrypt(message.encode(encode), key)


def decrypt(ciphertext, key, encode=encode_type):
    return rsa.decrypt(ciphertext, key).decode(encode)


def sign(message, key, encode=encode_type, hash_str=hash_function):
    return rsa.sign(message.encode(encode), key, hash_str)


def verify(message, signature, key, encode=encode_type, hash_str=hash_function):
    try:
        return rsa.verify(message.encode(encode), signature, key, ) == hash_str
    finally:
        return False
