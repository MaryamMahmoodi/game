# Implementation 
## Overview

This document provides a detailed explanation of the implementation for the Scoober Code Challenge.

## Technologies Used

- **Java 21**: The core programming language.
- **Spring Boot 3.3.2**: Framework used to build the REST API.
- **Maven**: Dependency management and project building tool.
- **Swagger**: Used for API documentation and testing.
- **JUnit 5**: For writing and running unit tests.
- **Docker**: To containerize the application for easy deployment and scalability.
- **Lombok**: Used to reduce code by generating getters, setters, constructors at compile time.

## Project Structure

The project is organized into several packages:

- **controller**: Contains the REST controllers that handle incoming HTTP requests.
- **model**: Contains the entity classes and service.
    - **entity**: Defines the `GameMove` entity class with added Schema annotations  to specify an example for each field.
    - **service**: Contains the game logic.
### Implementation Details

1. **GameMove Class:** Represents the state of a game move.
2. **GameService:** Contains the logic for processing game moves and determining the winner.
3. **PlayerController:** Provides endpoints for initiating and processing game moves.


##API Endpoints

### `/player/move`

- **Method:** `POST`
- **Request Body:**

    ```json
    {
      "playerName": "Player 1",
      "number": 56,
      "addedValue": 0,
      "isGameOver": false
    }
    ```

- **Response:**

    - **200 OK:** Returns the updated game state or the game over message.
    - **400 Bad Request:** Returns an error if the request is invalid.
  
### Example Workflow

1. Player 1 starts with a number.
2. Player 2 performs a move, and the game state is updated.
3. The game continues until one player reaches the number 1.


##Testing
Unit tests are written using **JUnit 5** to ensure the correctness of the service and controller layers.
To test the game logic, follow the instructions provided in the Implementation Details.
```bash
  mvn test
```
## API Documentation

- **Swagger UI:** Visit `http://localhost:8080/swagger-ui.html` to view the API documentation and interact with endpoints.
: Access the Swagger UI at http://localhost:8080/swagger-ui.html for exploring API endpoints and documentation.