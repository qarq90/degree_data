stack = []

def switch(choice):
    if choice == 1:
        item = input("Enter an item to push: ")
        stack.insert(0, item)
    elif choice == 2:
        if len(stack) == 0:
            print("Stack is empty. Cannot pop.")
        else:
            first = stack[0]
            print("Popped item is:", stack.remove(first))
            print(stack)
    elif choice == 3:
        if len(stack) == 0:
            print("Stack is empty.")
        else:
            print("Stack:", stack)
    else:
        print("Invalid choice.")


choice = 1

while (choice != 0):
    print("\n1. Push")
    print("2. Pop")
    print("3. Display")
    print("0. Exit")
    x = int(input("Enter your choice: "))
    if (x == 0):
        break
    switch(x)
    