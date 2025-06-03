CREATE DATABASE akihabara_db;
USE akihabara_db;

CREATE TABLE producto (
	id int primary key auto_increment,
    nombre varchar(255) not null,
    categoria varchar(100),
    precio decimal(10, 2),
    stock int
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