// Creacion de tablas

CREATE TABLE `sverga`.`usuarios` (
`idusuario` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(20) NOT NULL,
`apellido1` VARCHAR(20) NOT NULL,
`apellido2` VARCHAR(20) NOT NULL,
`empleo` VARCHAR(20) NOT NULL,
`mail` VARCHAR(20) NULL,
`telefono` INT NULL,
`departamento` VARCHAR(20) NULL,
`rol` VARCHAR(20) NOT NULL,
PRIMARY KEY (`idusuario`));

CREATE TABLE `sverga`.`horarios` (
`tipo` VARCHAR(20) NOT NULL,
`inicio` TIME NOT NULL,
`fin` TIME NOT NULL,
`num_hora` INT NULL,
PRIMARY KEY (`tipo`, `inicio`, `fin`));

CREATE TABLE `sverga`.`aulas` (
`idaula` INT NOT NULL,
`edificio` VARCHAR(20) NOT NULL,
`nombre` VARCHAR(45) NULL,
`capacidad` INT NULL,
`puestos` INT NULL,
`modulo` VARCHAR(20) NULL,
`zar` TINYINT NULL,
`rap` TINYINT NULL,
`red_osorio` TINYINT NULL,
`wan_pg` TINYINT NULL,
`proyector` TINYINT NULL,
`pizarra_digital` TINYINT NULL,
`extras` VARCHAR(100) NULL,
PRIMARY KEY (`idaula`, `edificio`));

CREATE TABLE `sverga`.`reservas` (
`idreserva` INT NOT NULL,
`fk_solicitante` INT NULL,
`fk_autorizador` INT NULL,
`fk_horario_tipo` VARCHAR(20) NULL,
`fk_horario_inicio` TIME NULL,
`fk_horario_fin` TIME NULL,
`fk_edificio` VARCHAR(20) NULL,
`fk_aula` INT NULL,
`num_alumnos` INT NULL,
`civil_militar` TINYINT NULL,
`ejercito` VARCHAR(20) NULL,
PRIMARY KEY (`idreserva`),
INDEX `fk_solicitante_idx` (`fk_solicitante` ASC) VISIBLE,
INDEX `fk_autorizador_idx` (`fk_autorizador` ASC) VISIBLE,
INDEX `fk_horario_tipo_idx` (`fk_horario_tipo` ASC) VISIBLE,
INDEX `fk_horario_inicio_idx` (`fk_horario_inicio` ASC) VISIBLE,
INDEX `fk_horario_fin_idx` (`fk_horario_fin` ASC) VISIBLE,
INDEX `fk_aula_idx` (`fk_aula` ASC) VISIBLE,
INDEX `fk_edificio_idx` (`fk_edificio` ASC) VISIBLE,
CONSTRAINT `fk_solicitante`
FOREIGN KEY (`fk_solicitante`)
REFERENCES `sverga`.`usuarios` (`idusuario`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_autorizador`
FOREIGN KEY (`fk_autorizador`)
REFERENCES `sverga`.`usuarios` (`idusuario`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_horario_tipo`
FOREIGN KEY (`fk_horario_tipo`)
REFERENCES `sverga`.`horarios` (`tipo`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_horario_inicio`
FOREIGN KEY (`fk_horario_inicio`)
REFERENCES `sverga`.`horarios` (`inicio`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_horario_fin`
FOREIGN KEY (`fk_horario_fin`)
REFERENCES `sverga`.`horarios` (`fin`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_aula`
FOREIGN KEY (`fk_aula`)
REFERENCES `sverga`.`aulas` (`idaula`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_edificio`
FOREIGN KEY (`fk_edificio`)
REFERENCES `sverga`.`aulas` (`edificio`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);
