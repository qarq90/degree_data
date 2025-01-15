def prime(x):
    isPrime = True
    for i in range(2,x):
        if x % i == 0:
            isPrime = False
            break
        else:
            isPrime = True
    return isPrime
    

x = int(input("Enter an integer:"))
isPrime = prime(x)

if isPrime:
    print(x, "is a prime number.")
else:
    print(x, "is not a prime number.")
