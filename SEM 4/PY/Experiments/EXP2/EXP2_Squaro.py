import turtle,random

t = turtle.Turtle() 

t.pensize(5) 
t.speed(500)
n=10

col =['red','magenta','blue','yellow','green','purple','cyan','pink']

for i in range (n*4):
	t.color(random.choice(col))
	t.fd(i*10)
	t.rt(90) 
	
turtle.done()
