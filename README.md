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
       ('phong', '1234'),
       ('staff1', '123456'),
       ('staff2', '123456');

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
   INSERT INTO regMovie
   (title, billcast, director, releasedate, duration, genre, rating, distributor, website, synopsis)
   VALUES
   ('Inception', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page', 'Christopher Nolan', '2010-07-16', '148', 'Sci-Fi, Action', 'PG-13', 'Warner Bros.',
   'https://www.warnerbros.com/movies/inception', 'Một nhóm xâm nhập giấc mơ để cấy ý tưởng vào tiềm thức mục tiêu.'),
   ('Titanic', 'Leonardo DiCaprio, Kate Winslet', 'James Cameron', '1997-12-19', '195', 'Romance, Drama', 'PG-13', 'Paramount Pictures', 'https://www.paramount.com', 'Chuyện 
   tình trên con tàu huyền thoại RMS Titanic.'),
   ('Avengers: Endgame', 'Robert Downey Jr., Chris Evans, Scarlett Johansson', 'Anthony Russo, Joe Russo', '2019-04-26', '181', 'Action, Superhero', 'PG-13', 'Marvel Studios',
   'https://www.marvel.com/movies/avengers-endgame', 'Các Avengers nỗ lực đảo ngược thảm họa của Thanos.'),
   ('Interstellar', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'Christopher Nolan', '2014-11-07', '169', 'Sci-Fi, Adventure', 'PG-13', 'Paramount Pictures',
   'https://www.paramount.com', 'Hành trình xuyên hố đen đi tìm ngôi nhà mới cho nhân loại.'),
   ('The Dark Knight', 'Christian Bale, Heath Ledger', 'Christopher Nolan', '2008-07-18', '152', 'Action, Crime', 'PG-13', 'Warner Bros.',
   'https://www.warnerbros.com/movies/dark-knight', 'Batman đối đầu Joker, kẻ khủng bố hỗn loạn.'),
   ('Parasite', 'Song Kang-ho, Lee Sun-kyun, Cho Yeo-jeong', 'Bong Joon-ho', '2019-05-30', '132', 'Thriller, Drama', 'R', 'CJ Entertainment',
   'https://www.cjentertainment.com', 'Hai gia đình ở hai tầng lớp xã hội va chạm bất ngờ.'),
   ('Spirited Away', 'Rumi Hiiragi, Miyu Irino (voice)', 'Hayao Miyazaki', '2001-07-20', '125', 'Animation, Fantasy', 'PG', 'Studio Ghibli', 'https://www.ghibli.jp', 'Cô bé 
   lạc vào thế giới linh hồn kỳ ảo.'),
   ('La La Land', 'Ryan Gosling, Emma Stone', 'Damien Chazelle', '2016-12-09', '128', 'Musical, Romance', 'PG-13', 'Lionsgate', 'https://www.lionsgate.com', 'Tình yêu và ước 
   mơ giữa nhạc sĩ jazz và nữ diễn viên.'),
   ('The Godfather', 'Marlon Brando, Al Pacino', 'Francis Ford Coppola', '1972-03-24', '175', 'Crime, Drama', 'R', 'Paramount Pictures', 'https://www.paramount.com', 'Biên 
   niên sử gia tộc mafia Corleone.'),
   ('Your Name', 'Ryunosuke Kamiki, Mone Kamishiraishi (voice)', 'Makoto Shinkai', '2016-08-26', '106', 'Animation, Romance', 'PG', 'Toho', 'https://www.toho.co.jp', 'Hai 
   thiếu niên hoán đổi thân xác kỳ lạ.'),
   ('Dune: Part Two', 'Timothée Chalamet, Zendaya', 'Denis Villeneuve', '2024-03-01', '166', 'Sci-Fi, Adventure', 'PG-13', 'Warner Bros.',
   'https://www.warnerbros.com/movies/dune-part-two', 'Paul Atreides hợp nhất Fremen để phục hưng nhà Atreides.'),
   ('Oppenheimer', 'Cillian Murphy, Emily Blunt, Robert Downey Jr.', 'Christopher Nolan', '2023-07-21', '180', 'Biography, Drama', 'R', 'Universal Pictures',
   'https://www.universalpictures.com', 'Câu chuyện J. Robert Oppenheimer và Dự án Manhattan.');


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
       ('Avengers: Endgame', '19:00', '2025-11-06'),
      ('The Dark Knight', '21:00', '2025-11-05'),
      ('Avengers: Endgame', '16:00', '2025-11-06'),
      ('Interstellar', '19:00', '2025-11-06'),
      ('Parasite', '21:30', '2025-11-06'),
      ('Dune: Part Two', '15:30', '2025-11-07'),
      ('Oppenheimer', '18:45', '2025-11-07'),
      ('La La Land', '21:15', '2025-11-07');
5 **Run the Application**

    Copy all files in Source Packages/oop into your NetBeans project.

    Run Login.java to start the application.
