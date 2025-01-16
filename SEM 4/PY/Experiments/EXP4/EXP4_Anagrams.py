x = "Captain Price"
y = "Ethan winters"

a = "listen"
b = "silent"

z = sorted(x.replace(" ","").lower()) == sorted(y.replace(" ","").lower())
c = sorted(a.replace(" ","").lower()) == sorted(b.replace(" ","").lower())

print("String X: ", x)

print("String Y: ", y)

print("Are the strings anagrams? ", z)

print("String A: ", a)

print("String B: ", b)

print("Are the strings anagrams? ", c)