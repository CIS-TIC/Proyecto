# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/pedrosverga.png)
## Tareas
### Arquitectura
- [X] Montar DB
- [X] Pasar esquema relacional a la DB
- [ ] Preparar contenedores (Apache, MySQL y NGINX)
### Aplicación
- [ ] Diseño nuevas pantallas
- [ ] Preparación de Bootstrap
- [ ] Realizar plantillas HTML+CSS

>[!TIP]
>+ USUARIOS: Cambiar/anular solicitud aprobada?
## Documentación
:link:[Enlace carpeta de contenidos](https://1drv.ms/f/s!Aixurhs-zJm9bmkndDmPo6mAk1Q?e=WchtPc)
### Base de Datos
![Esquema DB](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/E-R%20SVERGA%205.0%20.PNG)


| ENTIDAD | ATRIBUTOS |
| --- | --- |
| usuarios | (**idusuario**, nombre, apellido1, apellido2, empleo, mail, telefono, departamento, clave) |
| roles | (**rol**) |
| roles_usuarios | (**idusuario**, **rol**) |
| reservas | (**idreserva**, *fk_solicitante*, *fk_autorizador*, *fk_aula*, num_alumnos, civil_militar, ejercito, estado_reserva, observaciones) |
| aulas | (**idaula**, edificio, nombre, capacidad, puestos, modulo, zar, rap, red_ossorio, wan_pg, proyector, pizarra_digital, extras) |
| calendario | (**inicio**, **fk_reserva**, fin, tipo, num_hora) |



![Diseño final DB](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/RELACIONAL%20SVERGA%205.0.png)


