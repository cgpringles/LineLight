package pe.edu.pucp.linelight.model;
// Generated 03/06/2014 08:23:06 PM by Hibernate Tools 3.6.0



/**
 * Vehiculoxnodo generated by hbm2java
 */
public class Vehiculoxnodo  implements java.io.Serializable {


     private VehiculoxnodoId id;
     private Vehiculo vehiculo;
     private Nodo nodo;
     private String test;

    public Vehiculoxnodo() {
    }

	
    public Vehiculoxnodo(VehiculoxnodoId id, Vehiculo vehiculo, Nodo nodo) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.nodo = nodo;
    }
    public Vehiculoxnodo(VehiculoxnodoId id, Vehiculo vehiculo, Nodo nodo, String test) {
       this.id = id;
       this.vehiculo = vehiculo;
       this.nodo = nodo;
       this.test = test;
    }
   
    public VehiculoxnodoId getId() {
        return this.id;
    }
    
    public void setId(VehiculoxnodoId id) {
        this.id = id;
    }
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Nodo getNodo() {
        return this.nodo;
    }
    
    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
    public String getTest() {
        return this.test;
    }
    
    public void setTest(String test) {
        this.test = test;
    }




}


