import re

x = "laifnclai"
y = "scythethroughtheheart05@gmail.com"

print(x)
print(y)

print(re.match("[a-zA-Z0-9]+@[a-zA-Z].[a-z]",x))
print(re.match("[a-zA-Z0-9]+@[a-zA-Z].[a-z]",y))


#  [a-zA-Z0-9@[a-zA-A-Z].[a-z]