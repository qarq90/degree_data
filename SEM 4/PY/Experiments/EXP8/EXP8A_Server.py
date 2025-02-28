import socket
import pickle

details = {
        "device_name": "GhouledGadget",
        "device_model": "Dell Inspiron 15",
        "ram": "24GB",
        "ssd": "512GB"
    }

serialized_details = pickle.dumps(details)

s = socket.socket()

try:
    s.bind(("localhost",3000))
    print("Socket binded to port 3000")
    s.listen(5)

    response, address = s.accept()
    print(f"Socket connection established with address {address}")

    response.sendall(serialized_details)
    response.close()
    s.close()
except:
    print("Something went wrong")