### 1. DNS (Domain Name System)

1. DNS translates human-readable domain names into IP addresses for computers to locate servers.
2. It functions like the Internet’s phonebook system.
3. It uses hierarchical servers such as root, TLD, and authoritative DNS.
4. Common record types include A, MX, CNAME, and TXT records.
5. DNS improves accessibility and simplifies web navigation for users.

```bash
Address: 142.250.183.110, Family: IPv4
IPv4 Addresses: [ '142.250.183.110', '142.250.183.102', ... ]
Hostnames for 8.8.8.8: [ 'dns.google' ]
```

---
### 2. REPL (Read-Eval-Print Loop)

1. REPL reads user input, evaluates it, prints the result, and loops again.
2. It provides an interactive programming environment for testing code snippets.
3. Used in languages like JavaScript (Node.js), Python, and Ruby.
4. Useful for debugging, experimenting, and learning programming interactively.
5. Promotes rapid development by providing immediate feedback on executed commands.

```bash
$ node
> 2 + 3
5
> console.log("Hello World")
Hello World
```

---
### 3. React Props

1. Props are short for “properties” used to pass data between React components.
2. They make components dynamic, reusable, and configurable from outside.
3. Props are immutable inside child components, ensuring predictable behavior.
4. They are passed as attributes in JSX during component rendering.
5. Props improve modularity and reusability of UI components efficiently.

```javascript
function Welcome(props) {
  return <h1>Hello, {props.name}!</h1>;
}

function App() {
  return <Welcome name="John" />;
}
```

---
### 4. Cookies

1. Cookies are small text files stored in the user’s browser by websites.
2. They store session data, preferences, and tracking information temporarily.
3. Cookies can be either session-based or persistent with expiration dates.
4. They are sent with every HTTP request to the server automatically.
5. Used for authentication, personalization, and maintaining user login states.

```javascript
document.cookie = "username=John; expires=Fri, 31 Dec 2025 12:00:00 UTC; path=/";
console.log(document.cookie);
```

---
### 5. Session

1. A session is a temporary interaction between a client and server.
2. It stores user-specific data during active website usage periods.
3. Sessions end when the user logs out or the browser closes.
4. Session IDs are usually stored in cookies or URLs securely.
5. Sessions help maintain state and user continuity in web applications.

```javascript
// Express.js Example
app.get("/login", (req, res) => {
  req.session.user = "John";
  res.send("Session started!");
});
```

---
### 6. Arrow Function

1. Arrow functions are a concise syntax for writing JavaScript functions.
2. Introduced in ES6, they use the `=>` arrow symbol.
3. They inherit `this` from their lexical scope, unlike regular functions.
4. Cannot be used as constructors or with `new` keyword.
5. Great for callbacks, array methods, and cleaner functional code.

```javascript
// Normal Function
function multiply(a, b) {
  return a * b;
}

// Arrow Function
const multiplyArrow = (a, b) => a * b;
```

---
### 8. JSON (JavaScript Object Notation)

1. JSON is a lightweight text format for data exchange between systems.
2. It represents data as key-value pairs in a structured format.
3. JSON is language-independent but easy to use with JavaScript.
4. Commonly used for APIs, configurations, and data storage purposes.
5. It is human-readable and supports arrays, objects, numbers, and strings.

```json
{
  "mapName": "Der Eisendrache",
  "releaseYear": 2016,
  "isEasterEggCompleted": true,
  "mainWeapons": ["Wrath of the Ancients", "Death Machine", "Haymaker 12"],
  "characterDetails": {
    "players": ["Dempsey", "Nikolai", "Takeo", "Richtofen"],
    "location": "Griffin Castle, Austria"
  },
  "lastPlayed": null
}
```

---
### 9. NPM (Node Package Manager)

1. NPM is the default package manager for Node.js applications.
2. It helps install, update, and manage JavaScript libraries easily.
3. Developers use `npm install` to add dependencies in projects.
4. It maintains `package.json` for tracking versions and project dependencies.
5. Enables sharing and reusing of code across multiple projects efficiently.

```bash
npm init -y        # Create package.json
npm install react  # Install React
npm run start      # Run project script
```

---
### 10. JSX (JavaScript XML)

1. JSX allows writing HTML-like syntax within JavaScript for React.
2. It simplifies component creation and improves readability significantly.
3. JSX is compiled into regular JavaScript using Babel transpiler.
4. Enables embedding expressions inside `{}` within markup easily.
5. Improves development speed and component-based UI structure consistency.

```javascript
import React, { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0); // state variable

  const increment = () => setCount(count + 1);
  const decrement = () => setCount(count - 1);
  const reset = () => setCount(0);

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
      <button onClick={reset}>Reset</button>
    </div>
  );
}

export default Counter;
```

---
### 11. Buffers

- A temporary memory area used to store and manage binary data efficiently.
- Helps process files, images, and network packets directly in memory.
- Works seamlessly with streams for smooth data transfer operations.
- Stores incomplete data chunks before full data is received.
- Ideal when data arrives gradually from files or network sources.

```javascript
// Create a Buffer from a string
const buf = Buffer.from('Hello');

// Display buffer content
console.log(buf);          // <Buffer 48 65 6c 6c 6f>
console.log(buf.toString()); // Hello
```

---
### 12. Streams

- A Stream is a continuous flow of data that can be read or written in small chunks instead of loading it all at once.
- Enable efficient reading and writing of large files or data sources.
- Reduce memory usage by processing data piece by piece.
- Commonly used for file handling, video, or network data transfer.

**Types of streams:**
1. Readable – For reading data (e.g., `fs.createReadStream()`).
2. Writable – For writing data (e.g., `fs.createWriteStream()`).
3. Duplex – Both readable and writable (e.g., network sockets).
4. Transform – Modify data while reading/writing (e.g., compression).

```javascript
const fs = require('fs');

// Create a readable stream (read file in chunks)
const readable = fs.createReadStream('input.txt', 'utf8');

// Create a writable stream (write to another file)
const writable = fs.createWriteStream('output.txt');

// Pipe the data from input.txt to output.txt
readable.pipe(writable);

console.log('File copied using streams!');
```

---
### 13. Promises

- A Promise is an object in JavaScript that represents the eventual completion (or failure) of an asynchronous operation and its result
- It represents a value that may be available now or in the future.
- Has three states: _pending_, _fulfilled_, and _rejected_.
- It helps to avoid callback hell and makes asynchronous code easier to manage.
- Useful for asynchronous operations such as fetching or database queries.

```javascript
// Creating a Promise
let myPromise = new Promise((resolve, reject) => {
  let success = true;

  setTimeout(() => {
    if (success) {
      resolve("Data fetched successfully!"); // handles success
    } else {
      reject("Error while fetching data.");   // handles failure
    }
  }, 2000);
});

// Consuming a Promise
myPromise
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.log(error);
  })
  .finally(() => {
    console.log("Operation completed");
  });
```

---
### 14. Generator

- Express Generator is a CLI tool for creating Express app boilerplates quickly.
- It sets up the basic folder structure and configuration automatically.
- Saves time by generating routes, views, and public directories instantly.
- Helps developers start coding without manual setup of project files.
- Includes folders like /routes, /views, /public, and app.js.

```bash
npx express myApp
cd myApp
npm install
npm start
```

---
### 15. Authentication

- Authentication verifies a user’s identity before granting access to resources.
- Common methods include passwords, tokens, and biometric verification.
- In Node.js, it’s often implemented using `JWT`, `Passport.js`, or `OAuth`.
- Ensures that only authorized users can access protected routes or data.
- Helps maintain security and prevent unauthorized access to applications.
- **In Express:** Usually implemented using **middleware** (like `passport.js`, `jsonwebtoken`, or custom logic).

- **Example Flow:**
    1. User logs in → credentials verified.
    2. Server creates a **token** (e.g., `JWT`).
    3. Token is sent with each request to verify the user.

```javascript
const jwt = require("jsonwebtoken");
app.post("/login", (req, res) => {
  const token = jwt.sign({ user: req.body.user }, "secret");
  res.json({ token });
});
```

---
### 16. HTTP (Hyper-Text Transfer Protocol)

- A set of rules used by browsers and servers to communicate and transfer web content (like HTML pages, images, videos).
- Standard web protocol for sending data between your browser and websites.
- Data is sent in plain text, which is not secure and can be read by others.
- Uses port 80. It is faster but offers no protection for information.
- Suitable for non-sensitive sites like blogs or news portals.
- The lack of encryption makes it vulnerable to attacks.

```http
http://example.com 
```

---
### 17. HTTPS (Hyper-Text Transfer Protocol Secure)

- The secure version of HTTP, which adds encryption (SSL/TLS) to protect the data being exchanged.
- Secure version of HTTP that encrypts all data exchanged for safety.
- Uses TLS/SSL encryption to protect data from being intercepted or stolen.
- Uses port 443. It verifies website identity with an SSL certificate and handshake.
- Essential for banks, e-commerce, and any site handling personal data.
- Shows a padlock in the address bar to indicate a secure connection.

```http
https://example.com 
```

---
### 18. Event Loop

---
### 19. REST (Representational State Transfer) APIs

**REST** (Representational State Transfer) — architecture style for designing networked applications. A REST API uses HTTP verbs to operate on resources represented by URIs.

**Principles:**
1. **Stateless**:
	- Each request from client to server must contain all information needed to understand it.
	- No client context is stored on the server between requests.
2. **Client-Server**  
	- Separation of concerns. Client handles UI and user state, server manages data storage and business logic.
3. **Uniform Interface**  
	- Standardized interaction. Resources are identified in requests, and representations (like JSON) are used to transfer data.
4. **Cacheable**  
	- Responses must define themselves as cacheable or not. 
	- Caching can prevent some client-server interactions, improving performance.
5. **Layered System**  
	- Architecture can be composed of hierarchical layers. 
	- Client cannot tell if it's connected directly to the end server or an intermediary.
6. **Code on Demand (Optional)**  
	 - Servers can temporarily extend client functionality by transferring executable code (e.g., JavaScript). 
	 - This is the only optional constraint.
7. **HTTP Methods**  
	- Uses standard HTTP verbs: 
	- GET (retrieve), POST (create), PUT (update), DELETE (remove). Each method has specific, well-defined semantics.
8. **HTTP Status Codes**  
	- Uses standard HTTP status codes to indicate result: 200 (OK), 201 (Created), 400 (Bad Request), 404 (Not Found), 500 (Server Error).

```javascript
// 1. GET - Retrieve all users
GET /api/users
Response: 200 OK
[
  { "id": 1, "name": "John", "email": "john@example.com" },
  { "id": 2, "name": "Jane", "email": "jane@example.com" }
]

// 2. GET - Retrieve specific user
GET /api/users/1
Response: 200 OK
{ "id": 1, "name": "John", "email": "john@example.com" }

// 3. POST - Create new user
POST /api/users
Body: { "name": "Mike", "email": "mike@example.com" }
Response: 201 Created
{ "id": 3, "name": "Mike", "email": "mike@example.com" }

// 4. PUT - Update entire user
PUT /api/users/1
Body: { "name": "John Smith", "email": "john.smith@example.com" }
Response: 200 OK
{ "id": 1, "name": "John Smith", "email": "john.smith@example.com" }

// 5. PATCH - Partial update
PATCH /api/users/1
Body: { "name": "John Doe" }
Response: 200 OK
{ "id": 1, "name": "John Doe", "email": "john@example.com" }

// 6. DELETE - Remove user
DELETE /api/users/1
Response: 204 No Content

// Error Examples:
GET /api/users/999
Response: 404 Not Found
{ "error": "User not found" }

POST /api/users
Body: { "name": "" }  // Invalid data
Response: 400 Bad Request
{ "error": "Name is required" }
```

---
### 20. Routing in Express JS

Routing in Express maps HTTP methods and paths to handler functions. Routes can include parameters, query strings, middleware, and nested routers.

- **HTTP method + path**: `app.get('/users', handler)`
- **Route parameters**:` /users/:id` captured as `req.params.id`
- **Query parameters**: `?page=2` available at `req.query.page`
- **Middleware**: functions that run before the route handler (e.g., auth, logging)
- **Router**: modular mountable route handler: `const r = express.Router()`
- **Route chains & arrays**: multiple handlers for same route; next() moves to next handler
- **Order matters**: first matching route wins. Use specific routes before wildcards.

```javascript
app.get('/hello', (req, res) => res.send('GET hello'));
app.post('/hello', (req, res) => res.send('POST hello'));
```