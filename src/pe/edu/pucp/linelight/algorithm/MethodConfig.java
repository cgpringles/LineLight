/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.algorithm;

/**
 *
 * @author Angel
 */
public class MethodConfig {
    
    public static void setSizeAllGen()
    {
        if (Config.N_CROSS==0) {
            
            Config.N_CROSS = 20; //numero de intersecciones en el mapa, que poseen 2 semaforos
            Config.size_allGen = Config.N_PERIOD * Config.N_CROSS;            
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
