# Searching and Sorting Techniques

## Radix Sort

### Theory

1. **Non-Comparative Sorting**: Radix Sort is a non-comparative sorting algorithm that sorts numbers based on individual digits. It processes each digit starting from the least significant digit (LSD) or the most significant digit (MSD) in order.

2. **Stable Sorting**: Radix Sort is stable, meaning that it preserves the relative order of elements with equal values. This property makes it useful in applications that require stable sorting.

3. **Multiple Passes**: The algorithm performs multiple passes over the data, each time sorting based on a single digit. The number of passes depends on the number of digits in the largest number.

4. **Efficiency**: Radix Sort has a time complexity of O(nk), where n is the number of elements and k is the number of digits in the largest number. It is efficient when k is small compared to n.

5. **Memory Usage**: While the algorithm can be memory-intensive due to the use of auxiliary storage for sorting, it performs efficiently on large datasets with a fixed range of digits.

6. **Not In-Place**: Radix Sort is not an in-place algorithm, meaning it requires additional space proportional to the input size for sorting the digits.

7. **Use Case**: Radix Sort is particularly effective for sorting integers or strings where the data has a uniform distribution of digits. It is often used in applications like sorting large datasets or numbers in parallel systems.

8. **Limitations**: Radix Sort is limited to integer or string data types, and it can be inefficient when the range of digit values (k) is large, leading to higher complexity.

### Algorithm: Radix Sort

1. Find the maximum number in the array to determine the number of digits.
2. For each digit (starting from the least significant digit):
   - Perform a stable sort using the digit in the current place.
   - Repeat the sorting process for all digits.
3. Return the sorted array.

### C Code: Radix Sort

```c
#include <stdio.h>
#include <stdlib.h>

void countingSort(int arr[], int n, int exp) {
    int output[n];
    int count[10] = {0};

    for (int i = 0; i < n; i++)
        count[(arr[i] / exp) % 10]++;

    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < n; i++)
        arr[i] = output[i];
}

void radixSort(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++)
        if (arr[i] > max)
            max = arr[i];

    for (int exp = 1; max / exp > 0; exp *= 10)
        countingSort(arr, n, exp);
}

int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);

    radixSort(arr, n);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}
```

## Merge Sort

### Theory

1. **Divide and Conquer**: Merge Sort is a divide-and-conquer algorithm that divides the array into two halves, recursively sorts each half, and merges them together. It repeatedly divides the problem into smaller subproblems.

2. **Stable Sorting**: Merge Sort is a stable sorting algorithm, meaning that it preserves the relative order of elements with equal values. This is particularly useful when sorting data with multiple attributes.

3. **Time Complexity**: Merge Sort has a time complexity of O(n log n) in the best, worst, and average cases, making it one of the more efficient sorting algorithms for large datasets.

4. **Space Complexity**: Merge Sort requires additional space proportional to the size of the array being sorted, with a space complexity of O(n), since it requires extra space for the temporary arrays during the merge phase.

5. **Not In-Place Sorting**: Merge Sort is not an in-place sorting algorithm. It uses additional memory to store the left and right halves of the array during the merging process.

6. **Use Case**: Merge Sort is particularly useful when stable sorting is required, or when dealing with large datasets that do not fit entirely into memory. It’s often used in external sorting algorithms.

7. **Efficiency for Large Datasets**: Merge Sort is highly efficient for sorting large datasets, especially when the data is stored in external memory or when sorting linked lists. It is consistently O(n log n), unlike Quick Sort, which can degrade to O(n²).

8. **Limitations**: The primary limitation of Merge Sort is its additional space requirement, which can be a significant overhead for large datasets. It is also slower in practice compared to algorithms like Quick Sort when dealing with smaller datasets.

### Algorithm: Merge Sort

1. Divide the unsorted list into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves into a single sorted list.

### C Code: Merge Sort

```c
#include <stdio.h>

void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);

    mergeSort(arr, 0, n - 1);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    return 0;
}
```

## Insertion Sort

### Theory

1. **Basic Concept**: Insertion Sort works similarly to how you would sort playing cards in your hands. It picks an element and places it at the correct position in a sorted part of the array. This process is repeated for every element in the array.

2. **Time Complexity**: The worst-case time complexity of Insertion Sort is O(n²), which occurs when the array is sorted in reverse order. The best-case time complexity is O(n), which occurs when the array is already sorted.

3. **Space Complexity**: Insertion Sort is an in-place sorting algorithm, meaning it does not require extra space for another array or data structure. Its space complexity is O(1).

4. **Stable Sorting**: Insertion Sort is stable, meaning that equal elements retain their relative order after sorting. This property is useful when sorting objects or records with multiple attributes.

5. **Use Case**: Insertion Sort is ideal for small datasets or nearly sorted data. It is very efficient when dealing with a small number of elements and works well for tasks like sorting cards or real-time systems where data arrives gradually.

6. **Adaptive**: Insertion Sort adapts well to data that is already partially sorted. As a result, it often performs much better than other O(n²) algorithms, such as Bubble Sort and Selection Sort, when dealing with nearly sorted arrays.

7. **Efficiency for Small Data**: Due to its simple nature and low overhead, Insertion Sort can perform well on small datasets. It is often used as a subroutine in other algorithms like Timsort when sorting small portions of data.

8. **Limitations**: Insertion Sort becomes inefficient for large datasets because of its O(n²) time complexity. It is generally not recommended for sorting large amounts of data but is useful for certain applications involving small or nearly sorted datasets.

### Algorithm: Insertion Sort

1. Start from the second element of the array.
2. Compare the current element with the previous element.
3. If the current element is smaller, shift the larger elements to the right and place the current element in its correct position.
4. Repeat the process for all elements in the array.

### C Code: Insertion Sort

```c
#include <stdio.h>

void insertionSort(int arr[], int n) {
    int i, key, j;
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;

        // Move elements of arr[0..i-1], that are greater than key, to one position ahead
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    insertionSort(arr, n);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    return 0;
}
```

## Selection Sort

### Theory

1. **Basic Concept**: Selection Sort works by repeatedly finding the smallest (or largest) element from the unsorted portion of the array and swapping it with the first unsorted element. This process continues until the entire array is sorted.

2. **Time Complexity**: The time complexity of Selection Sort is O(n²) in all cases (best, worst, and average), because it always performs n-1 comparisons in the first pass, n-2 in the second, and so on, regardless of the input data.

3. **Space Complexity**: Selection Sort is an in-place sorting algorithm, meaning it does not require any extra space for another array or data structure. Its space complexity is O(1), which makes it efficient in terms of memory usage.

4. **Not Stable**: Selection Sort is not a stable sorting algorithm. This means that equal elements may not retain their original relative order after sorting, which can be problematic in certain applications where the order of equal elements matters.

5. **Use Case**: Selection Sort is often used in situations where memory is limited, and its simplicity makes it a good choice for small datasets. However, due to its O(n²) complexity, it is not recommended for large datasets.

6. **Efficiency for Small Data**: While not the most efficient for large datasets, Selection Sort performs well on small arrays, where its simplicity and low overhead make it competitive with other O(n²) algorithms like Insertion Sort and Bubble Sort.

7. **Minimizes Swap Operations**: Selection Sort minimizes the number of swaps compared to other O(n²) algorithms. Each element is swapped at most once, which can be beneficial when the cost of swapping elements is high.

8. **Limitations**: The primary limitation of Selection Sort is its quadratic time complexity, which makes it inefficient for large datasets. For larger arrays, more advanced sorting algorithms like Merge Sort, Quick Sort, or Heap Sort are usually preferred.

### Algorithm: Selection Sort

1. Iterate over the array and find the smallest element in the unsorted portion.
2. Swap the smallest element with the first unsorted element.
3. Repeat this process for all unsorted elements in the array until the entire array is sorted.

### C Code: Selection Sort

```c
#include <stdio.h>

void selectionSort(int arr[], int n) {
    int i, j, minIndex, temp;

    for (i = 0; i < n - 1; i++) {
        minIndex = i;

        for (j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Swap the found minimum element with the first element of unsorted part
        temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}

int main() {
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr) / sizeof(arr[0]);

    selectionSort(arr, n);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
```

## Quick Sort

### Theory

1. **Basic Concept**: Quick Sort is a divide-and-conquer algorithm that selects a 'pivot' element from the array and partitions the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.

2. **Time Complexity**: The average time complexity of Quick Sort is O(n log n), but its worst-case time complexity is O(n²), which occurs when the pivot elements are poorly chosen (e.g., always picking the smallest or largest element as pivot). However, it performs well in practice with good pivot selection.

3. **Space Complexity**: Quick Sort is an in-place sorting algorithm, meaning it does not require additional storage except for the stack used by recursion. Its space complexity is O(log n) on average, but it can reach O(n) in the worst case due to deep recursion.

4. **Stable vs Unstable**: Quick Sort is not a stable sorting algorithm. This means that equal elements may not retain their original order after sorting, which could be problematic in certain applications where relative order matters.

5. **Pivot Selection**: The performance of Quick Sort heavily depends on how the pivot element is chosen. Common pivot selection methods include selecting the first element, the last element, the middle element, or using randomization. Randomized pivot selection helps avoid the worst-case time complexity.

6. **Efficiency for Large Datasets**: Quick Sort is highly efficient for large datasets due to its O(n log n) average time complexity. It is often preferred over other algorithms like Merge Sort or Selection Sort when sorting large arrays, as it generally outperforms them in real-world scenarios.

7. **Tail Recursion Optimization**: Quick Sort can be optimized by eliminating tail recursion, which occurs when one recursive call is the last operation. This can reduce the amount of memory used by the recursion stack and improve performance for large arrays.

8. **Applications**: Quick Sort is widely used in sorting applications where average case performance is critical. It is commonly used in libraries and systems where sorting speed is important, such as databases, file systems, and other data-processing applications.

### Algorithm: Quick Sort

1. Choose a pivot element from the array.
2. Partition the array into two sub-arrays: one containing elements less than the pivot, and one containing elements greater than the pivot.
3. Recursively apply Quick Sort to the sub-arrays until the base case (array with 1 or 0 elements) is reached.
4. Combine the sorted sub-arrays to obtain the final sorted array.

### C Code: Quick Sort

```c
#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int arr[] = {10, 80, 30, 90, 40, 50, 70};
    int n = sizeof(arr) / sizeof(arr[0]);

    quickSort(arr, 0, n - 1);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
```

## Radix Sort

### Theory

1. **Basic Concept**: Radix Sort is a non-comparative sorting algorithm that sorts data with integer keys by grouping the keys by the individual digits which share the same significant position. It processes digits starting from the least significant digit (LSD) or most significant digit (MSD) depending on the implementation.

2. **Time Complexity**: The time complexity of Radix Sort is O(n \* k), where n is the number of elements and k is the number of digits in the largest number. The time complexity is linear relative to the number of elements and digits, making it efficient for sorting integers or fixed-length strings.

3. **Space Complexity**: Radix Sort requires additional space for the counting sort (or bucket sort) used in each digit pass, so its space complexity is O(n + k), where n is the number of elements and k is the range of digits (e.g., 10 for decimal numbers).

4. **Stable Sorting**: Radix Sort is a stable sorting algorithm, meaning that if two elements are equal, they will retain their relative order after sorting. This feature is important when sorting multi-field records, such as sorting a list of names and then sorting by ages.

5. **Efficiency for Large Data**: Radix Sort is highly efficient when sorting large sets of data, especially when the number of digits (k) is significantly smaller than the number of elements (n). It is used in applications where sorting numbers or strings with uniform lengths is required, like in external sorting.

6. **Limitations**: Radix Sort is limited to sorting data that can be mapped to integer values or strings. It may not be as efficient when sorting floating-point numbers or objects that don't have a clear numeric representation. Additionally, it may not be as efficient for small datasets compared to algorithms like Quick Sort or Merge Sort.

7. **Digit Processing**: In Radix Sort, each digit (or character) is processed using a stable sorting algorithm like Counting Sort. The key idea is that sorting each digit independently ensures the overall sorted order once all digits are processed. The sorting proceeds from the least significant to the most significant digit in the LSD variant.

8. **Applications**: Radix Sort is useful in applications where the dataset consists of integers, fixed-length strings, or data that can be interpreted as numbers. It is commonly used in databases, external sorting, and certain algorithms for efficiently handling large datasets in data processing tasks.

### Algorithm: Radix Sort

1. Find the maximum number to determine the number of digits.
2. Start sorting from the least significant digit (LSD) or most significant digit (MSD).
3. Use a stable sorting algorithm (e.g., Counting Sort) to sort based on each digit.
4. Repeat the process for all digits, from the least significant to the most significant (or vice versa).
5. After sorting all digits, the list is sorted.

### C Code: Radix Sort

```c
#include <stdio.h>

#define MAX 10

// A function to do counting sort based on the digit represented by exp.
void countingSort(int arr[], int n, int exp) {
    int output[n];
    int count[MAX] = {0};

    // Store count of occurrences in count[]
    for (int i = 0; i < n; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    // Change count[i] to contain the actual position of this digit in output[]
    for (int i = 1; i < MAX; i++) {
        count[i] += count[i - 1];
    }

    // Build the output array
    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    // Copy the output array to arr[], so that arr[] contains sorted numbers
    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

// The main function to that sorts arr[] using Radix Sort
void radixSort(int arr[], int n) {
    // Find the maximum number to determine the number of digits
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Do counting sort for every digit. The exp is 10^i where i is the current digit number.
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSort(arr, n, exp);
    }
}

int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);

    radixSort(arr, n);

    printf("Sorted array: \n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
```

## Linear Search

### Theory

1. **Basic Concept**: Linear Search is a simple search algorithm that checks each element in a list or array sequentially to find a target value. It starts from the first element and continues until the target is found or the list ends.

2. **Time Complexity**: The time complexity of Linear Search is O(n), where n is the number of elements in the array or list. This means that in the worst case, it may have to check all elements, making it inefficient for large datasets.

3. **Space Complexity**: The space complexity of Linear Search is O(1) as it does not require any additional space apart from the input array and the search target. It works in-place without the need for extra memory allocation.

4. **Ease of Implementation**: Linear Search is one of the simplest search algorithms to implement. It does not require any advanced data structures or algorithms, making it easy to understand and use in small applications.

5. **No Sorting Required**: Unlike many other search algorithms, Linear Search does not require the list to be sorted. It can be applied to any unsorted list or array, which makes it versatile but inefficient for large datasets.

6. **Best Case**: The best case occurs when the target element is the first element in the list. In this case, the search takes constant time, O(1), as it finds the element immediately.

7. **Worst Case**: The worst-case scenario happens when the target element is not present in the array or is located at the last position. In this case, the algorithm must check every element in the array, resulting in O(n) time complexity.

8. **Applications**: Linear Search is useful in situations where the dataset is small or unsorted, and the overhead of more efficient search algorithms (like Binary Search) would not be justified. It is commonly used for searching in lists, simple data validation, and small-scale applications.

### Algorithm: Linear Search

1. Start at the first element of the array.
2. Compare the current element with the target element.
3. If the current element matches the target, return the index of the element.
4. If the current element does not match the target, move to the next element.
5. Repeat steps 2-4 until the target element is found or the list ends.
6. If the target is not found, return a value indicating the element is absent (e.g., -1).

### C Code: Linear Search

```c
#include <stdio.h>

// Function to perform linear search
int linearSearch(int arr[], int n, int target) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == target) {
            return i; // Return the index of the found element
        }
    }
    return -1; // Return -1 if element is not found
}

int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 30;

    int result = linearSearch(arr, n, target);

    if (result != -1) {
        printf("Element found at index: %d\n", result);
    } else {
        printf("Element not found\n");
    }

    return 0;
}
```

## Binary Search

### Theory

1. **Basic Concept**: Binary Search is an efficient search algorithm that works on sorted arrays. It repeatedly divides the search interval in half. If the value of the target is less than the value in the middle of the interval, the search continues in the left half; otherwise, it continues in the right half.

2. **Time Complexity**: The time complexity of Binary Search is O(log n), where n is the number of elements in the array. This is much faster than Linear Search (O(n)), especially for large datasets, as it reduces the search space by half with each comparison.

3. **Space Complexity**: The space complexity of Binary Search is O(1) when implemented iteratively, as it only requires a few extra variables to store the low, high, and mid pointers. Recursive implementations may have a space complexity of O(log n) due to the function call stack.

4. **Precondition**: Binary Search only works on **sorted arrays or lists**. If the list is not sorted, it must be sorted first, which can increase the overhead of using this algorithm. Sorting takes O(n log n) time in general.

5. **Best Case**: The best case occurs when the target element is in the middle of the array. In this case, Binary Search will find the element in the first comparison, resulting in O(1) time complexity.

6. **Worst Case**: The worst-case scenario occurs when the target element is at the very end of the array or not present at all. In this case, the algorithm divides the search space log n times, making the time complexity O(log n).

7. **Divide and Conquer**: Binary Search follows a **divide and conquer** approach. It divides the array into two halves at each step, significantly reducing the number of comparisons needed compared to Linear Search, especially in large datasets.

8. **Applications**: Binary Search is commonly used for searching in large datasets that are already sorted, such as looking up values in databases, finding elements in sorted lists, and performing fast searches in computational geometry problems.

### Algorithm: Binary Search

1. Initialize two pointers, `low` and `high`, to the first and last index of the array, respectively.
2. Find the middle element `mid = (low + high) / 2`.
3. If the middle element is equal to the target, return `mid`.
4. If the target is less than the middle element, set `high = mid - 1`.
5. If the target is greater than the middle element, set `low = mid + 1`.
6. Repeat steps 2-5 until the target is found or `low > high`.
7. If the target is not found, return -1.

### C Code: Binary Search

```c
#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int n, int target) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        // Check if the target is at the middle
        if (arr[mid] == target) {
            return mid; // Return the index of the target
        }

        // If target is smaller, ignore the right half
        if (arr[mid] > target) {
            high = mid - 1;
        }
        // If target is larger, ignore the left half
        else {
            low = mid + 1;
        }
    }

    return -1; // Return -1 if the target is not found
}

int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 30;

    int result = binarySearch(arr, n, target);

    if (result != -1) {
        printf("Element found at index: %d\n", result);
    } else {
        printf("Element not found\n");
    }

    return 0;
}
```

## Hashing Concept

### Theory

1. **Basic Concept**: Hashing is a technique used to uniquely identify a specific object from a collection of objects. It involves using a hash function to map data to a fixed-size value, typically called a hash code, which is used to efficiently access stored data.

2. **Hash Function**: A hash function takes an input (or "key") and returns a fixed-size string or number, known as a hash code. This hash code represents the input data in a condensed form, allowing for quick access or comparison of the original data.

3. **Hash Table**: A hash table is a data structure that uses a hash function to map keys to specific locations in an array. It allows for fast data retrieval, typically in constant time O(1), making it ideal for tasks like looking up values associated with keys.

4. **Efficiency**: The efficiency of hashing comes from its ability to provide near-instantaneous data retrieval and insertion. By using a hash table, the average time complexity for searching, inserting, or deleting an element is O(1) in the best case scenario.

5. **Collisions**: Hashing may produce the same hash code for different inputs. This is called a collision. Collisions are handled through various resolution techniques, such as chaining or open addressing, to maintain the integrity and performance of the hash table.

6. **Applications**: Hashing is widely used in areas such as **database indexing**, **password storage**, **caching**, and **data retrieval systems**. It enables fast search operations, which are critical for performance in large datasets or systems with high transaction volumes.

7. **Load Factor**: The load factor of a hash table determines how full the table can get before it needs to be resized. A high load factor can result in a high number of collisions, while a low load factor can lead to wasted space in the table.

8. **Security Considerations**: Hashing is also an essential component in cryptography, where functions like SHA-256 are used to securely store data like passwords. A good hash function in these contexts is designed to be collision-resistant and produce unique hashes for distinct inputs.

### Example: Hashing Process

1. **Input**: Key = "John"
2. **Hash Function**: Apply a hash function to "John" to generate a hash code, e.g., `hash("John") -> 24356`.
3. **Hash Table**: The hash table stores the key-value pair (John, 24356) at the index corresponding to the hash value 24356.

## Hash Functions

### Theory

1. **Definition**: A hash function is a function that takes an input (or "key") and returns a fixed-size string or numerical value called a hash code. This value uniquely represents the original data and is used to quickly retrieve, store, or compare the data in a hash table.

2. **Properties of a Good Hash Function**:

   - **Deterministic**: A hash function should consistently produce the same hash value for the same input.
   - **Efficient**: It should be fast to compute, even for large datasets.
   - **Uniform Distribution**: A good hash function should evenly distribute input values across the entire range of possible hash values to minimize collisions.
   - **Minimizing Collisions**: Collisions occur when two distinct inputs produce the same hash value. A good hash function minimizes these collisions.

3. **Applications**: Hash functions are commonly used in **data structures** like hash tables, **cryptography** for generating checksums and digital signatures, and **data integrity checks** for detecting changes to files or messages.

4. **Example**: For the input "Hello", a hash function might generate a value such as 12345, mapping this input to a particular index in a hash table or a checksum value used to verify data integrity.

5. **Common Hash Functions**:

   - **Division Method**: Hashes are generated by taking the key modulo the size of the table. For example, `hash(key) = key % table_size`.
   - **Multiplicative Method**: This method involves multiplying the key by a constant and then taking the fractional part before multiplying by the table size.
   - **MD5 (Message Digest Algorithm 5)**: A widely used cryptographic hash function that produces a 128-bit hash value, though it is not recommended for security purposes due to vulnerabilities.
   - **SHA (Secure Hash Algorithm)**: A family of cryptographic hash functions like SHA-256 that are used for security purposes in systems like SSL/TLS certificates.

6. **Collision Resistance**: A good hash function should ideally minimize the occurrence of collisions, where different inputs yield the same hash value. Collisions are handled using techniques such as **chaining** (linked lists) or **open addressing** (probing).

7. **Security Considerations**: Cryptographic hash functions like SHA-256 are designed to be resistant to pre-image attacks (finding an input from a hash) and collision attacks (finding two distinct inputs with the same hash).

8. **Load Factor & Resizing**: The efficiency of a hash table relies on the load factor, which is the number of elements divided by the number of slots in the table. As the load factor increases, the likelihood of collisions rises, necessitating resizing the hash table or altering the hash function.

### Example: Simple Hash Function

```c
#include <stdio.h>

unsigned int simpleHash(char* str) {
    unsigned int hash = 0;
    while (*str) {
        hash = (hash << 5) + *str++;  // hash * 31 + current_char
    }
    return hash;
}

int main() {
    char key[] = "Hello";
    printf("Hash value for 'Hello': %u\n", simpleHash(key));
    return 0;
}
```

## Collision Resolution Techniques

### Theory

1. **Collision in Hashing**: A collision occurs when two distinct keys produce the same hash value. Since multiple keys might hash to the same index in the hash table, collision resolution techniques are necessary to ensure the integrity of data and retrieval performance.

2. **Chaining**: In chaining, each table slot points to a linked list (or another data structure) that stores all elements whose keys hash to the same index. This technique handles collisions by allowing multiple keys to occupy the same index without overwriting any existing values.

3. **Open Addressing**: In open addressing, all elements are stored directly within the hash table itself. When a collision occurs, the algorithm searches for the next available slot based on a probing sequence. The primary methods of open addressing are **linear probing**, **quadratic probing**, and **double hashing**.

4. **Linear Probing**: Linear probing resolves collisions by checking the next available slot in the hash table sequentially. If the slot at index `i` is occupied, it checks index `i+1`, then `i+2`, and so on, until it finds an empty slot or wraps around to the beginning of the table.

5. **Quadratic Probing**: Quadratic probing is similar to linear probing but instead of checking the next slot sequentially, it uses a quadratic function to determine the next slot. For example, if a collision occurs at index `i`, the algorithm checks `i + 1^2`, `i + 2^2`, `i + 3^2`, and so on.

6. **Double Hashing**: Double hashing involves using a second hash function to calculate the step size for probing. If a collision occurs at index `i`, the second hash function is applied to compute an offset, and the next slot is determined by adding this offset to `i`.

7. **Load Factor and Rehashing**: The load factor is the ratio of the number of elements in the hash table to the number of slots available. A high load factor increases the likelihood of collisions. Rehashing involves increasing the size of the hash table and redistributing the elements to new slots, reducing collisions.

8. **Comparison of Techniques**: Chaining is simple and does not require a resizing operation, but it can lead to poor cache performance. Open addressing avoids linked lists but requires a resizing when the table becomes too full. Each technique has its advantages depending on the application’s performance needs and memory constraints.

### Example: Linear Probing for Collision Resolution

```c
#include <stdio.h>
#define TABLE_SIZE 10

// Hash function to get index
int hash(int key) {
    return key % TABLE_SIZE;
}

// Linear probing to insert value into hash table
void insert(int table[], int key) {
    int index = hash(key);

    // Linear probing to find an empty slot
    while (table[index] != -1) {
        index = (index + 1) % TABLE_SIZE;
    }

    table[index] = key;
}

// Display hash table
void display(int table[]) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        if (table[i] != -1) {
            printf("Index %d: %d\n", i, table[i]);
        }
    }
}

int main() {
    int table[TABLE_SIZE];
    for (int i = 0; i < TABLE_SIZE; i++) {
        table[i] = -1; // Initialize table with -1 (empty slots)
    }

    insert(table, 12);
    insert(table, 22);
    insert(table, 32);

    printf("Hash Table:\n");
    display(table);

    return 0;
}
```
