-- Buat database
CREATE DATABASE thread_db;

-- Gunakan database
USE thread_db;

-- Buat tabel user
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
//database utamanya untuk aplikasi simple-thread di XAMPP