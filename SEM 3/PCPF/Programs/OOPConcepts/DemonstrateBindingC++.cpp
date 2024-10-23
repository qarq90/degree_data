#include <iostream>

class Animal
{
public:
    virtual void speak()
    {
        std::cout << "Animal speaks\n";
    }
};

class Dog : public Animal
{
public:
    void speak() override
    {
        std::cout << "Dog barks\n";
    }
};

class Cat : public Animal
{
public:
    void speak() override
    {
        std::cout << "Cat meows\n";
    }
};

void makeAnimalSpeak(Animal *animal)
{
    animal->speak();
}

int main()
{
    Dog myDog;
    Cat myCat;

    makeAnimalSpeak(&myDog);
    makeAnimalSpeak(&myCat);

    return 0;
}
