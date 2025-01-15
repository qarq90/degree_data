l1 = [7, 91, 13, 34]
l2 = [8, 5, 93, 37]

l3 = l1 + l2

l4 = []

for i in l1:
    for j in l2:
        l4.append(i + j)
        break  

print("List 1: ",l1)
print("List 2: ",l2)
print("List 3 (Concatenating List 1 and List 2): ",l3)
print("List 4 (Adding elements of List 1 and List 2): ",l4)