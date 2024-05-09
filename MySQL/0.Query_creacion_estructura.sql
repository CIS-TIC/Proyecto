// Creacion de tablas

CREATE TABLE `aulas` (
`idaula` varchar(20) NOT NULL,
`edificio` varchar(20) DEFAULT NULL,
`nombre` varchar(45) DEFAULT NULL,
`capacidad` int DEFAULT NULL,
`puestos` int DEFAULT NULL,
`modulo` varchar(45) DEFAULT NULL,
`zar` tinyint(1) DEFAULT NULL,
`rap` tinyint(1) DEFAULT NULL,
`red_ossorio` tinyint(1) DEFAULT NULL,
`wan_pg` tinyint(1) DEFAULT NULL,
`proyector` tinyint(1) DEFAULT NULL,
`pizarra_digital` tinyint(1) DEFAULT NULL,
`extras` varchar(255) DEFAULT NULL,
PRIMARY KEY (`idaula`)
);

CREATE TABLE `calendario` (
`tipo` varchar(20) NOT NULL,
`num_hora` varchar(20) NOT NULL,
`inicio` datetime DEFAULT NULL,
`fin` datetime DEFAULT NULL,
PRIMARY KEY (`tipo`,`num_hora`),
UNIQUE KEY `tipo` (`tipo`),
UNIQUE KEY `num_hora` (`num_hora`)
) ;
CREATE TABLE `usuarios` (
`idusuario` int NOT NULL AUTO_INCREMENT,
`nombre` varchar(20) NOT NULL,
`apellido1` varchar(20) NOT NULL,
`apellido2` varchar(20) NOT NULL,
`empleo` varchar(20) DEFAULT NULL,
`mail` varchar(45) DEFAULT NULL,
`telefono` varchar(10) DEFAULT NULL,
`departamento` varchar(20) DEFAULT NULL,
`prim_inicio` tinyint(1) DEFAULT NULL,
`estado` varchar(20) DEFAULT NULL,
`clave` varchar(20) DEFAULT NULL,
PRIMARY KEY (`idusuario`),
UNIQUE KEY `mail_UNIQUE` (`mail`)
) ;

CREATE TABLE `reservas` (
`idreserva` int NOT NULL AUTO_INCREMENT,
`fk_solicitante` int NOT NULL,
`fk_autorizador` int NOT NULL,
`fk_aula` varchar(20) DEFAULT NULL,
`num_alumnos` int DEFAULT NULL,
`civil_militar` tinyint(1) DEFAULT NULL,
`ejercito` varchar(20) DEFAULT NULL,
PRIMARY KEY (`idreserva`),
KEY `fk_solicitante` (`fk_solicitante`),
KEY `fk_aula` (`fk_aula`),
KEY `fk_autorizador` (`fk_autorizador`),
CONSTRAINT `fk_aula` FOREIGN KEY (`fk_aula`) REFERENCES `aulas` (`idaula`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_autorizador` FOREIGN KEY (`fk_autorizador`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_solicitante` FOREIGN KEY (`fk_solicitante`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `reservas_calendario` (
`fk_reserva` int NOT NULL,
`fk_tipo_cal` varchar(20) NOT NULL,
`fk_num_hora_cal` varchar(20) NOT NULL,
PRIMARY KEY (`fk_reserva`,`fk_tipo_cal`,`fk_num_hora_cal`),
KEY `fk_tipo_cal_idx` (`fk_tipo_cal`),
KEY `fk_num_hora_cal_idx` (`fk_num_hora_cal`),
CONSTRAINT `fk_num_hora_cal` FOREIGN KEY (`fk_num_hora_cal`) REFERENCES `calendario` (`num_hora`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_reserva` FOREIGN KEY (`fk_reserva`) REFERENCES `reservas` (`idreserva`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_tipo_cal` FOREIGN KEY (`fk_tipo_cal`) REFERENCES `calendario` (`tipo`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `roles` (
`rol` varchar(20) NOT NULL,
PRIMARY KEY (`rol`)
) ;

CREATE TABLE `roles_usuarios` (
`idusuario` int NOT NULL AUTO_INCREMENT,
`rol` varchar(20) NOT NULL,
KEY `idusuario` (`idusuario`),
KEY `rol` (`rol`),
CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `rol` FOREIGN KEY (`rol`) REFERENCES `roles` (`rol`) ON DELETE CASCADE ON UPDATE CASCADE
);
