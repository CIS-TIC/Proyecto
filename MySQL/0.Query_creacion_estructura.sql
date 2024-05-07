// Creacion de tablas

CREATE TABLE usuarios (
	idusuario INT PRIMARY KEY,
	nombre VARCHAR(20),
	apellido1 VARCHAR(20),
	apellido2 VARCHAR(20),
	empleo VARCHAR(20),
	mail VARCHAR(20),
	telefono INT,
	departamento VARCHAR(0),
	prim_inicio BOOLEAN,
	estado BOOLEAN,
	contraseña VARCHAR(255)
);

CREATE TABLE roles (
	rol VARCHAR(20) PRIMARY KEY
);

CREATE TABLE roles_usuarios (
	idusuario INT,
	rol VARCHAR(20),
	FOREIGN KEY (idusuario) REFERENCES usuarios(idusuario),
	FOREIGN KEY (rol) REFERENCES roles(rol),
	PRIMARY KEY (idusuario, rol)
);

CREATE TABLE aulas (
	idaula INT PRIMARY KEY,
	edificio VARCHAR(20),
	nombre VARCHAR(20),
	capacidad INT,
	puestos INT,
	modulo VARCHAR(20),
	zar BOOLEAN,
	rap BOOLEAN,
	red_ossorio BOOLEAN,
	wan_pg BOOLEAN,
	proyector BOOLEAN,
	pizarra_digital BOOLEAN,
	extras VARCHAR(255)
);

CREATE TABLE calendario (
	tipo VARCHAR(20),
	num_hora INT,
	inicio DATETIME,
	fin DATETIME,
	PRIMARY KEY (tipo, num_hora),
	INDEX (tipo),
	INDEX (num_hora)
);

CREATE TABLE reservas (
	idreserva INT PRIMARY KEY,
	fk_solicitante INT,
	fk_autorizador INT,
	fk_aula INT,
	num_alumnos INT,
	civil_militar BOOLEAN,
	ejercito VARCHAR(20),
	FOREIGN KEY (fk_solicitante) REFERENCES usuarios(idusuario),
	FOREIGN KEY (fk_autorizador) REFERENCES usuarios(idusuario),
	FOREIGN KEY (fk_aula) REFERENCES aulas(idaula)
);

CREATE TABLE reservas_calendario (
	fk_reserva INT,
	fk_tipo_cal VARCHAR(20),
	fk_num_hora_cal INT,
	dia DATE,
	FOREIGN KEY (fk_reserva) REFERENCES reservas(idreserva),
	FOREIGN KEY (fk_tipo_cal) REFERENCES calendario(tipo),
	FOREIGN KEY (fk_num_hora_cal) REFERENCES calendario(num_hora),
	PRIMARY KEY (fk_reserva, fk_tipo_cal, fk_num_hora_cal, dia)
);
