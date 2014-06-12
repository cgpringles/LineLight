package pe.edu.pucp.linelight.model;
// Generated 12/06/2014 12:06:23 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Distrito generated by hbm2java
 */
public class Distrito  implements java.io.Serializable {


     private Integer idDistrito;
     private String nombre;
     private Date fecRegistro;
     private byte[] activo;
     private Set vias = new HashSet(0);
     private Set semaforos = new HashSet(0);
     private Set distritoxhorarios = new HashSet(0);
     private Set zonas = new HashSet(0);

    public Distrito() {
    }

	
    public Distrito(byte[] activo) {
        this.activo = activo;
    }
    public Distrito(String nombre, Date fecRegistro, byte[] activo, Set vias, Set semaforos, Set distritoxhorarios, Set zonas) {
       this.nombre = nombre;
       this.fecRegistro = fecRegistro;
       this.activo = activo;
       this.vias = vias;
       this.semaforos = semaforos;
       this.distritoxhorarios = distritoxhorarios;
       this.zonas = zonas;
    }
   
    public Integer getIdDistrito() {
        return this.idDistrito;
    }
    
    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecRegistro() {
        return this.fecRegistro;
    }
    
    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }
    public byte[] getActivo() {
        return this.activo;
    }
    
    public void setActivo(byte[] activo) {
        this.activo = activo;
    }
    public Set getVias() {
        return this.vias;
    }
    
    public void setVias(Set vias) {
        this.vias = vias;
    }
    public Set getSemaforos() {
        return this.semaforos;
    }
    
    public void setSemaforos(Set semaforos) {
        this.semaforos = semaforos;
    }
    public Set getDistritoxhorarios() {
        return this.distritoxhorarios;
    }
    
    public void setDistritoxhorarios(Set distritoxhorarios) {
        this.distritoxhorarios = distritoxhorarios;
    }
    public Set getZonas() {
        return this.zonas;
    }
    
    public void setZonas(Set zonas) {
        this.zonas = zonas;
    }




}


