#include <stdio.h>
#include <stdlib.h>

// Node structure for linked list
struct Node
{
    int data;
    struct Node *next;
};

// Queue structure with front and rear pointers
struct Queue
{
    struct Node *front;
    struct Node *rear;
};

// Function to initialize the queue
void initQueue(struct Queue *q)
{
    q->front = NULL;
    q->rear = NULL;
}

// Function to check if the queue is empty
int isEmpty(struct Queue *q)
{
    return q->front == NULL;
}

// Function to add an element to the queue (enqueue)
void enqueue(struct Queue *q, int value)
{
    // Create a new node
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    // If the queue is empty, both front and rear point to the new node
    if (isEmpty(q))
    {
        q->front = newNode;
        q->rear = newNode;
    }
    else
    {
        // Add the new node at the rear of the queue
        q->rear->next = newNode;
        q->rear = newNode;
    }
    printf("Enqueued: %d\n", value);
}

// Function to remove an element from the queue (dequeue)
int dequeue(struct Queue *q)
{
    if (isEmpty(q))
    {
        printf("Queue is empty. Cannot dequeue.\n");
        return -1; // Return a sentinel value to indicate an error
    }

    // Get the data from the front node
    int dequeuedValue = q->front->data;

    // Move the front pointer to the next node
    struct Node *temp = q->front;
    q->front = q->front->next;

    // If the front becomes NULL, also set rear to NULL (queue is empty)
    if (q->front == NULL)
    {
        q->rear = NULL;
    }

    // Free the memory allocated for the dequeued node
    free(temp);

    return dequeuedValue;
}

// Function to display the queue
void displayQueue(struct Queue *q)
{
    if (isEmpty(q))
    {
        printf("Queue is empty.\n");
        return;
    }

    struct Node *current = q->front;
    printf("Queue elements: ");
    while (current != NULL)
    {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

// Main function to test the queue
int main()
{
    struct Queue q;
    initQueue(&q);

    enqueue(&q, 10);
    enqueue(&q, 20);
    enqueue(&q, 30);

    displayQueue(&q);

    printf("Dequeued: %d\n", dequeue(&q));
    displayQueue(&q);

    printf("Dequeued: %d\n", dequeue(&q));
    displayQueue(&q);

    enqueue(&q, 40);
    displayQueue(&q);

    printf("Dequeued: %d\n", dequeue(&q));
    displayQueue(&q);

    return 0;
}
