import random

x = [7, 91, 13, 34, 8, 5, 93, 37, 80, 83, 27, 61, 30, 78, 94, 19, 68, 55, 63, 9, 29, 70, 69, 9, 52]

print(x) # print the list

print("Max element: " , max(x)) # max element
print("Min element: " , min(x)) # min element
print("Sum of list elements: " ,sum(x)) # sum of list elements
print("Length of list elements: " , len(x)) # length of list elements
print("Appending 34:" , x.append(34)) # appends 34 
print("Popping from list: " , x.pop(0)) # pops the first element
print("Sorted list elements: " , sorted(x)) # sorts the list elements
print("Counting  '9' in list: " , x.count(9)) # counts the number of 9s
print("Inserting '76' at '4' index: " , x.insert(1,76)) # inserts '76' at index '4'
print(x)# print the list
print("Clearing list:") # clears the list
x.clear()
print(x)# print the list
