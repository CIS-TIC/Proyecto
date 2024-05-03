# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/image71559.png)
## Tareas
### Arquitectura
- [ ] Montar DB
- [ ] Pasar esquema relacional a la DB
- [ ] Preparar contenedores (Apache y MySQL)
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
| usuario | (**idusuario**, nombre, apellido1, apellido2, empleo, mail, telefono) |
| dotacion | (*fk_usuario*, departamento) |
| coordinador | (*fk_usuario*) |
| administrador | (*fk_usuario*) |
| reservas | (**id**, *FK_DOTACION*, *FK_COORDIANDOR*, *FK_HORARIO*, *FK_AULA*, NºAlumnos, Civil/Militar, Ejercito) |
| AULAS | (**Id**, Edificio, Nombre, Capacidad, Puestos, Modulo, Superficie, Equipamiento, ZAR, RAP, Red Ossorio, WAN-PG, Proyector, Pantalla inteligente, Extras) |
| HORARIOS | (**Tipo**, NºHora, **Inicio**, **Fin**) |


