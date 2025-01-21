import random

words = ["Captain Price", "Aloy", "Ethan Winters", "Trevor Philips", "Spectre", "Simon Riley", "John Marston", "Arthur Morgan"]

attempts = 0
score = 0

word = random.choice(words)
shuffled_word = ''.join(random.sample(word, len(word)))

while True:

    attempts += 1

    print("\nAttempts:", attempts)
    print("Current Score:", score)
    print("Shuffled Word:", shuffled_word)
    
    guess = input("Enter your guess: ")
    if guess == word:
        print("Congratulations! You guessed the word correctly.")
        score += 1
        break
