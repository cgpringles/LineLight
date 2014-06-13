/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.reportClasses;

/**
 *
 * @author Charito
 */
public class Semaforo_aux {
    String id_semaforo;
    String id_nodo;
    String t_verde;
    String t_rojo;
    String estado;

    public String getId_semaforo() {
        return id_semaforo;
    }

    public void setId_semaforo(String id_semaforo) {
        this.id_semaforo = id_semaforo;
    }

    public String getId_nodo() {
        return id_nodo;
    }

    public void setId_nodo(String id_nodo) {
        this.id_nodo = id_nodo;
    }

    public String getT_verde() {
        return t_verde;
    }

    public void setT_verde(String t_verde) {
        this.t_verde = t_verde;
    }

    public String getT_rojo() {
        return t_rojo;
    }

    public void setT_rojo(String t_rojo) {
        this.t_rojo = t_rojo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Semaforo_aux() {
    }
    
    
}
