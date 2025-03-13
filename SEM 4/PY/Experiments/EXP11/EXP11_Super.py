class Soldier:
    def __init__(self, name, health, weapon):
        self.name = name
        self.health = health
        self.weapon = weapon

    def show_info(self):
        print(f"Name: {self.name}")
        print(f"Health: {self.health}")
        print(f"Weapon: {self.weapon}")

    def attack(self):
        print(f"{self.name} is attacking with {self.weapon}!")


class Assault(Soldier):
    def __init__(self, name, health, weapon, ability):
        super().__init__(name, health, weapon)
        self.ability = ability

    def show_info(self):
        super().show_info()
        print(f"Ability: {self.ability}")

    def use_ability(self):
        print(f"{self.name} is using {self.ability}!")


class Sniper(Soldier):
    def __init__(self, name, health, weapon, scope):
        super().__init__(name, health, weapon)
        self.scope = scope

    def show_info(self):
        super().show_info()
        print(f"Scope: {self.scope}x")

    def snipe(self):
        print(f"{self.name} is sniping with a {self.scope}x scope!")


assault_soldier = Assault("John", 100, "M4A1", "Tactical Sprint")
sniper_soldier = Sniper("Alex", 80, "AX-50", 10)

print("--- Assault Soldier ---")
assault_soldier.show_info()
assault_soldier.use_ability()
assault_soldier.attack()

print("\n--- Sniper Soldier ---")
sniper_soldier.show_info()
sniper_soldier.snipe()
sniper_soldier.attack()