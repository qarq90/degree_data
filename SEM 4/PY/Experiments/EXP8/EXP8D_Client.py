import socket

s = socket.socket()

try:
    s.connect(("localhost", 3000))
    img = open("Lady D.png", "rb")
    s.sendall(img.read())
    print("Image sent to the server")
    img.close()

    s.close()
except Exception as e:
    print(f"Something went wrong: {e}")