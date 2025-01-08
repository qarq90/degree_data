def my_function(x):
    for i in range (x):
        for j in range(i):
            print((j+1),end=" ")
        print("")


n = int(input("Enter a number:"))
my_function(n)
