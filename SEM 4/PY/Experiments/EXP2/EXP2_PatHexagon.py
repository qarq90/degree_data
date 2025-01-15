import turtle
import random

x = turtle.Turtle()

colors = ["red","green","yellow","blue","purple","black"]

x.pensize(5)
for i in range(6):
    for j in range(6):
        x.forward(90)
        x.left(60)
    x.color(colors[i])
    x.left(60)
    x.forward(100)
