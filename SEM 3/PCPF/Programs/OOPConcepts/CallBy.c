#include <stdio.h>

void callByValue(int arg)
{
    arg = arg + 1;
    printf("Inside callByValue function after incrementing X = %d\n", arg);
}

void callByReference(int *arg)
{
    *arg = *arg + 1;
    printf("Inside callByRefrence function after incrementing y = %d\n", *arg);
}

int main()
{
    int x = 10;
    int y = 20;

    printf("Original X = %d\n", x);
    printf("Original Y = %d\n", y);

    callByValue(x);

    printf("Inside main function After calling callByValue X = %d\n", x);

    callByReference(&y);

    printf("Inside main function After calling callByRefrence Y = %d\n", y);

    return 0;
}
