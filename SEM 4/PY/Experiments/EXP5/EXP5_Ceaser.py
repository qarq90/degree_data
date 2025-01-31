student_info = {
    "name": "qarq90",
    "roll_no": "242466",  
    "branch": "Information Technology",
    "subject": "Python",
    "faculty": "Zainab Mam"
}

def ceaser_cipher(input_text, key, encrypt=True):
    characters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                  "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/", "+", " "]
    result = ""
    
    for char in input_text:
        if char in characters:
            index = characters.index(char)
            if encrypt:
                new_index = (index + key) % len(characters)
            else:
                new_index = (index - key) % len(characters)
            result += characters[new_index]
        else:
            result += char  
    
    return result

key = 5 
encrypted_info = {k: ceaser_cipher(str(v), key, True) for k, v in student_info.items()}

decrypted_info = {k: ceaser_cipher(v, key, False) for k, v in encrypted_info.items()}

print("Original Dictionary:\n", student_info)
print("\nEncrypted Dictionary:\n", encrypted_info)
print("\nDecrypted Dictionary:\n", decrypted_info)
