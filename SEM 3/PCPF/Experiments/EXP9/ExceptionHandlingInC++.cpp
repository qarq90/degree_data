#include <iostream>
#include <stdexcept>

double divide(double numerator, double denominator)
{
    if (denominator == 0)
    {
        throw std::invalid_argument("Division by zero");
    }
    return numerator / denominator;
}

int main()
{
    double num1 = 10.0, num2 = 0.0;

    try
    {
        double result = divide(num1, num2);
        std::cout << "Result: " << result << std::endl;
    }
    catch (const std::invalid_argument &e)
    {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}
