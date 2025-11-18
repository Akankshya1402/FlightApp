A complete backend application for flight search and ticket booking built using Spring Boot, JPA, MySQL, and REST APIs.

This system supports airlines adding inventory, customers searching flights, booking tickets, retrieving PNR info, checking booking history, and canceling tickets.

🚀 Features
✈️ Airline & Inventory Management

Add new airline

Add flight inventory with departure/arrival details

🔍 Flight Search

Search available flights by source, destination, date

🎫 Ticket Booking

Book a ticket

Automatic PNR generation

Reduce seat availability securely

📄 Ticket Management

Get ticket by PNR

View booking history by email

Cancel ticket by PNR

🛢 Database

MySQL database (flightdb) auto-created by JPA

Four tables: airline, flight, passenger, ticket

🧩 Tech Stack
Layer	Technology
Backend	Spring Boot 3.5
Programming Language	Java 17
Database	MySQL 8
ORM	JPA / Hibernate
Build Tool	Maven
Testing	JUnit 5, Mockito
Tools	SonarLint, Postman
📁 Project Structure (Overview)
src/main/java/com/flightapp/
│── controller/
│── dto/
│── entity/
│── exception/
│── repository/
│── service/
│── service/impl/
│── util/
│── FlightAppApplication.java

🔗 REST API Endpoints
1. Add Airline
POST /api/v1.0/flight/airline/add

2. Add Flight / Inventory
POST /api/v1.0/flight/airline/inventory/add

3. Search Flights
POST /api/v1.0/flight/search

4. Book Ticket
POST /api/v1.0/flight/booking/{flightId}

5. Get Ticket by PNR
GET /api/v1.0/flight/ticket/{pnr}

6. Booking History
GET /api/v1.0/flight/booking/history/{email}

7. Cancel Ticket
DELETE /api/v1.0/flight/booking/cancel/{pnr}

🔧 How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/Akankshya1402/FlightApp.git

2️⃣ Configure MySQL

Create a database:

CREATE DATABASE flightdb;


Update application.properties if needed:

spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

3️⃣ Run the Application

Using IDE (Eclipse/STS):

Run → Spring Boot App


or using terminal:

mvn spring-boot:run

4️⃣ Use APIs via Postman

Import the Postman collection:

FlightApp API Collection.json

Server runs on:

http://localhost:9090

📝 Postman Collection

A full Postman collection with all APIs is included in the repo.
File name:

FlightApp API Collection.postman_collection.json

🧪 Testing

JUnit tests for controllers & services

Mockito for mocking dependencies

Run tests:

mvn test

🧹 Code Quality (SonarLint)

Removed unused imports

Fixed deprecated calls

Replaced field injection with constructor injection

Eliminated wildcard generics

Improved exception handling

📸 Screenshots Included

Your submission folder contains:

Postman API results

SonarLint reports

DB schema

Application console logs

👩‍💻 Author

Akankshya
B.Tech CSE (AIML)
