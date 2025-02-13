old_file = open("dialogues.txt", "r")
content = old_file.read()

old_file.close()

new_file = open("mohavare.txt", "w")

print()
print("Old Content")
print()
print(content)

char = ""

new_file.write(content)
while char != "@":
    char = input("Enter '@' to exit:")
    new_file.write(char) 

new_file.close()

new_fileA = open("mohavare.txt", "r")

content = new_fileA.read()

print()
print("New Content")
print()
print(content)

new_fileA.close()