package pe.edu.pucp.linelight.model;
// Generated 12/06/2014 12:06:23 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Vehiculo generated by hbm2java
 */
public class Vehiculo  implements java.io.Serializable {


     private VehiculoId id;
     private Ejecucionalgoritmo ejecucionalgoritmo;
     private String posInit;
     private String posFin;
     private String posActual;
     private String velocidad;
     private Set vehiculoxnodos = new HashSet(0);

    public Vehiculo() {
    }

	
    public Vehiculo(VehiculoId id, Ejecucionalgoritmo ejecucionalgoritmo) {
        this.id = id;
        this.ejecucionalgoritmo = ejecucionalgoritmo;
    }
    public Vehiculo(VehiculoId id, Ejecucionalgoritmo ejecucionalgoritmo, String posInit, String posFin, String posActual, String velocidad, Set vehiculoxnodos) {
       this.id = id;
       this.ejecucionalgoritmo = ejecucionalgoritmo;
       this.posInit = posInit;
       this.posFin = posFin;
       this.posActual = posActual;
       this.velocidad = velocidad;
       this.vehiculoxnodos = vehiculoxnodos;
    }
   
    public VehiculoId getId() {
        return this.id;
    }
    
    public void setId(VehiculoId id) {
        this.id = id;
    }
    public Ejecucionalgoritmo getEjecucionalgoritmo() {
        return this.ejecucionalgoritmo;
    }
    
    public void setEjecucionalgoritmo(Ejecucionalgoritmo ejecucionalgoritmo) {
        this.ejecucionalgoritmo = ejecucionalgoritmo;
    }
    public String getPosInit() {
        return this.posInit;
    }
    
    public void setPosInit(String posInit) {
        this.posInit = posInit;
    }
    public String getPosFin() {
        return this.posFin;
    }
    
    public void setPosFin(String posFin) {
        this.posFin = posFin;
    }
    public String getPosActual() {
        return this.posActual;
    }
    
    public void setPosActual(String posActual) {
        this.posActual = posActual;
    }
    public String getVelocidad() {
        return this.velocidad;
    }
    
    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    public Set getVehiculoxnodos() {
        return this.vehiculoxnodos;
    }
    
    public void setVehiculoxnodos(Set vehiculoxnodos) {
        this.vehiculoxnodos = vehiculoxnodos;
    }




}


