package com.eeae.Sverga.domain;

import javax.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva", nullable = false)
    private Integer idreserva;

    @Column(name = "fk_solicitante", nullable = false)
    private Integer fk_solicitante;

    @Column(name = "fk_autorizador", nullable = false)
    private Integer fk_autorizador;

    @Column(name = "fk_aula", length = 20)
    private String fk_aula;

    @Column(name = "num_alumnos")
    private Integer num_alumnos;

    @Column(name = "civil_militar")
    private Boolean civil_militar;

    @Column(name = "ejercito", length = 20)
    private String ejercito;

    @Column(name = "estado_reserva", length = 20)
    private String estado_reserva;

    @Column(name = "observaciones", length = 255)
    private String observaciones;

    public Reserva() {
    }

    public Reserva(Integer idReserva, Integer fkSolicitante, Integer fkAutorizador,
            String fkAula, Integer numAlumnos, Boolean civilMilitar,
            String ejercito, String estadoReserva, String observaciones) {
        this.idreserva = idReserva;
        this.fk_solicitante = fkSolicitante;
        this.fk_autorizador = fkAutorizador;
        this.fk_aula = fkAula;
        this.num_alumnos = numAlumnos;
        this.civil_militar = civilMilitar;
        this.ejercito = ejercito;
        this.estado_reserva = estadoReserva;
        this.observaciones = observaciones;
    }

    public Reserva(Integer fkSolicitante, Integer fkAutorizador, String fkAula,
            Integer numAlumnos, Boolean civilMilitar, String ejercito,
            String estadoReserva, String observaciones) {
        this.fk_solicitante = fkSolicitante;
        this.fk_autorizador = fkAutorizador;
        this.fk_aula = fkAula;
        this.num_alumnos = numAlumnos;
        this.civil_militar = civilMilitar;
        this.ejercito = ejercito;
        this.estado_reserva = estadoReserva;
        this.observaciones = observaciones;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getFk_solicitante() {
        return fk_solicitante;
    }

    public void setFk_solicitante(Integer fk_solicitante) {
        this.fk_solicitante = fk_solicitante;
    }

    public Integer getFk_autorizador() {
        return fk_autorizador;
    }

    public void setFk_autorizador(Integer fk_autorizador) {
        this.fk_autorizador = fk_autorizador;
    }

    public String getFk_aula() {
        return fk_aula;
    }

    public void setFk_aula(String fk_aula) {
        this.fk_aula = fk_aula;
    }

    public Integer getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(Integer num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    public Boolean getCivil_militar() {
        return civil_militar;
    }

    public void setCivil_militar(Boolean civil_militar) {
        this.civil_militar = civil_militar;
    }

    public String getEjercito() {
        return ejercito;
    }

    public void setEjercito(String ejercito) {
        this.ejercito = ejercito;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
