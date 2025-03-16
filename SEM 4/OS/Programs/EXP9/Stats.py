def calculate_mean(numbers):
    return sum(numbers) / len(numbers)

def calculate_median(numbers):
    n = len(numbers)

    # Sort the numbers
    numbers.sort()

    # Calculate median
    if n % 2 == 0:
        median = (numbers[n // 2 - 1] + numbers[n // 2]) / 2
    else:
        median = numbers[n // 2]

        return median