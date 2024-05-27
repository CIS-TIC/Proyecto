package com.eeae.Sverga.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calendario")
@IdClass(CalendarioId.class)
public class Calendario {

    @Id
    @Column(name = "fk_reserva", nullable = false)
    private Integer fk_reserva;

    @Id
    @Column(name = "inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;

    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "num_hora", length = 20)
    private String num_hora;

    @ManyToOne
    @JoinColumn(name = "fk_reserva", referencedColumnName = "idreserva", insertable = false, updatable = false)
    private Reserva reserva;

    public Integer getFk_reserva() {
        return fk_reserva;
    }

    public void setFk_reserva(Integer fk_reserva) {
        this.fk_reserva = fk_reserva;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNum_hora() {
        return num_hora;
    }

    public void setNum_hora(String num_hora) {
        this.num_hora = num_hora;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}

