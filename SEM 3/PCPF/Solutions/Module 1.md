# Comparison of Static Binding and Dynamic Binding

| Feature                 | Static Binding (Early Binding)                                             | Dynamic Binding (Late Binding)                                 |
| ----------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------- |
| **Timing**              | Occurs at compile time.                                                    | Occurs at runtime.                                             |
| **Resolution**          | Function or variable association is resolved by the compiler.              | Function or variable association is resolved during execution. |
| **Performance**         | Faster due to early resolution.                                            | Slower due to runtime resolution overhead.                     |
| **Polymorphism**        | Does not support polymorphism.                                             | Supports polymorphism, such as method overriding.              |
| **Flexibility**         | Inflexible, fixed at compile time.                                         | Flexible, allows runtime decisions.                            |
| **Usage**               | Used for non-virtual functions, overloaded functions, and primitive types. | Used for virtual functions and in dynamically typed languages. |
| **Overhead**            | Minimal runtime overhead.                                                  | Additional runtime overhead due to dynamic resolution.         |
| **Examples in C++**     | Non-virtual functions, operator overloading.                               | Virtual functions, pointers to derived objects.                |
| **Error Detection**     | Errors are detected at compile time.                                       | Errors may occur at runtime.                                   |
| **Language Dependency** | Common in statically typed languages like C++ and Java.                    | Common in dynamically typed or object-oriented languages.      |
