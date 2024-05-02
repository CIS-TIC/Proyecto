# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/SVERGA.png)
## Tareas
### Arquitectura
- [ ] Montar DB
- [ ] Preparar contenedores (Apache y MySQL)
### Aplicación
- [ ] Realizar plantillas HTML+CSS
- [ ] Diseño nuevas pantallas

>[!TIP]
>+ USUARIOS: Cambiar/anular solicitud aprobada?
>+ 
## Documentación
:link:[Enlace carpeta de contenidos](https://minisdefear-my.sharepoint.com/:f:/g/personal/escanoasaugue_minisdefear_onmicrosoft_com/EtAFxpsyZkxMo7nGqYn215gBakcX1UwHNWfo752WsTBJoQ?e=5LR0RJ)
### Relacional DB
| ENTIDAD | ATRIBUTOS |
| --- | --- |
| USUARIO | (**Id**, Nombre, Apellidos, Empleo, Mail, Teléfono) |
| DOTACIÓN | (*FK_USUARIO*, Departamento) |
| COORDINADOR | (*FK_USUARIO*) |
| ADMINISTRADOR | (*FK_USUARIO*) |
| RESERVAS | (**Id**, *FK_DOTACION*, *FK_COORDIANDOR*, *FK_HORARIO*, *FK_AULA*, NºAlumnos, Civil/Militar, Ejercito) |
| AULAS | (**Id**, Edificio, Nombre, Capacidad, Puestos, Modulo, Superficie, Equipamiento, ZAR, RAP, Red Ossorio, WAN-PG, Proyector, Pantalla inteligente, Extras) |
| HORARIOS | (**Tipo**, NºHora, **Inicio**, **Fin**) |


