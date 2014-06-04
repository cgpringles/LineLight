package pe.edu.pucp.linelight.model;
// Generated 03/06/2014 08:23:06 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tipovia generated by hbm2java
 */
public class Tipovia  implements java.io.Serializable {


     private Integer idTipoVia;
     private String descripcion;
     private Integer velocidadMaxima;
     private Set vias = new HashSet(0);

    public Tipovia() {
    }

    public Tipovia(String descripcion, Integer velocidadMaxima, Set vias) {
       this.descripcion = descripcion;
       this.velocidadMaxima = velocidadMaxima;
       this.vias = vias;
    }
   
    public Integer getIdTipoVia() {
        return this.idTipoVia;
    }
    
    public void setIdTipoVia(Integer idTipoVia) {
        this.idTipoVia = idTipoVia;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getVelocidadMaxima() {
        return this.velocidadMaxima;
    }
    
    public void setVelocidadMaxima(Integer velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    public Set getVias() {
        return this.vias;
    }
    
    public void setVias(Set vias) {
        this.vias = vias;
    }




}


