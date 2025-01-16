x = "Welcome to the family son!"

print("Original String:", x)

print("Pascal Cased String:", end=" ")

for i in x.split(" "):
    print(i.capitalize() , end=" ")
