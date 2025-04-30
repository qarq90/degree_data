import socket
import json  

s = socket.socket()

try:
    s.connect(("localhost", 3000))
    data = s.recv(1024)  
    data_str = data.decode('utf-8')  
    data_dict = json.loads(data_str)  
    print("Received details:", data_dict)
    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")