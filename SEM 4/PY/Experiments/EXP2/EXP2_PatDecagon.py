import turtle

x = turtle.Turtle()
colors = ["red", "green", "yellow", "blue", "purple", "black", "orange", "pink", "blue", "purple"]
x.pensize(5)
x.speed(1000)

for i in range(10):
    x.pencolor(colors[i])
    for j in range(10):
        x.forward(38)
        x.left(36)
    x.forward(90)
    x.right(36)

turtle.done()
