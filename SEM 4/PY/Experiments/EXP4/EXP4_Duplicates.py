x = "You are a good man Arthur Morgan."

print("Original String:", x)

c = []

for i in x:
    if i not in c:
        c.append(i)

print("Unique Characters:", c)

for i in c:
    print("Character '" , i , "' is repeated " , x.count(i) , " times.")
