#  To-Do App Backend

A RESTful API built with **Node.js**, **Express**, and **PostgreSQL**, aimed to serve as the backend for a To-Do frontend application. Database is managed via **Docker**, and configuration is handled through environment variables (the Node.js equivalent of Spring Boot's `application.properties`).

---

##  Technologies Used

- **Node.js** – JavaScript runtime  
- **Express** – Web framework  
- **PostgreSQL** – Relational database  
- **Docker** – Containerization for DB setup  
- **dotenv** – Environment variable loader  

---

##  Prerequisites

Ensure you have the following installed:

- [Node.js (LTS)](https://nodejs.org/)  
- [Docker](https://www.docker.com/) (or Docker Desktop)  

---

##  PostgreSQL with Docker

Start a PostgreSQL DB locally using Docker:

```bash
docker run --name todo-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=tododb \
  -p 5432:5432 \
  -d postgres
```
This will run a PostgreSQL container exposing port 5432, with user postgres, password postgres, and a database named tododb.

## Configuring via Environment Variables
In Node.js, we don't use application.properties. Instead, create a .env file for configuration:
```bash
DB_HOST=localhost
DB_PORT=5432
DB_USER=postgres
DB_PASSWORD=postgres
DB_NAME=tododb
PORT=3000
```
Spring Boot equivalent (application.properties):
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```
## Installation & Setup
Clone the repository:
```bash
git clone https://github.com/Andreastephgm/todo-s-backend.git
cd todo-s-backend
```

2. Install dependencies:
```bash
git clone https://github.com/Andreastephgm/todo-s-backend.git
cd todo-s-backend
```
3. Create your .env as shown above.
4. Make sure the Docker PostgreSQL container is running (see step above).
5. Start the server:
```bash
   npm start
```
## API Endpoints

| Method | Endpoint      | Description                      |
|--------|--------------|----------------------------------|
| GET    | /todos       | Retrieve all tasks               |
| POST   | /todos       | Create a new task                 |
| PUT    | /todos/:id   | Update task name or status        |
| DELETE | /todos/:id   | Delete a task                     |

> All endpoints use JSON payloads.


## Example Usage (curl)
```bash
# Add a task
curl -X POST -H "Content-Type: application/json" \
     -d '{"name":"Buy groceries"}' \
     http://localhost:3000/todos

# Get all tasks
curl http://localhost:3000/todos

# Toggle completion
curl -X PUT -H "Content-Type: application/json" \
     -d '{"name":"Buy groceries","completed":true}' \
     http://localhost:3000/todos/<id>

# Delete a task
curl -X DELETE http://localhost:3000/todos/<id>
```
## How It Integrates with the Frontend
This backend is designed to work seamlessly with the frontend app (e.g., configured to call http://localhost:3000/todos). If your frontend is hosted elsewhere or using a different port, make sure to update the API base URL accordingly.
## Project Structure
```bash
todo-s-backend/
│── index.js          # Main server entry point
│── routes/           # Route definitions (e.g. todos)
│── controllers/      # Business logic (optional)
│── models/           # DB queries (e.g. using pg or ORM)
│── .env              # Environment variables (not committed)
│── package.json
└── README.md
```
## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it.
