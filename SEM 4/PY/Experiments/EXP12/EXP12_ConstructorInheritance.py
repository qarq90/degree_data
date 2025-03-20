class Character:
    def __init__(self, name, role, weapon):
        self.name = name
        self.role = role
        self.weapon = weapon

    def show_info(self):
        print(f"Name: {self.name}")
        print(f"Role: {self.role}")
        print(f"Weapon: {self.weapon}")


class Human(Character):
    def __init__(self, name, role, weapon, tribe):
        super().__init__(name, role, weapon)
        self.tribe = tribe

    def show_info(self):
        super().show_info()
        print(f"Tribe: {self.tribe}")


class Machine(Character):
    def __init__(self, name, role, weapon, weakness):
        super().__init__(name, role, weapon)
        self.weakness = weakness

    def show_info(self):
        super().show_info()
        print(f"Weakness: {self.weakness}")


class Tribe(Character):
    def __init__(self, name, role, weapon, territory):
        super().__init__(name, role, weapon)
        self.territory = territory

    def show_info(self):
        super().show_info()
        print(f"Territory: {self.territory}")


aloy = Human("Aloy", "Hunter", "Bow", "Nora")
thunderjaw = Machine("Thunderjaw", "Apex Predator", "Disc Launcher", "Tearblast Arrows")
tenakth = Tribe("Tenakth", "Warrior Tribe", "Spear", "The Clan Lands")

print("--- Human ---")
aloy.show_info()
print("\n--- Machine ---")
thunderjaw.show_info()
print("\n--- Tribe ---")
tenakth.show_info()