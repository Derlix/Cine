CREATE DATABASE bd_cine;
USE bd_cine;

-- Crear la tabla de Cines
CREATE TABLE Cines (
    ID_Cine INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Cine VARCHAR(255),
    Direccion VARCHAR(255),
    Ciudad VARCHAR(255),
    Pais VARCHAR(255)
);

-- Insertar datos de ejemplo en la tabla de Cines
INSERT INTO Cines (Nombre_Cine, Direccion, Ciudad, Pais) VALUES
('CineCity', 'Calle 123', 'Ciudad Principal', 'País A'),
('CinemaTop', 'Avenida 456', 'Ciudad Secundaria', 'País B'),
('CineMax', 'Plaza 789', 'Ciudad Terciaria', 'País C'),
('CineParadise', 'Bulevar 101', 'Ciudad Cuaternaria', 'País D'),
('CineDream', 'Paseo 202', 'Ciudad Quinaria', 'País E');

-- Crear la tabla de Salas de Cine
CREATE TABLE Salas_Cine (
    ID_Sala INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Sala VARCHAR(255),
    Capacidad INT,
    ID_Cine INT,
    FOREIGN KEY (ID_Cine) REFERENCES Cines(ID_Cine)
);

-- Insertar datos de ejemplo en la tabla de Salas de Cine
INSERT INTO Salas_Cine (Nombre_Sala, Capacidad, ID_Cine) VALUES
('Sala 1', 100, 1),
('Sala 2', 80, 1),
('Sala 1', 120, 2),
('Sala 1', 90, 3),
('Sala 2', 110, 4);

-- Crear la tabla de Películas
CREATE TABLE Peliculas (
    ID_Pelicula INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(255),
    Categoria VARCHAR(255),
    Etiquetas VARCHAR(255),
    Restriccion_Edad INT,
    Duracion INT,
    Pais_Origen VARCHAR(255),
    Imagen BLOB,
    Ruta_Imagen VARCHAR(255),
    Fecha_Inicio DATE,
    Fecha_Fin DATE,
    Estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo'
);


-- Insertar datos de ejemplo en la tabla de Películas
INSERT INTO Peliculas (Titulo, Categoria, Etiquetas, Restriccion_Edad, Duracion, Pais_Origen, Imagen, Ruta_Imagen, Fecha_Inicio, Fecha_Fin, Estado) VALUES
('Titanic', 'Romance', 'Drama, Histórico', 12, 195, 'EEUU', LOAD_FILE('/ruta/a/Titanic.jpg'), '/ruta/a/Titanic.jpg', '2024-01-01', '2024-01-31', 'Activo'),
('The Matrix', 'Ciencia Ficción', 'Acción, Cyberpunk', 16, 136, 'EEUU', LOAD_FILE('/ruta/a/TheMatrix.jpg'), '/ruta/a/TheMatrix.jpg', '2024-02-01', '2024-02-29', 'Activo'), 
('The Godfather', 'Crimen', 'Drama, Mafia', 18, 175, 'EEUU', LOAD_FILE('/ruta/a/TheGodfather.jpg'), '/ruta/a/TheGodfather.jpg', '2024-03-01', '2024-03-31', 'Activo'),
('Inception', 'Ciencia Ficción', 'Aventura, Misterio', 14, 148, 'EEUU', LOAD_FILE('/ruta/a/Inception.jpg'), '/ruta/a/Inception.jpg', '2024-04-01', '2024-04-30', 'Activo'),
('The Shawshank Redemption', 'Drama', 'Crimen, Inspirador', 16, 142, 'EEUU', LOAD_FILE('/ruta/a/TheShawshankRedemption.jpg'), '/ruta/a/TheShawshankRedemption.jpg', '2024-05-01', '2024-05-31', 'Activo');




-- Crear la tabla de Funciones
CREATE TABLE Funciones (
    ID_Funcion INT PRIMARY KEY AUTO_INCREMENT,
    ID_Pelicula INT,
    ID_Sala INT,
    Fecha DATE,
    Hora_Inicio TIME,
    Hora_Final TIME,
    FOREIGN KEY (ID_Pelicula) REFERENCES Peliculas(ID_Pelicula),
    FOREIGN KEY (ID_Sala) REFERENCES Salas_Cine(ID_Sala)
);

-- Insertar datos de ejemplo en la tabla de Funciones
INSERT INTO Funciones (ID_Pelicula, ID_Sala, Fecha, Hora_Inicio, Hora_Final) VALUES
(1, 1, '2024-03-01', '15:00:00', '17:30:00'),
(2, 2, '2024-03-01', '17:30:00', '20:00:00'),
(3, 3, '2024-03-02', '14:00:00', '16:55:00'),
(4, 4, '2024-03-02', '18:00:00', '20:30:00'),
(5, 5, '2024-03-03', '16:30:00', '19:15:00');

-- Crear la tabla de Usuarios
CREATE TABLE Usuarios (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Usuario VARCHAR(255),
    Contraseña VARCHAR(255),
    Rol ENUM('Cajero', 'Administrador')
);

-- Insertar datos de ejemplo en la tabla de Usuarios
INSERT INTO Usuarios (Nombre_Usuario, Contraseña, Rol) VALUES
('usuario1', 'password1', 'Cajero'),
('usuario2', 'password2', 'Cajero'),
('usuario3', 'password3', 'Administrador'),
('usuario4', 'password4', 'Cajero'),
('usuario5', 'password5', 'Administrador');

-- Crear la tabla de Ventas
CREATE TABLE Ventas (
    ID_Venta INT PRIMARY KEY AUTO_INCREMENT,
    ID_Pelicula INT,
    ID_Funcion INT,
    ID_Usuario INT,
    Cantidad_Boletos INT,
    Total_Venta DECIMAL(10, 2),
    Fecha_Venta DATE,
    FOREIGN KEY (ID_Pelicula) REFERENCES Peliculas(ID_Pelicula),
    FOREIGN KEY (ID_Funcion) REFERENCES Funciones(ID_Funcion),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario)
);

-- Insertar datos de ejemplo en la tabla de Ventas
INSERT INTO Ventas (ID_Pelicula, ID_Funcion, ID_Usuario, Cantidad_Boletos, Total_Venta, Fecha_Venta) VALUES
(1, 1, 1, 2, 30.00, '2024-03-01'),
(2, 2, 2, 3, 45.00, '2024-03-01'),
(3, 3, 3, 1, 15.00, '2024-03-02'),
(4, 4, 4, 2, 30.00, '2024-03-02'),
(5, 5, 5, 2, 40.00, '2024-03-03');

-- Crear la tabla de Asientos
CREATE TABLE Asientos (
    ID_Asiento INT PRIMARY KEY AUTO_INCREMENT,
    ID_Sala INT,
    Fila CHAR,
    Numero INT,
    Estado ENUM('Disponible', 'En_Uso', 'Reservado'),
    FOREIGN KEY (ID_Sala) REFERENCES Salas_Cine(ID_Sala)
);

-- Insertar datos de ejemplo en la tabla de Asientos
INSERT INTO Asientos (ID_Sala, Fila, Numero, Estado) VALUES
(1, 'A', 1, 'Disponible'),
(1, 'A', 2, 'Disponible'),
(1, 'B', 1, 'Disponible'),
(2, 'A', 1, 'Disponible'),
(2, 'B', 2, 'Reservado');

-- Crear la tabla de Cajeros por Cine
CREATE TABLE Cajeros_Cine (
    ID_Cajero INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT,
    ID_Cine INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Cine) REFERENCES Cines(ID_Cine)
);

-- Insertar datos de ejemplo en la tabla de Cajeros por Cine
INSERT INTO Cajeros_Cine (ID_Usuario, ID_Cine) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4);

-- Crear la tabla de Reportes
CREATE TABLE Reportes (
    ID_Reporte INT PRIMARY KEY AUTO_INCREMENT,
    Tipo ENUM('Diario', 'Semanal', 'Mensual'),
    Contenido TEXT,
    Fecha_Generacion DATE,
    ID_Usuario INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario)
);

-- Insertar datos de ejemplo en la tabla de Reportes
INSERT INTO Reportes (Tipo, Contenido, Fecha_Generacion, ID_Usuario) VALUES
('Diario', 'Reporte diario de ventas.', '2024-03-02', 3),
('Semanal', 'Reporte semanal de asistencias.', '2024-03-01', 5),
('Mensual', 'Reporte mensual de ingresos.', '2024-03-01', 3);


-- Crear la tabla de Anuncios
CREATE TABLE Anuncios (
    ID_Anuncio INT PRIMARY KEY AUTO_INCREMENT,
    Contenido TEXT,
    Fecha_Publicacion DATE,
    Duracion INT,
    ID_Pelicula INT,
    FOREIGN KEY (ID_Pelicula) REFERENCES Peliculas(ID_Pelicula)
);

-- Insertar datos de ejemplo en la tabla de Anuncios
INSERT INTO Anuncios (Contenido, Fecha_Publicacion, Duracion, ID_Pelicula) VALUES
('¡No te pierdas la nueva película!', '2024-03-01', 30, 1),
('Ven a disfrutar de nuestra promoción.', '2024-03-02', 15, 2),
('La mejor experiencia en CineMax.', '2024-03-01', 20, 3);

-- Crear la tabla de Logins
CREATE TABLE Logins (
    ID_Login INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT,
    Hora_Login DATETIME,
    Rol ENUM('Cajero', 'Administrador'),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario)
);


-- Trigger para verificar la restricción de edad en las ventas
DELIMITER //
CREATE TRIGGER verificar_restriccion_edad
BEFORE INSERT ON Ventas
FOR EACH ROW
BEGIN
    DECLARE edad_usuario INT;
    DECLARE usuario_id INT;
    SELECT Restriccion_Edad INTO edad_usuario FROM Peliculas WHERE ID_Pelicula = NEW.ID_Pelicula;
    SELECT ID_Usuario INTO usuario_id FROM Ventas WHERE ID_Venta = NEW.ID_Venta;
    
    IF edad_usuario > (SELECT DATEDIFF(CURRENT_DATE(), (SELECT Fecha_Nacimiento FROM Usuarios WHERE ID_Usuario = usuario_id)) / 365) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El usuario no cumple con la restricción de edad para esta película.';
    END IF;
END//
DELIMITER ;

-- Trigger para actualizar el total de ventas después de insertar una venta
DELIMITER //
CREATE TRIGGER actualizar_total_ventas
AFTER INSERT ON Ventas
FOR EACH ROW
BEGIN
    DECLARE cantidad_boletos_vendidos INT;
    DECLARE id_sala_venta INT;

    -- Obtener la cantidad de boletos vendidos en esta venta
    SET cantidad_boletos_vendidos = NEW.Cantidad_Boletos;

    -- Obtener el ID de la sala correspondiente a la función vendida
    SET id_sala_venta = (SELECT ID_Sala FROM Funciones WHERE ID_Funcion = NEW.ID_Funcion);

    -- Actualizar el inventario de asientos disponibles en la sala
    UPDATE Asientos
    SET Estado = 'En_Uso'
    WHERE ID_Asiento IN (
        SELECT ID_Asiento
        FROM (
            SELECT ID_Asiento
            FROM Asientos
            WHERE ID_Sala = id_sala_venta AND Estado = 'Disponible'
            LIMIT cantidad_boletos_vendidos
        ) AS subquery
    );
END;
//
DELIMITER ;

-- Trigger para actualizar el total de ventas después de eliminar una venta
DELIMITER //
CREATE TRIGGER actualizar_total_ventas_eliminar
AFTER DELETE ON Ventas
FOR EACH ROW
BEGIN
    -- Actualizar el inventario de asientos disponibles en la sala
    UPDATE Asientos
    SET Estado = 'Disponible'
    WHERE ID_Asiento IN (
        SELECT ID_Asiento
        FROM (
            SELECT ID_Asiento
            FROM Ventas
            JOIN Funciones ON Ventas.ID_Funcion = Funciones.ID_Funcion
            JOIN Asientos ON Funciones.ID_Sala = Asientos.ID_Sala
            WHERE Ventas.ID_Venta = OLD.ID_Venta
        ) AS subquery
    );
END//
DELIMITER ;

-- Trigger para guardar el usuario logueado y la hora de login
DELIMITER //
CREATE TRIGGER registrar_login
AFTER INSERT ON Usuarios
FOR EACH ROW
BEGIN
    INSERT INTO Logins (ID_Usuario, Hora_Login, Rol) VALUES (NEW.ID_Usuario, NOW(), NEW.Rol);
END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER reducir_inventario_asientos
AFTER INSERT ON Ventas
FOR EACH ROW
BEGIN
    DECLARE cantidad_boletos_vendidos INT;
    DECLARE id_sala_venta INT;

    -- Obtener la cantidad de boletos vendidos en esta venta
    SELECT NEW.Cantidad_Boletos INTO cantidad_boletos_vendidos;

    -- Obtener el ID de la sala correspondiente a la función vendida
    SELECT ID_Sala INTO id_sala_venta FROM Funciones WHERE ID_Funcion = NEW.ID_Funcion;

    -- Actualizar el inventario de asientos disponibles en la sala
    UPDATE Asientos
    SET Estado = 'En_Uso'
    WHERE ID_Asiento IN (
        SELECT ID_Asiento
        FROM (
            SELECT ID_Asiento
            FROM Asientos
            WHERE ID_Sala = id_sala_venta AND Estado = 'Disponible'
            LIMIT cantidad_boletos_vendidos
        ) AS subquery
    );
END;
DELIMITER ;

DELIMITER //
CREATE TRIGGER generar_reporte_venta
AFTER INSERT ON Ventas
FOR EACH ROW
BEGIN
    DECLARE tipo_reporte VARCHAR(10);
    DECLARE contenido_reporte VARCHAR(255);

    -- Determinar el tipo de reporte según la cantidad de boletos vendidos
    IF NEW.Cantidad_Boletos <= 3 THEN
        SET tipo_reporte = 'Diario';
    ELSEIF NEW.Cantidad_Boletos <= 10 THEN
        SET tipo_reporte = 'Semanal';
    ELSE
        SET tipo_reporte = 'Mensual';
    END IF;

    -- Construir el contenido del reporte
    SET contenido_reporte = CONCAT('Venta realizada el ', DATE_FORMAT(NEW.Fecha_Venta, '%Y-%m-%d'), ' por el usuario ID ', NEW.ID_Usuario, ' con ', NEW.Cantidad_Boletos, ' boletos.');

    -- Insertar el reporte en la tabla de Reportes
    INSERT INTO Reportes (Tipo, Contenido, Fecha_Generacion, ID_Usuario)
    VALUES (tipo_reporte, contenido_reporte, CURRENT_DATE(), NEW.ID_Usuario);
END //
DELIMITER ;
DELIMITER //

CREATE TRIGGER update_ruta_imagen_trigger
BEFORE UPDATE ON Peliculas
FOR EACH ROW
BEGIN
    IF OLD.Imagen != NEW.Imagen THEN
        SET NEW.Ruta_Imagen = CONCAT('/ruta/a/', NEW.Titulo, '.jpg'); -- Cambiar '/ruta/a/' por la ruta real
    END IF;
END//

DELIMITER ;
DELIMITER //
CREATE TRIGGER tr_pelicula_estado BEFORE INSERT ON Peliculas
FOR EACH ROW
BEGIN
    IF NEW.Fecha_Fin <= CURDATE() THEN
        SET NEW.Estado = 'Inactivo';
    END IF;
END$$
DELIMITER ;
-- Trigger para eliminar las relaciones y funciones antes de eliminar un cine
DELIMITER //
CREATE TRIGGER eliminar_relaciones_cine
BEFORE DELETE ON Cines
FOR EACH ROW
BEGIN
    -- Eliminar de la tabla Ventas
    DELETE FROM Ventas WHERE ID_Funcion IN (SELECT ID_Funcion FROM Funciones WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = OLD.ID_Cine));

    -- Eliminar de la tabla Cajeros_Cine
    DELETE FROM Cajeros_Cine WHERE ID_Cine = OLD.ID_Cine;

    -- Eliminar de la tabla Funciones
    DELETE FROM Funciones WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = OLD.ID_Cine);

    -- Eliminar de la tabla Asientos
    DELETE FROM Asientos WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = OLD.ID_Cine);

    -- Eliminar de la tabla Salas_Cine
    DELETE FROM Salas_Cine WHERE ID_Cine = OLD.ID_Cine;
END;
//
DELIMITER ;


