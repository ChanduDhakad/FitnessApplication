# FitnessApplication
Fitness Application is a web-based application that allows users to track their fitness goals and progress. The application provides an easy-to-use interface for users to log their exercises, set goals, and track their progress over time. The application also provides a dashboard to view statistics and progress charts.


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Modules

- Login Module
- Admin Module
- User Module
- CurrentUser module

- Authentication Module


# Features
# Authentication
- Sign up and Login: Users can sign up and log in to the application to access the full features of the application.
# User Features
- Fitness Profile Creation: Users can create their fitness profile, including age, height, weight, and activity level.

- Set Goals: Users can set fitness goals such as weight loss, muscle gain, or maintaining current fitness level.

- View Progress: Users can view their fitness progress, including exercise routine and progress towards goals.

- Get Suggestions: Users can get suggestions based on their activity level to improve their fitness routine.

# Admin Features
- Admin Dashboard: Admin can access the admin dashboard to manage users, fitness plans, and exercises.

- Add Users: Admin can add new users including name, age, height, weight, and activity level.

- Update Users: Admin can update user details including name, age, height, weight, and activity level.

- Remove Users: Admin can remove users from the application.

- View Fitness Plans: Admin can view the list of fitness plans and their details including name, description, and exercises.

- Add Fitness Plans: Admin can add new fitness plans including name, description, and exercises.

- Update Fitness Plans: Admin can update fitness plan details including name, description, and exercises.

- Remove Fitness Plans: Admin can remove fitness plans from the application.

- View Exercises: Admin can view the list of exercises and their details including name, description, and muscle groups targeted.

- Add Exercises: Admin can add new exercises including name, description, and muscle groups targeted.

- Update Exercises: Admin can update exercise details including name, description, and muscle groups targeted.

-Remove Exercises: Admin can remove exercises from the application.

# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- First Name: Must not contain numbers or special characters

- Last Name: Must not contain numbers or special characters

- Mobile Number: Must have 10 digits

- Password: Must be alphanumeric and contain 6-12 characters with at least one special character, one upper case, one lowercase, and one digit

- Email: Must be in the correct email format

- Exercise Name: Must not be empty and must be unique within the application

- Exercise Description: Must not be empty

- Fitness Plan Name: Must not be empty and must be unique within the application

- Fitness Plan Description: Must not be empty

- Fitness Profile Name: Must not be empty and must be unique within the user's profile


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
  server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/MasaiFitnessDB;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```
