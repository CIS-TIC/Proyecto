# Proyecto E2T
![SVERGA](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/pedrosverga.png)
## Tareas
### Arquitectura
- [X] Montar DB
- [ ] Preparar contenedores (Apache, MySQL y NGINX)
### Aplicación
- [ ] Diseño vista "Coordinador"
- [ ] Reset contraseña
- [ ] Conexión tabla Reservas

>[!TIP]
>+ USUARIOS: Cambiar/anular solicitud aprobada?
## Documentación
:link:[Enlace carpeta de contenidos](https://1drv.ms/f/c/bd99cc3e1bae6e2c/Eixurhs-zJkggL1uAAAAAAABhLj2wwH3PLojPXu3PmgDMg?e=U0cYJI)
### Base de Datos
![Esquema DB](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/SVERGA%20E-R%206.0.drawio.png)


| ENTIDAD | ATRIBUTOS |
| --- | --- |
| usuarios | (**idusuario**, nombre, apellido1, apellido2, empleo, mail, telefono, departamento, clave) |
| roles | (**rol**) |
| roles_usuarios | (**idusuario**, **rol**) |
| reservas | (**idreserva**, *fk_solicitante*, *fk_autorizador*, *fk_aula*, num_alumnos, civil_militar, ejercito, estado_reserva, observaciones) |
| aulas | (**idaula**, edificio, nombre, capacidad, puestos, modulo, zar, rap, red_ossorio, wan_pg, proyector, pizarra_digital, extras) |




![Diseño final DB](https://github.com/CIS-TIC/Proyecto/blob/main/Recursos/RELACIONAL%20%2BSVERGA%206.0.png)














