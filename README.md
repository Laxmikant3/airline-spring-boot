# Airline Ticket Booking API

## Overview
This is a simple in-memory airline ticket booking API built using **Spring Boot**. The API allows users to retrieve flight details, create tickets, view ticket information, and delete tickets.

## Technologies Used
- **Spring Boot**
- **Java 17+**
- **RESTful API**
- **Maven**

## Installation & Setup

### Prerequisites
- Java 17+
- Maven

### Steps to Run the Application
1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/airline-ticket-api.git
   cd airline-ticket-api
   ```
2. Build and run the project:
   ```sh
   mvn spring-boot:run
   ```
3. The server will start at:
   ```
   http://localhost:8080
   ```

## API Endpoints

### **Flights API**

#### **Get All Flights**
```http
GET /flights?sort=asc
```
**Description:** Retrieves all flights, sorted in ascending order.

#### **Get Flight by ID**
```http
GET /flights/{id}
```
**Description:** Fetches details of a specific flight by its ID.

#### **Get Flight Schedules by Date**
```http
GET /flights/{id}/schedules?dates=YYYY-MM-DD
```
**Description:** Retrieves flight schedules for a given date.

---

### **Ticket API**

#### **Create a Ticket**
```http
POST /tickets
```
**Description:** Creates a new ticket.

**Request Body Example (JSON):**
```json
{
  "passengerName": "John Doe",
  "flightNumber": "AI123",
  "price": 500.0
}
```

#### **Get a Ticket by ID**
```http
GET /tickets/{id}
```
**Description:** Fetches ticket details by ID.

#### **Delete a Ticket**
```http
DELETE /tickets/{id}
```
**Description:** Deletes a ticket by its ID.

---

## Testing the API
You can test the API using:
- **Postman**


## License
This project is licensed under the **MIT License**.

---

### Author
**Your Name** - [GitHub Profile](https://github.com/Laxmikant3)

