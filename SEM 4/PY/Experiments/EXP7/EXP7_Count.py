file = open("dialogues.txt", 'r')
content = file.read()
word_to_search = "the "
times = content.count(word_to_search)
print(content)
print(f"'{word_to_search}' is present in the file {times}")
file.close()