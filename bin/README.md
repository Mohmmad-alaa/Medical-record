Medical-record
Overview

The Medical-record project is a backend system for managing patient records. It leverages Spring Boot, Spring Data JPA, and MySQL to provide a robust and scalable solution for storing and retrieving medical records.
Features

    Patient registration
    Medical record management
    MySQL database integration

Technologies Used

    Java
    Spring Boot
    Spring Data JPA
    MySQL

Setup Instructions
Prerequisites

    Java 11 or higher
    MySQL server
    Maven

Installation

    Clone the repository:

    bash

git clone https://github.com/Mohmmad-alaa/Medical-record.git
cd Medical-record

Configure MySQL database:

    Create a database named medical_record.
    Update src/main/resources/application.properties with your MySQL credentials.

Build the project:

bash

./mvnw clean install

Run the application:

bash

    ./mvnw spring-boot:run

Usage

    The application will start on http://localhost:8080.
    Use Postman or any other API client to interact with the endpoints.

