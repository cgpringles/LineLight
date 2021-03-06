package pe.edu.pucp.linelight.model;
// Generated 12/06/2014 12:06:23 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tramo generated by hbm2java
 */
public class Tramo  implements java.io.Serializable {


     private TramoId id;
     private Via via;
     private Boolean estado;
     private Set tramoxnodos = new HashSet(0);
     private Set tramoxincidencias = new HashSet(0);

    public Tramo() {
    }

	
    public Tramo(TramoId id, Via via) {
        this.id = id;
        this.via = via;
    }
    public Tramo(TramoId id, Via via, Boolean estado, Set tramoxnodos, Set tramoxincidencias) {
       this.id = id;
       this.via = via;
       this.estado = estado;
       this.tramoxnodos = tramoxnodos;
       this.tramoxincidencias = tramoxincidencias;
    }
   
    public TramoId getId() {
        return this.id;
    }
    
    public void setId(TramoId id) {
        this.id = id;
    }
    public Via getVia() {
        return this.via;
    }
    
    public void setVia(Via via) {
        this.via = via;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getTramoxnodos() {
        return this.tramoxnodos;
    }
    
    public void setTramoxnodos(Set tramoxnodos) {
        this.tramoxnodos = tramoxnodos;
    }
    public Set getTramoxincidencias() {
        return this.tramoxincidencias;
    }
    
    public void setTramoxincidencias(Set tramoxincidencias) {
        this.tramoxincidencias = tramoxincidencias;
    }




}


