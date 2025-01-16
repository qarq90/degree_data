import random

words = ["python", "java", "ruby", "javascript", "html", "css"]

word = random.choice(words)

shuffled_word = ''.join(random.sample(word, len(word)))

print("Guess the word: ", shuffled_word)
guess = input("Enter your guess: ")

if guess.lower() == word:
    print("Correct! Well done.")
else:
    print(f"Oops! The correct word was: {word}")
