# Copilot Instructions for StausCode_DatabasesConnectivity

## Project Overview
This is a Spring Boot 3.2.5 application for managing `User` entities with custom status codes and exception handling, using a MySQL database. The project follows a layered architecture:
- **Controller**: Handles HTTP requests (see `controller/UserController.java`).
- **Service Interface/Impl**: Business logic is abstracted in `serviceI/UserInterface.java` and implemented in `serviceImp/UserImplemets.java`.
- **Repository**: Data access via Spring Data JPA (`repository/UserRepository.java`).
- **Model**: JPA entity (`model/User.java`).

## Key Patterns & Conventions
- **Service Naming**: Service interfaces are in `serviceI/`, implementations in `serviceImp/`.
- **Custom Exception Handling**: (Planned/partially implemented) Service methods are expected to throw custom exceptions for error cases (see TODOs in `UserImplemets.java`).
- **HTTP Status Codes**: Controllers return `ResponseEntity` with explicit status codes (e.g., `HttpStatus.ACCEPTED`, `HttpStatus.BAD_REQUEST`).
- **ID Field**: The primary key for `User` is `uid` (int).
- **Endpoints**:
  - `POST /postData` — Create user
  - `GET /getData` — List all users
  - `GET /getData/{uid}` — Get user by ID

## Build & Run
- **Build**: `./mvnw clean package`
- **Run**: `./mvnw spring-boot:run` (default port: 1111)
- **Test**: `./mvnw test`
- **Database**: MySQL, configured in `src/main/resources/application.properties` (DB: `status_code_customException`)

## Testing
- Uses JUnit 5 (`@SpringBootTest` in `StausCodeDatabasesConnectivityApplicationTests.java`).
- No custom test utilities; tests are minimal.

## Integration Points
- **Database**: MySQL via Spring Data JPA
- **No external APIs**

## Project-Specific Notes
- **Naming**: There are typos in some class names (e.g., `StausCodeDatabasesConnectivityApplication`, `UserImplemets`). Maintain consistency with existing names.
- **Custom Exception Handling**: If implementing, add custom exceptions and global exception handlers in a new `exception/` package.
- **No frontend**: Only REST API, no static/templated UI.

## Example: Add a new endpoint
1. Add method to `UserInterface` and implement in `UserImplemets`.
2. Expose via `UserController`.
3. Return `ResponseEntity` with appropriate status code.

## References
- Main entry: `StausCodeDatabasesConnectivityApplication.java`
- Example endpoint: `UserController.java`
- DB config: `application.properties`

---

If you add new features, follow the existing package structure and naming conventions. For custom exceptions, create a dedicated package and use `@ControllerAdvice` for global handling.
