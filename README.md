# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/pedrosverga.png)
## Tareas
### Arquitectura
- [ ] Montar DB
- [X] Pasar esquema relacional a la DB
- [X] Preparar contenedores (Apache, MySQL y NGINX)
### Aplicación
- [ ] Diseño nuevas pantallas
- [ ] Preparación de Bootstrap
- [ ] Realizar plantillas HTML+CSS

>[!TIP]
>+ USUARIOS: Cambiar/anular solicitud aprobada?
## Documentación
:link:[Enlace carpeta de contenidos](https://minisdefear-my.sharepoint.com/:f:/g/personal/escanoasaugue_minisdefear_onmicrosoft_com/EtAFxpsyZkxMo7nGqYn215gBakcX1UwHNWfo752WsTBJoQ?e=5LR0RJ)
### Base de Datos
![Esquema DB](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/E-R%20SVERGA.png)

| ENTIDAD | ATRIBUTOS |
| --- | --- |
| usuarios | (**idusuario**, nombre, apellido1, apellido2, empleo, mail, telefono, departamento, rol, 1er_inicio, estado, contraseña) |
| reservas | (**idreserva**, *fk_solicitante*, *fk_autorizador*, *fk_aula*, num_alumnos, civil_militar, ejercito) |
| aulas | (**idaula**, edificio, nombre, capacidad, puestos, modulo, zar, rap, red_ossorio, wan_pg, proyector, pizarra_digital, extras) |
| calendario | (**tipo**, **num_hora**, inicio, fin) |
| reservas_calendario | (**fk_reserva**, **fk_tipo_cal**, **fk_num_cal**, dia) |


