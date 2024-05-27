package com.eeae.Sverga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eeae.Sverga.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByMail(String mail);

    public Usuario findByIdusuario(Integer id);
}
