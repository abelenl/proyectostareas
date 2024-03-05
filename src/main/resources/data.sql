INSERT INTO proyecto (id, nombre, fechaalta) VALUES
(1, 'Enviar ficheros firmados', '2024-01-02'),
(2, 'Tratar ficheros EBICS', '2024-02-01'),
(3, 'alertas de envios', '2024-03-01');

INSERT INTO tarea (id, descripcion, fechalimite, orden, completada) VALUES
(1, 'Definir transmisiones ficheros firmados', '2024-01-02', 1, 'false'),
(2, 'Definir transmisiones EBICS', '2024-02-01', 1, 'false'),
(3, 'Definir alertas', '2024-03-01', 1, 'false');
