#include <iostream>
using namespace std;

class OverloadExample
{
public:
    int add(int a, int b)
    {
        return a + b;
    }

    int add(int a, int b, int c)
    {
        return a + b + c;
    }

    double add(double a, double b)
    {
        return a + b;
    }
};

int main()
{
    OverloadExample example;

    cout << "Sum of 2 and 3: " << example.add(2, 3) << endl;
    cout << "Sum of 2, 3 and 4: " << example.add(2, 3, 4) << endl;
    cout << "Sum of 2.5 and 3.5: " << example.add(2.5, 3.5) << endl;

    return 0;
}
