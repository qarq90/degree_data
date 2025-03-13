class Specialist:
    def __init__(self, name, ability, weapon, quote):
        self.name = name
        self.ability = ability
        self.weapon = weapon
        self.quote = quote

    def show_specialist(self):
        print(f"Specialist: {self.name}")
        print(f"Ability: {self.ability}")
        print(f"Weapon: {self.weapon}")
        print(f"Quote: '{self.quote}'")


spectre = Specialist("Spectre", "Active Camo", "Ripper", "I am the shadow, and the knife.")
seraph = Specialist("Seraph", "Annihilator", "Annihilator Pistol", "Justice is not blind, it is precise.")
outrider = Specialist("Outrider", "Vision Pulse", "Sparrow", "I see you, even in the dark.")
battery = Specialist("Battery", "Kinetic Armor", "War Machine", "You can't outrun the inevitable.")

spectre.show_specialist()
print()
seraph.show_specialist()
print()
outrider.show_specialist()
print()
battery.show_specialist()