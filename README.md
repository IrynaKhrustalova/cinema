# **📽️Cinema app📽️**

![R](https://user-images.githubusercontent.com/96648890/194519721-240e9718-a07a-4ae0-9568-8f5a6e49c107.jpg)


<!-- ABOUT THE PROJECT -->
## **📢Project Description**

A simple application that simulates a cinema's ticket-reservation system. It contents only with backend part.
Manage cinema by adding new movies, movie sessions, adding cinema halls. With registering new user the shopping cart linked to user will be created. After login as user add movie sessions to shopping cart and create orders to purchase tickets.



## 💻Implementation details

Project based on 3-layer architecture:

- Application layer (services)
- Data access layer (repository)
- Representation layer (controllers)

## ⚡Project configuration

1. Clone this project to your IDE as Maven project.
2. Check a pom.xml file if any errors are occurred - fix them.
3. Open MySql. It can be local or remote database. Create schema.
4. To configure connection to database open db.properties
   (src/main/resources/application.properties)
5. Edit these fields according to your data:

````
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD
````  

where:
- <YOUR_DATABASE_URL> - URL to Database (for local database: localhost)
- <YOUR_DATABASE_USERNAME> - username to get permission to read and write to database
- <YOUR_DATABASE_PASSWORD> - password for <YOUR_DATABASE_USERNAME> user
6. Run application and open on you Internet Explorer http://localhost:8083/inject page. If you see "true", you can open http://localhost:8083/swagger-ui/index.html and test this application.
## 🧧Application functionality

#### _Everyone_ has access to the following pages: 
**/register** and **/login**

#### Both _Users_ and _Admins_ can perform the following operations:

- Get a list of all movies (GET: /movies);
- Get a list of all cinema halls (GET: /cinema-halls);
- Get all movie sessions by a movie's id (GET: /movie-sessions/{id});
- Get a list of all films that will be shown in the cinema on a given day (GET: /movie-sessions/available).

#### Only Users can perform the following operations:

- Get a list of all the orders made by a user (GET: /orders);
- Get your shopping cart (GET: /shopping-carts/by-user), add your order (POST: /orders/complete), change a movie session from your shopping cart by a movie session's id (PUT: /shopping-carts/movie-sessions).

#### Only Admins can perform the following operations:

- Add a movie (POST: /movies);
- Add a movie session (POST: /movie-sessions);
- Add a cinema hall (POST: /cinema-halls );
- Get a user by email (GET: /users/by-email);
- Change a movie session by its id (PUT: /movie-sessions/{id});
- Delete a movie session by its id (DELETE: /movie-sessions/{id}).

## 🔥Application technologies used

- Java 11 
- Spring Boot 3.1.1
- Spring WEB 
- Spring MVC 
- Spring Security 
- Spring Data Jpa
- Hibernate Validator
- Lombok
- MySQL 
- Apache TomCat 
- Maven
- Swagger

## 📊Diagram of DB tables relations

![Hibernate_Cinema_Uml](https://user-images.githubusercontent.com/96648890/190859151-a9cdc3b6-e28a-4b56-93ba-65b1c2017515.png)

