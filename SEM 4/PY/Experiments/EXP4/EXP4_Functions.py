x = "50,000 people used to live here. Now it's a ghost town."

print("Original Sting: " , x)
print("Lowercase: " , x.lower())
print("Uppercase: " , x.upper())
print("Striping: " , x.strip())
print("Replacing ' ' with '_': " , x.replace(" ", "_"))
print("Splitting: " , x.split())
print("Joining '_': ".join(x.split()))
print("Counting 'e': " , x.count("e"))
print("Finding 'e': " , x.find("e"))
print("Startswith 'people': " , x.startswith("people"))
print("Endwith 'town': " , x.endswith("town."))