# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/image71559.png)
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
### Relacional DB
| ENTIDAD | ATRIBUTOS |
| --- | --- |
| usuarios | (**idusuario**, nombre, apellido1, apellido2, empleo, mail, telefono, departamento, rol) |
| reservas | (**idreserva**, *fk_solicitante*, *fk_autorizador*, *fk_horario_tipo*, *fk_horario_inicio*, *fk_horario_fin*, *fk_aula*, *fk_edificio*, num_alumnos, civil_militar, ejercito) |
| aulas | (**idaula**, **edificio**, nombre, capacidad, puestos, modulo, zar, rap, red_ossorio, wan_pg, proyector, pizarra_digital, extras) |
| horarios | (**tipo**, num_hora, **inicio**, **fin**) |


