#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a[] = {0, 1, 2, 3, 4, 5, 6, 7};

    printf("Array Elements:\n");

    for (int i = 0; i < (sizeof(a) / sizeof(a[0])); i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}