import socket
import pickle

s = socket.socket()

try:
    s.connect(("localhost", 3000))

    data = s.recv(1024)
    data_dict = pickle.loads(data)
    print("Received device details from server:", data_dict)

    response_message = "Device details received successfully!"
    s.sendall(response_message.encode())

    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")