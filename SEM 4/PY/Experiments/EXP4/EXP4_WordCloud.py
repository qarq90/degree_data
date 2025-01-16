x = "History Is Written By The Victor. History Is Filled With Liars. If He Lives, And We Die, His Truth Becomes Written And Ours Is Lost."

y = x.split(" ")
z = []

a = []

print(y)

for i in y:
    if i not in z:
        z.append(i)

print(z)

for i in z:
    count = y.count(i)
    if count > 1:
        a.append(i)
    print("The word '", i, "' appears ", count, " times.")


print("The words that appear more than once are:")

for i in a:
    count = y.count(i)
    print(i, "appears", count, "times.")
