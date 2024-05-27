package com.eeae.Sverga.servicio;

import com.eeae.Sverga.controladorDTO.UsuarioRegistroDTO;
import com.eeae.Sverga.domain.Rol;
import com.eeae.Sverga.domain.Usuario;
import com.eeae.Sverga.repository.RolRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.eeae.Sverga.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository; // Añade el repositorio de listaRoles
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Constructor
    public UsuarioServicioImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) { // Inyecta el repositorio de listaRoles
        super();
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository; // Asigna el repositorio de listaRoles
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        List<Rol> listaRoles = new ArrayList<>();
        Rol rolPendiente = rolRepository.findByRol("ROLE_PENDIENTE"); // Busca el rol "Pendiente" en la base de datos
        if (rolPendiente != null) {
            listaRoles.add(rolPendiente); // Añade el rol a la lista de listaRoles del usuario
        }

        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido1(),
                registroDTO.getApellido2(), registroDTO.getEmpleo(), registroDTO.getMail(),
                registroDTO.getTelefono(), registroDTO.getDepartamento(),
                passwordEncoder.encode(registroDTO.getClave()), listaRoles);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByMail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña incorrectos");
        }
        return new User(usuario.getMail(), usuario.getClave(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(List<Rol> ListaRoles) {
        return ListaRoles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> listarUsuariosPendientes() {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario.getRoles().stream()
                .map(Rol::getRol)
                .anyMatch(rol -> rol.equals("ROLE_PENDIENTE")))
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuariosAutorizados() {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario.getRoles().stream()
                .noneMatch(rol -> rol.getRol().equals("ROLE_PENDIENTE")))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = usuarioRepository.findByMail(registroDTO.getMail());
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public Usuario buscarUsuarioPorMail(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = usuarioRepository.findByMail(registroDTO.getMail());
        if (usuario != null) {
            return usuario;
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idusuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idusuario);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public Usuario actualizar(UsuarioRegistroDTO registroDTO) {
        Usuario usuarioExistente = usuarioRepository.findByMail(registroDTO.getMail());
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(registroDTO.getNombre());
            usuarioExistente.setApellido1(registroDTO.getApellido1());
            usuarioExistente.setApellido2(registroDTO.getApellido2());
            usuarioExistente.setEmpleo(registroDTO.getEmpleo());
            usuarioExistente.setTelefono(registroDTO.getTelefono());
            usuarioExistente.setDepartamento(registroDTO.getDepartamento());

            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
