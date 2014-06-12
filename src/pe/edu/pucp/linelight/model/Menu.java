package pe.edu.pucp.linelight.model;
// Generated 11/06/2014 07:24:50 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Menu generated by hbm2java
 */
public class Menu  implements java.io.Serializable {


     private Integer idMenu;
     private String descripcion;
     private Boolean estado;
     private Set perfils = new HashSet(0);

    public Menu() {
    }

    public Menu(String descripcion, Boolean estado, Set perfils) {
       this.descripcion = descripcion;
       this.estado = estado;
       this.perfils = perfils;
    }
   
    public Integer getIdMenu() {
        return this.idMenu;
    }
    
    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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
    public Set getPerfils() {
        return this.perfils;
    }
    
    public void setPerfils(Set perfils) {
        this.perfils = perfils;
    }




}


