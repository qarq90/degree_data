import sqlite3

def print_table(cursor):
    print("-" * 67)
    print(f"| {'ID':<3} | {'NAME':<12} | {'GENDER':<8} | {'WEAPON':<15} | {'ABILITY':<13} |")
    print("-" * 67)
    for row in cursor:
        print(f"| {row[0]:<3} | {row[1]:<12} | {row[2]:<8} | {row[3]:<15} | {row[4]:<13} |")
    print("-" * 67)

conn = sqlite3.connect('bo3.db')
print ("Opened database successfully")

cursor = conn.execute("SELECT id, name, gender, weapon, ability from SPECIALISTS")

print_table(cursor)
print ("Operation done successfully")
conn.close()

