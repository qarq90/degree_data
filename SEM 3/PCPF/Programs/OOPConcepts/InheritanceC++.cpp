#include "iostream"
using namespace std;

class Parent
{
public:
    void displayParent()
    {
        cout << "From Daddy" << endl;
    }
};

class Child : public Parent
{
public:
    void displayChild()
    {
        cout << "From Boomer" << endl;
    }
};

int main()
{
    Child child;
    child.displayParent();
    child.displayChild();
    return 0;
}
