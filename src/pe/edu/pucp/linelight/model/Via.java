package pe.edu.pucp.linelight.model;
// Generated 04/06/2014 09:38:07 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Via generated by hbm2java
 */
public class Via  implements java.io.Serializable {


     private ViaId id;
     private Tipovia tipovia;
     private Distrito distrito;
     private String nombre;
     private String descripcion;
     private Integer velocidad;
     private Set viaxhorarios = new HashSet(0);
     private Set tramos = new HashSet(0);

    public Via() {
    }

	
    public Via(ViaId id, Distrito distrito) {
        this.id = id;
        this.distrito = distrito;
    }
    public Via(ViaId id, Tipovia tipovia, Distrito distrito, String nombre, String descripcion, Integer velocidad, Set viaxhorarios, Set tramos) {
       this.id = id;
       this.tipovia = tipovia;
       this.distrito = distrito;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.velocidad = velocidad;
       this.viaxhorarios = viaxhorarios;
       this.tramos = tramos;
    }
   
    public ViaId getId() {
        return this.id;
    }
    
    public void setId(ViaId id) {
        this.id = id;
    }
    public Tipovia getTipovia() {
        return this.tipovia;
    }
    
    public void setTipovia(Tipovia tipovia) {
        this.tipovia = tipovia;
    }
    public Distrito getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getVelocidad() {
        return this.velocidad;
    }
    
    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }
    public Set getViaxhorarios() {
        return this.viaxhorarios;
    }
    
    public void setViaxhorarios(Set viaxhorarios) {
        this.viaxhorarios = viaxhorarios;
    }
    public Set getTramos() {
        return this.tramos;
    }
    
    public void setTramos(Set tramos) {
        this.tramos = tramos;
    }




}


