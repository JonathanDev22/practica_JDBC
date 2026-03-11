# JDBC CRUD Project with PostgreSQL (Legacy Code)

## Overview
This project demonstrates a complete CRUD (Create, Read, Update, Delete) application using Java and the JDBC driver for PostgreSQL. The code follows a legacy approach, focusing on direct JDBC usage without frameworks like Spring Boot.

## Features
- Connects to a PostgreSQL database using JDBC
- Performs CRUD operations on the `products` table
- Outputs results to the console

## Technologies Used
- Java 8+
- JDBC
- PostgreSQL

## Project Structure
```
repaso_JDBC/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/JonathanDev/Constructor.java
│   │   └── resources/
│   └── test/
│       └── java/com/JonathanDev/
└── README.md
```

## Setup Instructions
1. **PostgreSQL Database:**
   - Ensure PostgreSQL is running and accessible.
   - Create a database named `repo_local`.
   - Create a table `products` with columns: `id`, `name`, `price`, `date_create`.

2. **Configure Connection:**
   - Update the JDBC URL, username, and password in `Constructor.java` if needed.

3. **Build and Run:**
   - Compile the project:
     ```bash
     mvn clean install
     ```
   - Run the application:
     ```bash
     java -cp target/classes com.JonathanDev.Constructor
     ```

## CRUD Operations
- **Read:** Fetches all products from the database and displays them.
- **Create/Update/Delete:** Uncomment and modify SQL statements in `Constructor.java` to perform other operations.

## Best Practices
- Use environment variables for sensitive credentials.
- Handle exceptions and close resources properly.
- Follow layered architecture for maintainability (see [copilot-instructions](.github/copilot-instructions.md)).

## License
This project is for educational purposes.

## Author
JonathanDev
