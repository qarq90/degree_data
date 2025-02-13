file_lower = open("dialogues.txt", "r")
lower_cased = ""
content = file_lower.read() 
for c in content:
    if c.islower():
        lower_cased += c
    if c == " ":
        lower_cased += " "
    if c == "\n":
        lower_cased += "\n"

print(lower_cased)
file_lower.close()

file_upper = open("file_upper.txt", "w")
upper_cased = lower_cased.upper()

file_upper.write(upper_cased)

file_upper.close()