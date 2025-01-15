import random

List_random = []

for i in range(0,26):
    x = random.randint(1,100)
    List_random.append(x)

print(List_random)

print("Original List_random: " , List_random)
print("Greatest number of the List_random is:" , max(List_random))
print("Smallest number of the List_random is:" , min(List_random))
print("Reverse of the List_random is:", list(reversed(List_random)))
print("Sum of the List_random is:" , sum(List_random))
