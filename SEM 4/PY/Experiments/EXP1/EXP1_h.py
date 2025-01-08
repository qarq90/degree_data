def my_function(x):
    for i in range (x,0,-1):
        for j in range(1,i+1):
            print(j, end=" ")
        print("")
            
        
n = int(input("Enter a number:"))
my_function(n)
