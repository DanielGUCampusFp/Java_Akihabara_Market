DROP DATABASE IF EXISTS akihabara_db;
CREATE DATABASE akihabara_db;
USE akihabara_db;

CREATE TABLE producto (
	id int primary key auto_increment,
    nombre varchar(255) not null,
    categoria varchar(100),
    precio decimal(10, 2),
    stock int
);

CREATE TABLE clientes (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    telefono VARCHAR(15),
    fecha_registro DATE
);

INSERT INTO producto (nombre, categoria, precio, stock) VALUES
-- Categoría: Figura
('Figura Goku Super Saiyan', 'Figura', 35.99, 12),
('Figura Naruto Shippuden', 'Figura', 29.50, 8),
('Figura Luffy Gear 4', 'Figura', 45.00, 5),

-- Categoría: Manga
('Manga One Piece Vol. 1', 'Manga', 7.99, 30),
('Manga Naruto Vol. 1', 'Manga', 7.50, 25),
('Manga Demon Slayer Vol. 1', 'Manga', 8.20, 20),

-- Categoría: Póster
('Póster Attack on Titan', 'Póster', 5.99, 15),
('Póster My Hero Academia', 'Póster', 6.50, 10),
('Póster Tokyo Revengers', 'Póster', 6.00, 12),

-- Categoría: Llavero
('Llavero Pikachu', 'Llavero', 3.50, 40),
('Llavero Totoro', 'Llavero', 4.00, 35),
('Llavero Gengar', 'Llavero', 3.75, 25),

-- Categoría: Ropa
('Camiseta One Piece', 'Ropa', 19.99, 18),
('Sudadera Naruto', 'Ropa', 34.90, 10),
('Gorra Pokémon', 'Ropa', 14.50, 22);

INSERT INTO clientes (dni, nombre, email, telefono, fecha_registro) VALUES
('12345678A', 'Akira Tanaka', 'akira.tanaka@example.com', '611223344', '2024-05-01'),
('87654321B', 'Sakura Yamamoto', 'sakura.yamamoto@example.com', '622334455', '2024-05-03'),
('11223344C', 'Hiroshi Nakamura', 'hiroshi.nakamura@example.com', '633445566', '2024-05-05'),
('44332211D', 'Yumi Sato', 'yumi.sato@example.com', '644556677', '2024-05-07'),
('55667788E', 'Kenji Takahashi', 'kenji.takahashi@example.com', '655667788', '2024-05-10');
