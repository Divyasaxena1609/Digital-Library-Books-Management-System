# Digital Library Books Management System

## Overview

The Digital Library Books Management System is a web-based application designed to manage book records efficiently. It allows users to add, update, delete, and view book details. This system enables libraries to keep track of book information, including title, author, genre, availability, and more.

## Features

- Book Registration

- Update Book Details

- Delete Book Records

- View Book List

- Search Book by Title or ID

- RESTful API for CRUD Operations

## Technologies Used

## Backend:

- Java

- Spring Boot

- Spring Data JPA

- MySQL

## Tools & Platforms:

- IntelliJ IDEA / Eclipse

- Postman (for API testing)

- Git & GitHub

- Maven

## Ports

- Backend - localhost:8080

## API Endpoints

###Book Management
### Employee Management
| Method | Endpoint         | Description                |
|--------|------------------|----------------------------|
| GET    | /books/all       | Get all books              |
| GET    | /books/search/id/{bookId} | Get book by ID    |
| GET    | /books/search/title/{title} | Get book by title|
| POST   | /books/add       | Add a new book             |
| PUT    | /books/update/{bookId}  | Update book details    |
| DELETE | /books/delete/{bookId}  | Delete a book  |

## Folder Structure
```
Digital-Library-Books-Management-System/
│── src/
│   ├── main/
│   │   ├── java/com/example/library/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── customResponse/
│   │   │   ├── DigitalLibraryApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│── pom.xml
│── README.md
```
## How to Run the Project

## Backend:

1. Clone the repository:
   ```
   git clone https://github.com/your-repo/Digital-Library-Books-Management-System.git
   ```
2. Navigate to the project directory and build the project:
   ```
   cd Digital-Library-Books-Management-System
   mvn clean install
   ```
3. Run the Spring Boot application:
   ```
   mvn spring-boot:run
   ```
4. The backend will start at http://localhost:8080

## Sample Output
### Book Management

## Get all books

- Endpoint: GET /books/all

Response:
```
[
  {
    "id": 1,
    "bookId" : "B101",
    "title": "Spring Boot Guide",
    "author": "John Doe",
    "genre": "Technology",
    "availabilityStatus": "Available"
  }
]
```

## Get book by ID

- Endpoint: GET /books/search/id/{bookId}

Response:
```
{
  "id": 1,
  "bookId" : "B101",
  "title": "Spring Boot Guide",
  "author": "John Doe",
  "genre": "Technology",
  "availabilityStatus": "Available"
}
```
## Add a new book

- Endpoint: POST /books/add

Request:
```
{
  "bookId" : "B102",
  "title": "Java Basics",
  "author": "Jane Smith",
  "genre": "Programming",
  "availabilityStatus": "Available"
}
```
Response:
```
{
  "id": 2,
  "bookId" : "B102",
  "title": "Java Basics",
  "author": "Jane Smith",
  "genre": "Programming",
  "availabilityStatus": "Available"
}
```
## Update book details

- Endpoint: PUT /books/update/{bookId}

Request:
```
{
  "bookId" : "B101",
  "title": "Java Advanced",
  "author": "Jane Smith",
  "genre": "Programming",
  "availabilityStatus": "Checked Out"
}
```
Response:
```
{
  "id": 2,
  "bookId" : "B102",
  "title": "Java Advanced",
  "author": "Jane Smith",
  "genre": "Programming",
  "availabilityStatus": "Checked Out"
}
```
## Delete a book

- Endpoint: DELETE /books/{id}

Response:
```
{
  "message": "Book deleted successfully"
}
```

