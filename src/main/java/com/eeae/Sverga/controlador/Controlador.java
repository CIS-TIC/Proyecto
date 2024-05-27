package com.eeae.Sverga.controlador;

import com.eeae.Sverga.controladorDTO.AulaRegistroDTO;
import com.eeae.Sverga.controladorDTO.UsuarioRegistroDTO;
import com.eeae.Sverga.domain.Aula;
import com.eeae.Sverga.domain.Rol;
import com.eeae.Sverga.domain.Usuario;
import com.eeae.Sverga.repository.RolRepository;
import com.eeae.Sverga.servicio.AulaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.eeae.Sverga.servicio.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private AulaServicio aulaServicio;

    @Autowired
    private RolRepository rolRepository;

    @ModelAttribute("aula")
    public AulaRegistroDTO retornarNuevaAulaRegistroDTO() {
        return new AulaRegistroDTO();
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    //Muestra la ventana de login
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    //Muestra la pagina de inicio (despues de haber iniciado sesion)
    @GetMapping("/")
    public String verPaginaDeInicio() {
        return "index";
    }

    //////////////////////    USUARIOS   //////////////////////
    //Muestra el formulario de registro de un nuevo usuario
    @GetMapping("/registroUsuario")
    public String mostrarRegistroUsuario() {
        return "registroUsuario";
    }

    //Guarda el nuevo usuario en la BD
    @PostMapping("/registroUsuario")
    public String registroCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registroUsuario?exito";
    }

    //Inicio administrador
    @GetMapping("/administrador")
    public String verPaginaAdministrador() {
        return "administrador";
    }

    /*
    Ver Listado de Usuarios Autorizados, desde aqui se puede ir a editar usuarios y eliminarlos
     */
    @GetMapping("/mostrarUsuarios")
    public String verPaginaListaUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioServicio.listarUsuariosAutorizados());
        return "mostrarUsuarios";
    }

    //Muestra el formulario para actualizar los datos de un usuario
    @GetMapping("/editarUsuario/{idusuario}")
    public String mostrarActualizarUsuario(@PathVariable("idusuario") Integer idusuario, Model model) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        List<String> rolesDeUsuario = usuario.getRoles().stream()
                .map(Rol::getRol)
                .collect(Collectors.toList());
        model.addAttribute("usuario", usuario);
        model.addAttribute("rolesDeUsuario", rolesDeUsuario);
        return "editarUsuario";
    }

    //Efectua la actualizacion de datos de un usuario
    @PostMapping("/editarUsuario/{idusuario}")
    public String actualizarUsuario(@PathVariable("idusuario") Integer idusuario,
            @ModelAttribute("usuario") UsuarioRegistroDTO registroDTO,
            @RequestParam("roles") List<String> rolesSeleccionados) {

        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        // Actualiza los roles del usuario con los seleccionados
        List<Rol> nuevosRoles = new ArrayList<>();
        for (String rol : rolesSeleccionados) {
            Rol rolSeleccionado = rolRepository.findByRol(rol);
            if (rolSeleccionado != null) {
                nuevosRoles.add(rolSeleccionado);
            }
        }
        usuario.setRoles(nuevosRoles);
        usuarioServicio.actualizar(registroDTO);
        return "redirect:/mostrarUsuarios?usuarioActualizado";
    }

    //Elimina un usuario de la BD
    @GetMapping("/eliminarUsuario/{idusuario}")
    public String eliminarUsuario(@PathVariable("idusuario") Integer idusuario) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        if (usuario != null) {
            UsuarioRegistroDTO registroDTO = new UsuarioRegistroDTO();
            registroDTO.setMail(usuario.getMail());
            usuarioServicio.eliminar(registroDTO);
            return "redirect:/mostrarUsuarios?usuarioEliminado";
        }
        return "redirect:/mostrarUsuarios?error";
    }

    //Ver Listado de usuarios con SOLICITUDES PENDIENTES de alta
    @GetMapping("/solicitudesPendientes")
    public String verSolicitudesPendientes(Model model) {
        model.addAttribute("listaUsuarios", usuarioServicio.listarUsuariosPendientes());
        return "solicitudesPendientes";
    }

    //Muestra el formulario para Asignar un Rol a un usuario que este Pendiente.
    @GetMapping("/aceptarSolicitud/{idusuario}")
    public String mostrarAsignarRolUsuario(@PathVariable("idusuario") Integer idusuario, Model model) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        List<String> rolesDeUsuario = usuario.getRoles().stream()
                .map(Rol::getRol)
                .collect(Collectors.toList());
        model.addAttribute("usuario", usuario);
        model.addAttribute("rolesDeUsuario", rolesDeUsuario);
        return "aceptarSolicitud";
    }

    //Efectua la Asignacion de uno o varios Roles a un usuario que estaba pendiente.
    @PostMapping("/aceptarSolicitud/{idusuario}")
    public String asignarRolUsuario(@PathVariable("idusuario") Integer idusuario,
            @ModelAttribute("usuario") UsuarioRegistroDTO registroDTO,
            @RequestParam("roles") List<String> rolesSeleccionados) {

        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        // Actualiza los roles del usuario con los seleccionados
        List<Rol> nuevosRoles = new ArrayList<>();
        for (String rol : rolesSeleccionados) {
            Rol rolSeleccionado = rolRepository.findByRol(rol);
            if (rolSeleccionado != null) {
                nuevosRoles.add(rolSeleccionado);
            }
        }
        usuario.setRoles(nuevosRoles);
        usuarioServicio.actualizar(registroDTO);
        return "redirect:/solicitudesPendientes?exito";
    }

    //Elimina un usuario de la BD
    @GetMapping("/eliminarSolicitud/{idusuario}")
    public String eliminarSolicitud(@PathVariable("idusuario") Integer idusuario) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(idusuario);
        if (usuario != null) {
            UsuarioRegistroDTO registroDTO = new UsuarioRegistroDTO();
            registroDTO.setMail(usuario.getMail());
            usuarioServicio.eliminar(registroDTO);
            return "redirect:/solicitudesPendientes?solicitudEliminada";
        } else {
            return "redirect:/solicitudesPendientes?error";
        }
    }

    /////////////////////  AULAS    ///////////////////////
    //Muestra la ventana con el formulario de registrar un aula nueva
    @GetMapping("/registroAula")
    public String mostrarRegistroAula() {
        return "registroAula";
    }

    //Guarda un nuevo aula en la BD
    @PostMapping("/registroAula")
    public String registroAula(@ModelAttribute("aula") AulaRegistroDTO aulaRegistroDTO) {
        aulaServicio.guardar(aulaRegistroDTO);
        return "redirect:/mostrarAulas?registroAula";
    }

    /*
    Ver listado de Aulas, desde aqui se pueden modificar Aulas y eliminarlas
     */
    @GetMapping("/mostrarAulas")
    public String verPaginaListaAulas(Model model) {
        model.addAttribute("listaAulas", aulaServicio.listarAulas());
        return "mostrarAulas";
    }

    // Muestra el formulario para modificar un aula
    @GetMapping("/editarAula/{idaula}")
    public String mostrarActualizarAula(@PathVariable("idaula") String idaula, Model model) {
        Aula aula = aulaServicio.buscarAulaPorId(idaula);
        model.addAttribute("aula", aula);
        return "editarAula";
    }

    //Actualiza los datos de un aula en la BD
    @PostMapping("/editarAula/{idaula}")
    public String actualizarAula(@PathVariable("idaula") String idaula,
            @ModelAttribute("aula") AulaRegistroDTO registroDTO) {
        aulaServicio.actualizar(registroDTO);
        return "redirect:/mostrarAulas?aulaModificada";
    }

    //Elimina un aula de la BD
    @GetMapping("/eliminarAula/{idaula}")
    public String eliminarAula(@PathVariable("idaula") String idaula) {
        Aula aula = aulaServicio.buscarAulaPorId(idaula);
        if (aula != null) {
            AulaRegistroDTO registroDTO = new AulaRegistroDTO();
            registroDTO.setIdaula(aula.getIdaula());
            aulaServicio.eliminar(registroDTO);
            return "redirect:/mostrarAulas?aulaEliminada";
        } else {
            return "redirect:/mostarAulas?error";
        }
    }

    //Inicio coordinador
    @GetMapping("/coordinador")
    public String verPaginaCoordinador() {
        return "coordinador";
    }

    //Inicio profesor
    @GetMapping("/profesor")
    public String verPaginaProfesor() {
        return "profesor";
    }
}
