import re

x = "Death is an old friend."
y = "Arthur, where are you?"

print(x)
print(re.match("^A",x))

print(y)
print(re.match("^A",y))