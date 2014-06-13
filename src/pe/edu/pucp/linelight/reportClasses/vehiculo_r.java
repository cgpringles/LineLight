/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.reportClasses;

import java.util.List;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Vehiculoxnodo;

/**
 *
 * @author rzuniga
 */
public class vehiculo_r {
    int id;
    String posini;
    String posfin;
    String posactual;
    String velocidad;
    List<Vehiculoxnodo> nodos;

    public vehiculo_r() {
    }

    public int getId() {
        return id;
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosini() {
        return posini;
    }

    public void setPosini(String posini) {
        this.posini = posini;
    }

    public String getPosfin() {
        return posfin;
    }

    public void setPosfin(String posfin) {
        this.posfin = posfin;
    }

    public String getPosactual() {
        return posactual;
    }

    public void setPosactual(String posactual) {
        this.posactual = posactual;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public List<Vehiculoxnodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Vehiculoxnodo> nodos) {
        this.nodos = nodos;
    }
    
    
}
