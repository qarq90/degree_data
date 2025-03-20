class Daddy:
    def __init__(self):
        self.person='Daddy'
        print(self.person)
        super().__init__()

        
class Mommy:
    def __init__(self):
        self.person='Mommy'
        print(self.person)
        super().__init__()

        
class Baby(Daddy,Mommy):
    def __init__(self):
        self.person='Baby'
        print(self.person)
        super().__init__()

        
obj = Baby ()