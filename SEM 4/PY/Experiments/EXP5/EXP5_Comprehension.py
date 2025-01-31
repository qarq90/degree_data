squares = {x: x**2 for x in range(1, 6)}

cubes = {x: x**3 for x in range(1, 6)}

even_odd = {x: "Even" if x % 2 == 0 else "Odd" for x in range(1, 6)}

print("Squares: ", squares)
print("Cubes: ", cubes)
print("Even/Odd: ", even_odd)
