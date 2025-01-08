def my_function(x):
    k = 65
    for i in range (x):
        for j in range(i+1):
            print(chr(k),end=" ")
            k = k + 1
        print("")


n = int(input("Enter a number:"))
my_function(n)
