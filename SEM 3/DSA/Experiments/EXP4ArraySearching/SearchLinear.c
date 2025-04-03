#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int a[] = {42, 73, 21, 98, 64, 12, 57, 46, 88, 33};
    int n = sizeof(a) / sizeof(a[0]);
    int key = 100;
    bool check = false;

    printf("Array Elements:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");

    for (int i = 0; i < n; i++)
    {
        if (a[i] == key)
        {
            printf("Key found at index :%d ", i);
            check = true;
            break;
        }
        else
            check = false;
    }
    printf("\n");

    if (check)
        printf("Key is in array");
    else
        printf("Key not found");

    return 0;
}
