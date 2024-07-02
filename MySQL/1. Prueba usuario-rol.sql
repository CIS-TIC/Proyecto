use e2t_mysql;
/*QUERY MODIFICAR COLUMNA*/

ALTER TABLE `e2t_mysql`.`calendario` 
CHANGE COLUMN `num_hora` `num_hora` VARCHAR(20) NOT NULL ;

/*QUERY DE CREACIÓN DE USUARIO*/

INSERT INTO usuarios (idusuario,nombre,apellido1,apellido2,empleo,mail,telefono,departamento,prim_inicio,estado,clave)
VALUES (1, "Fulanito", "Fulanitez", "Fulanitez","Civil","fulanito@mail.com",123456789,"Informática",1,"Conectado","123");

/*ASIGNAR ROL A USUARIO*/

INSERT INTO roles_usuarios (idusuario,rol)
VALUES (1, "administrador");

/* IDENTIFICAR ADMINISTRADORES*/

SELECT usuarios.nombre from usuarios
join roles_usuarios on usuarios.idusuario = roles_usuarios.idusuario;

/*insertar hora en calendario*/
INSERT INTO `e2t_mysql`.`calendario` (`tipo`, `num_hora`, `inicio`, `fin`) VALUES ('LABORABLE', 'PRIMERA', '2024-05-10 08:30:00', '2024-05-10 09:30:00');
