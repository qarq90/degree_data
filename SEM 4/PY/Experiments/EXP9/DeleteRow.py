import sqlite3

conn = sqlite3.connect('bo3.db')
print("Opened database successfully")

def print_table(cursor):
    print("-" * 67)
    print(f"| {'ID':<3} | {'NAME':<12} | {'GENDER':<8} | {'WEAPON':<15} | {'ABILITY':<13} |")
    print("-" * 67)
    for row in cursor:
        print(f"| {row[0]:<3} | {row[1]:<12} | {row[2]:<8} | {row[3]:<15} | {row[4]:<13} |")
    print("-" * 67)

cursor = conn.execute("SELECT id, name, gender, weapon, ability FROM SPECIALISTS")
print("\nInitial Data:")
print_table(cursor)

conn.execute("DELETE FROM SPECIALISTS WHERE id = 100")
conn.commit()  

cursor = conn.execute("SELECT id, name, gender, weapon, ability FROM SPECIALISTS")
print("\nUpdated Data:")
print_table(cursor)

print("Operation done successfully")
conn.close()
