---
share_link: https://share.note.sx/7sws80wc#vO1toIHJ8eiceWfS7JV8tkTNEDAvBFWB1+cFXEFUbB0
share_updated: 2025-11-12T01:20:39+05:30
---

| Feature               | **MVC (Model–View–Controller)**                    | **Flux**                                              | **Redux**                                          |
| --------------------- | -------------------------------------------------- | ----------------------------------------------------- | -------------------------------------------------- |
| **Architecture Type** | Tri-layered architecture (Model, View, Controller) | Unidirectional data flow                              | Unidirectional data flow                           |
| **Data Flow**         | Bidirectional (View ↔ Controller ↔ Model)          | Strictly one-way (Action → Dispatcher → Store → View) | Strictly one-way (Action → Reducer → Store → View) |
| **Components**        | Model (data), View (UI), Controller (logic)        | Actions, Dispatcher, Store, View                      | Actions, Reducers, Store, View                     |
| **Complexity**        | Higher                                             | Moderate                                              | Simpler                                            |
| **State Management**  | Data changes can occur from multiple sources       | Centralized store updates data via dispatcher         | Centralized Single store updated by pure reducers  |
| Middleware Support    | Not built-in                                       | Limited Support                                       | Strong Support                                     |
| Debugging             | Harder due to<br>bidirectional flow                | Easier with dev tools                                 | Very easy with time-<br>travel debugging           |
| **Used In**           | Traditional frameworks like AngularJS, ASP.NET MVC | Facebook apps                                         | React + Redux ecosystem                            |

---

| Feature              | **HTML (HyperText Markup Language)**             | **XML (eXtensible Markup Language)**       |
| -------------------- | ------------------------------------------------ | ------------------------------------------ |
| **Purpose**          | Used to display data in a web browser            | Used to store and transport data           |
| **Tags**             | Predefined tags (e.g., `<h1>`, `<p>`, `<table>`) | User-defined tags                          |
| **Case Sensitivity** | Not case-sensitive                               | Case-sensitive                             |
| **Data Focus**       | Focuses on how data looks                        | Focuses on what data is                    |
| **Errors**           | Tolerant of errors                               | Strict — even a small error breaks parsing |
| **Closing Tags**     | Optional for some tags                           | Mandatory for all tags                     |
| **Structure**        | Designed for displaying information              | Designed for carrying information          |
| **Example**          | `<h1>Hello World</h1>`                           | `<name>John</name>`                        |

---

| Feature                    | **ES5 (ECMAScript 5)**         | **ES6 (ECMAScript 2015)**                   |
| -------------------------- | ------------------------------ | ------------------------------------------- |
| **Year Released**          | 2009                           | 2015                                        |
| **Variable Declaration**   | `var` only                     | `let`, `const`, and `var`                   |
| **Functions**              | Regular functions              | Arrow functions (`=>`)                      |
| **Classes**                | Not supported (use prototypes) | Introduced `class` and `constructor`        |
| **Modules**                | Not supported                  | `import` and `export` introduced            |
| **String Templates**       | Concatenation using `+`        | Template literals using backticks (`` ` ``) |
| **Default Parameters**     | Not available                  | Supported                                   |
| **Promises**               | Not available                  | Introduced for async handling               |
| **Scoping**                | Function scope                 | Block scope (`let`/`const`)                 |
| **Iterators & Generators** | Not available                  | Introduced in ES6                           |
| Spread Operator            | Not supported                  | Introduced `...`                            |
| Loops                      | for, while, do-while           | for-of, map, filter, reduce                 |
| Destructuting              | Not available                  | Supported                                   |

---

| Feature            | **let**                                | **const**                              |
| ------------------ | -------------------------------------- | -------------------------------------- |
| **Reassignment**   | Can be reassigned                      | Cannot be reassigned                   |
| **Redeclaration**  | Cannot be redeclared in the same scope | Cannot be redeclared in the same scope |
| **Initialization** | Can be declared without initialization | Must be initialized when declared      |
| **Scope**          | Block-scoped                           | Block-scoped                           |
| **Example**        | `let x = 5; x = 10;` ✅                 | `const y = 5; y = 10;` ❌               |

---

| Factor          | XML                    | JSON                                   |
| :-------------- | :--------------------- | :------------------------------------- |
| **Type**        | Markup Language        | Data Format                            |
| **Syntax**      | Tags & Attributes      | Key-Value Pairs                        |
| **Verbosity**   | More Verbose (heavier) | Less Verbose (lighter)                 |
| **Data Types**  | Everything is string   | Native (string, number, boolean, etc.) |
| **Parsing**     | Complex & Slower       | Simple & Faster                        |
| **Readability** | Less human-readable    | More human-readable                    |
| **Namespaces**  | Supported              | Not Supported                          |
| **Metadata**    | Uses Attributes        | As separate key-value pairs            |
| **Native JS**   | No                     | Yes                                    |
| **Common Use**  | Document data, configs | Web APIs, configs                      |
