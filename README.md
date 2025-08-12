# SimpleTourPackageApiApplication

# Simple Tour Package API

A simple RESTful API built with Spring Boot to manage tour packages, backed by PostgreSQL.

## Requirements
- Java 17+
- Maven 3.8+
- PostgreSQL 13+
- Eclipse IDE (or STS)

## Setup

1. Create a PostgreSQL database:
   - Database name: `tours_db`
   - User: `postgres`
   - Password: `postgres`

2. Update `src/main/resources/application.properties` if your DB credentials differ.

3. Import and run in Eclipse:
   - File > Import > Existing Maven Projects
   - Select project root (where `pom.xml` is)
   - Right click project > Run As > Spring Boot App

4. Run with Maven (alternative):
   - `mvn spring-boot:run`

## API

- Create Tour
  - POST `/api/tours`
  - Sample JSON:
    ```
    {
      "id": 1,
      "image": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
      "discountInPercentage": "17%",
      "title": "Himalayan Trek Adventure",
      "description": "14-day trek through the Himalayas",
      "duration": "14Days/13Nights",
      "actualPrice": "Rs1200",
      "discountedPrice": "Rs1000"
    }
    ```
  - 201 Created, Location header `/api/tours/{id}`

- List Tours
  - GET `/api/tours`
  - 200 OK, JSON array

- Get Tour by ID
  - GET `/api/tours/{id}`
  - 200 OK or 404 Not Found

## Validation & Errors
- Empty strings rejected for text fields
- Price formats like `Rs1200` accepted; numeric values derived internally
- 400 Bad Request for validation errors
- 404 Not Found when tour id does not exist

## Build
- `mvn clean package`
- Jar runs with: `java -jar target/simple-tour-package-api-1.0.0.jar`

