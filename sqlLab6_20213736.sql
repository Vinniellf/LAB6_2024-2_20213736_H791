-- este script tiene 3 segmentos, para utilizarlo deben crear un schema de base de datos
-- ejecutar cada segmento por separado.
-- eventmaster.eventos definition

DROP DATABASE IF EXISTS laboratorio6;

CREATE DATABASE IF NOT EXISTS laboratorio6;

USE laboratorio6;

CREATE TABLE `eventos` (
  `eventoId` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `asistentesEsperados` int DEFAULT NULL,
  PRIMARY KEY (`eventoId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO eventos (nombre, fecha, asistentesEsperados) 
VALUES ('Festival de Música', '2024-12-25', 5000),
       ('Concierto de Rock', '2024-11-15', 3000),
       ('Evento de Jazz', '2024-10-05', 1500);


-- eventmaster.artistas definition

CREATE TABLE `artistas` (
  `artistaId` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`artistaId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO artistas (nombre, genero, telefono)
VALUES ('Band Rocker', 'Rock', '987654321'),
       ('Smooth Jazz Band', 'Jazz', '987654322'),
       ('DJ Electron', 'Electronica', '987654323');

-- eventmaster.eventos_artistas definition (relaciona eventos con artistas)

CREATE TABLE `eventos_artistas` (
  `eventoId` int NOT NULL,
  `artistaId` int NOT NULL,
  PRIMARY KEY (`eventoId`, `artistaId`),
  KEY `eventos_artistas_evento_FK` (`eventoId`),
  KEY `eventos_artistas_artista_FK` (`artistaId`),
  CONSTRAINT `eventos_artistas_evento_FK` FOREIGN KEY (`eventoId`) REFERENCES `eventos` (`eventoId`),
  CONSTRAINT `eventos_artistas_artista_FK` FOREIGN KEY (`artistaId`) REFERENCES `artistas` (`artistaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO eventos_artistas (eventoId, artistaId)
VALUES (1, 1),  -- Festival de Música con Band Rocker
       (2, 1),  -- Concierto de Rock con Band Rocker
       (3, 2),  -- Evento de Jazz con Smooth Jazz Band
       (1, 3);  -- Festival de Música con DJ Electron
