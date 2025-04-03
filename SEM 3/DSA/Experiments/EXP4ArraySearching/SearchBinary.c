#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int binarySearch(int a[], int size, int key)
{
    int left = 0;
    int right = size - 1;

    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        if (a[mid] == key)
        {
            printf("Key Found: %d at %d \n", key, mid);
            return mid;
        }

        if (a[mid] > key)
        {
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }

    return -1;
}

int main()
{
    int a[] = {42, 73, 21, 98, 64, 12, 57, 46, 88, 33};
    int n = sizeof(a) / sizeof(a[0]);
    int key = 98;
    int check;

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

    check = binarySearch(a, n, key);

    if (check == -1)
    {
        printf("Key not found in the array.\n");
    }

    return 0;
}
