/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Trafico implements Serializable
{
    /*Atributos*/
    private Vehiculo[] vehiculos;
    private ArrayList<Individuo> mejoresResultados = new ArrayList<>();

    /*Constructor*/   
    public Trafico(int numeroVehiculos)
    {
        vehiculos = new Vehiculo[numeroVehiculos];
    }
    
    public Trafico(int numeroVehiculos, boolean addRandoms)
    {
        System.out.println("Input Data Generating ... ");
        vehiculos = new Vehiculo[numeroVehiculos];
        if(addRandoms) //se va a generar datos
        {   
            for (int i = 0; i < numeroVehiculos; i++)
            {
                final int x = i;
                agregarVehiculoRandom(x);
            }
        }
        else {
            // utilizado para migrar
            for (int i = 0; i < numeroVehiculos; i++)
            {
                final int x = i;
                agregarVehiculoGenerado(x);
            }            
        }
    }
    
    public Trafico(int numeroVehiculos, int tipo)
    {
        vehiculos = new Vehiculo[numeroVehiculos];
        if(tipo==1) //se va a importar un archivo de texto
        {
            System.out.println("Input Data Text Importing ... ");
        }
        else 
        {
            System.out.println("Input Data Serializable Importing ... ");        
        }    
    }
    
    /*Métodos*/
    private void agregarVehiculoRandom(int i) 
    {
        vehiculos[i] = new Vehiculo(true,i);
    }
    
    private void agregarVehiculoGenerado(int i) 
    {
        // utilizado para migrar
        vehiculos[i] = new Vehiculo(false,i);
    }
    
    public Vehiculo getVehiculo(int i)
    {
        return getVehiculos()[i];
    }

    public Vehiculo setVehiculo(int i, Vehiculo value)
    {
        return vehiculos[i] = value;
    }
    
    public Vehiculo[] getVehiculos() 
    {
        return vehiculos;
    }
    
    public void imprimirTrafico() 
    {
        for (int i=0; i<vehiculos.length; i++)
        {
            imprimirVehiculo(vehiculos[i]);
        }
    }
    
    public void imprimirVehiculo(Vehiculo value)
    {
        System.out.print("Placa: "+ value.getPlaca() +
                            "  Velocidad: " + value.getVelocidad() +
                            "  P.Inicio (" + value.getRoute().getPosIniX()+ "," + value.getRoute().getPosIniY() + ")" +
                            "  P.Fin (" + value.getRoute().getPosFinX()+ "," + value.getRoute().getPosFinY() + ")" +
                            "  P.Actual (" + value.getRoute().getActualPosX()+ "," + value.getRoute().getActualPosY() + ")" );
        imprimirRutaVehiculo(value.getRoute());
    }
    
    public void imprimirRutaVehiculo(Ruta value)
    {
        ArrayList<Integer> listaX = value.getPosX();
        ArrayList<Integer> listaY = value.getPosY();
        ArrayList<Long> listaNodo = value.getIdNodoRuta();
        System.out.print("  Ruta: [");
        for (int i=0; i<listaX.size() && i<listaY.size(); i++)
        {                
            System.out.print("("+listaX.get(i)+","+listaY.get(i)+","+ listaNodo.get(i) +") ");            
        }
        System.out.println("]");
    }
    
    public void exportarSerializableTrafico()
    {   
        System.out.println("File Traffic Serializable Exporting  ... ");
        try {
            FileOutputStream fos = new FileOutputStream("datosTraficoSerializado.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            oos.writeObject(GA.trafico);
            oos.close();
            fos.close();            
        } catch (IOException ex) {
            Logger.getLogger(GA.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void exportarTextoTrafico()
    {
        System.out.println("File Traffic Text Exporting  ... ");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("datosTraficoTexto.txt");
            pw = new PrintWriter(fichero);
            /*Escribir la cantidad de vehiculos generados*/
            pw.println(GA.trafico.vehiculos.length);
            /*Escribir los datos de cada vehículo: placa, velocidad, punto inicio, punto final, punto actual, ruta*/
            for (int i=0; i<GA.trafico.vehiculos.length; i++)
            {
                pw.print("Placa: " + GA.trafico.vehiculos[i].getPlaca() +
                        "  Velocidad: " + GA.trafico.vehiculos[i].getVelocidad() + " " +
                        "  P.Inicio (" + GA.trafico.vehiculos[i].getRoute().getPosIniX() + "," +  GA.trafico.vehiculos[i].getRoute().getPosIniY() + ")" +
                        "  P.Fin (" + GA.trafico.vehiculos[i].getRoute().getPosFinX()+ "," + GA.trafico.vehiculos[i].getRoute().getPosFinY() + ")" +
                        "  P.Actual (" + GA.trafico.vehiculos[i].getRoute().getActualPosX() + "," + GA.trafico.vehiculos[i].getRoute().getActualPosY() + ")" );
                
                pw.print("  Ruta: [");                               
                for (int j=0; j<GA.trafico.vehiculos[i].getRoute().getPosX().size() && 
                        j<GA.trafico.vehiculos[i].getRoute().getPosY().size(); j++)
                {                
                    pw.print("(" + GA.trafico.vehiculos[i].getRoute().getPosX().get(j) +","+ 
                            GA.trafico.vehiculos[i].getRoute().getPosY().get(j) + ") "); 
                }
                pw.println(" ]");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }        
    }    
    
    public void importarTextoTrafico()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;        
        try {
            archivo = new File("datosTraficoTexto.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            /*Leemos la cantidad de Vehiculos*/
            StringTokenizer linea = new StringTokenizer(br.readLine());
            int numeroVehiculos = Integer.parseInt(linea.nextToken());
            GA.trafico = new Trafico(numeroVehiculos,1); //importar archivo de texto            
            
            for (int i = 0; i < numeroVehiculos; i++)
            {
                linea = new StringTokenizer(br.readLine());
                final int x = i;
                agregarVehiculoRandom(x);
            }       
  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }        
    }
    
    public void importarSerializableTrafico()
    {
        System.out.println("File Traffic Serializable Importing  ... ");
        try {
            FileInputStream fis = new FileInputStream("datosTraficoSerializado.txt");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            Trafico tráfico = null;
            try {
                tráfico = (Trafico)ois.readObject();
                GA.trafico=tráfico;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Trafico.class.getName()).log(Level.SEVERE, null, ex);
            }
            ois.close();
            fis.close();            
        } catch (IOException ex) {
            Logger.getLogger(GA.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
            
    public void exportarTextoResultados(int tipo, int muestras,int tamPoblacionInicial, int tamMaxPoblacion,
            int maxCiclosSinCambiar, double tasaCasamiento, double tasaMutacion)
    {
        System.out.println("File Results Text Exporting  ... ");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("resultadosGeneticoTexto.txt");
            pw = new PrintWriter(fichero); 
            pw.print("Tipo de Ejecucion: ");
            switch (tipo) {
                case 1: pw.println("Por Tamaño Maximo de Población"); break;
                case 2: pw.println("Por Maximo Ciclos sin Cambiar"); break;
                case 3: pw.println("Por Tasa de Casamiento"); break;    
                case 4: pw.println("Por Tasa de Mutación"); break;
            }
            pw.println("Numero de Muestras:        " + muestras);
            pw.println("Tamanio Poblacion Inicial: " + tamPoblacionInicial);
            pw.println("Tamanio Maximo Poblacion:  " + tamMaxPoblacion);
            pw.println("Maximo ciclos sin cambiar: " + maxCiclosSinCambiar);
            pw.println("Tasa de casamiento:        " + tasaCasamiento);
            pw.println("Tasa de mutacion:          " + tasaMutacion);
            
            for (int i=0; i<muestras; i++) {
                System.out.println("Ejecución " + i);
                long time_start, time_end;
                time_start = System.currentTimeMillis();
                
                GA.trafico.ejecutarAlgoritmo(tamPoblacionInicial,tamMaxPoblacion,
                        maxCiclosSinCambiar, tasaCasamiento, tasaMutacion);
                Individuo individuo = mejoresResultados.get(i);
                /*Escribir la cantidad de vehiculos generados*/
                pw.print("Velocidad Optima:   " + individuo.getVelocidadPromedio());
                
                time_end = System.currentTimeMillis();
                pw.println("  Tiempo de Ejecucion:    "+ ( time_end - time_start ) +" milliseconds");
            }
            /*Escribir la cantidad de vehiculos generados*/
            
            /*Escribir los datos de cada vehículo: placa, velocidad, punto inicio, punto final, punto actual, ruta*/            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }        
    }    
        
    public void ejecutarAlgoritmo(int tamPoblacionInicial, int tamMaxPoblacion,
            int maxCiclosSinCambiar, double tasaCasamiento, double tasaMutacion)
    {        
        //Colocamos los parametros de ejecucion
        Algoritmo.setParametros(tamMaxPoblacion, maxCiclosSinCambiar, 
                tasaCasamiento, tasaMutacion);
        
        //Crear la población inicial
        Poblacion iniPob = new Poblacion(tamPoblacionInicial, true);                 
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        int last_fittest = 0;
        int ciclosSinCambiar = 0;
        System.out.println("Genetic Algorithm Executing ... ");
        while (ciclosSinCambiar < maxCiclosSinCambiar ) { 
            //se tomará una mezeta de hasta 4 valores repetidos para detener la ejecucion
            long time_start, time_end;
            time_start = System.currentTimeMillis();            
            
//            System.out.println("Población " + generationCount);
            int fittest = iniPob.getFittest().getFitness();
            float velocidad = iniPob.getFittest().getVelocidadPromedio();
            if(fittest == last_fittest)
            {
                ciclosSinCambiar++;
            }
//            else
//            {
//                ciclosSinCambiar = 0;
//            }
            last_fittest = fittest;
            
            System.out.println("Generación: " + generationCount + " Fittest: " + fittest + " seg " +
                    " Velocidad Promedio: " + velocidad + " km/h " );
//            System.out.println();
//            System.out.println();
            iniPob = Algoritmo.evolucionarPoblación(iniPob);
            generationCount++;
            
            ////////
            time_end = System.currentTimeMillis();
            System.out.println("the executing task has taken "+ ( time_end - time_start ) +" milliseconds");
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        
        Individuo individuo = iniPob.getFittest();
        
        GA.velocidad = individuo.getVelocidadPromedio();
        GA.tiempoEjecucion = individuo.getFitness();
        GA.mejorIndividuo = individuo;

        iniPob.getFittest().imprimirTiempoSemaforos();
        iniPob.getFittest().imprimirAllGen();
    }
    
}