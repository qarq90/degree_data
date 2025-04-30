import socket
import json  

details = {
    "device_name": "GhouledGadget",
    "device_model": "Dell Inspiron 15",
    "ram": "24GB",
    "ssd": "512GB"
}

serialized_details = json.dumps(details).encode('utf-8')  

s = socket.socket()

try:
    s.bind(("localhost", 3000))
    print("Socket bound to port 3000")
    s.listen(5)

    response, address = s.accept()
    print(f"Socket connection established with address {address}")

    response.sendall(serialized_details)  
    response.close()
    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")