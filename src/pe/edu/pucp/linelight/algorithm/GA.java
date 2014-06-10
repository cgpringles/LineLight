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
public class GA {

    public static Trafico trafico;
    public static float velocidad;
    public static int tiempoEjecucion;
    public static float velocidadHistorica;
    
    public static void main(String[] args) {

//        /*Generacion de los Datos del Mapa*/
//        trafico = new Trafico(2000,true);
//        trafico.imprimirTrafico();
//        /*Exportar Datos generados en un archivo*/        
//        trafico.exportarSerializableTrafico();
//        trafico.exportarTextoTrafico();
        
        /*Mapa: Se esta considerando una cuadricula como mapa de modo que se sabe
         por simple operaciones las ubicaciones de las vias*/
        /*Vehiculos: Se ha generado un conjunto de datos de los vehiculos en circulacion
         a partir del mapa mencionado*/
                
        trafico = new Trafico(2000);
        trafico.importarSerializableTrafico();
        trafico.imprimirTrafico();
        trafico.ejecutarAlgoritmo(10, 10, 50, 0.85, 0.1);
        
//        trafico.exportarTextoResultados(1,10,100,1000,500,0.5,0.1);        
//        genético.importarSerializableTrafico();
//        /*Exportar Resultados del algoritmo Genetico*/
//        /*tipo - muestras - tamPoblacionInicial - tamMaxPoblacion - maxCiclosSinCambiar - tasaCasamiento - tasaMutacion)*/
//        trafico.exportarTextoResultados(1,10,100,1000,500,0.5,0.1);
    }
}