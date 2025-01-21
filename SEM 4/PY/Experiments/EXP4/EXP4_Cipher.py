def ceaser_cipher(input, key, type):
    characters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K","M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/", "+", " "]
    base64 = ""
    for char in input:
        if(type == True):
            base64 += characters[(characters.index(char) + key) % len(characters)]
        else: 
            base64 += characters[(characters.index(char) - key) % len(characters)]
    
    return base64


x = input("Enter a string: ")
encrypted = ceaser_cipher(x, 32, True)
print("Encrypted: " ,encrypted)
decrypted = ceaser_cipher(encrypted, 32, False)
print("Decrypted: " ,decrypted)
