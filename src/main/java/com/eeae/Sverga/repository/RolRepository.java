package com.eeae.Sverga.repository;

import com.eeae.Sverga.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, String> {
    Rol findByRol(String rol);
}