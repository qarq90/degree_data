#include <stdio.h>
#include <stdlib.h>

void enQueue(int queue[], int *front, int *rear, int size)
{
    if (*rear == (size - 1))
    {
        printf("\n*** Queue is full ***\n");
        return;
    }
    if (*front == -1)
    {
        *front = 0;
    }
    int value;
    printf("Enter value to enqueue: ");
    scanf("%d", &value);
    queue[++(*rear)] = value;
    printf("\n%d enqueued to the Queue\n", value);
}

void deQueue(int queue[], int *front, int *rear)
{
    if (*front == -1)
    {
        printf("\n*** Queue is empty ***\n");
        return;
    }
    int value = queue[(*front)];
    ++(*front);
    if (*front > *rear)
    {
        *front = *rear = -1;
    }
    printf("\n%d dequeued from the Queue\n", value);
}

void displayQueue(int queue[], int *front, int *rear)
{
    if (*front == -1)
    {
        printf("\n*** Queue is empty ***\n");
        return;
    }
    else
    {
        for (int i = *front; i <= *rear; i++)
        {
            printf("%d ", queue[i]);
        }
    }
}

int main()
{
    int choice = 0, size, front = -1, rear = -1;

    printf("Enter Queue size: ");
    scanf("%d", &size);
    printf("\n");

    int queue[size];

    while (choice != 4)
    {
        printf("\n--- Queue Operations Menu ---\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            enQueue(queue, &front, &rear, size);
            break;
        case 2:
            deQueue(queue, &front, &rear);
            break;
        case 3:
            displayQueue(queue, &front, &rear);
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
