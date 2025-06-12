# Zenvion Banking Engine
Robust back-end application that replicates the core functionalities of a digital banking system. It enables comprehensive management of clients, accounts, and financial transactions, including deposits, withdrawals, internal transfers, and detailed transaction history queries.

The system is built on a modular and scalable architecture, integrating a relational database to ensure data consistency and persistence. It follows best development practices, with a strong focus on security, error handling, and data validation—key aspects in real-world financial environments.

Designed with a professional approach, the application stands out for its clean structure, maintainability, and adaptability to future enhancements, effectively simulating the operational dynamics of modern digital banking.

## Features
- Enterprise-grade security: Full implementation of authentication and authorization using JWT and Spring Security to ensure secure access to all operations.

- Bank account and transaction management: Create accounts, perform deposits, withdrawals, transfers, and maintain real-time balance control, simulating real banking workflows.

- Detailed transaction history: Every financial operation is logged for full traceability per user and account.

- Modular and scalable architecture: Clean layered structure (Controller, Service, Repository, DTO, Mapper, etc.) designed for maintainability, scalability, and testability.

- Robust validation and centralized exception handling: Input data is thoroughly validated, and errors are managed through a centralized mechanism for application stability.

- Reliable persistence with PostgreSQL: Integrated with a relational database via JPA/Hibernate, production-ready and optimized for consistency.

- Efficient data mapping using MapStruct: Strict separation between domain models and DTOs, ensuring clean, decoupled data transfer across layers.

- RESTful API design: Follows industry-standard REST conventions, making it easy to integrate with frontend applications or third-party services.

- Ready for real-world deployment: The project is structured, built, and documented in a way that reflects professional development environments.

## Technology
This project leverages the following technologies and tools to ensure a robust, secure, and maintainable banking backend:

- Java 21 – Latest long-term support version ensuring modern features and optimal performance.

- Spring Boot – Framework for building scalable, production-ready backend services.

- Spring Data JPA (Hibernate) – Robust ORM framework simplifying database interaction.

- Spring Security – Comprehensive security solution including authentication and authorization.

- Lombok – Code generation tool reducing boilerplate and improving code maintainability.

- MapStruct – Compile-time mapper for clean and efficient DTO-entity conversions.

- Thymeleaf – Server-side Java template engine for dynamic web content rendering.

- PostgreSQL – Enterprise-grade relational database for reliable and secure data storage.

- Git & GitHub – Version control and collaborative development platform.

## Project Structure
```bash
banking-engine/
├── src/
│   ├── main/
│   │   ├── java/com/zenvion/banking/engine/
│   │   │   ├── controller/      # RESTful API endpoints handling HTTP requests, validation, and response shaping
│   │   │   ├── service/         # Core domain logic, transaction orchestration, and business rules enforcement
│   │   │   ├── repository/      # Spring Data JPA repositories abstracting data persistence with PostgreSQL
│   │   │   ├── model/           # JPA entities representing the domain model with ORM mappings
│   │   │   ├── dto/             # Immutable Data Transfer Objects facilitating secure API communication
│   │   │   ├── mapper/          # MapStruct-based mappers for clean separation between entities and DTOs
│   │   │   ├── security/        # Security configurations including JWT filters, authentication providers, and access control
│   │   │   ├── exception/       # Custom exceptions and global exception handling via @ControllerAdvice
│   │   │   └── BankingEngineApplication.java  # Spring Boot entry point bootstrapping the application context
│   │   └── resources/
│   │       ├── application.properties  # Externalized configuration for datasource, security, and application properties
│   │       ├── static/                  # Frontend assets, if applicable
│   │       └── templates/               # Server-side rendering templates (Thymeleaf)
│   └── test/java/com/zenvion/banking/engine/
│       └── (unit, integration, and e2e test suites)
├── README.md                            # Detailed documentation including architecture, setup, and usage
├── pom.xml                             # Maven configuration with dependency management and build plugins
└── LICENSE                            # Licensing information (e.g., MIT)
```

## Prerequisites
Ensure the following software and tools are installed and configured:

1. Java 21 (JDK) – Required to build and run the application.

2. Maven 3.9+ – For project dependency management and build automation.

3. PostgreSQL 15+ – Running database instance with appropriate schema permissions.

4. Git – To clone the repository and manage version control.

5. Compatible IDE (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code) – With support for Java and Spring Boot development.

## Installation

### 1. Clone the Repository
Clone the project repository and navigate into the project directory:
```bash
git clone https://github.com/your-username/banking-engine.git
cd banking-engine
```
> Note: Switch to the relevant branch (usually main or develop) according to your workflow.

### 2. Configure PostgreSQL Database
Create a dedicated database for the application:
```bash
CREATE DATABASE atm_banking_system;
```

Create a database user with appropriate privileges:
```bash
CREATE USER atm_user WITH PASSWORD 'secure_password';
GRANT ALL PRIVILEGES ON DATABASE atm_banking_system TO atm_user;
```

Update the database connection properties in src/main/resources/application.properties:
```bash
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/atm_banking_system
spring.datasource.username=atm_user
spring.datasource.password=secure_password

# JPA / Hibernate Settings
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
> Warning: The ddl-auto=update setting is suitable for development. For production environments, consider validate or manage schema migrations with tools like Flyway or Liquibase.

### 3. Build the Project
Compile the project and resolve dependencies using Maven:
```bash
mvn clean install
```
This command generates an executable .jar file located in the target/ directory.

### 4. Run the Application
Launch the application server with:
```bash
mvn spring-boot:run
```

### 5. (Optional) Swagger API Documentation
If enabled, Swagger UI provides interactive API documentation:

```bash
http://localhost:8080/swagger-ui.html
```
This interface facilitates endpoint exploration, testing, and understanding of API contracts.

## Usage
After launching the application, users can perform typical ATM banking operations via a secure and intuitive web interface.

### 1. Access the Application
Open your preferred browser and navigate to:

```bash
http://localhost:8080
```

### 2. User Registration
- Navigate to the registration page at /register.

- Fill in the required personal details (first name, last name, email, etc.).

- Upon successful registration, the system will:

  - Create a new bank account with an initial balance of zero.

  - Generate a unique card number and PIN for authentication.

> Your card number and PIN will be displayed on screen after registration and will also be accessible via your user dashboard.

### 3. Login
- Navigate to the login page at /login.

- Enter your assigned card number and PIN.

- On successful authentication, you will be redirected to your personal dashboard.

### 4. Core Features
From the user dashboard, you can:

- View personal and card details

- Check current account balance

- Deposit funds

- Withdraw money

- Transfer funds to other registered users

- Review detailed transaction history

- Log out securely

### 5. Security
- All sensitive operations require authentication via card number and PIN.

- Input validation ensures consistency and prevents invalid transactions.

- Unauthorized access attempts are redirected to the login page and logged accordingly.

## License
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.