-- Creación de la base de datos 'apihoteles'
CREATE DATABASE apihoteles;

-- Seleccionar la base de datos para usarla
USE apihoteles;

-- Creación de la tabla 'hotel'
CREATE TABLE hotel (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       descripcion TEXT,
                       categoria VARCHAR(50), -- Ejemplo: 3 estrellas, 4 estrellas
                       piscina BOOLEAN DEFAULT FALSE, -- TRUE si tiene piscina, FALSE si no
                       localidad VARCHAR(100) NOT NULL
);

-- Creación de la tabla 'habitaciones'
CREATE TABLE habitaciones (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              hotel_id INT NOT NULL, -- Relación con el id del hotel
                              numero_habitacion INT NOT NULL,
                              tamano ENUM('una_persona', 'dos_personas', 'cuatro_personas') NOT NULL, -- Tamaño de la habitación
                              precio_noche DOUBLE NOT NULL, -- Precio por noche
                              desayuno BOOLEAN DEFAULT FALSE, -- TRUE si incluye desayuno, FALSE si no
                              ocupada BOOLEAN DEFAULT FALSE, -- TRUE si la habitación está ocupada, FALSE si no
                              FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
);

-- Insertar datos en la tabla 'hotel'
INSERT INTO hotel (nombre, descripcion, categoria, piscina, localidad)
VALUES
    ('Hotel Sol y Playa', 'Ubicado frente al mar con vistas espectaculares.', '4 estrellas', TRUE, 'Barcelona'),
    ('Montaña Encantada', 'Un lugar acogedor en medio de las montañas.', '3 estrellas', FALSE, 'Granada'),
    ('City Center Inn', 'Perfecto para viajes de negocios en el centro de la ciudad.', '5 estrellas', TRUE, 'Madrid'),
    ('Rincón Tranquilo', 'Un pequeño hotel boutique ideal para descansar.', '2 estrellas', FALSE, 'Sevilla');

-- Insertar datos en la tabla 'habitaciones'
INSERT INTO habitaciones (hotel_id, numero_habitacion, tamano, precio_noche, desayuno, ocupada)
VALUES
-- Habitaciones para Hotel Sol y Playa
(1, 101, 'dos_personas', 120.50, TRUE, FALSE),
(1, 102, 'cuatro_personas', 200.00, TRUE, TRUE),
(1, 103, 'una_persona', 90.00, FALSE, FALSE),

-- Habitaciones para Montaña Encantada
(2, 201, 'dos_personas', 85.00, TRUE, TRUE),
(2, 202, 'cuatro_personas', 150.00, FALSE, FALSE),
(2, 203, 'una_persona', 70.00, FALSE, TRUE),

-- Habitaciones para City Center Inn
(3, 301, 'dos_personas', 180.00, TRUE, FALSE),
(3, 302, 'cuatro_personas', 250.00, TRUE, TRUE),
(3, 303, 'una_persona', 150.00, TRUE, FALSE),

-- Habitaciones para Rincón Tranquilo
(4, 401, 'una_persona', 50.00, FALSE, FALSE),
(4, 402, 'dos_personas', 75.00, TRUE, FALSE),
(4, 403, 'cuatro_personas', 120.00, TRUE, TRUE);