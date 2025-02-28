import socket
import pickle

s = socket.socket()

try:
    s.connect(("localhost",3000))
    data = s.recv(1024)
    data_dict = pickle.loads(data)
    print(data_dict)
    s.close()
except:
    print("Something went wrong")

