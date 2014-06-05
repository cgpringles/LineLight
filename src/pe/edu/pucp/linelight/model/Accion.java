package pe.edu.pucp.linelight.model;
// Generated 04/06/2014 09:38:07 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Accion generated by hbm2java
 */
public class Accion  implements java.io.Serializable {


     private Integer idAccion;
     private String descripcion;
     private Boolean estado;
     private Set usuarioxaccions = new HashSet(0);

    public Accion() {
    }

    public Accion(String descripcion, Boolean estado, Set usuarioxaccions) {
       this.descripcion = descripcion;
       this.estado = estado;
       this.usuarioxaccions = usuarioxaccions;
    }
   
    public Integer getIdAccion() {
        return this.idAccion;
    }
    
    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getUsuarioxaccions() {
        return this.usuarioxaccions;
    }
    
    public void setUsuarioxaccions(Set usuarioxaccions) {
        this.usuarioxaccions = usuarioxaccions;
    }




}


