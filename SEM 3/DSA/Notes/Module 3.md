# Linked List Data Structure

## Introduction

- A **linked list** is a fundamental data structure where each element (referred to as a node) contains two parts:
  1. **Data**: This is the actual value or information stored in the node.
  2. **Pointer/Link**: This part of the node stores a reference (or link) to the next node in the sequence.
- The linked list is called a "dynamic" data structure, as its size can grow or shrink as needed, unlike arrays which have a fixed size once declared.
- **Advantages** of linked lists over arrays:
  - **Dynamic Memory Allocation**: Since linked lists don’t require contiguous memory locations, they are more efficient in utilizing memory.
  - **Ease of Insertion/Deletion**: Insertion and deletion can be performed more efficiently in linked lists (especially at the beginning or middle of the list) without needing to shift elements like in arrays.
- **Disadvantages** include the extra memory used for storing pointers and the fact that elements cannot be accessed randomly (i.e., you need to traverse the list to access an element).
- There are various types of linked lists, including **Singly Linked Lists**, **Doubly Linked Lists**, and **Circular Linked Lists**, each designed to optimize different use cases and operations.

---

## Representation of Linked List

- A **linked list** is represented by a collection of nodes where each node contains:
  - **Data Field**: Holds the data or value of the node.
  - **Next Pointer**: A reference to the next node in the list. The last node’s next pointer points to **null**, signifying the end of the list.
- The head node is the entry point to the list, and from here, we can access all subsequent nodes by following the links between them.
- In the **Singly Linked List**, each node contains only the link to the next node, and traversal is only possible in one direction (forward).
- In the **Doubly Linked List**, each node contains two links: one pointing to the next node and one pointing to the previous node, allowing traversal in both directions.
- A **Circular Linked List** is a variation where the last node points back to the first node, making the list circular. This allows for continuous traversal from any point in the list.

---

## Linked List v/s Array

- **Memory Allocation**:
  - **Arrays** are statically allocated in contiguous memory locations, meaning all elements must be stored next to each other in memory. This can be inefficient if the array is not completely utilized or if it needs to be resized frequently.
  - **Linked Lists** are dynamically allocated, meaning each node can be stored anywhere in memory, and each node contains a reference to the next node, making them more flexible in memory management.
- **Size Flexibility**:
  - **Arrays** have a fixed size, and the size must be known at the time of creation. To expand or shrink the array, resizing is required, which can be inefficient.
  - **Linked Lists** do not require a pre-defined size. They grow and shrink as needed, which makes them more flexible for scenarios where the exact number of elements is not known ahead of time.
- **Access Time**:
  - **Arrays** allow constant-time random access (O(1)) since elements are stored in contiguous memory. You can access any element using its index directly.
  - **Linked Lists** require linear-time traversal (O(n)) to access an element since you must start from the head node and follow the links until you reach the desired element.
- **Insertion/Deletion**:
  - **Arrays** require shifting elements during insertion or deletion (O(n) time), which can be slow, especially when elements need to be inserted or deleted in the middle or at the beginning.
  - **Linked Lists** offer efficient insertion and deletion operations (O(1)) when modifying the head or tail, as it only requires updating pointers rather than shifting elements.

---

## Types of Linked List

### Singly Linked List

- In a **Singly Linked List**, each node contains two fields:
  1. **Data**: The actual data value stored in the node.
  2. **Next Pointer**: A reference to the next node in the sequence.
- The list is unidirectional, meaning that traversal can only be done in one direction (from the head to the tail).
- The **head** node is the starting point of the list, and the last node's **next** pointer points to `null`, indicating the end of the list.
- Singly Linked Lists are suitable for use cases where operations involve frequent insertions and deletions at the beginning or end of the list.

### Circular Linked List

- A **Circular Linked List** is a variation of the singly linked list where the last node's next pointer points back to the first node, making the list circular.
- This structure eliminates the need for a null reference to indicate the end of the list, as traversal can continue indefinitely from any node.
- There are two types of circular linked lists:
  1. **Singly Circular Linked List**: Where each node only points to the next node.
  2. **Doubly Circular Linked List**: Where each node has references to both the next and previous nodes.
- Circular linked lists are often used in applications like **round-robin scheduling** or **buffer management**, where you need to loop through the elements continuously.

### Doubly Linked List

- A **Doubly Linked List** is a type of linked list where each node contains three fields:
  1. **Data**: The value stored in the node.
  2. **Next Pointer**: A reference to the next node in the sequence.
  3. **Previous Pointer**: A reference to the previous node in the sequence.
- This structure allows for **bi-directional traversal**, meaning you can traverse the list both forwards and backwards.
- Doubly linked lists provide more flexibility than singly linked lists, but at the cost of increased memory usage due to the extra pointer for the previous node.
- They are often used in applications that require frequent operations from both ends of the list, such as **undo/redo functionality**, **navigation history**, and **browser tab management**.

---

## Operations on Singly Linked List and Doubly Linked List

### Singly Linked List Operations

- **Insertion**:
  - **At the Beginning**: Add a new node by creating a new node and setting its `next` pointer to the current head, then update the head to this new node.
  - **At the End**: Traverse the list to find the last node (whose next pointer is `null`), and set its `next` pointer to the new node.
- **Deletion**:
  - **From the Beginning**: Simply update the head pointer to the next node, effectively removing the current head node.
  - **From the End**: Traverse the list to find the second-to-last node and set its `next` pointer to `null`, thus removing the last node.
- **Traversal**:
  - Start from the head node and follow the `next` pointers until reaching the end (`null`).

### Doubly Linked List Operations

- **Insertion**:

  - **At the Beginning**: Create a new node, set its `next` pointer to the current head, and set the current head's `previous` pointer to this new node.
  - **At the End**: Traverse to the last node and insert a new node by updating the `next` pointer of the last node and the `previous` pointer of the new node.

- **Deletion**:
  - **From the Beginning**: Set the head pointer to the next node, and set the `previous` pointer of the new head to `null`.
  - **From the End**: Traverse to the second-to-last node, update its `next` pointer to `null`, and remove the last node.
- **Traversal**:
  - For forward traversal, use the `next` pointer, and for backward traversal, use the `previous` pointer.

---

## Stack and Queue Using Singly Linked List

- **Stack**:
  - A **stack** follows the **Last In, First Out (LIFO)** principle. In the context of a singly linked list:
    - **Push**: To push an element, create a new node and add it at the beginning (head) of the list.
    - **Pop**: To pop an element, remove the node from the head and update the head pointer to the next node.
- **Queue**:
  - A **queue** follows the **First In, First Out (FIFO)** principle. In the context of a singly linked list:
    - **Enqueue**: To enqueue an element, add a new node at the end of the list (tail).
    - **Dequeue**: To dequeue an element, remove the node from the front (head) of the list, and update the head pointer to the next node.

---

## Singly Linked List Application - Polynomial Representation and Addition

- **Polynomial Representation**:
  - A polynomial can be represented using a singly linked list where each node holds the **coefficient** and the **exponent** of a term.
  - For example, the polynomial `5x^3 + 3x^2 + 2x + 1` can be represented as:
    ```
    (5, 3) -> (3, 2) -> (2, 1) -> (1, 0)
    ```
    Each node stores a pair: (coefficient, exponent).
- **Polynomial Addition**:
  - When adding two polynomials, the corresponding terms are added. You traverse both polynomials simultaneously and compare their exponents:
    1. If the exponents match, add the coefficients.
    2. If one polynomial has a higher exponent, add the corresponding term from that polynomial.
  - This operation can be performed efficiently by traversing the linked list nodes.

---

## Conclusion

Linked lists, including singly linked lists, doubly linked lists, and circular linked lists, are crucial data structures that offer flexibility in memory allocation and ease of dynamic size adjustments. They are particularly useful in scenarios where frequent insertion and deletion operations are needed. By understanding and implementing operations like insertion, deletion, and traversal, one can use linked lists effectively to optimize various real-world applications, such as in stack and queue data structures, polynomial addition, and more.
