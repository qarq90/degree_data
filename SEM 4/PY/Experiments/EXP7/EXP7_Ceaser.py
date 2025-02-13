def ceaser_cipher(input, key, type):
    characters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K","M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/", "+", " ", "-"]
    base64 = ""
    for char in input:
        if(type == True):
            base64 += characters[(characters.index(char) + key) % len(characters)]
        else: 
            base64 += characters[(characters.index(char) - key) % len(characters)]
    
    return base64


file_encrypted = open("file_encrypted.txt", "w")

content = ""
c = ""

print()
while c != "<>":
    c = input("Enter a string to encrypt or decrypt, type '<>' to exit : ")
    content += c

con = content.replace("<>", " ")
encrypted = ceaser_cipher(con, 17, True)
file_encrypted.write(encrypted)
file_encrypted.write(c)

file_encrypted.close()

print("\nEncrypted content has been saved in 'file_encrypted.txt'")
file_decrypted = open("file_decrypted.txt", "w")
decrypted = ceaser_cipher(encrypted, 17, False)

file_decrypted.write(decrypted)

file_decrypted.close()

print("\nDecrypted content has been saved in 'file_decrypted.txt'")