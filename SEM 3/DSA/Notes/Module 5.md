## Introduction to Graphs

### Theory

1. **Definition of Graph**: A graph is a mathematical structure used to model pairwise relationships between objects. It consists of a set of vertices (also called nodes) connected by edges (also called arcs). Graphs can represent various systems such as social networks, transportation systems, or web pages.

2. **Types of Graphs**: Graphs can be classified into two main categories:

   - **Directed Graph (Digraph)**: Edges have a direction, i.e., each edge is an ordered pair of vertices.
   - **Undirected Graph**: Edges do not have a direction, i.e., each edge is an unordered pair of vertices.

3. **Graph Representation**: Graphs can be represented in multiple ways:

   - **Adjacency Matrix**: A 2D matrix where each element represents the presence or weight of an edge between two vertices.
   - **Adjacency List**: A list where each vertex has a collection of vertices it is connected to.
   - **Edge List**: A list of all the edges in the graph, where each edge is represented as a pair of vertices.

4. **Graph Applications**: Graphs are used in a variety of real-world applications:

   - Social networks (e.g., Facebook friends, Twitter followers).
   - Web page ranking (e.g., Google PageRank algorithm).
   - Route mapping and navigation (e.g., Google Maps, road networks).
   - Network security (e.g., firewalls and intrusion detection).

5. **Weighted Graphs**: In weighted graphs, each edge has an associated weight or cost. This is commonly used in shortest path algorithms, such as Dijkstra's and Bellman-Ford algorithms, where the edge weight represents the distance or cost between nodes.

6. **Directed Acyclic Graph (DAG)**: A special type of directed graph where no cycles exist. DAGs are used in various applications like task scheduling, data processing, and in representing dependencies (e.g., project management tools).

7. **Graph Traversal**: Traversal refers to visiting all vertices in a graph systematically. Two common graph traversal techniques are:

   - **Depth First Search (DFS)**: Explores a graph by diving deep into each branch before backtracking.
   - **Breadth First Search (BFS)**: Explores a graph level by level, visiting all neighbors of a vertex before moving on to the next level.

8. **Complexity**: The time complexity of graph operations such as traversal depends on the method of representation. For adjacency lists, traversing a graph has a complexity of O(V + E), where V is the number of vertices and E is the number of edges. For adjacency matrices, it is O(V^2) due to the need to check every pair of vertices.

# Directed vs Undirected Graphs

| **Feature**                  | **Directed Graph (Digraph)**                                                              | **Undirected Graph**                                                                   |
| ---------------------------- | ----------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| **Definition**               | A graph in which edges have a direction, from one vertex to another.                      | A graph where edges do not have a direction, connecting two vertices bidirectionally.  |
| **Edge Direction**           | Each edge has a direction (from vertex A to vertex B).                                    | Edges do not have any direction (from vertex A to vertex B, or vice versa).            |
| **Edge Representation**      | Edges are represented as ordered pairs (A → B).                                           | Edges are represented as unordered pairs (A, B).                                       |
| **Connectivity**             | If there is an edge from A to B, it does not imply an edge from B to A.                   | If there is an edge between A and B, there is an implicit connection both ways.        |
| **Example**                  | If there’s an edge from **A** to **B**, it’s written as (A → B).                          | If there’s an edge between **A** and **B**, it’s written as (A, B).                    |
| **In-degree and Out-degree** | Nodes have both in-degree (edges coming in) and out-degree (edges going out).             | No concept of in-degree or out-degree. Each node has just a degree (number of edges).  |
| **Cycle Detection**          | Can have one-way cycles (e.g., A → B → C → A).                                            | Cycles are bidirectional (e.g., A — B — C — A).                                        |
| **Use Cases**                | Modeling one-way relationships like Twitter followers, web page links, or network flows.  | Modeling two-way relationships like social networks, undirected roads, or friendships. |
| **Graph Traversal**          | Traversal can be done in specific directions (DFS, BFS).                                  | Traversal is simpler since edges are bidirectional.                                    |
| **Symmetry of Edges**        | Edges are not symmetric (A → B does not imply B → A).                                     | Edges are symmetric (A — B means B — A).                                               |
| **Example Graph**            | `A → B → C → D` (One-way flow)                                                            | `A — B — C — D` (Two-way flow)                                                         |
| **Memory Representation**    | Requires storing both directions of edges (forward and reverse) in adjacency list/matrix. | Only one direction of the edge is needed in adjacency list/matrix.                     |

## Graph Terminologies

### Theory

1. **Vertex (Node)**: A vertex is a fundamental unit of a graph representing an entity such as a person, location, or any other object. Vertices are connected by edges, and in some cases, vertices may have attributes associated with them.

2. **Edge (Arc)**: An edge is a connection or relationship between two vertices. In directed graphs, edges have a direction (from one vertex to another), while in undirected graphs, edges do not have a direction and represent a bidirectional relationship.

3. **Degree**: The degree of a vertex refers to the number of edges connected to it. In directed graphs, the degree is split into in-degree (the number of incoming edges) and out-degree (the number of outgoing edges). A vertex with no edges is called an isolated vertex.

4. **Path**: A path is a sequence of vertices in which each consecutive pair of vertices is connected by an edge. A path does not revisit any vertex or edge in undirected graphs, but directed graphs may revisit vertices if cycles exist.

5. **Cycle**: A cycle in a graph is a path that begins and ends at the same vertex, with no repeated edges or vertices. Cycles are important in many algorithms and are often detected using depth-first search (DFS).

6. **Connected Graph**: A graph is connected if there is a path between every pair of vertices. In other words, for every pair of vertices u and v, there is a sequence of edges leading from u to v. A disconnected graph has separate subgraphs that are not connected to each other.

7. **Subgraph**: A subgraph is a portion of a graph consisting of a subset of vertices and edges. The subgraph is itself a graph, and it must include all edges between the vertices in the subset. A subgraph may be induced by selecting vertices and all edges that connect them.

8. **Complete Graph**: A complete graph is a graph in which every pair of distinct vertices is connected by a unique edge. In a complete graph, every vertex is adjacent to every other vertex. The number of edges in a complete graph with n vertices is n(n-1)/2 for an undirected graph.

## Representation of Graph

### Theory

1. **Adjacency Matrix**: An adjacency matrix is a 2D array where each cell (i, j) indicates the presence (or weight) of an edge between vertex i and vertex j. It is suitable for dense graphs, where the number of edges is close to the maximum possible number of edges. However, it requires O(V^2) space, where V is the number of vertices.

2. **Adjacency List**: An adjacency list represents a graph by associating each vertex with a list of its adjacent vertices. It is more space-efficient than the adjacency matrix for sparse graphs because it only requires space proportional to the number of edges. It is often used in algorithms that involve traversal or pathfinding.

3. **Incidence Matrix**: An incidence matrix is a matrix that relates vertices and edges in a graph. Each row represents a vertex, and each column represents an edge. The elements indicate whether a vertex is connected to a particular edge. This representation is useful for edge-centric applications but less efficient for dense graphs.

4. **Edge List**: An edge list is a simple representation where each edge in the graph is stored as a pair of vertices. It can be represented as an array or a linked list. This representation is memory-efficient and easy to use for algorithms that require edge enumeration, but it is not optimal for algorithms that require quick access to vertex neighbors.

5. **Adjacency Set**: Similar to the adjacency list, but instead of storing a list of adjacent vertices, an adjacency set uses a set data structure for each vertex. This allows for efficient checks for the existence of an edge between two vertices, especially in sparse graphs.

6. **Weighted Graph Representation**: In a weighted graph, where edges have weights (such as costs or distances), the adjacency matrix or list can be modified to store these weights. For an adjacency matrix, the value in position (i, j) would be the weight of the edge between vertex i and vertex j, or infinity if no edge exists.

7. **Space Complexity Consideration**: The space complexity of the graph representation varies depending on the structure used. For an adjacency matrix, it is O(V^2), while for an adjacency list, it is O(V + E), where E is the number of edges. The adjacency list is typically more efficient in terms of space for sparse graphs.

8. **Representation Choice**: The choice of graph representation depends on the graph's properties and the type of operations that need to be performed. For example, adjacency matrices are faster for checking if two vertices are connected but are inefficient for sparse graphs, whereas adjacency lists are better for sparse graphs with many vertices but fewer edges.

## Graph Traversals - Depth First Search (DFS) and Breadth First Search (BFS)

### Theory

### 1. **Depth First Search (DFS)**:

DFS is a graph traversal algorithm that starts at a source node and explores as far along each branch as possible before backtracking. It uses a stack (or recursion) to keep track of the visited nodes and returns to the last unvisited node when necessary. DFS is used for tasks like pathfinding, cycle detection, and topological sorting.

### 2. **DFS in Directed and Undirected Graphs**:

DFS works in both directed and undirected graphs. In a directed graph, DFS explores each directed edge, while in an undirected graph, it considers all the edges irrespective of direction. It visits all nodes in the graph, if reachable, and is useful for checking graph connectivity and detecting cycles.

### 3. **Stack Implementation**:

DFS can be implemented using either an explicit stack or recursion. In recursive DFS, the call stack manages the traversal. For an explicit stack, each vertex is pushed onto the stack, and neighbors are visited by popping the stack. The time complexity is O(V + E), where V is vertices and E is edges.

### 4. **DFS Applications**:

DFS is used in applications such as finding strongly connected components, topological sorting of a Directed Acyclic Graph (DAG), solving puzzles like mazes, and checking for cycles in directed and undirected graphs. It can also be used in algorithms like finding a path from a source to a destination.

### 5. **(DFS) C Program**:

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 10

// Declare adjacency matrix
int adj[MAX][MAX], visited[MAX];

// Depth First Search function
void DFS(int vertex, int n) {
    // Mark the current node as visited
    visited[vertex] = 1;
    printf("%d ", vertex);

    // Recursively visit all unvisited adjacent vertices
    for (int i = 0; i < n; i++) {
        if (adj[vertex][i] == 1 && !visited[i]) {
            DFS(i, n);
        }
    }
}

int main() {
    int n, e, x, y;

    // Read number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Initialize adjacency matrix and visited array
    for (int i = 0; i < n; i++) {
        visited[i] = 0;
        for (int j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
    }

    // Read the edges
    printf("Enter the number of edges: ");
    scanf("%d", &e);
    for (int i = 0; i < e; i++) {
        printf("Enter the edge (u, v): ");
        scanf("%d %d", &x, &y);
        adj[x][y] = 1;
        adj[y][x] = 1; // If the graph is undirected
    }

    // Perform DFS starting from vertex 0
    printf("Depth First Search (DFS) traversal: ");
    DFS(0, n);

    return 0;
}

```

### 6. **Breadth First Search (BFS)**:

BFS explores a graph level by level, visiting all neighbors of a vertex before moving on to the neighbors’ neighbors. It starts from the source node, visits all nodes at distance 1, then all at distance 2, and so on. BFS is implemented using a queue and is ideal for finding the shortest path in unweighted graphs.

### 7. **Queue Implementation**:

BFS uses a queue to maintain the vertices to be explored. Initially, the starting node is enqueued, and then the algorithm dequeues a node, explores its neighbors, and enqueues unvisited neighbors. This continues until all reachable nodes are explored. BFS also has a time complexity of O(V + E).

### 8. **Applications of BFS**:

BFS is optimal for finding the shortest path in unweighted graphs, as it explores nodes layer by layer. It is also used for level-order traversal in trees, solving problems like "minimum number of edges" between nodes, and checking if a graph is bipartite.

### 9. **(BFS) C Program**:

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 10

// Declare adjacency matrix
int adj[MAX][MAX], visited[MAX];

// Queue structure for BFS
struct Queue {
    int items[MAX];
    int front, rear;
};

// Function to initialize the queue
void initQueue(struct Queue *q) {
    q->front = -1;
    q->rear = -1;
}

// Function to check if the queue is empty
int isEmpty(struct Queue *q) {
    return q->front == -1;
}

// Function to enqueue an element
void enqueue(struct Queue *q, int value) {
    if (q->rear == MAX - 1) {
        printf("Queue is full\n");
        return;
    }
    if (q->front == -1) {
        q->front = 0;
    }
    q->rear++;
    q->items[q->rear] = value;
}

// Function to dequeue an element
int dequeue(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    }
    int item = q->items[q->front];
    q->front++;
    if (q->front > q->rear) {
        q->front = q->rear = -1; // Reset the queue when empty
    }
    return item;
}

// BFS function
void BFS(int start, int n) {
    struct Queue q;
    initQueue(&q);

    visited[start] = 1;
    enqueue(&q, start);
    printf("Breadth First Search (BFS) traversal: ");

    while (!isEmpty(&q)) {
        int vertex = dequeue(&q);
        printf("%d ", vertex);

        // Visit all the adjacent vertices of the dequeued node
        for (int i = 0; i < n; i++) {
            if (adj[vertex][i] == 1 && !visited[i]) {
                visited[i] = 1;
                enqueue(&q, i);
            }
        }
    }
}

int main() {
    int n, e, x, y;

    // Read number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Initialize adjacency matrix and visited array
    for (int i = 0; i < n; i++) {
        visited[i] = 0;
        for (int j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
    }

    // Read the edges
    printf("Enter the number of edges: ");
    scanf("%d", &e);
    for (int i = 0; i < e; i++) {
        printf("Enter the edge (u, v): ");
        scanf("%d %d", &x, &y);
        adj[x][y] = 1;
        adj[y][x] = 1; // If the graph is undirected
    }

    // Perform BFS starting from vertex 0
    BFS(0, n);

    return 0;
}

```

### 10. **Comparison of DFS and BFS**:

| **Aspect**                 | **DFS**                                                                                 | **BFS**                                                                            |
| -------------------------- | --------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **Traversal Method**       | Explores as far as possible along each branch before backtracking.                      | Explores level by level, visiting all neighbors before moving to the next level.   |
| **Data Structure**         | Uses a stack (explicit or recursion).                                                   | Uses a queue.                                                                      |
| **Memory Usage**           | Requires more memory due to deep recursion or stack usage.                              | Typically uses less memory as it processes nodes layer by layer.                   |
| **Optimal for**            | Pathfinding, cycle detection, and topological sorting in directed acyclic graphs (DAG). | Finding the shortest path in unweighted graphs and level-order traversal in trees. |
| **Time Complexity**        | O(V + E), where V is vertices and E is edges.                                           | O(V + E), where V is vertices and E is edges.                                      |
| **Space Complexity**       | O(V) in the worst case due to recursion or stack usage.                                 | O(V) due to the queue storing nodes at the current level.                          |
| **Search Direction**       | May go deep into a branch and revisit nodes.                                            | Explores nodes level by level, ensuring all nodes at a given level are processed.  |
| **Graph Type Suitability** | Works well with both directed and undirected graphs for full exploration.               | Best suited for unweighted graphs, especially for finding the shortest path.       |

## Graph Application - Topological Sorting

### Theory

1. **Topological Sorting**: Topological sorting is a linear ordering of vertices in a Directed Acyclic Graph (DAG) such that for every directed edge \( u \to v \), vertex \( u \) appears before vertex \( v \) in the ordering. It is commonly used for tasks such as job scheduling and resolving dependencies in systems.

2. **DAG Requirement**: Topological sorting is only possible for Directed Acyclic Graphs (DAGs), as a cycle in the graph would create a contradiction in the ordering (i.e., no vertex can appear before and after itself in a valid ordering).

3. **Applications of Topological Sorting**: It is used in applications like scheduling tasks in operating systems, determining the compilation order of files in programming, resolving dependencies in package management systems, and arranging activities in a way that respects their dependencies.

4. **DFS-based Algorithm**: One way to perform topological sorting is through a Depth First Search (DFS)-based algorithm. During the DFS traversal, each vertex is marked as visited, and the vertex is added to a stack when all its adjacent vertices are visited. The stack's contents provide the topological order.

5. **Kahn's Algorithm**: Another approach to topological sorting is Kahn's algorithm, which works by maintaining the in-degree (number of incoming edges) for each vertex. Vertices with an in-degree of 0 are placed in a queue, and as these vertices are processed, the in-degrees of their neighbors are decreased. The process continues until all vertices are processed.

6. **Complexity**: Both DFS-based topological sorting and Kahn's algorithm have a time complexity of \( O(V + E) \), where \( V \) is the number of vertices and \( E \) is the number of edges. These algorithms ensure that every vertex and edge is processed exactly once.

7. **Cycle Detection**: If, during topological sorting, not all vertices are processed (i.e., some vertices remain with non-zero in-degree), the graph contains a cycle. Therefore, topological sorting can also be used as a method for detecting cycles in a directed graph.

8. **Implementation in Practical Scenarios**: Topological sorting is widely used in areas such as project planning (where tasks have dependencies), computer science (compiling languages with dependencies), and network analysis (finding dependencies among different systems or processes).
