import pickle

data = {
    "tuple": (100, 200, 300),
    "string": "Aachar this string!"
}

with open("aachar.pkl", "wb") as file:
    pickle.dump(data, file)

print("Tuple and String have been aachaared successfully.")
