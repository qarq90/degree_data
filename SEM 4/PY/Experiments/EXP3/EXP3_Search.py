list = []

list_len = int(input("Enter list length: "))

for i in range(0,list_len):
    x = int(input("Enter an integer: "))
    list.append(x)


print("Original List:", list)

to_search = int(input("Enter number to search: "))

if to_search in list:
    print(to_search , " exists in list")
else:
    print(to_search , " is not present in the list")