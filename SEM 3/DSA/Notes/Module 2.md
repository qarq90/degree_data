# Threaded Binary Tree

## Theory

A **Threaded Binary Tree** is a binary tree in which each node has a thread pointer in addition to the usual left and right child pointers. The thread pointers point to the next node in the **in-order traversal** of the tree. Threaded Binary Trees are used to make in-order traversal faster by eliminating the need for recursion or stack-based solutions.

### Types of Threaded Binary Trees:

1. **Single Threaded Binary Tree**: Only one thread pointer (either left or right) is set for the nodes.
2. **Double Threaded Binary Tree**: Both left and right thread pointers are set for the nodes. If a node doesn't have a left or right child, the corresponding thread pointer points to the next node in in-order traversal.

### Key Concepts:

- **In-order Traversal**: The traversal in which the left child is visited first, followed by the root node, and then the right child.
- **Threading**: The process of replacing the NULL pointers of the left and/or right child with pointers to the next node in the in-order traversal.

### Advantages:

- **Faster traversal**: Eliminates the need for recursion or stack-based traversal.
- **Space-efficient**: The threading is done using existing NULL pointers in the tree.

### Operations:

1. **In-order Traversal**: Traverse the tree using the thread pointers.
2. **Insertion**: Insert a node and establish thread pointers.
3. **Deletion**: Delete a node and adjust the thread pointers.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

// Define the structure for a threaded binary tree node
struct Node {
    int data;
    struct Node *left, *right;
    int rightThread; // 0 if right pointer is child, 1 if it points to the next node in in-order traversal
};

// Create a new node for the tree
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    newNode->rightThread = 0;
    return newNode;
}

// Function for in-order traversal using threaded binary tree
void inOrderTraversal(struct Node* root) {
    struct Node* current = root;

    // Traverse the tree until we reach the leftmost node
    while (current != NULL) {
        // Move to the leftmost child
        while (current->left != NULL) {
            current = current->left;
        }

        // Print the current node's data
        printf("%d ", current->data);

        // If the right pointer is a thread, use it to go to the next node in the in-order traversal
        while (current->rightThread == 1 && current->right != NULL) {
            current = current->right;
            printf("%d ", current->data);
        }

        // Move to the right child
        current = current->right;
    }
}

// Function to insert a new node into the tree
void insertNode(struct Node* root, int data) {
    struct Node* newNode = createNode(data);
    struct Node* parent = NULL;
    struct Node* current = root;

    // Traverse the tree to find the position to insert
    while (current != NULL) {
        parent = current;
        if (data < current->data) {
            if (current->left == NULL) {
                current->left = newNode;
                break;
            }
            current = current->left;
        } else {
            if (current->right == NULL) {
                current->right = newNode;
                break;
            }
            current = current->right;
        }
    }

    // Update the threading information
    newNode->rightThread = 1;
    newNode->right = NULL;
    if (parent != NULL) {
        if (data < parent->data) {
            parent->left = newNode;
        } else {
            parent->right = newNode;
        }
    }
}

// Main function
int main() {
    struct Node* root = createNode(10);
    insertNode(root, 5);
    insertNode(root, 20);
    insertNode(root, 3);
    insertNode(root, 7);
    insertNode(root, 15);
    insertNode(root, 25);

    printf("In-order traversal of the threaded binary tree:\n");
    inOrderTraversal(root);
    printf("\n");

    return 0;
}
```

# AVL Tree

## Theory

An **AVL Tree** (Adelson-Velsky and Landis Tree) is a self-balancing **Binary Search Tree (BST)** where the difference in heights between the left and right subtrees (known as the balance factor) of any node is at most 1. This balance property ensures that the tree remains balanced, leading to **O(log n)** time complexity for operations like insertion, deletion, and searching.

### Key Properties:

1. **Binary Search Tree Property**: For any node, all values in the left subtree are smaller, and all values in the right subtree are greater.
2. **Balance Factor**: The balance factor of a node is the difference between the height of its left subtree and the height of its right subtree.
   - Balance Factor = Height of Left Subtree - Height of Right Subtree
   - A node is considered balanced if its balance factor is -1, 0, or +1.
3. **Rotations**: If the balance factor of a node becomes less than -1 or greater than +1, a rotation is performed to restore balance.

### Types of Rotations:

- **Left Rotation**: Performed when the right subtree is taller than the left.
- **Right Rotation**: Performed when the left subtree is taller than the right.
- **Left-Right Rotation**: A combination of left and right rotations.
- **Right-Left Rotation**: A combination of right and left rotations.

### Operations:

- **Insertion**: Insert a node while maintaining the binary search tree property, and perform rotations to maintain balance.
- **Deletion**: Remove a node while maintaining the binary search tree property, and perform rotations if needed to restore balance.
- **Searching**: Find a node in O(log n) time.

### Advantages:

- Self-balancing tree structure.
- Provides faster search, insertion, and deletion compared to a standard binary search tree due to the guaranteed log(n) height.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

// Define the structure of an AVL Tree node
struct Node {
    int data;
    struct Node *left, *right;
    int height;
};

// Function to get the height of the tree
int height(struct Node *node) {
    if (node == NULL) {
        return 0;
    }
    return node->height;
}

// Function to get the balance factor of a node
int getBalance(struct Node *node) {
    if (node == NULL) {
        return 0;
    }
    return height(node->left) - height(node->right);
}

// Function to perform a right rotation
struct Node* rightRotate(struct Node *y) {
    struct Node *x = y->left;
    struct Node *T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = 1 + (height(y->left) > height(y->right) ? height(y->left) : height(y->right));
    x->height = 1 + (height(x->left) > height(x->right) ? height(x->left) : height(x->right));

    return x;
}

// Function to perform a left rotation
struct Node* leftRotate(struct Node *x) {
    struct Node *y = x->right;
    struct Node *T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    // Update heights
    x->height = 1 + (height(x->left) > height(x->right) ? height(x->left) : height(x->right));
    y->height = 1 + (height(y->left) > height(y->right) ? height(y->left) : height(y->right));

    return y;
}

// Function to insert a node in the AVL Tree
struct Node* insert(struct Node* node, int data) {
    if (node == NULL) {
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->data = data;
        newNode->left = newNode->right = NULL;
        newNode->height = 1;
        return newNode;
    }

    // Perform the normal BST insert
    if (data < node->data) {
        node->left = insert(node->left, data);
    } else if (data > node->data) {
        node->right = insert(node->right, data);
    } else {
        return node; // Duplicate keys are not allowed
    }

    // Update height of the ancestor node
    node->height = 1 + (height(node->left) > height(node->right) ? height(node->left) : height(node->right));

    // Get the balance factor
    int balance = getBalance(node);

    // Left Left Case
    if (balance > 1 && data < node->left->data) {
        return rightRotate(node);
    }

    // Right Right Case
    if (balance < -1 && data > node->right->data) {
        return leftRotate(node);
    }

    // Left Right Case
    if (balance > 1 && data > node->left->data) {
        node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && data < node->right->data) {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    return node; // Return the (unchanged) node pointer
}

// Function to perform in-order traversal of the tree
void inOrder(struct Node *root) {
    if (root != NULL) {
        inOrder(root->left);
        printf("%d ", root->data);
        inOrder(root->right);
    }
}

// Main function to demonstrate the AVL Tree
int main() {
    struct Node* root = NULL;

    // Insert nodes into the AVL Tree
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 15);
    root = insert(root, 25);

    printf("In-order traversal of the AVL tree: \n");
    inOrder(root);
    printf("\n");

    return 0;
}
```

# Binary Search Tree (BST)

## Theory

A **Binary Search Tree (BST)** is a type of binary tree in which the nodes are arranged in a specific order. For every node:

- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.

This ordering property allows for efficient searching, insertion, and deletion operations.

### Key Properties:

1. **Binary Tree Property**: Each node has at most two children (left and right).
2. **Search Property**: For every node, all nodes in the left subtree are smaller, and all nodes in the right subtree are larger.
3. **Efficiency**: Operations like searching, insertion, and deletion take O(log n) time for a balanced tree. However, in the worst case (unbalanced tree), these operations can take O(n) time.

### Operations:

1. **Search**: Traverse the tree by comparing the search key with the current node's key.
   - If the key is smaller, move to the left subtree.
   - If the key is larger, move to the right subtree.
2. **Insertion**: Insert a node while maintaining the BST property.
   - Find the correct position by comparing the key and inserting the node at that position.
3. **Deletion**: Delete a node and maintain the BST property.
   - If the node to be deleted has no children, remove it.
   - If the node has one child, replace it with its child.
   - If the node has two children, find the in-order successor (smallest node in the right subtree) and replace the node with it.

### Advantages:

- Provides efficient searching, insertion, and deletion.
- Easy to implement.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *tree; // Tree root
void create_tree();
void insertElement();
void preorderTraversal(struct node *tree);
void inorderTraversal(struct node *tree);
void postorderTraversal(struct node *tree);
void deleteElement();

int main()
{
    int c;
    create_tree();
    do
    {
        printf("\n ******MAIN MENU******* \n");
        printf("\n 1. Insert Element");
        printf("\n 2. Preorder Traversal");
        printf("\n 3. Inorder Traversal");
        printf("\n 4. Postorder Traversal");
        printf("\n 5. Delete an element");
        printf("\n 6. Exit");
        printf("\n\n Enter your option : ");
        scanf("%d", &c);
        switch (c)
        {
        case 1:
            insertElement();
            break;
        case 2:
            printf("\nPreorder Traversal: ");
            preorderTraversal(tree);
            break;
        case 3:
            printf("\nInorder Traversal: ");
            inorderTraversal(tree);
            break;
        case 4:
            printf("\nPostorder Traversal: ");
            postorderTraversal(tree);
            break;
        case 5:
            deleteElement();
            break;
        }
    } while (c != 6);
    return 0;
}

void create_tree()
{
    tree = NULL;
}

void insertElement()
{
    struct node *ptr, *nodeptr, *parentptr;
    int val;
    ptr = (struct node *)malloc(sizeof(struct node));
    printf("\n Enter the value of the new node: ");
    scanf("%d", &val);
    ptr->data = val;
    ptr->left = NULL;
    ptr->right = NULL;

    if (tree == NULL)
    {
        tree = ptr; // Root node
    }
    else
    {
        parentptr = NULL;
        nodeptr = tree;
        while (nodeptr != NULL)
        {
            parentptr = nodeptr;
            if (val < nodeptr->data)
                nodeptr = nodeptr->left;
            else
                nodeptr = nodeptr->right;
        }
        if (val < parentptr->data)
            parentptr->left = ptr;
        else
            parentptr->right = ptr;
    }
}

void preorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        printf("%d\t", tree->data);
        preorderTraversal(tree->left);
        preorderTraversal(tree->right);
    }
}

void inorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        inorderTraversal(tree->left);
        printf("%d\t", tree->data);
        inorderTraversal(tree->right);
    }
}

void postorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        postorderTraversal(tree->left);
        postorderTraversal(tree->right);
        printf("%d\t", tree->data);
    }
}

void deleteElement()
{
    struct node *cur, *parent, *suc, *psuc;
    int val;
    if (tree == NULL)
    {
        printf("\n The tree is empty.");
        return;
    }

    printf("\n Enter the element to be deleted: ");
    scanf("%d", &val);

    cur = tree;
    parent = NULL;

    // Search for the element
    while (cur != NULL && cur->data != val)
    {
        parent = cur;
        if (val < cur->data)
            cur = cur->left;
        else
            cur = cur->right;
    }

    if (cur == NULL)
    {
        printf("\n The value to be deleted is not present in the tree.");
        return;
    }

    // Case 1: Node has no children
    if (cur->left == NULL && cur->right == NULL)
    {
        if (parent == NULL) // Node to be deleted is the root node
            tree = NULL;
        else if (parent->left == cur)
            parent->left = NULL;
        else
            parent->right = NULL;
    }
    // Case 2: Node has one child
    else if (cur->left == NULL || cur->right == NULL)
    {
        struct node *child = (cur->left != NULL) ? cur->left : cur->right;
        if (parent == NULL)
            tree = child;
        else if (parent->left == cur)
            parent->left = child;
        else
            parent->right = child;
    }
    // Case 3: Node has two children
    else
    {
        psuc = cur;
        suc = cur->right;

        while (suc->left != NULL)
        {
            psuc = suc;
            suc = suc->left;
        }

        cur->data = suc->data; // Replace with inorder successor

        if (psuc != cur)
            psuc->left = suc->right;
        else
            psuc->right = suc->right;

        cur = suc;
    }

    free(cur);
    printf("\n Element deleted successfully.");
}
```

# Game Tree

## Theory

A **Game Tree** is a tree structure used to model decisions in game theory. It represents all possible moves in a game, including the possible outcomes resulting from those moves. Each node in the tree represents a game state, and each edge represents a possible move or action taken from one state to another.

### Characteristics:

1. **Root Node**: Represents the initial game state.
2. **Child Nodes**: Each child node represents a possible move or action that the current player can take.
3. **Leaf Nodes**: The end game states, where no further moves are possible. These nodes represent final outcomes, such as win, loss, or draw.
4. **Alternating Players**: The game tree typically alternates between players (e.g., Player 1 and Player 2 in a two-player game).
5. **Minimax Algorithm**: A common algorithm used to evaluate the optimal move for each player. It assumes that both players play optimally.

### Operations:

- **Minimax**: At each level, the algorithm chooses the best possible move based on the assumption that the opponent also makes optimal moves.
- **Alpha-Beta Pruning**: A technique used to optimize the minimax algorithm by eliminating branches that cannot affect the final decision.

### Use Cases:

- **Two-player games** like chess, checkers, tic-tac-toe, etc.
- **AI in games** to determine the best possible move.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

// Define a structure for the Game Tree Node
struct GameNode {
    int state;           // The current state of the game (e.g., 0 for empty, 1 for player 1, 2 for player 2)
    struct GameNode *left;  // Left child node (representing the next state)
    struct GameNode *right; // Right child node (representing the next state)
};

// Function to create a new game tree node
struct GameNode* createNode(int state) {
    struct GameNode* newNode = (struct GameNode*)malloc(sizeof(struct GameNode));
    newNode->state = state;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function to perform a simple Minimax evaluation (e.g., 1 for win, -1 for loss, 0 for draw)
int minimax(struct GameNode* node, int depth, int isMaximizingPlayer) {
    // Base case: If the node is a leaf (end of game), return the evaluation of the game state
    if (node == NULL) {
        return node->state;
    }

    // Maximizing player (Player 1)
    if (isMaximizingPlayer) {
        int best = -1000;  // Initialize best score to a very low value

        // Evaluate the left child (representing one possible move)
        best = (best > minimax(node->left, depth + 1, 0)) ? best : minimax(node->left, depth + 1, 0);

        // Evaluate the right child (representing another possible move)
        best = (best > minimax(node->right, depth + 1, 0)) ? best : minimax(node->right, depth + 1, 0);

        return best;
    }
    // Minimizing player (Player 2)
    else {
        int best = 1000;  // Initialize best score to a very high value

        // Evaluate the left child (representing one possible move)
        best = (best < minimax(node->left, depth + 1, 1)) ? best : minimax(node->left, depth + 1, 1);

        // Evaluate the right child (representing another possible move)
        best = (best < minimax(node->right, depth + 1, 1)) ? best : minimax(node->right, depth + 1, 1);

        return best;
    }
}

// Function to create the game tree for a simple example (tic-tac-toe-like)
struct GameNode* createGameTree() {
    // Manually create a simple game tree for demonstration
    struct GameNode* root = createNode(0);  // Initial state of the game

    root->left = createNode(1);   // Player 1 wins (example state)
    root->right = createNode(-1); // Player 2 wins (example state)

    root->left->left = createNode(1);   // Player 1 wins in left subtree
    root->left->right = createNode(0);  // Draw in right subtree of Player 1 win

    root->right->left = createNode(-1); // Player 2 wins in left subtree
    root->right->right = createNode(0); // Draw in right subtree of Player 2 win

    return root;
}

// Main function to demonstrate the Game Tree and Minimax algorithm
int main() {
    struct GameNode* root = createGameTree();

    // Apply Minimax algorithm to determine the optimal move
    int result = minimax(root, 0, 1); // Starting at root with Player 1 (Maximizing player)

    if (result == 1) {
        printf("Player 1 wins!\n");
    } else if (result == -1) {
        printf("Player 2 wins!\n");
    } else {
        printf("It's a draw!\n");
    }

    return 0;
}
```

# B+ Tree

## Theory

A **B+ Tree** is a type of self-balancing tree data structure that maintains sorted data and allows for efficient insertion, deletion, and search operations. It is an extension of the **B Tree** and is mainly used in database systems and file systems.

### Characteristics:

- **Leaf Nodes**: In a B+ Tree, all the data (actual records) are stored in the leaf nodes. These leaf nodes are linked in a linked list for efficient range queries.
- **Internal Nodes**: Internal nodes store only keys (indexes) and are used for navigation. They do not store actual data.
- **Balanced Tree**: The B+ Tree is always balanced, ensuring that all leaf nodes are at the same depth, which results in logarithmic time complexity for search, insert, and delete operations.
- **Ordered**: Both internal and leaf nodes are ordered based on their keys.
- **Efficient Range Queries**: Due to the linked list of leaf nodes, range queries can be performed efficiently by simply traversing the leaf nodes in order.

### Operations:

1. **Search**: Start at the root and traverse down through internal nodes until the appropriate leaf node is found. This operation takes O(log n) time.
2. **Insert**: Insert a new key and data record. If a node exceeds its maximum number of allowed children, it splits into two nodes, and the median key is pushed up to the parent.
3. **Delete**: To delete a key, it is removed from the leaf node. If necessary, nodes are merged or keys are redistributed to maintain balance.
4. **Range Queries**: Since leaf nodes are linked, a range query can efficiently traverse through the leaf nodes.

### Use Cases:

- **Database Indexing**: B+ Trees are commonly used in databases to store indexes.
- **File Systems**: They are used to efficiently manage large files and directories.
- **Memory Storage**: B+ Trees are used in memory management for organizing large amounts of data.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 4  // Maximum number of children in a node

// B+ Tree Node Structure
struct BPlusNode {
    int keys[MAX - 1];               // Keys in the node
    struct BPlusNode* children[MAX]; // Child pointers
    struct BPlusNode* next;          // Next pointer for leaf nodes
    int numKeys;                     // Number of keys in the node
    int isLeaf;                      // 1 if the node is a leaf, 0 otherwise
};

// Function to create a new node
struct BPlusNode* createNode(int isLeaf) {
    struct BPlusNode* newNode = (struct BPlusNode*)malloc(sizeof(struct BPlusNode));
    newNode->isLeaf = isLeaf;
    newNode->numKeys = 0;
    newNode->next = NULL;
    for (int i = 0; i < MAX; i++) {
        newNode->children[i] = NULL;
    }
    return newNode;
}

// Function to split a node
void splitNode(struct BPlusNode* parent, int index, struct BPlusNode* child) {
    struct BPlusNode* newChild = createNode(child->isLeaf);
    newChild->numKeys = MAX / 2;

    // Move half of the keys to the new node
    for (int i = 0; i < MAX / 2; i++) {
        newChild->keys[i] = child->keys[i + MAX / 2];
        child->children[i + MAX / 2] = child->children[i + MAX / 2];
    }
    child->numKeys = MAX / 2;

    // Insert new child into parent node
    for (int i = parent->numKeys; i > index; i--) {
        parent->children[i + 1] = parent->children[i];
    }
    parent->children[index + 1] = newChild;

    // Insert median key into parent node
    for (int i = parent->numKeys - 1; i >= index; i--) {
        parent->keys[i + 1] = parent->keys[i];
    }
    parent->keys[index] = child->keys[MAX / 2];
    parent->numKeys++;
}

// Function to insert a key into the tree
void insert(struct BPlusNode* root, int key) {
    struct BPlusNode* node = root;
    struct BPlusNode* parent = NULL;

    // Traverse down to the leaf node
    while (!node->isLeaf) {
        parent = node;
        for (int i = 0; i < node->numKeys; i++) {
            if (key < node->keys[i]) {
                node = node->children[i];
                break;
            }
            if (i == node->numKeys - 1) {
                node = node->children[i + 1];
            }
        }
    }

    // Insert the key in the leaf node
    if (node->numKeys < MAX - 1) {
        int i = node->numKeys - 1;
        while (i >= 0 && node->keys[i] > key) {
            node->keys[i + 1] = node->keys[i];
            i--;
        }
        node->keys[i + 1] = key;
        node->numKeys++;
    } else {
        // Node is full, split it
        struct BPlusNode* newLeaf = createNode(1);
        int tempKeys[MAX];
        for (int i = 0; i < MAX - 1; i++) {
            tempKeys[i] = node->keys[i];
        }
        tempKeys[MAX - 2] = key;
        node->numKeys = 0;
        int i = 0;
        while (i < MAX - 1 && tempKeys[i] < tempKeys[i + 1]) {
            node->keys[i++] = tempKeys[i];
        }
        node->numKeys = i;
    }
}

// Function to print the B+ Tree (in-order traversal)
void printTree(struct BPlusNode* root) {
    struct BPlusNode* node = root;
    while (node != NULL) {
        for (int i = 0; i < node->numKeys; i++) {
            printf("%d ", node->keys[i]);
        }
        node = node->next;
        printf("\n");
    }
}

// Main function
int main() {
    // Create root node
    struct BPlusNode* root = createNode(1);  // Root is a leaf node

    // Insert keys into the tree
    insert(root, 10);
    insert(root, 20);
    insert(root, 30);
    insert(root, 40);
    insert(root, 50);

    // Print the tree
    printf("B+ Tree Structure:\n");
    printTree(root);

    return 0;
}
```

# B-Tree

## Theory

A **B-Tree** is a self-balancing search tree that maintains sorted data and allows searches, insertions, deletions, and sequential access in logarithmic time. It is commonly used in databases and file systems to manage large datasets.

### Characteristics of B-Tree:

- **Balanced**: All leaf nodes are at the same depth.
- **Multi-way Tree**: A node can have more than two children.
- **Sorted**: All keys are stored in sorted order.
- **Nodes**: Each node contains a sorted list of keys and child pointers. Internal nodes store keys and pointers to children, whereas leaf nodes store keys and possibly data.
- **Height is Balanced**: The height of the tree is balanced to ensure that the time complexity for searching, inserting, and deleting is logarithmic.

### Properties:

1. **Order of the Tree (m)**: The maximum number of children a node can have. A B-Tree of order m can have at most m-1 keys and m children per node.
2. **Root Node**: The root node must have at least two children if it is not a leaf node.
3. **Internal Nodes**: Each internal node can have between `ceil(m/2)` and `m` children.
4. **Leaf Nodes**: Leaf nodes do not have any children and store the actual data.

### Operations:

- **Search**: A search starts from the root and proceeds down the tree by choosing the appropriate child based on the key comparisons. This operation takes O(log n) time.
- **Insertion**: To insert a key, first find the correct position and insert the key. If the node is full, split it into two nodes and push a key up into the parent node.
- **Deletion**: When a key is deleted, the node is adjusted to maintain the balance. If a node underflows (has too few keys), it may borrow a key from a neighboring sibling or merge with it.
- **Traversal**: The B-Tree supports in-order traversal, which visits nodes in sorted order.

### Use Cases:

- **Database Indexing**: B-Trees are used to create indexes in databases.
- **File Systems**: B-Trees help in managing files by storing information in an ordered and efficient way.
- **External Sorting**: In systems where data is too large to fit in memory, B-Trees are used for efficient disk-based sorting.

## C Program Implementation

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 5  // Maximum number of children per node (Order 5)

// B-Tree Node Structure
struct BTreeNode {
    int keys[MAX - 1];             // Keys stored in the node
    struct BTreeNode* children[MAX]; // Pointers to child nodes
    int numKeys;                   // Number of keys in the node
    int isLeaf;                    // 1 if the node is a leaf, 0 otherwise
};

// Function to create a new node
struct BTreeNode* createNode(int isLeaf) {
    struct BTreeNode* newNode = (struct BTreeNode*)malloc(sizeof(struct BTreeNode));
    newNode->isLeaf = isLeaf;
    newNode->numKeys = 0;
    for (int i = 0; i < MAX; i++) {
        newNode->children[i] = NULL;
    }
    return newNode;
}

// Function to split a child node
void splitChild(struct BTreeNode* parent, int index, struct BTreeNode* child) {
    struct BTreeNode* newChild = createNode(child->isLeaf);
    newChild->numKeys = MAX / 2;

    // Move the last keys from the child to the new child
    for (int i = 0; i < MAX / 2; i++) {
        newChild->keys[i] = child->keys[i + MAX / 2];
        child->children[i + MAX / 2] = child->children[i + MAX / 2];
    }

    child->numKeys = MAX / 2;

    // Insert the new child into the parent node
    for (int i = parent->numKeys; i > index; i--) {
        parent->children[i + 1] = parent->children[i];
    }
    parent->children[index + 1] = newChild;

    // Push the median key up to the parent
    for (int i = parent->numKeys - 1; i >= index; i--) {
        parent->keys[i + 1] = parent->keys[i];
    }
    parent->keys[index] = child->keys[MAX / 2];
    parent->numKeys++;
}

// Function to insert a key in the B-Tree
void insert(struct BTreeNode** root, int key) {
    struct BTreeNode* r = *root;
    if (r->numKeys == MAX - 1) {
        // Root is full, create a new node
        struct BTreeNode* newRoot = createNode(0);
        newRoot->children[0] = r;
        *root = newRoot;
        splitChild(newRoot, 0, r);
    }
    // Insert the key into the non-full node
    struct BTreeNode* node = *root;
    while (!node->isLeaf) {
        int i = node->numKeys - 1;
        while (i >= 0 && key < node->keys[i]) {
            i--;
        }
        node = node->children[i + 1];
    }

    // Insert the key into the leaf node
    int i = node->numKeys - 1;
    while (i >= 0 && key < node->keys[i]) {
        node->keys[i + 1] = node->keys[i];
        i--;
    }
    node->keys[i + 1] = key;
    node->numKeys++;
}

// Function to print the B-Tree (In-order Traversal)
void printTree(struct BTreeNode* root) {
    if (root != NULL) {
        for (int i = 0; i < root->numKeys; i++) {
            if (!root->isLeaf) {
                printTree(root->children[i]);
            }
            printf("%d ", root->keys[i]);
        }
        if (!root->isLeaf) {
            printTree(root->children[root->numKeys]);
        }
    }
}

// Main function
int main() {
    struct BTreeNode* root = createNode(1);  // Create root node (leaf node)

    // Insert keys into the B-Tree
    insert(&root, 10);
    insert(&root, 20);
    insert(&root, 5);
    insert(&root, 6);
    insert(&root, 12);
    insert(&root, 30);
    insert(&root, 7);
    insert(&root, 17);

    // Print the B-Tree
    printf("B-Tree Structure:\n");
    printTree(root);

    return 0;
}
```
