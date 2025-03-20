class Troop:
    def attack(self, target, weapon=None):
        if weapon:
            print(f"Attacking {target} with {weapon}!")
        else:
            print(f"Attacking {target} with a default weapon!")

class Hero(Troop):
    def attack(self, target, weapon=None, ability=None):
        if ability:
            print(f"Attacking {target} with {weapon} and using {ability}!")
        else:
            super().attack(target, weapon)  

archer = Troop()
barbarian_king = Hero()

print("--- Clash of Clans Troops ---")
archer.attack("Enemy Tower")  
barbarian_king.attack("Enemy Castle", "Sword", "Iron Fist")  