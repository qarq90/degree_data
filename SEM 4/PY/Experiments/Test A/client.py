import socket

s = socket.socket()

try:
    s.connect(("localhost",3030))
    data = s.recv(1024).decode()
    print(data)
    s.close()
except:
    print("Something went wrong")


