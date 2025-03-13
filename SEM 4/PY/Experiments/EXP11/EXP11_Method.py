class RDR2Character:
    def __init__(self, first_name, last_name, gang, role, signature_weapon):
        self.first_name = first_name
        self.last_name = last_name
        self.gang = gang
        self.role = role
        self.signature_weapon = signature_weapon

    def show_char(self):
        print(f"Name: {self.first_name} {self.last_name}")
        print(f"Gang: {self.gang}")
        print(f"Role: {self.role}")
        print(f"Signature Weapon: {self.signature_weapon}")


arthur = RDR2Character("Arthur", "Morgan", "Van der Linde Gang", "Enforcer", "Cattleman Revolver")
dutch = RDR2Character("Dutch", "van der Linde", "Van der Linde Gang", "Leader", "Double-Action Revolver")
john = RDR2Character("John", "Marston", "Van der Linde Gang", "Gunslinger", "Schofield Revolver")
sadie = RDR2Character("Sadie", "Adler", "Van der Linde Gang", "Bounty Hunter", "Lancaster Repeater")

arthur.show_char()
print()
dutch.show_char()
print()
john.show_char()
print()
sadie.show_char()