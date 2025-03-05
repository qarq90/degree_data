import sqlite3

conn = sqlite3.connect('bo3.db')
print ("Opened database successfully")

conn.execute('''
INSERT INTO SPECIALISTS (ID, NAME, GENDER, WEAPON, ABILITY) VALUES
(1, 'Ruin', 'Male', 'Gravity Spikes', 'Overdrive'),
(2, 'Outrider', 'Female', 'Sparrow', 'Vision Pulse'),
(3, 'Prophet', 'Male', 'Tempest', 'Glitch'),
(4, 'Battery', 'Female', 'War Machine', 'Kinetic Armor'),
(5, 'Seraph', 'Female', 'Annihilator', 'Combat Focus'),
(6, 'Nomad', 'Male', 'H.I.V.E.', 'Rejack'),
(7, 'Reaper', 'Robot', 'Scythe', 'Psychosis'),
(8, 'Spectre', 'Unknown', 'Ripper', 'Active Camo'),
(9, 'Firebreak', 'Male', 'Purifier', 'Heat Wave'),
(10, 'Blackjack', 'Male', 'Rogue', 'Gambler')
''');

conn.commit()
print ("Records created successfully")
conn.close()
