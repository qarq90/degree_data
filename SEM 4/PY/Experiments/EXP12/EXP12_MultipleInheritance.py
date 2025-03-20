class Daddy:
    def __init__(self):
        super().__init__()

    def printDaddy(self):
        print('From Daddy')

        
class Mommy:
    def __init__(self):
        super().__init__()

    def printMommy(self):
        print('From Mommy')

        
class Baby(Daddy,Mommy):
    def __init__(self):
        super().__init__()

    def printBaby(self):
        print('I am Baby')
        super().printDaddy()
        super().printMommy()

        
obj = Baby()

obj.printBaby()