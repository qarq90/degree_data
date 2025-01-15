def Fibonacci(x):
    y = 0
    z = 1
    print(y ,end=" ")
    print(z, end=" ")
    for i in range(0,x):
        a = y + z
        print(a, end=" ")
        y = z
        z = a    

x = int(input("Enter a number: "))
Fibonacci(x)
