package pe.edu.pucp.linelight.model;
// Generated 03/06/2014 08:23:06 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Nodo generated by hbm2java
 */
public class Nodo  implements java.io.Serializable {


     private long idNodo;
     private Double latitud;
     private Double longitud;
     private Set vehiculoxnodos = new HashSet(0);
     private Set tramoxnodos = new HashSet(0);
     private Set semaforos = new HashSet(0);

    public Nodo() {
    }

	
    public Nodo(long idNodo) {
        this.idNodo = idNodo;
    }
    public Nodo(long idNodo, Double latitud, Double longitud, Set vehiculoxnodos, Set tramoxnodos, Set semaforos) {
       this.idNodo = idNodo;
       this.latitud = latitud;
       this.longitud = longitud;
       this.vehiculoxnodos = vehiculoxnodos;
       this.tramoxnodos = tramoxnodos;
       this.semaforos = semaforos;
    }
   
    public long getIdNodo() {
        return this.idNodo;
    }
    
    public void setIdNodo(long idNodo) {
        this.idNodo = idNodo;
    }
    public Double getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public Set getVehiculoxnodos() {
        return this.vehiculoxnodos;
    }
    
    public void setVehiculoxnodos(Set vehiculoxnodos) {
        this.vehiculoxnodos = vehiculoxnodos;
    }
    public Set getTramoxnodos() {
        return this.tramoxnodos;
    }
    
    public void setTramoxnodos(Set tramoxnodos) {
        this.tramoxnodos = tramoxnodos;
    }
    public Set getSemaforos() {
        return this.semaforos;
    }
    
    public void setSemaforos(Set semaforos) {
        this.semaforos = semaforos;
    }




}


