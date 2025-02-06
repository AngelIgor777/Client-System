
# 🌟 Client System

Client System is an application for managing clients, built using **Java**, **Spring Framework**, and **PostgreSQL**. It provides an easy-to-use interface for registering, managing, and storing client information.

---

## 🛠️ Technologies & Versions

- **Java**: 17
- **Spring Framework**: 2.7.18
- **PostgreSQL**: 14
- **Flyway**: Database migrations
- **Gradle**: Project build
- **Docker and Docker Compose**: Application containerization

---

## 📋 Features

- Client management: create,and view clients.
- Pagination and filtering of clients.
- Data storage in **PostgreSQL** database.
- Database migrations using **Flyway**.

---

## 🚀 Running the Application

### 🔧 Local Setup (Linux)

1. Ensure that the following are installed:
    - **Java 17+**
    - **Gradle**

2. Clone the project:

   ```bash
   git clone https://github.com/AngelIgor777/Client-System.git
   cd Client-System
   ```

### 🐳 Running with Docker

1. Ensure the following tools are installed:
    - **Docker** (verify installation with `docker --version`)
    - **Docker Compose** (verify installation with `docker-compose --version`)

2. In the project root, find the `Dockerfile` and `docker-compose.yml` files.

3. Run the application using Docker Compose:

   ```bash
   docker-compose up --build
   ```

Once the containers are built and running, the application will be available at http://localhost:8081, and the PostgreSQL database will be available on port 5432.

## 🧳 Postman Integration

In the project root, there is a folder `postman-api`, which contains collections for testing the API with Postman. To test the API, simply import the collections and environment into Postman, and you can start using the pre-configured requests.

---

## API Endpoints

### Client API

#### **POST /api/v1/clients**
- **Description**: Add a new client.
- **Request Body**:

```json
{
  "name": "Client Name"
}
```
- **Response**: The newly added client information.
```json
{
  "id": 1,
  "name": "Client Name",
  "contacts": []
}
```

#### **GET /api/v1/clients**
- **Description**: Retrieve all clients with pagination.
- **Query Parameters**:
    - `page`: Page number (default: 0)
    - `size`: Number of items per page (default: 20)

- **Response**: A list of clients in paginated form.
```json
{
  "content": [
    {
      "id": 1,
      "name": "Client Name",
      "contacts": []
    }
  ],
  "totalPages": 1,
  "totalElements": 1
}
```

#### **GET /api/v1/clients/{id}**
- **Description**: Retrieve a client by ID.
- **Response**: Client information by the provided ID.
```json
{
  "id": 1,
  "name": "Client Name",
  "contacts": []
}
```

### Contact API

#### **POST /api/v1/contacts**
- **Description**: Add a new contact for a client.
- **Request Body**:

```json
{
  "type": "PHONE",
  "value": "1234567890",
  "clientId": 1
}
```

- **Response**: The newly added contact information.
```json
{
  "id": 1,
  "type": "PHONE",
  "value": "1234567890"
}
```

#### **GET /api/v1/contacts/client/{clientId}**
- **Description**: Retrieve all contacts for a client by client ID with pagination.
- **Query Parameters**:
    - `page`: Page number (default: 0)
    - `size`: Number of items per page (default: 20)

- **Response**: A list of contacts for the client.
```json
{
  "content": [
    {
      "id": 1,
      "type": "PHONE",
      "value": "1234567890"
    }
  ],
  "totalPages": 1,
  "totalElements": 1
}
```

#### **GET /api/v1/contacts/client/{clientId}/type/{type}**
- **Description**: Retrieve contacts by client ID and contact type (PHONE, EMAIL) with pagination.
- **Response**: A list of contacts for the client filtered by type.
```json
{
  "content": [
    {
      "id": 1,
      "type": "PHONE",
      "value": "1234567890"
    }
  ],
  "totalPages": 1,
  "totalElements": 1
}
```

---

## How to Consume the API

The API can be accessed at the following base URL:

- **Base URL**: `http://localhost:8080`

### Example Usage

#### Create a Client

```bash
curl -X POST "http://localhost:8080/api/v1/clients" -H "Content-Type: application/json" -d '{"name": "Client Name"}'
```

#### Get All Clients

```bash
curl "http://localhost:8080/api/v1/clients?page=0&size=10"
```

#### Get Client by ID

```bash
curl "http://localhost:8080/api/v1/clients/1"
```

#### Create a Contact for a Client

```bash
curl -X POST "http://localhost:8080/api/v1/contacts" -H "Content-Type: application/json" -d '{"type": "PHONE", "value": "1234567890", "clientId": 1}'
```

#### Get Contacts for a Client

```bash
curl "http://localhost:8080/api/v1/contacts/client/1?page=0&size=10"
```

#### Get Contacts by Type

```bash
curl "http://localhost:8080/api/v1/contacts/client/1/type/PHONE?page=0&size=10"
```


### 🧳 Database Migrations

Flyway automatically applies migrations when the application starts. Migrations are located in the `src/resources/db/migration` directory.

Ensure that you have a PostgreSQL database and that migrations have been applied.

### 🚧 Common Issues

- If the application does not start, ensure that ports 8081 and 5432 are not occupied by other services.

---
