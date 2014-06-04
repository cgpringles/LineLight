/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

import java.io.Serializable;
import java.util.Random;
import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;
import pe.edu.pucp.linelight.structure.Node;

/**
 *
 * @author Angel
 */
public class Vehiculo implements Serializable
{
    /*Atributos*/
    private String placa;    
    private Ruta route;   
    private int velocidad = Config.velocidadPred;

    /*Constructor*/
    public Vehiculo(String placa, int velocidad, Ruta r)
    {
        this.placa = placa;
        this.velocidad = velocidad;
        route = r;
    }
    
    public Vehiculo(boolean generateRandom,int i_placa)
    {
        initialize(i_placa);
        route = new Ruta(generateRandom, i_placa);
        if(generateRandom)
        {           
            velocidad = new Random().nextInt(Config.velocidadMax - Config.velocidadMin) 
                                    + Config.velocidadMin;
        }
        else {
            // utilizado para migrar
            velocidad = new Random().nextInt(Config.velocidadMax - Config.velocidadMin) 
                                    + Config.velocidadMin; // deberia se cambiado por un valor tambien generado en Robot                    
        }
    }
    
    /*Métodos*/
    private void initialize(int i)
    {
        placa = "PER".concat(String.valueOf(i));
    }

    public int getVelocidad()
    {
        return velocidad;
    }

    public String getPlaca() 
    {
        return placa;
    }
  
    public Ruta getRoute() 
    {
        return route;
    }

}
