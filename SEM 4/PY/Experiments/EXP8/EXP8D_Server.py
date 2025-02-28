import socket

s = socket.socket()

try:
    s.bind(("localhost", 3000))
    print("Socket binded to port 3000")
    s.listen(5)

    response, address = s.accept()
    print(f"Socket connection established with address {address}")
    client_response = response.recv(4096)

    print(f"Received response from client:")
    print(client_response)

    response.close()
    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")