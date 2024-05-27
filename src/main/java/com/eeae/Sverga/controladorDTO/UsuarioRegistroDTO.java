package com.eeae.Sverga.controladorDTO;

public class UsuarioRegistroDTO {

    private Integer idusuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String empleo;
    private String mail;
    private String telefono;
    private String departamento;
    private String clave;


    public UsuarioRegistroDTO() {
    }

    public UsuarioRegistroDTO(Integer idusuario, String nombre, String apellido1,
            String apellido2, String empleo, String mail, String telefono,
            String departamento, String clave) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.empleo = empleo;
        this.mail = mail;
        this.telefono = telefono;
        this.departamento = departamento;
        this.clave = clave;
    }

    public UsuarioRegistroDTO(String nombre, String apellido1, String apellido2,
            String empleo, String mail, String telefono, String departamento,
            String clave) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.empleo = empleo;
        this.mail = mail;
        this.telefono = telefono;
        this.departamento = departamento;
        this.clave = clave;
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
}
