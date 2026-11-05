CREATE DATABASE IF NOT EXISTS biblioteca_poo;
USE biblioteca_poo;

CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(120) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    ejemplares INT NOT NULL
);
