package com.eeae.Sverga.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 20)
    private String apellido1;

    @Column(name = "apellido2", nullable = false, length = 20)
    private String apellido2;

    @Column(name = "empleo", length = 20)
    private String empleo;

    @Column(name = "mail", length = 45)
    private String mail;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "departamento", length = 20)
    private String departamento;

    @Column(name = "clave", length = 255)
    private String clave;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = @JoinColumn(name = "idusuario", referencedColumnName = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "rol", referencedColumnName = "rol")
    )
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre, String apellido1, String apellido2,
            String empleo, String mail, String telefono, String departamento,
            String clave, List<Rol> roles) {
        this.idusuario = id_usuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.empleo = empleo;
        this.mail = mail;
        this.telefono = telefono;
        this.departamento = departamento;
        this.clave = clave;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellido1, String apellido2, String empleo,
            String mail, String telefono, String departamento, String clave,
            List<Rol> roles) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.empleo = empleo;
        this.mail = mail;
        this.telefono = telefono;
        this.departamento = departamento;
        this.clave = clave;
        this.roles = roles;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}