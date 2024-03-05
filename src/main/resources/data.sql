INSERT INTO proyecto (idProy, nombre, fechaCreacion) VALUES
(1, "Enviar ficheros firmados", "2024-01-02"),
(2, "Tratar ficheros EBICS", "2024-02-01"),
(3, "Enviar alertas ficheros no tratados", "2024-03-01");

INSERT INTO tarea (idTarea, descripcion, fechaLimite) VALUES
(1, "Definir transmisiones ficheros firmados", "2024-01-02", 1, "false", 1),
(2, "Definir transmisiones EBICS", "2024-02-01", 1, "false", 1),
(3, "Definir alertas", "2024-03-01", 1, "false", 1);


