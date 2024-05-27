package com.eeae.Sverga.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

    public Rol() {
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}