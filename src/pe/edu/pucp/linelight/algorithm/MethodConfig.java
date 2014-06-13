/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.algorithm;

import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;

/**
 *
 * @author Angel
 */
public class MethodConfig {
    
    public static void setSizeAllGen()
    {
        if(Config.N_CROSS == 0)
        {
            int numInt = 0;
            
            int tamano = EjecucionAlgoritmoController.semaforosMapa.size();
            for (int i=0; i<tamano; i++){
                if (EjecucionAlgoritmoController.semaforosMapa.get(i).getEstado() == true) {
                    numInt++; // si hay uno desabilitado estado (false 0) su espejo tambien debera estar deshabilitado
                }                
            }
            
//            Vehiculo [] vehiculos = GA.trafico.getVehiculos();
//            for (int i=0; i<vehiculos.length  ;i++){
//                numInt += vehiculos[i].getRoute().getPosX().size();
//            }
                        
            Config.N_CROSS = tamano/2; //numero de intersecciones en el mapa, que poseen 2 semaforos
            Config.size_allGen = Config.N_PERIOD * Config.N_CROSS;
            System.out.println("Cantidad de Intersecciones : " +  Config.N_CROSS + "  Semaforos : " + tamano);
        }
        
//        if(Config.N_CROSS == 0)
//        {
//            int x = Config.mapX, y = Config.mapY;
//            Config.N_CROSS = ((x/Config.entreCallesX)+1)*((y/Config.entreCallesY)+1); /*numero de cruces o intersecciones*/
//            Config.size_allGen = Config.N_PERIOD * Config.N_CROSS; /*periodo o tiempo de ejecucion por la cantidad de intersecciones*/
//        }        
    }
    
    public static int getSizeAllGen()
    {
        return Config.size_allGen;
    }
    
    
}
