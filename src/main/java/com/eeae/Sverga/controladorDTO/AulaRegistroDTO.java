package com.eeae.Sverga.controladorDTO;

public class AulaRegistroDTO {
    
    private String idaula;
    private String edificio;
    private String nombre;
    private Integer capacidad;
    private Integer puestos;
    private String modulo;
    private Boolean zar;
    private Boolean rap;
    private Boolean red_ossorio;
    private Boolean wan_pg;
    private Boolean proyector;
    private Boolean pizarra_digital;
    private String extras;

    public AulaRegistroDTO() {
    }

    public AulaRegistroDTO(String idaula, String edificio, String nombre, 
            Integer capacidad, Integer puestos, String modulo, Boolean zar, 
            Boolean rap, Boolean red_ossorio, Boolean wan_pg, Boolean proyector, 
            Boolean pizarra_digital, String extras) {
        this.idaula = idaula;
        this.edificio = edificio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.puestos = puestos;
        this.modulo = modulo;
        this.zar = zar;
        this.rap = rap;
        this.red_ossorio = red_ossorio;
        this.wan_pg = wan_pg;
        this.proyector = proyector;
        this.pizarra_digital = pizarra_digital;
        this.extras = extras;
    }

    public AulaRegistroDTO(String edificio, String nombre, Integer capacidad, 
            Integer puestos, String modulo, Boolean zar, Boolean rap, Boolean 
                    red_ossorio, Boolean wan_pg, Boolean proyector, Boolean pizarra_digital, 
                    String extras) {
        this.edificio = edificio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.puestos = puestos;
        this.modulo = modulo;
        this.zar = zar;
        this.rap = rap;
        this.red_ossorio = red_ossorio;
        this.wan_pg = wan_pg;
        this.proyector = proyector;
        this.pizarra_digital = pizarra_digital;
        this.extras = extras;
    }

    public String getIdaula() {
        return idaula;
    }

    public void setIdaula(String idaula) {
        this.idaula = idaula;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Boolean getZar() {
        return zar;
    }

    public void setZar(Boolean zar) {
        this.zar = zar;
    }

    public Boolean getRap() {
        return rap;
    }

    public void setRap(Boolean rap) {
        this.rap = rap;
    }

    public Boolean getRed_ossorio() {
        return red_ossorio;
    }

    public void setRed_ossorio(Boolean red_ossorio) {
        this.red_ossorio = red_ossorio;
    }

    public Boolean getWan_pg() {
        return wan_pg;
    }

    public void setWan_pg(Boolean wan_pg) {
        this.wan_pg = wan_pg;
    }

    public Boolean getProyector() {
        return proyector;
    }

    public void setProyector(Boolean proyector) {
        this.proyector = proyector;
    }

    public Boolean getPizarra_digital() {
        return pizarra_digital;
    }

    public void setPizarra_digital(Boolean pizarra_digital) {
        this.pizarra_digital = pizarra_digital;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    
    
}
