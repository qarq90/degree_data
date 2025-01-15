import turtle

x = turtle.Turtle()
colors = ["red", "green", "yellow", "blue", "purple", "black", "orange", "pink"]
x.pensize(5)
x.speed(1000)

for i in range(10):
    x.pencolor(colors[i])
    for j in range(9):
        x.forward(60)
        x.left(40)
    x.forward(60)
    x.right(40)

turtle.done()
