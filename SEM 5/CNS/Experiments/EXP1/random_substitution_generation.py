import random

a = ""

while(True):
    x = random.randint(65,90)
    if chr(x) not in a:
        a = a + (chr(x))
        
    if len(a) == 26:
        print(a)
        break