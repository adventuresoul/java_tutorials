# Spring Boot CRUD Application with PostgreSQL and Docker

## 📌 Overview
This is a simple Spring Boot CRUD (Create, Read, Update, Delete) application that interacts with a PostgreSQL database. It follows the **Controller-Service-Repository** pattern and is fully containerized using Docker.

## 🛠 Technologies Used
- **Spring Boot** (REST API)
- **Spring JDBC Template** (Database interaction)
- **PostgreSQL** (Relational database)
- **Docker** (Containerization)
- **Maven** (Build tool)

---

## 🚀 Getting Started
### 1️⃣ Clone the Repository
```sh
git clone <repo-url>
cd <project-folder>
```

### 2️⃣ Set Up Environment Variables
Create a `.env` file in the root directory and define the database credentials:
```ini
DB_URL=jdbc:postgresql://ip:5432/mydb
DB_USER=postgres
DB_PASSWORD=yourpassword
```

Alternatively, you can export them manually:
```sh
export DB_URL=jdbc:postgresql://ip:5432/mydb
export DB_USER=postgres
export DB_PASSWORD=yourpassword
```

### 3️⃣ Run the Application Locally
Make sure you have PostgreSQL running and execute:
```sh
mvn spring-boot:run
```
The application will start on **http://localhost:8080**

---

## 🐳 Running with Docker
### 1️⃣ Build Docker Image
```sh
docker build -t spring-crud .
```

### 2️⃣ Run the Application
```sh
docker run -p 8080:8080 --env-file .env spring-crud
```
This will start the application on **http://localhost:8080**

---

## 📌 API Endpoints
| Method | Endpoint        | Description |
|--------|----------------|-------------|
| GET    | `/`     | Get all products |
| GET    | `/{id}` | Get a product by ID |
| POST   | `/`     | Create a new product |
| PUT    | `/{id}` | Update a product |
| DELETE | `/{id}` | Delete a product |

---

## ✅ Testing the API
Use **Postman** or **cURL** to test:
```sh
curl -X GET http://localhost:8080/
```

---

## 📌 Project Structure
```
src/main/java/com/spring/crud
│── model          # Entity classes
│── repository     # Data access layer (JDBC Template)
│── service        # Business logic layer
│── controller     # REST endpoints
│── CrudApplication.java  # Main application entry point
```

---

## 🛑 Stopping the Application
To stop the Docker container, run:
```sh
docker ps
# Get the container ID and then run:
docker stop <container_id>
```

To remove the container:
```sh
docker rm <container_id>
```

---

## 📌 Additional Notes
- Ensure PostgreSQL is running before starting the app.
- Use Docker Compose if you want to set up a database container along with the app.
- You can configure application properties in `src/main/resources/application.properties`

---

## 🎯 Future Improvements
- Implement unit and integration tests
- Add API documentation using Swagger
- Implement authentication and authorization

---

