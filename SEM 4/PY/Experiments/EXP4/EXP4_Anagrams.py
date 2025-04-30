x = "Captain Price"
y = "Ethan winters"

a = "listen"
b = "silent"

def check_anagrams(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    
    sorted_str1 = sorted(str1)
    sorted_str2 = sorted(str2)
    print(sorted_str1)
    print(sorted_str2)

    if sorted_str1 == sorted_str2:  
        return True
    else:
        return False

result = check_anagrams(x, y)
if result:
    print(f'"{x}" and "{y}" are anagrams.')
else:
    print(f'"{x}" and "{y}" are NOT anagrams.')

result = check_anagrams(a, b)
if result:
    print(f'"{a}" and "{b}" are anagrams.')
else:
    print(f'"{a}" and "{b}" are NOT anagrams.')
