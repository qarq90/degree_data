class ResidentEvilCharacter:
    def __init__(self, name, ability, weapon):
        self.name = name
        self.ability = ability
        self.weapon = weapon

    def show_character(self):
        print(f"Character: {self.name}")
        print(f"Ability: {self.ability}")
        print(f"Weapon: {self.weapon}")


ethan = ResidentEvilCharacter("Ethan Winters", "Regeneration", "Lemi Handgun")
lady_dimitrescu = ResidentEvilCharacter("Lady Dimitrescu", "Super Strength", "Claw Attacks")
heisenberg = ResidentEvilCharacter("Karl Heisenberg", "Magnetic Control", "Hammer")

ethan.show_character()
print()
lady_dimitrescu.show_character()
print()
heisenberg.show_character()