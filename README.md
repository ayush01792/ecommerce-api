# 🛒 E-Commerce REST API

A fully functional backend REST API for an E-Commerce platform built with **Java**, **Spring Boot**, **Spring Security (JWT)**, and **MySQL**.

---

## 🚀 Features

- ✅ User Registration & Login with JWT Authentication
- ✅ Role-based Access Control (USER / ADMIN)
- ✅ Product Catalog with Search & Pagination
- ✅ Category Management
- ✅ Shopping Cart (Add, Update, Remove items)
- ✅ Order Placement with Stock Management
- ✅ Global Exception Handling
- ✅ Swagger UI for API Documentation

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3.2.5 | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT (jjwt 0.12.5) | Token-based Auth |
| Spring Data JPA | Database ORM |
| Hibernate | JPA Implementation |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate |
| Springdoc OpenAPI | Swagger UI |
| Maven | Dependency Management |

---

## 📁 Project Structure

```
ecommerce-api/
├── src/main/java/com/ecommerce/
│   ├── config/          # Security & Swagger configuration
│   ├── controller/      # REST Controllers
│   ├── dto/             # Request/Response DTOs
│   ├── entity/          # JPA Entity classes
│   ├── exception/       # Global exception handling
│   ├── repository/      # Spring Data JPA Repositories
│   ├── security/        # JWT Filter, Token Provider
│   └── service/         # Business Logic
└── src/main/resources/
    └── application.properties
```

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17
- MySQL 8+
- Maven

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/YOUR_USERNAME/ecommerce-api.git
cd ecommerce-api
```

**2. Configure MySQL**

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

**3. Run the application**
```bash
mvn spring-boot:run
```

The app will start on `http://localhost:8080` and auto-create all database tables.

---

## 📖 API Documentation

Once running, open Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Authentication Flow

1. **Register** → `POST /api/auth/register`
2. **Login** → `POST /api/auth/login` → returns JWT token
3. **Use token** → Add to request header: `Authorization: Bearer <token>`

---

## 📌 API Endpoints

### Auth
| Method | Endpoint | Access |
|---|---|---|
| POST | `/api/auth/register` | Public |
| POST | `/api/auth/login` | Public |

### Products
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/products` | Public |
| GET | `/api/products/{id}` | Public |
| GET | `/api/products/search?keyword=` | Public |
| GET | `/api/products/category/{categoryId}` | Public |
| POST | `/api/products` | Admin |
| PUT | `/api/products/{id}` | Admin |
| DELETE | `/api/products/{id}` | Admin |

### Categories
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/categories` | Public |
| POST | `/api/categories` | Admin |
| PUT | `/api/categories/{id}` | Admin |
| DELETE | `/api/categories/{id}` | Admin |

### Cart
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/cart` | User |
| POST | `/api/cart/items` | User |
| PUT | `/api/cart/items/{itemId}` | User |
| DELETE | `/api/cart/items/{itemId}` | User |

### Orders
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/orders` | User |
| GET | `/api/orders/{id}` | User |
| POST | `/api/orders` | User |
| PUT | `/api/orders/{id}/status` | Admin |

---

## 🧪 Sample Request — Register

```json
POST /api/auth/register
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer",
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

---

## 👨‍💻 Author

**Ayush Raj**  
📧 ayushr.cs.22@nitj.ac.in  
🎓 NIT Jalandhar

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
