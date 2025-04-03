#include "iostream"
#include "string"
using namespace std;

class Character
{
private:
    string name;

public:
    void getName(string n)
    {
        name = n;
    }
    void printName()
    {
        cout << "Name: " << name << endl;
    }
};

int main()
{
    Character p;
    p.getName("Arthur Morgan");
    p.printName();
    return 0;
}