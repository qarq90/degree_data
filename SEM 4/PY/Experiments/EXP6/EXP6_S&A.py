numbers = tuple(map(int, input("Enter numbers separated by space: ").split()))
sum_values = sum(numbers)
avg_value = sum_values / len(numbers)

print("Sum:", sum_values)
print("Average:", avg_value)
