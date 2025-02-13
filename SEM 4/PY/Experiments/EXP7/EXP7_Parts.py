file = open("dialogues.txt", "r")
content = file.read()

num_words = 0
num_chars = len(content)
num_lines = 0

for c in content:
    if c == " ":
        num_words += 1
    elif c == "\n":
        num_lines += 1


print()
print(content)
print("Number of words in the file: " , num_words)
print("Number of lines in the file: " , num_lines)
print("Number of characters in the file: " , num_chars)

file.close()