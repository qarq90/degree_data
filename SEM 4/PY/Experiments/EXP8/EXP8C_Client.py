import socket

s = socket.socket()

try:
    s.connect(("localhost", 3000))

    while True:
        server_msg = s.recv(1024).decode()
        if server_msg.lower() == "over":
            print("Server has ended the conversation.")
            break
        print(f"Server says: {server_msg}")

        client_msg = input("Client, enter your message: ")
        s.send(client_msg.encode())
        if client_msg.lower() == "over":
            print("Client is closing the connection.")
            break

    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")