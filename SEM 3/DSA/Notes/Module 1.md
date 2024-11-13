# Data Structures & Abstract Data Types (ADT)

## Data Structure

A **data structure** is a way to store and organize data so that it can be accessed and modified efficiently. It defines how data is stored, organized, and manipulated in memory.

### Types of Data Structures:

#### 1. Primitive Data Structures

Primitive data structures are the most basic types of data structures that hold single data values. Examples include:

- **Integer**
- **Float**
- **Character**
- **Boolean**

#### 2. Non-Primitive Data Structures

Non-primitive data structures are more complex structures that store multiple data values. Examples include:

- **Arrays**: A collection of elements of the same type.
- **Linked Lists**: A sequence of nodes, where each node stores data and a reference to the next node.
- **Stacks**: A collection that follows the Last-In-First-Out (LIFO) principle.
- **Queues**: A collection that follows the First-In-First-Out (FIFO) principle.
- **Trees**: A hierarchical data structure with a root element and sub-elements (nodes).
- **Graphs**: A collection of nodes (vertices) and edges connecting pairs of nodes.

## Key Differences between Linear and Non-Linear Data Structures

| Feature                     | Linear Data Structure                                         | Non-Linear Data Structure                                                        |
| --------------------------- | ------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| **Arrangement of Elements** | Elements are arranged in a sequence                           | Elements have multiple relationships (e.g., hierarchy, network)                  |
| **Traversal**               | Simple (one-to-one relationship)                              | Complex (many-to-many relationships)                                             |
| **Memory Allocation**       | Contiguous memory (arrays) or dynamic (linked lists)          | Dynamic memory (trees, graphs)                                                   |
| **Examples**                | Arrays, Linked Lists, Stacks, Queues                          | Trees, Graphs                                                                    |
| **Representation**          | Sequential or linear collection                               | Hierarchical or network-based structure                                          |
| **Complexity**              | Simpler and more intuitive                                    | More complex and flexible for certain types of relationships                     |
| **Use Cases**               | Suitable for simple data collections and linear relationships | Suitable for representing complex relationships like hierarchies, networks, etc. |

---

## Abstract Data Types (ADT)

An **Abstract Data Type (ADT)** is a theoretical concept that defines a data structure by its behavior from the point of view of a user. It specifies the operations that can be performed on the data, but does not define how these operations will be implemented.

### Key Features of ADTs:

- **Encapsulation**: Hides the implementation details.
- **Interface**: Defines the operations available for interacting with the data.
- **Behavior**: Specifies what operations do, not how they are done.

### Examples of ADTs:

#### 1. Stack

An ADT that supports the following operations:

- **push(x)**: Adds an element `x` to the top of the stack.
- **pop()**: Removes the top element from the stack.
- **peek()**: Returns the top element without removing it.
- **isEmpty()**: Returns whether the stack is empty.

#### 2. Queue

An ADT that supports the following operations:

- **enqueue(x)**: Adds an element `x` to the end of the queue.
- **dequeue()**: Removes the element from the front of the queue.
- **peek()**: Returns the front element without removing it.
- **isEmpty()**: Returns whether the queue is empty.

#### 3. List

An ADT that supports the following operations:

- **add(x)**: Adds an element `x` to the list.
- **remove(x)**: Removes the element `x` from the list.
- **get(index)**: Returns the element at a specified index.
- **size()**: Returns the size of the list.

#### 4. Tree

A hierarchical ADT that supports:

- **insert(x)**: Adds an element `x` to the tree.
- **delete(x)**: Removes an element `x` from the tree.
- **find(x)**: Searches for an element `x` in the tree.

## Key Differences Between Data Structures and ADTs

- **Data Structure**: Specifies how the data is stored and how the operations are implemented.
- **ADT**: Specifies what operations can be performed and their behavior but doesn't specify how the operations are implemented.

## Choosing the Right Data Structure

Choosing the appropriate data structure depends on:

- **Time complexity** of operations.
- **Space complexity** requirements.
- **Use case**: What kind of data are you working with? (e.g., sequence, graph, etc.)
- **Constraints**: Memory limitations, real-time processing, etc.

# Linked List

A **Linked List** is a linear data structure where elements are stored in nodes. Each node contains two parts:

1. **Data**: The actual value.
2. **Next**: A pointer/reference to the next node in the sequence.

Unlike arrays, linked lists do not have a fixed size and can grow or shrink dynamically, making them more flexible for memory management. There are various types of linked lists: singly linked lists, doubly linked lists, and circular linked lists.

## Types of Linked Lists

1. **Singly Linked List**: In a singly linked list, each node contains a data part and a pointer to the next node. The last node's next pointer is null, indicating the end of the list.
2. **Doubly Linked List**: Each node in a doubly linked list has two pointers: one to the next node and one to the previous node. This allows traversal in both directions.
3. **Circular Linked List**: A circular linked list can be singly or doubly linked, where the last node points back to the first node, forming a circle.

## Operations on Linked List

1. **Insertion**: Adding a node at the beginning, middle, or end of the list.
2. **Deletion**: Removing a node from the beginning, middle, or end of the list.
3. **Traversal**: Accessing all nodes in the list sequentially.
4. **Searching**: Finding a node with a specific value.
5. **Reversing**: Reversing the order of nodes in the list.

## Advantages of Linked List

1. **Dynamic Size**: Linked lists do not require predefined sizes, making them efficient for dynamic memory allocation.
2. **Efficient Insertions/Deletions**: Inserting and deleting nodes can be done in constant time if the pointer to the node is known.
3. **Memory Efficiency**: Memory is allocated only when needed, avoiding wastage as seen in arrays.

## Disadvantages of Linked List

1. **Memory Overhead**: Each node requires additional memory for the pointer.
2. **Sequential Access**: Accessing elements is sequential, making searching inefficient (O(n) time complexity).
3. **Complexity**: Linked lists are more complex to implement and manage compared to arrays.

## C Code for Singly Linked List Operations

```c
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
```

# Doubly Linked List

## Introduction

A **Doubly Linked List (DLL)** is a type of linked list in which each node contains three parts:

1. **Data**: The value of the node.
2. **Next**: A pointer/reference to the next node.
3. **Prev**: A pointer/reference to the previous node.

Unlike a singly linked list, a doubly linked list can be traversed in both directions (forward and backward). This bidirectional traversal makes it more flexible, especially for operations that need to navigate both ways.

## Types of Doubly Linked List

1. **Singly Doubly Linked List**: Each node has a reference to both the next and previous nodes.
2. **Circular Doubly Linked List**: The last node’s `next` pointer points to the first node, and the first node’s `prev` pointer points to the last node, forming a circular loop.

## Operations on Doubly Linked List

1. **Insertion**: Adding a node at the beginning, middle, or end of the list. Since nodes have both `prev` and `next` pointers, insertion is straightforward, even in the middle.
2. **Deletion**: Removing a node from the beginning, middle, or end of the list.
3. **Traversal**: Traversing nodes in both forward and backward directions.
4. **Searching**: Finding a node with a specific value.
5. **Reversing**: Reversing the entire list by swapping `prev` and `next` pointers of all nodes.

## Advantages of Doubly Linked List

1. **Bidirectional Traversal**: The list can be traversed in both directions, which allows efficient back-and-forth movement.
2. **Efficient Deletion**: Deleting a node can be done efficiently from both ends, as each node has a reference to its predecessor.
3. **Flexibility**: Since there are two pointers per node, it allows more flexible manipulations compared to singly linked lists.

## Disadvantages of Doubly Linked List

1. **Memory Overhead**: Each node requires extra memory for the `prev` pointer, increasing space complexity.
2. **Complex Implementation**: Managing two pointers (prev and next) adds to the complexity of implementation and maintenance.
3. **Higher Overhead in Operations**: Operations like insertion or deletion involve modifying two pointers, which can lead to higher overhead compared to singly linked lists.

## C Code for Doubly Linked List Operations

```c
#include <stdio.h>
#include <stdlib.h>

// Define the node structure for the doubly linked list
struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

// Function to insert a node at the beginning
void insertAtBeginning(struct Node** head, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = *head;
    newNode->prev = NULL;

    if (*head != NULL) {
        (*head)->prev = newNode;
    }

    *head = newNode;
    printf("\n%d inserted at the beginning\n", value);
}

// Function to insert a node at the end
void insertAtEnd(struct Node** head, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    struct Node* temp = *head;
    newNode->data = value;
    newNode->next = NULL;

    if (*head == NULL) {
        newNode->prev = NULL;
        *head = newNode;
        printf("\n%d inserted at the end\n", value);
        return;
    }

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;
    printf("\n%d inserted at the end\n", value);
}

// Function to delete a node from the beginning
void deleteFromBeginning(struct Node** head) {
    if (*head == NULL) {
        printf("\nList is empty, nothing to delete\n");
        return;
    }

    struct Node* temp = *head;
    *head = (*head)->next;

    if (*head != NULL) {
        (*head)->prev = NULL;
    }

    free(temp);
    printf("\nNode deleted from the beginning\n");
}

// Function to delete a node from the end
void deleteFromEnd(struct Node** head) {
    if (*head == NULL) {
        printf("\nList is empty, nothing to delete\n");
        return;
    }

    struct Node* temp = *head;

    if (temp->next == NULL) {
        *head = NULL;
        free(temp);
        printf("\nNode deleted from the end\n");
        return;
    }

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->prev->next = NULL;
    free(temp);
    printf("\nNode deleted from the end\n");
}

// Function to display the list in forward direction
void displayForward(struct Node* head) {
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }

    struct Node* temp = head;
    printf("\nDoubly Linked List (Forward): ");
    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

// Function to display the list in backward direction
void displayBackward(struct Node* head) {
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }

    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    printf("\nDoubly Linked List (Backward): ");
    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->prev;
    }
    printf("NULL\n");
}

int main() {
    struct Node* head = NULL;

    insertAtBeginning(&head, 10);
    insertAtBeginning(&head, 20);
    insertAtEnd(&head, 30);
    insertAtEnd(&head, 40);

    displayForward(head);
    displayBackward(head);

    deleteFromBeginning(&head);
    displayForward(head);

    deleteFromEnd(&head);
    displayForward(head);

    return 0;
}
```

# Circular Linked List

## Introduction

A **Circular Linked List** is a variation of the singly linked list where the last node's `next` pointer points back to the first node instead of `NULL`. This forms a loop or circle. There are two types of circular linked lists:

1. **Singly Circular Linked List**: In this, each node points to the next node, and the last node points to the first node.
2. **Doubly Circular Linked List**: Each node has two pointers, `next` pointing to the next node, and `prev` pointing to the previous node, with the last node's `next` pointing to the first node, and the first node’s `prev` pointing to the last node.

## Characteristics of Circular Linked List

- The **head** node is connected to the **last** node via the `next` pointer.
- There is no `NULL` pointer at the end of the list, unlike singly linked lists.
- It allows for circular traversal, making it ideal for applications like buffering, continuous data structures, or round-robin scheduling.

## Operations on Circular Linked List

1. **Insertion**: A new node can be inserted at the beginning, end, or middle. Since the last node points to the head, insertion can be done without needing to traverse the entire list.
2. **Deletion**: A node can be deleted from the beginning, end, or middle. Adjusting the `next` pointers helps manage node removal.
3. **Traversal**: Traversing the list involves visiting each node from the head and looping back to the head once the last node is reached.
4. **Search**: Searching for a specific element in a circular linked list requires traversing the entire list until the head is encountered again.

## Advantages of Circular Linked List

1. **Efficient Traversal**: Circular traversal allows easy access to the first and last elements without needing to reset pointers.
2. **Flexible Memory Usage**: Memory usage is more efficient, especially when the list has an unpredictable length, as no memory is wasted (unlike array-based implementations).
3. **Ideal for Round-Robin Scheduling**: Circular linked lists are useful for applications that require repeated access to nodes in a round-robin fashion.

## Disadvantages of Circular Linked List

1. **Complexity**: The implementation of circular linked lists is more complex than singly linked lists.
2. **No End Condition**: Because of the circular structure, a proper termination condition is required to prevent infinite loops during traversal.
3. **Increased Memory Usage**: Requires managing the `next` pointer and additional checks for circularity, which increases memory and time overhead.

## C Code for Circular Linked List Operations

```c
#include <stdio.h>
#include <stdlib.h>

// Define the node structure for circular linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to insert a node at the beginning of the circular linked list
void insertAtBeginning(struct Node** head, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;

    if (*head == NULL) {
        newNode->next = newNode; // Point to itself if the list is empty
        *head = newNode;
    } else {
        struct Node* temp = *head;
        while (temp->next != *head) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->next = *head;
        *head = newNode;
    }

    printf("\n%d inserted at the beginning\n", value);
}

// Function to insert a node at the end of the circular linked list
void insertAtEnd(struct Node** head, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;

    if (*head == NULL) {
        newNode->next = newNode; // Point to itself if the list is empty
        *head = newNode;
    } else {
        struct Node* temp = *head;
        while (temp->next != *head) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->next = *head;
    }

    printf("\n%d inserted at the end\n", value);
}

// Function to delete a node from the beginning of the circular linked list
void deleteFromBeginning(struct Node** head) {
    if (*head == NULL) {
        printf("\nList is empty, nothing to delete\n");
        return;
    }

    struct Node* temp = *head;

    if ((*head)->next == *head) {
        free(*head);
        *head = NULL;
    } else {
        struct Node* last = *head;
        while (last->next != *head) {
            last = last->next;
        }
        *head = (*head)->next;
        last->next = *head;
        free(temp);
    }

    printf("\nNode deleted from the beginning\n");
}

// Function to delete a node from the end of the circular linked list
void deleteFromEnd(struct Node** head) {
    if (*head == NULL) {
        printf("\nList is empty, nothing to delete\n");
        return;
    }

    struct Node* temp = *head;
    if ((*head)->next == *head) {
        free(*head);
        *head = NULL;
    } else {
        struct Node* last = *head;
        while (last->next != *head) {
            last = last->next;
        }
        struct Node* secondLast = *head;
        while (secondLast->next != last) {
            secondLast = secondLast->next;
        }
        secondLast->next = *head;
        free(last);
    }

    printf("\nNode deleted from the end\n");
}

// Function to display the circular linked list
void display(struct Node* head) {
    if (head == NULL) {
        printf("\nList is empty\n");
        return;
    }

    struct Node* temp = head;
    printf("\nCircular Linked List: ");
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("(head)\n");
}

int main() {
    struct Node* head = NULL;

    insertAtBeginning(&head, 10);
    insertAtBeginning(&head, 20);
    insertAtEnd(&head, 30);
    insertAtEnd(&head, 40);

    display(head);

    deleteFromBeginning(&head);
    display(head);

    deleteFromEnd(&head);
    display(head);

    return 0;
}
```

# Circular Queue using Array in C

A **Circular Queue** is a type of queue data structure where the last element points to the first element, forming a circle. This structure helps in utilizing the space efficiently in a fixed-size queue by allowing the rear pointer to "wrap around" when it reaches the end of the queue.

## Characteristics of Circular Queue

1. **Fixed Size**: The queue has a predefined size, and once full, no new elements can be added until some elements are dequeued.
2. **Efficient Memory Use**: Elements are continuously added and removed, and the space is reused, ensuring no wasted memory.
3. **FIFO**: Like other queues, the circular queue follows the First In First Out (FIFO) principle.

## Operations of Circular Queue

1. **Enqueue**: Adds an element to the rear of the queue.
2. **Dequeue**: Removes an element from the front of the queue.
3. **Peek/Front**: Retrieves the front element without removing it.
4. **isFull**: Checks if the queue is full.
5. **isEmpty**: Checks if the queue is empty.

## Circular Queue Implementation in C

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 5  // Maximum size of the queue

typedef struct {
    int front, rear;
    int queue[MAX_SIZE];
} CircularQueue;

// Function to initialize the queue
void initQueue(CircularQueue *q) {
    q->front = q->rear = -1;
}

// Function to check if the queue is empty
int isEmpty(CircularQueue *q) {
    return (q->front == -1);
}

// Function to check if the queue is full
int isFull(CircularQueue *q) {
    return ((q->rear + 1) % MAX_SIZE == q->front);
}

// Function to add an element to the queue
void enqueue(CircularQueue *q, int value) {
    if (isFull(q)) {
        printf("Queue is full. Cannot enqueue %d.\n", value);
    } else {
        if (q->front == -1) {  // If the queue is initially empty
            q->front = 0;
        }
        q->rear = (q->rear + 1) % MAX_SIZE;
        q->queue[q->rear] = value;
        printf("Enqueued %d.\n", value);
    }
}

// Function to remove an element from the queue
int dequeue(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty. Cannot dequeue.\n");
        return -1;  // Indicating empty queue
    } else {
        int dequeuedValue = q->queue[q->front];
        if (q->front == q->rear) {  // Only one element was in the queue
            q->front = q->rear = -1;
        } else {
            q->front = (q->front + 1) % MAX_SIZE;
        }
        return dequeuedValue;
    }
}

// Function to view the front element of the queue
int peek(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty. No front element.\n");
        return -1;
    }
    return q->queue[q->front];
}

// Function to display the queue
void display(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty.\n");
    } else {
        printf("Queue elements: ");
        int i = q->front;
        while (1) {
            printf("%d ", q->queue[i]);
            if (i == q->rear) {
                break;
            }
            i = (i + 1) % MAX_SIZE;
        }
        printf("\n");
    }
}

int main() {
    CircularQueue q;
    initQueue(&q);

    // Enqueueing elements
    enqueue(&q, 10);
    enqueue(&q, 20);
    enqueue(&q, 30);
    enqueue(&q, 40);
    enqueue(&q, 50);

    // Display the queue
    display(&q);

    // Dequeueing elements
    printf("Dequeued: %d\n", dequeue(&q));
    printf("Dequeued: %d\n", dequeue(&q));

    // Display the queue after dequeue
    display(&q);

    // Enqueue more elements
    enqueue(&q, 60);
    enqueue(&q, 70);

    // Display the queue after enqueue
    display(&q);

    return 0;
}
```

# Double-Ended Queue (Deque)

## Theory

A Double-Ended Queue (Deque) is a linear data structure that allows insertion and deletion of elements from both ends—front and rear. It can be thought of as a combination of both a queue and a stack.

### Key Operations:

- **Insert Front**: Adds an element to the front of the deque.
- **Insert Rear**: Adds an element to the rear of the deque.
- **Delete Front**: Removes an element from the front of the deque.
- **Delete Rear**: Removes an element from the rear of the deque.
- **Get Front**: Returns the front element of the deque.
- **Get Rear**: Returns the rear element of the deque.
- **isEmpty**: Checks if the deque is empty.
- **isFull**: Checks if the deque is full.

### Types of Deque:

- **Input-restricted Deque**: Insertion is allowed only at one end (either front or rear), but deletion can occur from both ends.
- **Output-restricted Deque**: Deletion is allowed only at one end (either front or rear), but insertion can occur from both ends.

## C Program

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 5

// Declare a deque using an array
int deque[MAX];
int front = -1, rear = -1;

// Check if the deque is full
int isFull() {
    if ((front == 0 && rear == MAX - 1) || front == rear + 1)
        return 1;
    return 0;
}

// Check if the deque is empty
int isEmpty() {
    if (front == -1)
        return 1;
    return 0;
}

// Insert an element at the front of the deque
void insertFront(int value) {
    if (isFull()) {
        printf("Deque is full!\n");
        return;
    }
    if (front == -1) {
        front = rear = 0;
    } else if (front == 0) {
        front = MAX - 1;
    } else {
        front = front - 1;
    }
    deque[front] = value;
}

// Insert an element at the rear of the deque
void insertRear(int value) {
    if (isFull()) {
        printf("Deque is full!\n");
        return;
    }
    if (front == -1) {
        front = rear = 0;
    } else if (rear == MAX - 1) {
        rear = 0;
    } else {
        rear = rear + 1;
    }
    deque[rear] = value;
}

// Delete an element from the front of the deque
void deleteFront() {
    if (isEmpty()) {
        printf("Deque is empty!\n");
        return;
    }
    if (front == rear) {
        front = rear = -1;
    } else if (front == MAX - 1) {
        front = 0;
    } else {
        front = front + 1;
    }
}

// Delete an element from the rear of the deque
void deleteRear() {
    if (isEmpty()) {
        printf("Deque is empty!\n");
        return;
    }
    if (front == rear) {
        front = rear = -1;
    } else if (rear == 0) {
        rear = MAX - 1;
    } else {
        rear = rear - 1;
    }
}

// Get the front element of the deque
int getFront() {
    if (isEmpty()) {
        printf("Deque is empty!\n");
        return -1;
    }
    return deque[front];
}

// Get the rear element of the deque
int getRear() {
    if (isEmpty()) {
        printf("Deque is empty!\n");
        return -1;
    }
    return deque[rear];
}

// Display the elements of the deque
void display() {
    if (isEmpty()) {
        printf("Deque is empty!\n");
        return;
    }
    printf("Deque elements: ");
    if (front <= rear) {
        for (int i = front; i <= rear; i++)
            printf("%d ", deque[i]);
    } else {
        for (int i = front; i < MAX; i++)
            printf("%d ", deque[i]);
        for (int i = 0; i <= rear; i++)
            printf("%d ", deque[i]);
    }
    printf("\n");
}

int main() {
    insertRear(5);
    insertRear(10);
    insertFront(15);
    insertRear(20);
    insertFront(25);

    display(); // Output: 25 15 5 10 20

    printf("Front element: %d\n", getFront());  // Output: 25
    printf("Rear element: %d\n", getRear());    // Output: 20

    deleteFront();
    deleteRear();

    display(); // Output: 15 5 10

    return 0;
}
```

# Priority Queue

## Theory

A **Priority Queue** is an abstract data structure similar to a regular queue, but each element is associated with a **priority**. Elements with higher priority are dequeued before elements with lower priority, regardless of their order in the queue.

### Key Operations:

1. **Insert**: Adds an element to the queue with a given priority.
2. **Remove**: Removes the element with the highest priority from the queue.
3. **Peek/Front**: Returns the element with the highest priority without removing it from the queue.
4. **isEmpty**: Checks if the queue is empty.

### Types of Priority Queues:

- **Max-Priority Queue**: The element with the highest value (priority) is dequeued first.
- **Min-Priority Queue**: The element with the lowest value (priority) is dequeued first.

### Use Cases:

- Job scheduling
- Bandwidth management in computer networks
- A\* search algorithm

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 5

// Define a structure for the priority queue elements
typedef struct {
    int value;
    int priority;
} PQElement;

// Define the priority queue
PQElement pq[MAX];
int size = 0;

// Function to check if the priority queue is full
int isFull() {
    return size == MAX;
}

// Function to check if the priority queue is empty
int isEmpty() {
    return size == 0;
}

// Function to insert an element into the priority queue
void insert(int value, int priority) {
    if (isFull()) {
        printf("Priority Queue is full!\n");
        return;
    }
    int i = size - 1;
    while (i >= 0 && pq[i].priority < priority) {
        pq[i + 1] = pq[i];
        i--;
    }
    pq[i + 1].value = value;
    pq[i + 1].priority = priority;
    size++;
}

// Function to remove the element with the highest priority
void removeMax() {
    if (isEmpty()) {
        printf("Priority Queue is empty!\n");
        return;
    }
    printf("Removing element with value %d and priority %d\n", pq[0].value, pq[0].priority);
    for (int i = 0; i < size - 1; i++) {
        pq[i] = pq[i + 1];
    }
    size--;
}

// Function to peek the element with the highest priority
PQElement peek() {
    if (isEmpty()) {
        printf("Priority Queue is empty!\n");
        PQElement empty = {-1, -1};
        return empty;
    }
    return pq[0];
}

// Function to display the elements of the priority queue
void display() {
    if (isEmpty()) {
        printf("Priority Queue is empty!\n");
        return;
    }
    printf("Priority Queue elements:\n");
    for (int i = 0; i < size; i++) {
        printf("Value: %d, Priority: %d\n", pq[i].value, pq[i].priority);
    }
}

int main() {
    insert(10, 2);
    insert(20, 1);
    insert(30, 3);
    insert(40, 1);
    insert(50, 5);

    display();

    PQElement front = peek();
    printf("Element with highest priority: Value = %d, Priority = %d\n", front.value, front.priority);

    removeMax();
    display();

    return 0;
}
```

# Stack

A **stack** is a linear data structure that follows the **Last In, First Out (LIFO)** principle, meaning that the last element added is the first one to be removed. It operates like a stack of plates, where the plate added last is the first one to be removed.

## Characteristics of a Stack

1. **LIFO Principle**:
   The stack follows the Last In, First Out rule. The most recently added item is the first one to be removed, making it similar to a stack of plates.

2. **Operations**:
   There are primarily two main operations in a stack:

   - **Push**: Adds an element to the top of the stack.
   - **Pop**: Removes the top element from the stack.

3. **Peek**:
   The peek operation returns the top element without removing it. It allows access to the element at the top of the stack without changing the stack.

4. **Is Empty**:
   This operation checks whether the stack is empty. It returns `true` if the stack has no elements, otherwise, it returns `false`.

5. **Uses**:
   Stacks are commonly used in applications like expression evaluation (e.g., converting infix to postfix), backtracking algorithms, undo mechanisms in software, and memory management in recursion.

6. **Memory Allocation**:
   Stacks can be implemented using arrays or linked lists. With arrays, the size of the stack is fixed, while with linked lists, the stack can dynamically grow or shrink.

7. **Space Efficiency**:
   Space in a stack is allocated as elements are added. If the stack grows too large, space might be exhausted in array-based stacks, whereas linked lists can dynamically adjust size.

8. **Examples**:
   - **Function Call Stack**: The function calls in programming languages are managed by a stack, where each function call is pushed onto the stack, and once completed, it is popped off.
   - **Browser History**: In web browsers, visited pages can be stored in a stack to allow navigation (back and forward through pages).

## Example of Stack Operations

- **Push Operation**:
  - `Push(5)` → Stack: [5]
  - `Push(10)` → Stack: [5, 10]
- **Pop Operation**:

  - `Pop()` → Stack: [5], Element removed: 10

- **Peek Operation**:
  - `Peek()` → Element: 5, Stack remains: [5]

## Stack Using Linked List

1. **Definition**:
   A stack is a linear data structure that follows the Last In First Out (LIFO) principle. In a linked list-based stack, elements are stored in nodes, where each node points to the next element in the stack.

2. **Structure**:
   A stack using a linked list has two key components: a `Node` structure, which holds the data and a reference (or pointer) to the next node, and the `top` pointer, which points to the top element in the stack.

3. **Push Operation**:
   The push operation adds an element to the top of the stack. A new node is created, the new node's `next` pointer is set to the current top, and the `top` pointer is updated to point to this new node.

4. **Pop Operation**:
   The pop operation removes the top element from the stack. The `top` pointer is moved to the next node, effectively removing the reference to the previous top element. This operation returns the data of the removed node.

5. **Peek Operation**:
   The peek operation returns the data of the top element without modifying the stack. It simply accesses the `top` pointer and retrieves the value stored in the node it points to.

6. **Is Empty Operation**:
   The isEmpty operation checks whether the stack is empty by verifying if the `top` pointer is `null` or not. If `top` is `null`, the stack is empty, otherwise, it contains elements.

7. **Advantages**:
   Linked list-based stacks offer dynamic memory allocation, which means they can grow and shrink as needed. They do not require a fixed size, making them more flexible compared to array-based stacks.

8. **Disadvantages**:
   The primary disadvantage of using a linked list for a stack is the additional memory overhead due to storing pointers in each node. This can lead to more memory usage compared to an array implementation.

```c
#include <stdio.h>
#include <stdlib.h>

// Define a node for the stack
struct Node {
    int data;
    struct Node* next;
};

// Function to push an element onto the stack
void push(struct Node** top, int value)
{
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("\n*** Stack Overflow: Unable to push ***\n");
        return;
    }
    newNode->data = value;
    newNode->next = *top;
    *top = newNode;
    printf("\n%d pushed to the stack\n", value);
}

// Function to pop an element from the stack
void pop(struct Node** top)
{
    if (*top == NULL) {
        printf("\n*** Stack Underflow: No elements to pop ***\n");
        return;
    }
    struct Node* temp = *top;
    int value = temp->data;
    *top = (*top)->next;
    free(temp);
    printf("\n%d popped from the stack\n", value);
}

// Function to display the elements of the stack
void display(struct Node* top)
{
    if (top == NULL) {
        printf("\n*** Stack is empty ***\n");
        return;
    }
    printf("\nStack elements are: ");
    while (top != NULL) {
        printf("%d", top->data);
        if (top->next != NULL) {
            printf(" | ");
        }
        top = top->next;
    }
    printf("\n");
}

int main()
{
    int choice = 0;
    struct Node* top = NULL;  // Initialize the stack to be empty

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
            {
                int value;
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(&top, value);
                break;
            }
        case 2:
            pop(&top);
            break;
        case 3:
            display(top);
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

```

## Stack Using Array

1. **Definition**:
   A stack using an array is a linear data structure that follows the Last In First Out (LIFO) principle. Elements are stored in a contiguous block of memory, and the stack grows and shrinks based on the array size.

2. **Structure**:
   The stack is represented by an array where elements are stored sequentially. A pointer or index, often called `top`, keeps track of the top element in the stack, and the stack grows until the array is full.

3. **Push Operation**:
   In the push operation, the `top` pointer is incremented, and the new element is added to the array at the position indicated by the `top`. This operation does not affect other elements in the stack.

4. **Pop Operation**:
   The pop operation removes the element at the position indicated by the `top` pointer. The pointer is then decremented to the next element in the stack, effectively removing the reference to the previous top element.

5. **Peek Operation**:
   The peek operation retrieves the element at the `top` pointer without modifying the stack. It returns the element currently stored at the position indicated by the `top` pointer.

6. **Is Empty Operation**:
   To check if the stack is empty, the isEmpty operation compares the `top` pointer to `-1`. If `top` equals `-1`, the stack is empty; otherwise, it contains elements.

7. **Advantages**:
   Array-based stacks are simple to implement and provide fast access to elements. Memory overhead is lower compared to linked lists, as there are no additional pointers to store with each element.

8. **Disadvantages**:
   The major disadvantage of using an array for a stack is the fixed size. Once the array is full, no more elements can be pushed onto the stack, leading to potential overflow issues unless dynamic resizing is implemented.

```c
#include <stdio.h>
#include <stdlib.h>

// Function to push an element onto the stack
void push(int stack[], int *top, int size)
{
    // Check if the stack is full (overflow)
    if (*top == (size - 1))
    {
        printf("\n*** Stack Overflow: Unable to push ***\n");
        return;
    }
    else
    {
        int value;
        // Get the value to push from the user
        printf("Enter value to push: ");
        scanf("%d", &value);
        (*top)++;  // Increment the top index
        stack[*top] = value;  // Add the value to the stack
        printf("\n%d pushed to the stack\n", value);
    }
}

// Function to pop an element from the stack
void pop(int stack[], int *top)
{
    // Check if the stack is empty (underflow)
    if (*top == -1)
    {
        printf("\n*** Stack Underflow: No elements to pop ***\n");
        return;
    }
    else
    {
        int value = stack[*top];  // Get the value at the top of the stack
        (*top)--;  // Decrease the top index
        printf("\n%d popped from the stack\n", value);
    }
}

// Function to display the elements of the stack
void display(int stack[], int top)
{
    // Check if the stack is empty
    if (top == -1)
    {
        printf("\n*** Stack is empty ***\n");
        return;
    }
    printf("\nStack elements are: ");
    // Print all elements from top to bottom (LIFO order)
    for (int i = top; i >= 0; i--)
    {
        printf("%d", stack[i]);
        if (i > 0)
        {
            printf(" | ");  // Add a separator between elements
        }
    }
    printf("\n");
}

int main()
{
    int choice = 0;
    int top = -1;  // Initialize the stack as empty
    int size;

    printf("Enter stack size: ");
    scanf("%d", &size);
    printf("\n");

    int stack[size];

    while (choice != 4)
    {
        // Display the stack operations menu
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

    return 0;  // Exit the program
}

```
