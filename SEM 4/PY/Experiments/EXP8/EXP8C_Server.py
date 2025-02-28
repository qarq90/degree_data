import socket

s = socket.socket()

try:
    s.bind(("localhost", 3000))
    print("Socket binded to port 3000")
    s.listen(5)

    response, address = s.accept()
    print(f"Socket connection established with address {address}")

    while True:
        server_msg = input("Server, enter your message: ")
        response.send(server_msg.encode())
        if server_msg.lower() == "over":
            print("Server is closing the connection.")
            break

        client_msg = response.recv(1024).decode()
        if client_msg.lower() == "over":
            print("Client has ended the conversation.")
            break
        print(f"Client says: {client_msg}")

    response.close()
    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")