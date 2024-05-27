package com.eeae.Sverga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class CalendarioId implements Serializable {

    private Integer fk_reserva;
    private Date inicio;

    // Getters
    public Integer getFk_reserva() {
        return fk_reserva;
    }

    public Date getInicio() {
        return inicio;
    }

    // Setters
    public void setFk_reserva(Integer fk_reserva) {
        this.fk_reserva = fk_reserva;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarioId that = (CalendarioId) o;
        return Objects.equals(fk_reserva, that.fk_reserva) &&
               Objects.equals(inicio, that.inicio);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(fk_reserva, inicio);
    }
}
