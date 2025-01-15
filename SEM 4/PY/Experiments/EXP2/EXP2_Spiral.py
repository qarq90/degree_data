import turtle,random

t = turtle.Turtle() 

t.pensize(5)
t.speed(10000)

for i in range (5): 
    for col in ['red','magenta','blue','yellow','green','purple','cyan','pink']:
        t.color(col)
        t.circle(100) 
        t.left(10)
        
turtle.done()
