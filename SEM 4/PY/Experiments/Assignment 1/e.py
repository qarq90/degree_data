import re

x = "laisfnvliadfvnliaflaisjnfing"
y = "asjfbahskcvhsadvjhwa"

print(x)
print(y)

print(re.match(".*ing$", x))
print(re.match(".*ing$", y))