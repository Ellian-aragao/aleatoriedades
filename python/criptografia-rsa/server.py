import multiprocessing
import socket
import sys
from _thread import *

list_of_clients = []


def clientthread(conn, addr):
    conn.send("Welcome to this chatroom!".encode())
    while True:
        try:
            message = conn.recv(2048).decode()
            if message:
                print("<" + str(addr) + "> " + message)
                message_to_send = "<" + str(addr) + "> " + message
                broadcast(message_to_send, conn)
            else:
                remove(conn)
        except Exception as e:
            print(e)
            print("Connection with " + str(addr) + " closed")
            continue


def broadcast(message, connection):
    for clients in list_of_clients:
        if clients != connection:
            try:
                clients.send(message.encode())
            except:
                clients.close()
                remove(clients)


def remove(connection):
    if connection in list_of_clients:
        list_of_clients.remove(connection)


if __name__ == '__main__':
    if len(sys.argv) != 3:
        print("Correct usage: script, IP address, port number")
        exit()
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    IP_address = str(sys.argv[1])
    Port = int(sys.argv[2])
    server.bind((IP_address, Port))
    server.listen(100)
    processes = []
    while True:
        conn, addr = server.accept()
        list_of_clients.append(conn)
        print(addr[0] + " connected")
        process = multiprocessing.Process(target=clientthread, args=(conn, addr))
        processes.append(process)
        process.start()

    for p in processes:
        p.join()
        p.close()
    conn.close()
    server.close()
