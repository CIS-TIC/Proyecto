// Creacion de tablas

CREATE TABLE `sverga`.`usuario` (
`idusuario` INT NOT NULL AUTO_INCREMENT,
`nombre` NVARCHAR(20) NOT NULL,
`apellido1` NVARCHAR(20) NOT NULL,
`apellido2` NVARCHAR(20) NOT NULL,
`empleo` NVARCHAR(20) NOT NULL,
`mail` NVARCHAR(20) NULL,
`telefono` INT NULL,
PRIMARY KEY (`idusuario`));

CREATE TABLE `sverga`.`dotacion` (
`fk_usuario` INT NOT NULL,
`departamento` NVARCHAR(20) NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario`
FOREIGN KEY (`fk_usuario_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE);

CREATE TABLE `sverga`.`coordinador` (
`fk_usuario` INT NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario_coordinador`
FOREIGN KEY (`fk_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE);

CREATE TABLE `sverga`.`administrador` (
`fk_usuario` INT NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario_administrador`
FOREIGN KEY (`fk_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE);

