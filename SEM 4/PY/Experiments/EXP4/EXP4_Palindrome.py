def isPalindrome(string_x):
    for i in range(0, len(string_x)):
        if string_x[i] != string_x[len(string_x) - i - 1]:
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
