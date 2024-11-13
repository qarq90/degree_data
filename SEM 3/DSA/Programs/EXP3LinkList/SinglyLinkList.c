#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

struct Node
{
    int data;
    struct Node *next;
};

void insertAtEnd(struct Node **head)
{
    int valueToInsert;
    printf("Enter the value to insert at the end: ");
    scanf("%d", &valueToInsert);

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = valueToInsert;
    newNode->next = NULL;

    if (*head == NULL)
    {
        *head = newNode;
        return;
    }

    struct Node *last = *head;
    while (last->next != NULL)
    {
        last = last->next;
    }

    last->next = newNode;
}

void insertAtStart(struct Node **head)
{
    int valueToInsert;
    printf("Enter the value to insert at the start: ");
    scanf("%d", &valueToInsert);

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = valueToInsert;

    newNode->next = *head;

    *head = newNode;
}

void deleteFromStart(struct Node **head)
{
    if (*head == NULL)
    {
        printf("LinkList is empty. Nothing to delete.\n");
        return;
    }

    struct Node *temp = *head;
    *head = (*head)->next;
    free(temp);
}

void deleteFromEnd(struct Node **head)
{
    if (*head == NULL)
    {
        printf("LinkList is empty. Nothing to delete.\n");
        return;
    }

    struct Node *temp, *preTemp;
    temp = *head;

    while (temp->next != NULL)
    {
        preTemp = temp;
        temp = temp->next;
    }

    preTemp->next = NULL;
    free(temp);
}

void reverseLinkList(struct Node **head)
{
    if (*head == NULL)
    {
        printf("LinkList is empty. Nothing to reverse.\n");
        return;
    }

    struct Node *prev = NULL;
    struct Node *current = *head;
    struct Node *next = NULL;

    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    *head = prev;
}

void display(struct Node *head)
{
    struct Node *currentNode = head;
    while (currentNode != NULL)
    {
        printf("[%d] --> ", currentNode->data);
        currentNode = currentNode->next;
    }
    printf("NULL\n");
}

int main()
{
    struct Node *head = NULL;
    int choice;

    while (choice != 7)
    {
        printf("\nChoose an operation:\n");
        printf("1. Insert at Start\n");
        printf("2. Insert at End\n");
        printf("3. Delete From Start\n");
        printf("4. Delete From End\n");
        printf("5. Reverse the List\n");
        printf("6. Display\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            insertAtStart(&head);
            break;

        case 2:
            insertAtEnd(&head);
            break;

        case 3:
            deleteFromStart(&head);
            break;

        case 4:
            deleteFromEnd(&head);
            break;

        case 5:
            reverseLinkList(&head);
            break;

        case 6:
            display(head);
            break;

        case 7:
            printf("Exiting...\n");
            break;

        default:
            printf("Invalid choice. Please enter a valid option (1-4).\n");
            break;
        }
    }

    return 0;
}