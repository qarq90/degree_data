import turtle

canvas = turtle.Screen()

pen = turtle.Turtle()

for i in range(5):
    for j in range(40):
        pen.forward(10)
        pen.left(10)
    pen.forward(-25)
    

pen.done()
