
#include <stdio.h>
#include <stdlib.h>
int main()
{

    int rows, cols, sum = 0;

    printf("Enter the number of rows: ");
    scanf("%d", &rows);

    printf("Enter the number of columns: ");
    scanf("%d", &cols);

    int mat1[rows][cols];

    printf("Enter the elements of the matrix A: ");
    printf("\n");

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("Enter value for [%d] [%d]: ", i, j);
            scanf("%d", &mat1[i][j]);
        }
    }

    printf("Matrix A : [");
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("%d,", mat1[i][j]);
        }
    }
    printf("]");

    int mat2[rows][cols];

    printf("\n");
    printf("Enter the elements of the matrix B: ");
    printf("\n");

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("Enter value for [%d] [%d]: ", i, j);
            scanf("%d", &mat2[i][j]);
        }
    }

    printf("Matrix B : [");
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("%d,", mat2[i][j]);
        }
    }
    printf("]");

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            sum += mat1[i][j] + mat2[i][j];
        }
    }

    printf("\nSum of elements in Matrix A and Matrix B: %d", sum);

    return 0;
}