import socket

s = socket.socket()

try:
    s.bind(("localhost",3030))
    print("Socket binded to port 3030")
    s.listen(5)

    response, address = s.accept()
    print(f"Socket connection established with address {address}")

    response.send("Name: Abdurrahman Qureshi\nRoll No: 242466".encode())
    response.close()
    s.close()
except:
    print("Something went wrong")
