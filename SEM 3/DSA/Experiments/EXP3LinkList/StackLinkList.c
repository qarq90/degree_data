#include <stdio.h>
#include <stdlib.h>

// Node structure for linked list
struct Node
{
    int data;
    struct Node *next;
};

// Stack structure with a pointer to the top of the stack
struct Stack
{
    struct Node *top;
};

// Function to initialize the stack
void initStack(struct Stack *s)
{
    s->top = NULL;
}

// Function to check if the stack is empty
int isEmpty(struct Stack *s)
{
    return s->top == NULL;
}

// Function to push an element onto the stack
void push(struct Stack *s, int value)
{
    // Create a new node
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = s->top; // Point new node to the current top

    // Move the top pointer to the new node
    s->top = newNode;
    printf("Pushed: %d\n", value);
}

// Function to pop an element from the stack
int pop(struct Stack *s)
{
    if (isEmpty(s))
    {
        printf("Stack is empty. Cannot pop.\n");
        return -1; // Return a sentinel value to indicate an error
    }

    // Get the data from the top node
    int poppedValue = s->top->data;

    // Move the top pointer to the next node
    struct Node *temp = s->top;
    s->top = s->top->next;

    // Free the memory allocated for the popped node
    free(temp);

    return poppedValue;
}

// Function to get the top element of the stack
int peek(struct Stack *s)
{
    if (isEmpty(s))
    {
        printf("Stack is empty. No top element.\n");
        return -1; // Return a sentinel value to indicate an error
    }
    return s->top->data;
}

// Function to display the stack elements
void displayStack(struct Stack *s)
{
    if (isEmpty(s))
    {
        printf("Stack is empty.\n");
        return;
    }

    struct Node *current = s->top;
    printf("Stack elements: ");
    while (current != NULL)
    {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

// Main function to test the stack
int main()
{
    struct Stack s;
    initStack(&s);

    push(&s, 10);
    push(&s, 20);
    push(&s, 30);

    displayStack(&s);

    printf("Popped: %d\n", pop(&s));
    displayStack(&s);

    printf("Popped: %d\n", pop(&s));
    displayStack(&s);

    push(&s, 40);
    displayStack(&s);

    printf("Peek: %d\n", peek(&s));

    printf("Popped: %d\n", pop(&s));
    displayStack(&s);

    printf("Popped: %d\n", pop(&s));
    displayStack(&s);

    return 0;
}
