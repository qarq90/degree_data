def my_function(x):
    for i in range(x):
        for j in range(x,i+1,-1):
            print(" ", end="")
        for k in range(i+1):
            print("*", end="")
        for m in range(i):
            print("*", end="")
        print("")
            
        
n = int(input("Enter a number:"))
my_function(n)
