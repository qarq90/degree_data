alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
substituted_alphabets = "PJBTDGQRVHXCKLZOMFYWNAIUSE/"

def mono_alphabetic_encrypt(plain_text: str):
    if len(plain_text) == 0: return
    
    plain_text = plain_text.upper()
    plain_text = plain_text.strip()
    
    encrypted_text = ""
    characters_in_plain_text = []
    
    for i in plain_text:
        mapped_index = alphabets.index(i)
        encrypted_text = encrypted_text + substituted_alphabets[mapped_index]
        if i not in characters_in_plain_text:
            characters_in_plain_text.append(i)
            
    print("Length of the plain text:", len(plain_text))
    
    for i in characters_in_plain_text:
        if i == " ":
            print(f"Frequency of ' ' in plain text is {(len(plain_text) / plain_text.count(i))}%")
        else:
            print(f"Frequency of {i} in plain text is {(len(plain_text) / plain_text.count(i))}%")
    
    print(characters_in_plain_text)

    return encrypted_text


def mono_alphabetic_decrypt(cipher_text: str):
    if len(cipher_text) == 0: return

    cipher_text = cipher_text.upper()
    cipher_text = cipher_text.strip()

    decrypted_text = ""

    for i in cipher_text:
        mapped_index = substituted_alphabets.index(i)
        decrypted_text = decrypted_text + alphabets[mapped_index]

    return decrypted_text


original_message = "History is written by the victor"
print("Original Message: ", original_message)
encrypted_message = mono_alphabetic_encrypt(original_message)
print("Encrypted Message: ", encrypted_message)
decrypted_message = mono_alphabetic_decrypt(encrypted_message)
print("Decrypted Message: ", decrypted_message)
