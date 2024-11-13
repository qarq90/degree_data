# Detailed Theory on Trees

## Introduction

- A **tree** is a non-linear data structure consisting of nodes connected by edges. It is hierarchical in nature, with a single root node and zero or more child nodes.
- Trees are widely used in various applications like file systems, databases, XML document parsing, and expression evaluation due to their efficient way of storing and accessing hierarchical data.
- Unlike linear data structures like arrays or linked lists, trees allow branching structures, which makes them suitable for hierarchical representations.
- The primary components of a tree include **nodes** (which store data) and **edges** (which define relationships between nodes), with the **root** node being the topmost node.

---

## Tree Terminologies

- **Node**: An element in the tree, which contains data and pointers to its child nodes.
- **Edge**: A connection between two nodes in the tree, representing the parent-child relationship.
- **Root**: The topmost node in a tree, from which all other nodes originate.
- **Leaf Node**: A node with no children, typically found at the bottom of the tree.
- **Parent Node**: A node that has one or more children.
- **Child Node**: A node that is a descendant of another node, i.e., it has a parent node.
- **Height**: The maximum number of edges from the root to any leaf node.
- **Depth**: The number of edges from the root to a given node.
- **Subtree**: A portion of the tree, consisting of a node and all its descendants.

---

## Binary Tree

- A **binary tree** is a type of tree in which each node has at most two children, usually referred to as the **left child** and the **right child**.
- Binary trees are used in many applications such as expression parsing, decision trees, and heap structures.
- A binary tree can be **balanced** or **unbalanced**, with balanced trees offering better performance in terms of search, insertion, and deletion.
- Binary trees can also be **complete** (all levels fully filled except possibly the last) or **full** (every node has either 0 or 2 children).

---

## Binary Tree Representation

- A binary tree is typically represented in two ways:
  - **Linked Representation**: In this representation, each node is an object that contains data and two pointers: one for the left child and one for the right child.
  - **Array Representation**: In an array representation, the binary tree is stored in an array such that the root node is at index 0, and the left and right children of a node at index `i` are stored at indices `2i+1` and `2i+2`, respectively.
- The **array representation** works best for **complete binary trees**, where the tree is perfectly balanced and filled at all levels.
- The **linked representation** is more flexible and efficient when dealing with sparse or unbalanced binary trees.

---

## Types of Binary Tree

- **Full Binary Tree**: A binary tree where every node has either zero or two children. It ensures that no node has exactly one child.
- **Complete Binary Tree**: A binary tree where all levels are completely filled except possibly the last, which is filled from left to right.
- **Perfect Binary Tree**: A binary tree where all leaf nodes are at the same level, and every internal node has exactly two children.
- **Degenerate (or Pathological) Tree**: A tree where each parent node has only one child, resembling a linked list rather than a tree.
- **Balanced Binary Tree**: A tree where the height of the left and right subtrees of any node differ by at most one. This ensures logarithmic height, improving performance.

---

## Binary Tree Traversals

- **Pre-order Traversal**: Visit the root node first, followed by the left subtree and then the right subtree. This traversal is used for tree copying or printing a tree’s structure.
- **In-order Traversal**: Visit the left subtree first, then the root node, followed by the right subtree. In a binary search tree, this traversal retrieves data in sorted order.
- **Post-order Traversal**: Visit the left subtree first, then the right subtree, and finally the root node. It is often used for deleting nodes or evaluating expressions in expression trees.
- **Level-order Traversal**: Also known as **breadth-first traversal**, it visits all nodes at the present depth level before moving on to nodes at the next depth level. This is done using a queue.

---

## Binary Search Tree

- A **Binary Search Tree (BST)** is a binary tree in which each node's left child contains a value less than the node’s value, and the right child contains a value greater than the node’s value.
- This property makes searching for an element in a BST efficient, with a time complexity of **O(log n)** in a balanced tree.
- The BST structure allows for fast searching, insertion, and deletion operations, which are essential in various applications like databases, indexing, and searching algorithms.
- The tree remains efficient as long as it remains balanced. Insertion and deletion operations may lead to an unbalanced tree, requiring rebalancing techniques.

---

## Operations on Binary Search Tree

- **Insertion**: Insert a new node by starting at the root and recursively moving left or right based on whether the new value is less or greater than the current node’s value.
- **Deletion**: Remove a node, considering three cases: no children (delete the node), one child (link the child directly to the parent), and two children (replace the node with its in-order successor).
- **Search**: Start from the root and recursively check if the search key is less than or greater than the current node’s value, moving left or right accordingly.
- **Traversal**: In-order, pre-order, and post-order traversals are used to process the nodes in a specific order depending on the application.

---

## Applications of Binary Tree - Expression Tree

- An **Expression Tree** is a binary tree where each leaf node contains an operand and each internal node contains an operator. It is used in the evaluation of mathematical expressions.
- The tree is used in **compilers** for parsing expressions, evaluating the result of mathematical expressions, and simplifying expressions.
- **Post-order traversal** of the expression tree is used to evaluate the expression, as it ensures that operands are processed before the operators.
- Expression trees can represent infix, prefix, or postfix expressions, and can be used for **compiling** or **interpreting** mathematical expressions.

---

## Huffman Encoding

- **Huffman Encoding** is a widely used lossless data compression algorithm. It uses a **binary tree** to assign variable-length codes to input characters, with more frequent characters assigned shorter codes.
- The process begins by calculating the frequency of each character in the input data. A **Huffman Tree** is then constructed by repeatedly merging the two least frequent characters or subtrees until a single tree is formed.
- The result is a **Huffman Code**, which is a prefix-free binary code used to represent the characters in the input data efficiently.
- Huffman encoding is used in formats like **ZIP**, **JPEG**, and **MP3** for file compression, reducing storage and transmission costs.

---

## Search Trees - AVL

- **AVL Trees** are self-balancing binary search trees. They maintain a balance factor for each node, ensuring that the height difference between the left and right subtrees is at most one.
- This property guarantees that the tree remains balanced, allowing search, insertion, and deletion operations to be performed in **O(log n)** time.
- The AVL tree is named after its inventors **Adelson-Velsky** and **Landis**. Balancing is maintained through rotations, ensuring that the tree does not degrade into a linked list.
- The AVL tree is more efficient than an unbalanced binary search tree because it guarantees logarithmic height.

---

## Rotations in AVL Tree

- **Rotations** are the operations used to restore balance in an AVL tree after insertion or deletion.
  - **Left Rotation**: Performed when a node’s right subtree is taller than its left subtree. The right child of the node becomes the new root, and the node becomes the left child of the new root.
  - **Right Rotation**: Performed when a node’s left subtree is taller than its right subtree. The left child of the node becomes the new root, and the node becomes the right child of the new root.
  - **Left-Right Rotation**: A combination of a left rotation followed by a right rotation, used when the imbalance occurs in the left subtree of the right child.
  - **Right-Left Rotation**: A combination of a right rotation followed by a left rotation, used when the imbalance occurs in the right subtree of the left child.

---

## Operations on AVL Tree

- **Insertion**: After a new node is inserted, the tree may become unbalanced. The **balance factor** of each ancestor node is updated, and if necessary, rotations are performed to restore balance.
- **Deletion**: After a node is deleted, the balance factors of the affected nodes are updated. If an ancestor node becomes unbalanced, rotations are performed to restore balance.
- **Search**: Searching in an AVL tree takes **O(log n)** time due to the balance property, ensuring that the tree remains efficient for fast lookups.
- **Rebalancing**: The AVL tree ensures that it remains balanced by performing rotations during insertions and deletions, keeping the height of the tree logarithmic.

---

## Introduction of B Tree

- A **B-Tree** is a self-balancing search tree used in databases and file systems. It is designed to store large amounts of data efficiently, typically on disk.
- Unlike binary trees, a B-tree node can have more than two children, making it ideal for systems with large amounts of data where minimizing disk access is crucial.
- The B-tree is balanced by ensuring that all leaf nodes are at the same depth, which guarantees that data retrieval operations are performed in logarithmic time.
- B-trees are used in databases to index and retrieve data efficiently.

---

## B+ Tree

- A **B+ Tree** is an extension of the B-Tree that stores all records at the leaf level, with internal nodes storing only keys to guide searches.
- This structure allows for efficient range queries and sequential access to data, making it particularly useful for database indexing.
- The **leaf nodes** in a B+ tree are connected in a linked list, enabling efficient traversal of data in sorted order.
- B+ trees are often used in applications that require high-performance **searching** and **range queries**, such as in file systems, databases, and storage engines.
