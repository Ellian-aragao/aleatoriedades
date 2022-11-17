import crypt

import generate_keys


def main():
    generate_keys.generate_keys()
    public_key = generate_keys.get_public_key()
    private_key = generate_keys.get_private_key()
    # message = input('Write your message here:')
    message = 'teste'
    ciphertext = crypt.encrypt(message, public_key)
    signature = crypt.sign(message, private_key)
    text = crypt.decrypt(ciphertext, private_key)
    print(f'Cipher text: {ciphertext}')
    print(f'Signature: {signature}')

    if text:
        print(f'Message text: {text}')
    else:
        print(f'Unable to decrypt the message.')

    if crypt.verify(text, signature, public_key):
        print('Successfully verified signature')
    else:
        print('The message signature could not be verified')


if __name__ == '__main__':
    main()
