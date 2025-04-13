def my_function():
    for j in range(1,11):
        print("====================")
        print("    Table of: " , j)
        print("====================")
        print("")
        for k in range(1,11):
            res = j * k
            print(k , " * " , j , " = " , res)
        print("")
            
        
print("")
my_function()
