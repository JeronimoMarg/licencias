-- Inserts 
INSERT INTO metodosagiles.usuario (id, contrasenia, nombre_usuario,nro_documento,rol,tipo_documento) VALUES (1, 'root','root',123,'SUPERUSUARIO','DNI');

-- Insertos en la tabla tipodelicencias
INSERT INTO metodosagiles.tipodelicencias (id, descripcion, edad_minima, letra_clase) VALUES
(1, 'Licencia tipo A', 17, 'A'),
(2, 'Licencia tipo B', 17, 'B'),
(3, 'Licencia tipo C', 21, 'C'),
(4, 'Licencia tipo D', 21, 'D'),
(5, 'Licencia tipo E', 21, 'E'),
(6, 'Licencia tipo G', 17, 'G');


-- Insertos en la tabla costos
INSERT INTO metodosagiles.costos (id, costo, vigencia, id_tipo_licencia) VALUES
(1, 40.00, 5, 1),
(2, 30.00, 4, 1),
(3, 25.00, 3, 1),
(4, 20.00, 1, 1),

(5, 40.00, 5, 2),
(6, 30.00, 4, 2),
(7, 25.00, 3, 2),
(8, 20.00, 1, 2),

(9, 47.00, 5, 3),
(10, 35.00, 4, 3),
(11, 30.00, 3, 3),
(12, 23.00, 1, 3),

(13, 50.00, 5, 4),
(14, 40.00, 4, 4),
(15, 35.00, 3, 4),
(16, 25.00, 1, 4),

(17, 59.00, 5, 5),
(18, 44.00, 4, 5),
(19, 39.00, 3, 5),
(20, 29.00, 1, 5),

(21, 40.00, 5, 6),
(22, 30.00, 4, 6),
(23, 25.00, 3, 6),
(24, 20.00, 1, 6);
