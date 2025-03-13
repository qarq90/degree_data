class game:
    def __init__(self, name, type, dev):
        self.name = name
        self.type = type
        self.dev = dev

    def put_data(self):
        print("Game Name: " , self.name)
        print("Game Type: " , self.type)
        print("Game Developer: " , self.dev)
        
