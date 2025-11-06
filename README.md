# Cinema Management System in Java

A college assignment project designed to manage a small cinema. This application provides staff with movie listings and session schedules for staff use only.

---

## Features

1. **Register a New Movie**  
   - Store movie details including:  
     - Title  
     - Rating  
     - Duration  
     - Synopsis  
     - Release date  
     - Billed cast  
     - Director  
     - Genre  
     - Distributor  
     - Official website  

2. **Schedule Movie Sessions**  
   - Only one cinema screen is available, so only one movie can be shown at any given time.

3. **Display Movie Listings**  
   - Lists all movies.  
   - Selecting a movie shows all details, including its future session times.

4. **Display Session Times by Day**  
   - Shows all sessions for a selected day.  
   - Sessions are sorted from earliest to latest.  
   - Identifies which movie is screening at each time.

---

## Installation & Setup (NetBeans)

1. **Install MySQL Community Edition**  
   - Default account:  
     - Username: `root`  
     - Password: `123456789`  
     - Port: `3306`

2. **Install MySQL Workbench**  

3. **Add Required Libraries to Your Project**  
   - `mysql-connector-j-9.5.0.jar`  
   - `rs2xml.jar`

4. **Database Setup**  

   Open MySQL Workbench and execute the following SQL commands:

   ```sql
   -- Create database
   CREATE DATABASE IF NOT EXISTS movie_db;
   USE movie_db;

   -- Users table
   CREATE TABLE IF NOT EXISTS users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL
   );

   INSERT INTO users (username, password)
   VALUES
       ('admin', '123456'),
       ('phong', '1234');

   -- Registered movies table
   CREATE TABLE IF NOT EXISTS regMovie (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255),
       billcast VARCHAR(255),
       director VARCHAR(255),
       releasedate VARCHAR(50),
       duration VARCHAR(50),
       genre VARCHAR(100),
       rating VARCHAR(50),
       distributor VARCHAR(255),
       website VARCHAR(255),
       synopsis TEXT
   );

   -- Scheduled movies table
   CREATE TABLE IF NOT EXISTS secMovie (
       id INT AUTO_INCREMENT PRIMARY KEY,
       MovieTitle VARCHAR(200) NOT NULL,
       SecTime VARCHAR(20),
       SecDate DATE
   );

   -- Sample data for scheduled movies
   INSERT INTO secMovie (MovieTitle, SecTime, SecDate)
   VALUES 
       ('Inception', '18:00', '2025-11-05'),
       ('Titanic', '20:30', '2025-11-05'),
       ('Avengers: Endgame', '19:00', '2025-11-06');
5 **Run the Application**

    Copy all files in Source Packages/oop into your NetBeans project.

    Run Login.java to start the application.
