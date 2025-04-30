def my_function(x):
    for i in range (x):
        k = 65
        for j in range(i+1):
            print(chr(k),end=" ")
            k = k + 1
        print("")


my_function(10)
