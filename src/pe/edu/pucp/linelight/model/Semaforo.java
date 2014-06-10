package pe.edu.pucp.linelight.model;
// Generated 04/06/2014 09:38:07 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Semaforo generated by hbm2java
 */
public class Semaforo  implements java.io.Serializable {


     private SemaforoId id;
     private Nodo nodo;
     private Integer tverde;
     private Boolean estado;
     private Integer trojo;
     private String descripcion;
     private Integer tipo;
     private String via1;
     private String via2;
     private String distrito;
     private Set ejecucionalgoritmoxsemaforos = new HashSet(0);
     public static boolean ROJO=false;
     public static boolean VERDE=true;

    public Semaforo() {
    }

	
    public Semaforo(SemaforoId id, Nodo nodo) {
        this.id = id;
        this.nodo = nodo;
    }
    public Semaforo(SemaforoId id, Nodo nodo, Integer tverde, Boolean estado, Integer trojo, String descripcion, Integer tipo, String via1, String via2, String distrito, Set ejecucionalgoritmoxsemaforos) {
       this.id = id;
       this.nodo = nodo;
       this.tverde = tverde;
       this.estado = estado;
       this.trojo = trojo;
       this.descripcion = descripcion;
       this.tipo = tipo;
       this.via1 = via1;
       this.via2 = via2;
       this.distrito = distrito;
       this.ejecucionalgoritmoxsemaforos = ejecucionalgoritmoxsemaforos;
    }
   
    public SemaforoId getId() {
        return this.id;
    }
    
    public void setId(SemaforoId id) {
        this.id = id;
    }
    public Nodo getNodo() {
        return this.nodo;
    }
    
    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
    public Integer getTverde() {
        return this.tverde;
    }
    
    public void setTverde(Integer tverde) {
        this.tverde = tverde;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Integer getTrojo() {
        return this.trojo;
    }
    
    public void setTrojo(Integer trojo) {
        this.trojo = trojo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public String getVia1() {
        return this.via1;
    }
    
    public void setVia1(String via1) {
        this.via1 = via1;
    }
    public String getVia2() {
        return this.via2;
    }
    
    public void setVia2(String via2) {
        this.via2 = via2;
    }
    public String getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public Set getEjecucionalgoritmoxsemaforos() {
        return this.ejecucionalgoritmoxsemaforos;
    }
    
    public void setEjecucionalgoritmoxsemaforos(Set ejecucionalgoritmoxsemaforos) {
        this.ejecucionalgoritmoxsemaforos = ejecucionalgoritmoxsemaforos;
    }




}


