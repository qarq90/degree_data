class RDR2Character:

    game = "Red Dead Redemption II"
    
    characters = {
        "Arthur Morgan": {
            "gang": "Van der Linde Gang",
            "role": "Enforcer",
            "signature_weapon": "Cattleman Revolver"
        },
        "Dutch van der Linde": {
            "gang": "Van der Linde Gang",
            "role": "Leader",
            "signature_weapon": "Double-Action Revolver"
        },
        "John Marston": {
            "gang": "Van der Linde Gang",
            "role": "Gunslinger",
            "signature_weapon": "Schofield Revolver"
        },
        "Sadie Adler": {
            "gang": "Van der Linde Gang",
            "role": "Bounty Hunter",
            "signature_weapon": "Lancaster Repeater"
        }
    }
    
    @classmethod
    def print_characters(cls):
        for character, details in cls.characters.items():
            print(f"{character}:")
            print(f"   Gang: {details["gang"]}")
            print(f"   Role: {details["role"]}")
            print(f"   Signature Weapon: {details["signature_weapon"]}")
            print()

print()
print("------------------------------------------------------------")
print("\t\tGame:" , RDR2Character.game)
print("------------------------------------------------------------")
print()
RDR2Character.print_characters()