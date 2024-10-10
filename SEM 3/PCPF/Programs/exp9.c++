#include <iostream>

class MyClass {
public:
    MyClass() { std::cout << "Constructor called!" << std::endl; }
    ~MyClass() { std::cout << "Destructor called!" << std::endl; }
};

int main() {
    {
        MyClass obj = MyClass();
    } 

    std::cout << "End of the program." << std::endl;
    return 0;
}
