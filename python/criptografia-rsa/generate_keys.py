from pathlib import Path
import rsa


def generate_keys():
    (publicKey, privateKey) = rsa.newkeys(1024)
    Path('keys').mkdir(parents=True, exist_ok=True)
    with open('keys/publicKey.pem', 'wb') as p:
        p.write(publicKey.save_pkcs1('PEM'))
    with open('keys/privateKey.pem', 'wb') as p:
        p.write(privateKey.save_pkcs1('PEM'))


def get_public_key():
    with open('keys/publicKey.pem', 'rb') as p:
        return rsa.PublicKey.load_pkcs1(p.read())


def get_private_key():
    with open('keys/privateKey.pem', 'rb') as p:
        return rsa.PrivateKey.load_pkcs1(p.read())
