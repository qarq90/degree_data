class OnePiece:
    def __init__(self, name, devil_fruit, role, age, gender):
        self.name = name
        self.devil_fruit = devil_fruit
        self.role = role
        self.age = age
        self.gender = gender

    def __ls__(self, next):
        if self.age < next.age:
            return -1
        else:
            return 1
        
    def __add__(self, next):
        return self.age + next.age


nico_robin = OnePiece("Nico Robin", "Flower Flower Fruit", "Archeologist", 32, "Female")
luffy = OnePiece("Monkey D. Luffy", "Gum Gum Fruit", "Captain", 21, "Male")

print("------------ Nico Robin ------------\n")
print("Name:", nico_robin.name)
print("Gender:", nico_robin.gender)
print("Age:", nico_robin.age)
print("Role:", nico_robin.role)
print("Devil Fruit:", nico_robin.devil_fruit)

print("\n------------ Monkey D. Luffy ------------\n")
print("Name:", luffy.name)
print("Gender:", luffy.gender)
print("Age:", luffy.age)
print("Role:", luffy.role)
print("Devil Fruit:", luffy.devil_fruit)

print("\nCombined Age of both: ", nico_robin + luffy)

if nico_robin.age < luffy.age:
    print("\nNico Robin is younger than Monkey D. Luffy.")
else:
    print("\nMonkey D. Luffy is younger than Nico Robin.")