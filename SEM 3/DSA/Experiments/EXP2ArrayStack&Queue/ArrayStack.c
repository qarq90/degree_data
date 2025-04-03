#include <stdio.h>
#include <stdlib.h>

void push(int stack[], int *top, int size)
{
    if (*top == (size - 1))
    {
        printf("\n*** Stack Overflow: Unable to push ***\n");
        return;
    }
    else
    {
        int value;
        printf("Enter value to push: ");
        scanf("%d", &value);
        (*top)++;
        stack[*top] = value;
        printf("\n%d pushed to the stack\n", value);
    }
}

void pop(int stack[], int *top)
{
    if (*top == -1)
    {
        printf("\n*** Stack Underflow: No elements to pop ***\n");
        return;
    }
    else
    {
        int value = stack[*top];
        (*top)--;
        printf("\n%d popped from the stack\n", value);
    }
}

void display(int stack[], int top)
{
    if (top == -1)
    {
        printf("\n*** Stack is empty ***\n");
        return;
    }
    printf("\nStack elements are: ");
    for (int i = top; i >= 0; i--)
    {
        printf("%d", stack[i]);
        if (i > 0)
        {
            printf(" | ");
        }
    }
    printf("\n");
}

int main()
{
    int choice = 0;
    int top = -1;
    int size;

    printf("Enter stack size: ");
    scanf("%d", &size);
    printf("\n");

    int stack[size];

    while (choice != 4)
    {
        printf("\n--- Stack Operations Menu ---\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            push(stack, &top, size);
            break;
        case 2:
            pop(stack, &top);
            break;
        case 3:
            display(stack, top);
            break;
        case 4:
            printf("\nExiting...\n");
            break;
        default:
            printf("\nInvalid choice, please enter a valid option (1-4).\n");
            break;
        }
    }

    return 0;
}
