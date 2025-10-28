alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def initialize_repeated_key(plain_text: str, key: str):
    repeated_key = ""
    key = key.upper()
    for i in range(len(plain_text)):
        repeated_key += key[i % len(key)]
    print("Repeated Key: ", repeated_key)
    return repeated_key

def vigenere_encrypt(plain_text: str, repeated_key: str):
    if len(plain_text) == 0: 
        return ""
    
    plain_text = plain_text.upper()
    plain_text = plain_text.strip()
    
    encrypted_text = ""
    characters_in_plain_text = []
    
    for i in range(len(plain_text)):
        char = plain_text[i]
        key_char = repeated_key[i]
        
        mapped_index = (alphabets.index(char) + alphabets.index(key_char)) % 26
        encrypted_text += alphabets[mapped_index]
        
        if char not in characters_in_plain_text:
            characters_in_plain_text.append(char)
            
    print("Length of the plain text:", len(plain_text))
    
    for char in characters_in_plain_text:
        frequency = (plain_text.count(char) / len(plain_text)) * 100
        print(f"Frequency of {char} in plain text is {frequency:.2f}%")
    
    print("Unique characters:", characters_in_plain_text)

    return encrypted_text

def vigenere_decrypt(cipher_text: str, repeated_key: str):
    if len(cipher_text) == 0: 
        return ""

    cipher_text = cipher_text.upper()
    cipher_text = cipher_text.strip()

    decrypted_text = ""

    for i in range(len(cipher_text)):
        char = cipher_text[i]
        key_char = repeated_key[i]
        
        mapped_index = (alphabets.index(char) - alphabets.index(key_char)) % 26
        decrypted_text += alphabets[mapped_index]

    return decrypted_text

original_message = "Historyiswrittenbythevictor"
key = "GORODKROVI"
print("Original Message: ", original_message)

repeated_key = initialize_repeated_key(original_message, key)
encrypted_message = vigenere_encrypt(original_message, repeated_key)
print("Encrypted Message: ", encrypted_message)
decrypted_message = vigenere_decrypt(encrypted_message, repeated_key)
print("Decrypted Message: ", decrypted_message)