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
 * @author Charito
 */
public class SemaforosReport {
    List <Semaforo_aux> semaforos= new ArrayList<>();
    String simulacion;
    String dia;
    String hora;

    public List<Semaforo_aux> getSemaforos() {
        return semaforos;
    }

    public void setSemaforos(List<Semaforo_aux> semaforos) {
        this.semaforos = semaforos;
    }

    public String getSimulacion() {
        return simulacion;
    }

    public void setSimulacion(String simulacion) {
        this.simulacion = simulacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public SemaforosReport() {
    }
    
    
    
    
}
