---
share_link: https://share.note.sx/lb8o9v5i#HSXzj1W0YDoNWVAsndbxtLIVdfkitw/hvBPqArVUALU
share_updated: 2025-10-15T00:22:08+05:30
---
1. Elements of dynamic programming
2. Difference between greedy approach and dynamic programming
3. Difference between naïve string matching and Rabin Karp
4. Differentiate between NP-Hard and NP-complete problem
5. Knuth-Morris-Pratt String Matching algorithm
6. Naïve String Matching Algorithm
7. Applications of String matching algorithms
8. Short note on NP hard and NP complete problem
9. Short note on Genetic Algorithms (GA)
10. Vertex Cover problem with example
11. Matrix Chain Multiplication problem
12. All pair shortest path problem
13. Travelling salesman problem
14. Longest Common Subsequence problem

--- 
### Answers

--- 

**Q1) Elements of dynamic programming.**

A **Dynamic Programming (DP) algorithm** is a method used to solve complex problems by breaking them into smaller overlapping subproblems, solving each subproblem only once, and storing their results to avoid redundant computation.

**Elements of Dynamic Programming:**
1. **Optimal Substructure** – Solution can be built from subproblem solutions.
2. **Overlapping Subproblems** – Same subproblems occur multiple times.
3. **Memoization** – Store results of solved subproblems (top-down).
4. **Tabulation** – Solve subproblems iteratively (bottom-up).
5. **State Definition** – Represent each subproblem by key parameters.
6. **Recurrence Relation** – Express relation between current and smaller subproblems.

Consider the **Fibonacci series**, where,
F(n) = F(n−1) + F(n−2), with F(0)=0 and F(1)=1.

Using **Dynamic Programming**, we store previously calculated terms:

Let
- **T1 = 0**
- **T2 = 1**

Then, compute further terms:
- **T3 = T1 + T2 = 0 + 1 = 1**
- **T4 = T2 + T3 = 1 + 1 = 2**
- **T5 = T3 + T4 = 1 + 2 = 3**
- **T6 = T4 + T5 = 2 + 3 = 5**
- **T7 = T5 + T6 = 3 + 5 = 8**

Thus, **F(6) = 8**.

**Example code (Python):**

```
def fibonacci(n):
    T1, T2 = 0, 1  
    if n == 0:
        return T1
    elif n == 1:
        return T2
    
    for i in range(2, n + 1):
        T3 = T1 + T2      
        T1 = T2
        T2 = T3
    return T3

print(fibonacci(6))  
```

--- 

**Q2) Difference between greedy approach and dynamic programming.**

| Factor                      | Greedy Approach                                   | Dynamic Programming                                                                           |
| --------------------------- | ------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| **Strategy**                | Makes the **locally optimal** choice at each step | Solves **subproblems** and combines results for global optimum                                |
| **Optimality**              | May **not always** give the global optimum        | **Always** gives global optimum if problem has overlapping subproblems & optimal substructure |
| **Overlapping Subproblems** | **Not required**                                  | **Required**                                                                                  |
| **Backtracking**            | **No backtracking**                               | May **require backtracking** for reconstruction                                               |
| **Example**                 | Kruskal's and Prim's algorithm                    | Matrix Chain Multiplication, Floyd-Warshall                                                   |
| **Complexity**              | Usually **faster and simpler**                    | **More complex**, but accurate                                                                |

--- 

**Q3) Difference between naïve string matching and Rabin Karp.**

| Factor                        | Naïve String Matching              | Rabin-Karp Algorithm                                     |
| ----------------------------- | ---------------------------------- | -------------------------------------------------------- |
| **Approach**                  | Compares pattern at every position | Uses **hashing** to compare pattern with text substrings |
| **Time Complexity (Average)** | **O(nm)**                          | **O(n + m)** average                                     |
| **Time Complexity (Worst)**   | **O(nm)**                          | **O(nm)** (due to hash collisions)                       |
| **Efficiency**                | **Less efficient** for large texts | **More efficient** for multiple pattern matching         |
| **Use of Hash**               | **Not used**                       | **Used** for quick comparison                            |
| **Example Use**               | Simple search in small data        | Searching multiple patterns or plagiarism detection      |

--- 

**Q4) Differentiate between NP-Hard and NP-complete problem.**

| Factor           | NP-Hard                                       | NP-Complete                                       |
| ---------------- | --------------------------------------------- | ------------------------------------------------- |
| **Definition**   | Problems **at least as hard as NP problems**  | Problems that are **both in NP and NP-Hard**      |
| **Verification** | **May not** be verifiable in polynomial time  | **Can** be verified in polynomial time            |
| **Solution**     | Not required to have polynomial-time verifier | Has polynomial-time verifier                      |
| **Relation**     | **Superset** of NP-Complete                   | **Subset** of NP-Hard                             |
| **Example**      | Halting Problem                               | Traveling Salesman, 3-SAT                         |
| **Solvability**  | **May not** be solvable at all                | **Solvable**, but not in polynomial time (so far) |

--- 

**Q5) Knuth-Morris-Pratt String Matching algorithm.**

The **KMP Algorithm** efficiently finds all occurrences of a pattern within a text by **avoiding unnecessary comparisons**. It preprocesses the pattern to create a **Longest Prefix Suffix (LPS)** array, which helps skip characters in the text when a mismatch occurs.

**Algorithm Steps:**

1. **Preprocess the pattern** to compute the LPS array, where `LPS[i]` stores the length of the longest proper prefix which is also a suffix for the pattern substring `P[0..i]`.
2. **Scan the text** from left to right:
    - Compare the pattern with the current text window.
    - If characters match, move to the next character in both pattern and text.
    - If a mismatch occurs:
        - Use the **LPS array** to shift the pattern without rechecking matched characters.
3. **Repeat** until the end of the text.
4. **Pattern found** whenever all characters of the pattern match the text window.

**Time Complexity:**
- **Preprocessing (LPS array):** O(m)
- **Searching:** O(n)
- **Overall:** O(n + m)

**Advantages:**
- Efficient for large texts and patterns
- Avoids redundant comparisons
- Works well for patterns with repeated substrings

**Disadvantages:**
- Slightly complex compared to Naïve approach
- Needs extra space for LPS array

`I am too lazy to add an example for this`

--- 

**Q6) Naïve String Matching Algorithm.**

The **Naïve String Matching Algorithm** is the simplest method for finding all occurrences of a pattern within a text. It works by checking every possible position in the text to see if the pattern starts there. Uses a **Brute-force approach** that slides the pattern over the text one by one.

**Algorithm Steps:**
1. **Slide the pattern** over the text one character at a time
2. **For each position** `i` in text (from 0 to n-m):
    - Check if pattern `P[0..m-1]` matches text `T[i..i+m-1]`
    - If all characters match, pattern found at position `i`
3. **Continue** until all possible positions are checked

**Time Complexity:**
- **Best Case:** O(n) - when pattern not found or found at beginning
- **Worst Case:** O(m × n) - when all characters match except the last one
- **Average Case:** O(m × n)

**Advantages:**
- Simple to understand and implement
- No preprocessing required
- Works well for small texts and patterns

**Disadvantages:**
- Inefficient for large texts
- Poor performance when pattern has many partial matches
- Not suitable for multiple pattern searching

`I am too lazy to add an example for this`

--- 

**Q7) Applications of String matching algorithms.**

- Search Engine Queries
- Plagiarism Detection
- Text Editors and Word Processors
- Digital Forensics and Cybersecurity
- Spell Checkers and Auto-Corrections
- Syntax Highlighting in Code Editors
- Lexical Analysis in Compilers
- Database Query Processing
- Email and Message Spam Filtering
- Regular Expressions and Text Analysis

--- 

**Q8) Short note on NP hard and NP complete problem.**

**NP Hard:**
- NP-Hard problems are **at least as hard as NP problems**.
- They **may not be verifiable** in polynomial time.
- They are **not required to have** a polynomial-time verifier.
- NP-Hard problems form a **superset** of NP-Complete problems.
- A common **example** is the **Halting Problem**.
- These problems **may not be solvable** at all.

**NP Complete:**
- NP-Complete problems are **both in NP and NP-Hard**.
- They **can be verified** in polynomial time.
- They **have** a polynomial-time verifier.
- NP-Complete problems form a **subset** of NP-Hard problems.
- Common **examples** include the **Traveling Salesman Problem** and **3-SAT**.
- These problems are **solvable**, but **no polynomial-time solution** is known so far.

--- 

**Q9) Short note on Genetic Algorithms (GA).**

Genetic Algorithms are **search and optimization techniques** inspired by the principles of **natural selection and genetics**. They work by evolving a population of candidate solutions over generations using **selection, crossover, and mutation** to find an optimal or near-optimal solution. GAs are particularly useful for **complex problems with large search spaces** where traditional methods may fail.

**Key Points:**

- **Population-based:** Multiple solutions evolve simultaneously.
- **Fitness Function:** Measures how good a solution is.
- **Operators:**
    - **Selection:** Chooses best solutions for reproduction.
    - **Crossover:** Combines parts of two solutions.
    - **Mutation:** Introduces random changes for diversity.
- **Applications:** Optimization problems, scheduling, machine learning, and engineering design.

--- 

**Q10) Vertex Cover problem with example.**

A subset of V is called a vertex covering of G if every edge of G is incident with or covered by a vertex in subset of V.

`I am too lazy to add an example for this`

--- 

**Q11) Matrix Chain Multiplication problem.**

The **Matrix Chain Multiplication problem** is a classic **dynamic programming problem**. It involves finding the most efficient way to multiply a given sequence of matrices.
The goal is **not to perform the multiplications**, but to **determine the order of multiplication** that minimizes the total number of scalar multiplications.

`I am too lazy to add an example for this`

--- 

**Q12) All pair shortest path problem.**

The **All-Pairs Shortest Path (APSP) Problem** is a fundamental problem in graph theory and computer science. Given a weighted graph (directed or undirected), the goal is to find the shortest path distance between **every pair of vertices** in the graph.

`I am too lazy to add an example for this`

--- 

**Q13) Travelling salesman problem.**

The **Travelling Salesman Problem (TSP)** is a classic **combinatorial optimization problem** in computer science and operations research.
A salesman must visit **each city exactly once** and return to the starting city, minimizing the total travel cost or distance.

`I am too lazy to add an example for this`

--- 

**Q14) Longest Common Subsequence problem.**

S1: bcdaacd
S2: acdbac

| X   | X   | b   | c   | d   | a   | a   | c   | d   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| X   | 0   | 0   | 0   | 0   | 0   | 0   | 0   | 0   |
| a   | 0   | 0   | 0   | 0   | 1   | 1   | 1   | 1   |
| c   | 0   | 0   | 1   | 1   | 1   | 1   | 2   | 2   |
| d   | 0   | 0   | 1   | 2   | 2   | 2   | 2   | 3   |
| b   | 0   | 1   | 1   | 2   | 2   | 2   | 2   | 3   |
| a   | 0   | 1   | 1   | 2   | 3   | 3   | 3   | 3   |
| c   | 0   | 1   | 2   | 2   | 3   | 3   | 4   | 4   |
LCS = cdac