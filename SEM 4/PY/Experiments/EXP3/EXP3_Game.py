import random

options = ["ROCK", "PAPER", "SCISSOR"]
score = []

choice = "Y"

def round_winner(player, computer):
    if player == computer:
        return "TIE"
    elif (player == "ROCK" and computer == "SCISSOR") or (player == "SCISSOR" and computer == "PAPER") or (player == "PAPER" and computer == "ROCK"):
        return "PLAYER"
    else:
        return "COMPUTER"

while (choice.upper() != "N"):
    computer_choice = options[random.randint(0, 2)]
    player_choice = input("Enter your choice (rock, paper, scissor): ").upper()
    
    if player_choice not in options:
        print("Invalid choice! Please enter ROCK, PAPER, or SCISSOR.")
        continue

    result = round_winner(player_choice, computer_choice)
    
    print("\nPlayer chose:", player_choice)
    print("Computer chose:", computer_choice)
    print("Round Winner:", result, "\n")
    score.append(result)

    choice = input("Do you wish to continue to play the game? (y/n): ").upper()
    if choice not in ["Y", "N"]:
        print("Invalid input, please enter 'y' or 'n'.")
    elif choice == "N":
        print("\nGame Over!")
        print("Final Score:")
        print("Player: ", score.count("PLAYER"))
        print("Computer: ", score.count("COMPUTER"))
        print("Ties: ", score.count("TIE"))
