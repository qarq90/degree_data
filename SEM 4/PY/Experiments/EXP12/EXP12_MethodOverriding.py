class Survivor:
    def __init__(self, name, health):
        self.name = name
        self.health = health

    def use_ability(self):
        print(f"{self.name} uses a generic ability.")


class Coach(Survivor):
    def use_ability(self):
        print(f"{self.name} uses a powerful melee attack to clear zombies!")


class Zoey(Survivor):
    def use_ability(self):
        print(f"{self.name} uses precise shooting to take down the special infected!")


coach = Coach("Coach", 100)
zoey = Zoey("Zoey", 80)

print("--- Left 4 Dead 2 Survivors ---")
coach.use_ability()  
zoey.use_ability()   