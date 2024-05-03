// Creacion de tablas

CREATE TABLE `sverga`.`usuario` (
`idusuario` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(20) NOT NULL,
`apellido1` VARCHAR(20) NOT NULL,
`apellido2` VARCHAR(20) NOT NULL,
`empleo` VARCHAR(20) NOT NULL,
`mail` VARCHAR(20) NULL,
`telefono` INT NULL,
PRIMARY KEY (`idusuario`)
);

CREATE TABLE `sverga`.`dotacion` (
`fk_usuario` INT NOT NULL,
`departamento` VARCHAR(20) NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario_dotacion`
FOREIGN KEY (`fk_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE `sverga`.`coordinador` (
`fk_usuario` INT NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario_coordinador`
FOREIGN KEY (`fk_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE `sverga`.`administrador` (
`fk_usuario` INT NOT NULL,
PRIMARY KEY (`fk_usuario`),
CONSTRAINT `fk_usuario_administrador`
FOREIGN KEY (`fk_usuario`)
REFERENCES `sverga`.`usuario` (`idusuario`)
ON DELETE CASCADE
ON UPDATE CASCADE
);
