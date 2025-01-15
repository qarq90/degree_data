def sortList(L):
    n = int(input("Enter number of items in the list: "))
    
    for i in range(n):
        L.append(int(input("Enter an integer for position [" + str(i) + "]: ")))

    print("Original List:", L)

    print("\nVia sort():")
    L_sort = sorted(L)
    print(L_sort)

    print("\nVia Bubble Sort:")
    L_bubble = L
    for i in range(len(L_bubble)):
        for j in range(len(L_bubble) - 1):
            if L_bubble[j] > L_bubble[j + 1]:
                temp = L_bubble[j]
                L_bubble[j] = L_bubble[j + 1]
                L_bubble[j + 1] = temp

    print(L_bubble)

L = []
sortList(L)
