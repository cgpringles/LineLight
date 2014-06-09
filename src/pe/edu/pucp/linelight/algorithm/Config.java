/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

/**
 *
 * @author Angel
 */
public class Config 
{
    /*Atributos*/
    public final static int T_PERIOD = 1;          // 1 segundo
    public final static int N_PERIOD = 120;         /* Numero de periodos por semaforo, osea cuantos genes poseera la interseccion en el cromosoma*/
    public final static int T_CYCLIC = T_PERIOD * N_PERIOD; // utilizado para obtener el tiempo de demora sobre el tiempo transcurrido
    
    public static final int lengthRouteMin = 5;
    public static final int lengthRouteMax = 50;
    
    public final static int mapX = 2400; /*dimension del mapa en X, se multiplicara por 100 para llegar a los 240 mil metros (240 km)*/
    public final static int mapY = 1600; /*dimension del mapa en Y, se multiplicara por 100 para llegar a los 160 mil metros (160 km)*/
    public final static int entreCallesX = 100; /*cada cuantos metros para calle en X*/
    public final static int entreCallesY = 100; /*cada cuantos metros para calle en Y*/
    
    public static int N_CROSS = 0; /*Número de interseccione donde en cada uno se ubicara un par de semaforos*/
    
    public static int size_oneGen = N_PERIOD; /**/
    public static int size_allGen = 0; /*Tamaño de genes*/
        
    public static int velocidadMax = 120; /*esto debería cambiar debido a que la velocidad es relativo a la vía*/
    public static int velocidadMin = 30;
    public static int velocidadPred = 60;
    
    public final static int tiempoVerdeMax = 90; /*dependera del N_PERIOD*/
    public final static int tiempoVerdeMin = 20;
    public final static int tiempoRojoMax = 50; /*dependera del N_PERIOD*/
    public final static int tiempoRojoMin = 10;
    public final static int defaultTime = 60; /*dependera del N_PERIOD*/
    
    public final static Double kmAms = 0.2777777777777778;
    public final static int factorPos = 10000000;
}
