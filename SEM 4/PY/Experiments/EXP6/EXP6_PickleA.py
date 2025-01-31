import pickle

data = {
    "list": [1, 2, 3, 4, 5],
    "dict": {"name": "qarq90", "age": 20},
    "tuple": (10, 20, 30),
    "string": "Death is an old friend"
}

with open("data.pkl", "wb") as file:
    pickle.dump(data, file)

print("Aachaar is ready to serve")
