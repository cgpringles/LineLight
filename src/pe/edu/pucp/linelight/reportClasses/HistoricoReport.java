/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.reportClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rzuniga
 */
public class HistoricoReport {
    String simulacion;
    List<vehiculo_r> vehiculos = new ArrayList<>();

    public HistoricoReport() {
    }

    public String getSimulacion() {
        return simulacion;
    }

    public void setSimulacion(String simulacion) {
        this.simulacion = simulacion;
    }

    public List<vehiculo_r> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<vehiculo_r> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
}
