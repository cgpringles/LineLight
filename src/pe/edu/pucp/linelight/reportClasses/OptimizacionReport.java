/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.reportClasses;

import java.util.List;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;

/**
 *
 * @author rzuniga
 */
public class OptimizacionReport {
    List<Ejecucionalgoritmo> simulaciones;

    public OptimizacionReport() {
    }

    public List<Ejecucionalgoritmo> getSimulaciones() {
        return simulaciones;
    }

    public void setSimulaciones(List<Ejecucionalgoritmo> simulaciones) {
        this.simulaciones = simulaciones;
    }
    
    
    
}
