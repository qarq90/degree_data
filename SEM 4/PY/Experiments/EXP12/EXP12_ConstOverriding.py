class Father:
    def __init__(self,property1=0):
        self.property1 = property1
        
    def display(self):
        print( " \n Father\'s property",self.property)

class Son(Father):
    def __init__(self,property1=0,property2=0):
        super().__init__ (property1)
        self.property2 = property2
        
    def display(self):
         print( "\nSon\'s property =",self.property1 + self.property2)
        
s = Son(1000000,100000)
s.display()