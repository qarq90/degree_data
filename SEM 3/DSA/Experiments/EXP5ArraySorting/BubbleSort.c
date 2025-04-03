#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[] = {42, 73, 21, 98, 64, 12, 57, 46, 88, 33};
    int n = sizeof(a) / sizeof(a[0]);

    printf("Array Elements:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (a[i] > a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    printf("Sorted Elements :\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
