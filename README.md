# Ebook Store

This project is an *Ebook Store* application built using *Servlets*, *JSP*, *HikariCP*, *JDBC*, and *PostgreSQL*. It follows *design patterns* for better modularity and scalability. The application is developed using *NetBeans IDE*.

## Features

- *User Management*: Sign up, login, and manage user details.
- *Book Catalog*: Browse and search books by categories.
- *Shopping Cart*: Add books to a cart and calculate total price.
- *Order Management*: Place orders, view order history, and manage payment details.
- *Responsive UI*: Clean and user-friendly interface using JSP.

## Technology Stack

- *Backend*: Java Servlets, JSP
- *Database*: PostgreSQL
- *Connection Pooling*: HikariCP
- *Web Server*: Apache Tomcat
- *IDE*: NetBeans

---

## Database Design

### 1. *Book Orders (public.book_order)*

| Column      | Type                      | Nullable | Default                              |
|-------------|---------------------------|----------|--------------------------------------|
| id          | integer                 | No       | nextval('book_order_id_seq')      |
| order_id    | character varying(100)  | No       |                                      |
| user_name   | character varying(255)  | No       |                                      |
| email       | character varying(255)  | No       |                                      |
| address     | text                    | No       |                                      |
| book_name   | character varying(255)  | No       |                                      |
| author      | character varying(255)  | No       |                                      |
| price       | character varying(50)   | No       |                                      |
| payment     | character varying(50)   | No       |                                      |
| number      | character varying(15)   | No       |                                      |
| order_time  | timestamp               | Yes      | now()                              |

### 2. *Books (public.books)*

| Column       | Type                      | Nullable | Default                              |
|--------------|---------------------------|----------|--------------------------------------|
| id           | integer                 | No       | nextval('books_id_seq')           |
| bname        | character varying(255)  | No       |                                      |
| author       | character varying(255)  | No       |                                      |
| price        | character varying(50)   | No       |                                      |
| bookcategory | character varying(50)   | No       |                                      |
| status       | character varying(50)   | No       |                                      |
| photo        | character varying(255)  | Yes      |                                      |
| email        | character varying(255)  | No       |                                      |

### 3. *Cart (public.cart)*

| Column       | Type                      | Nullable | Default                              |
|--------------|---------------------------|----------|--------------------------------------|
| cid          | integer                 | No       | nextval('cart_cid_seq')           |
| bid          | integer                 | No       |                                      |
| uid          | integer                 | No       |                                      |
| bookname     | character varying(255)  | No       |                                      |
| author       | character varying(255)  | No       |                                      |
| price        | numeric(10,2)           | No       |                                      |
| totalprice   | numeric(10,2)           | No       |                                      |
| created_at   | timestamp               | Yes      | now()                              |
| updated_at   | timestamp               | Yes      | now()                              |

### 4. *Users (public.users)*

| Column       | Type                      | Nullable | Default                              |
|--------------|---------------------------|----------|--------------------------------------|
| id           | integer                 | No       | nextval('users_id_seq')           |
| name         | character varying(255)  | No       |                                      |
| email        | character varying(255)  | No       |                                      |
| phonenumber  | character varying(15)   | Yes      |                                      |
| password     | character varying(255)  | No       |                                      |
| address      | text                    | Yes      |                                      |
| landmark     | character varying(255)  | Yes      |                                      |
| city         | character varying(100)  | Yes      |                                      |
| state        | character varying(100)  | Yes      |                                      |
| zip          | character varying(10)   | Yes      |                                      |
| created_at   | timestamp               | Yes      | now()                              |
| updated_at   | timestamp               | Yes      | now()                              |

---

## Setup Instructions

### Prerequisites

- *Java Development Kit (JDK)* installed
- *Apache Tomcat* server installed
- *PostgreSQL* database setup
- *NetBeans IDE* for development

### Steps to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/utkarshsingh17/EBook-Store.git
