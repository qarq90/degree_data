#include "iostream"
#include "string"
using namespace std;

class Character
{
private:
    string name;

public:
    Character(string n)
    {
        cout << "Character is in scope - Object created" << endl;
        name = n;
        cout << name << " is a a damn good character" << endl;
    }
    ~Character()
    {
        cout << name << " is probably dead" << endl;
        cout << "Character is now out of scope - Object destroyed" << endl;
    }
};

int main()
{
    Character T("Trevor Philips");
    Character J("John Marston");
    return 0;
}