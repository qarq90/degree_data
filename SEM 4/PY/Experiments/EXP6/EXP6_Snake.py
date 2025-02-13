import time
import random

SLEEP_BETWEEN_ACTIONS = 0.2
MAX_VAL = 100
PLAYER_DINE = True

snake = {
    12: 2,
    23: 4,
    36: 12,
    69: 48,
    98: 56,
    87: 29,
    74: 69,
    41: 55,
}

ladder = {
    14: 25,
    47: 61,
    78: 91,
    89: 95,
    96: 99,
    63: 80,
    32: 46,
    21: 73,
}

playerX = {
    "name": "",
    "position": 0,
}

playerY = {
    "name": "",
    "position": 0,
}

def get_name():
    print()
    playerX["name"] = input("😀 Player 1 would like to be called as: ")
    playerY["name"] = input("😀 Player 2 would like to be called as: ")
    print()

def roll_dice(player_dine):
    new_dice_value = random.randint(1, 6)
    if not player_dine:
        player = playerX
    else:
        player = playerY

    new_position = player["position"] + new_dice_value

    if new_position == 100:
        print(f"{player['name']} rolled 🎲 and got {new_dice_value}")
        print(f"{player['name']} moved ▶▶▶▶ to {new_position}")
        print(f"{player['name']} WON ✨🎉")
        exit()

    if new_position > 100:
        print(f"{player['name']} is on {player['position']} and needs {100 - player['position']}")
        return

    player["position"] = new_position
    print(f"{player['name']} rolled 🎲 and got {new_dice_value}") # 3
    print(f"{player['name']} moved ▶▶▶▶ to {player['position']}") # 12 --> 15

    if player["position"] in snake:
        print(f"🐍 Oops! {player['name']} got bitten by a snake! Sliding down to {snake[player['position']]}")
        player["position"] = snake[player["position"]]

    if player["position"] in ladder:
        print(f"### Yay! {player['name']} climbed a ladder! Moving up to {ladder[player['position']]}")
        player["position"] = ladder[player["position"]]

    print()

get_name()
for i in range(1, 60): 
    if PLAYER_DINE:
        PLAYER_DINE = False
    else:
        PLAYER_DINE = True
    roll_dice(PLAYER_DINE)
    time.sleep(SLEEP_BETWEEN_ACTIONS) 