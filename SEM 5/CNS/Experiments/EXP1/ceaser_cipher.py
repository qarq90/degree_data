alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

def ceaser_cipher_encrypt(plain_text: str, key):
    if len(plain_text) == 0: return
    
    plain_text = plain_text.upper()
    plain_text = plain_text.strip()
    
    encrypted_message = ""
    characters_in_plain_text = []
    
    for i in plain_text:
        mapped_index = alphabets.index(i)
        encrypted_message = encrypted_message + alphabets[(mapped_index + key) % 27]
        if i not in characters_in_plain_text:
            characters_in_plain_text.append(i)
            
    print("Length of the plain text:", len(plain_text))
    
    for i in characters_in_plain_text:
        if i == " ":
            print(f"Frequency of ' ' in plain text is {(len(plain_text) / plain_text.count(i))}%")
        else:
            print(f"Frequency of {i} in plain text is {(len(plain_text) / plain_text.count(i))}%")
        
    
    print(characters_in_plain_text)
    
    return encrypted_message
    
    
def ceaser_cipher_decrypt(cipher_text: str, key):
    if len(cipher_text) == 0: return
    decrypted_message = ""
    
    cipher_text = cipher_text.upper()
    cipher_text = cipher_text.strip()
    
    for i in cipher_text:
        mapped_index = alphabets.index(i)
        decrypted_message = decrypted_message + alphabets[(mapped_index - key) % 27]
    
    return decrypted_message

    
original_message = "Death is an old friend"
print("Original Message: ", original_message)
encrypted_message = ceaser_cipher_encrypt(original_message, 3)
print("Encrypted Message: ", encrypted_message)
decrypted_message = ceaser_cipher_decrypt(encrypted_message, 3)
print("Decrypted Message: ", decrypted_message)