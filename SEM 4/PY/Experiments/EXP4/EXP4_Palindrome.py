def isPalindrome(string_x):
        if string_x.lower() != string_x[::-1].lower():
            return False
        return True
    
if (isPalindrome("Death is an old friend.")):
    print("The string 'Death is an old friend.' is a palindrome.")
else:
    print("The string 'Death is an old friend.' is not a palindrome")

if (isPalindrome("RACECAR")):
    print("The string 'RACECAR' is a palindrome.")
else:
    print("The string 'RACECAR' is not a palindrome")
