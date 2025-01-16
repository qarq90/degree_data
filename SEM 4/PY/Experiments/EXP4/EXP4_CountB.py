x = "Why did I move here? I guess it was the weather."

print("Original String:", x)

d = {}

for i in x:
    if i not in d:
        d[i] = x.count(i)

print("Dictionary:", d)

for c in d:
    print("cacter '", c, "' is repeated ", d[c], " times.")
