import sqlite3

conn = sqlite3.connect("bo3.db")
print("Connected to database successfully")

conn.execute('''CREATE TABLE SPECIALISTS
         (
         ID INT PRIMARY KEY      NOT NULL,
         NAME           TEXT     NOT NULL,
         GENDER         CHAR(50) NOT NULL,
         WEAPON         CHAR(50),
         ABILITY        CHAR(50)
         );''')
print ("Table created successfully")

conn.close()
