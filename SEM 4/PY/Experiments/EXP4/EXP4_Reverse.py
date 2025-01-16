x = "Switching To Your Pistol Is Always Faster Than Reloading."
y = x.split(" ")

print("Original String: ", x)
print("Reversed Each word: ", end="")
for i in y:
    print(i[::-1], end=" ")