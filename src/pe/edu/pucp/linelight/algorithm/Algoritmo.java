/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Angel
 */
public class Algoritmo {

    /* Atributos */
    private static int maxPopulation;    
    private static double crossoverRate;
    private static double mutationRate;
    private static int maxCiclesNoChanges;
    private static final boolean elitismo = true;    
    
    /* Métodos */
    public static void setParametros(int tamMaxPoblacion, int maxCiclosSinCambiar,
            double tasaCasamiento, double tasaMutacion)
    {
        maxPopulation = tamMaxPoblacion;
        maxCiclesNoChanges = maxCiclosSinCambiar;
        crossoverRate = tasaCasamiento;
        mutationRate = tasaMutacion;
    }
    
    // Evolve a population
    public static Poblacion evolucionarPoblación(Poblacion pop) 
    {        
        int numSelecciones, numCasamientos;
        ArrayList<Individuo> listaHijos=new ArrayList<>();
        ArrayList<Individuo> listaPadres=new ArrayList<>();
        Individuo individuo, padre1, padre2;
        
        int tamañoPoblación = pop.size();
        Poblacion newPopulation = new Poblacion(tamañoPoblación, false); 
        
        numCasamientos = (int) (pop.size() * crossoverRate) / 2; // se divide debido a que la cantidad de padres sacados por removeAleatorio pueden ser nulos al no encontrar mas
        
        /*Aplicamos el casamiento utilizando la tasa de casamiento*/
        for (int j = 0; j < numCasamientos; j++) {
            // Probabilidad de seleccion proporcional a la funcion fitness
            padre1 = removerAleatorio(pop);
            listaPadres.add(padre1);
            padre2 = removerAleatorio(pop);
            listaPadres.add(padre2);
            
            Individuo hijo1 = cruzamiento(padre1,padre2); //hay que controlar en el cruzamiento que el padre puede ser null
            listaHijos.add(hijo1);
            Individuo hijo2 = cruzamiento(padre2,padre1);
            listaHijos.add(hijo2);     
        }
        
        /*Aplicamos la mutacion utilizando la tasa de mutacion*/
        for (int i = 0; i < listaHijos.size(); i++) {
            // Mutar a los individuos con cierta probabilidad
            mutate(listaHijos.get(i));
            // FIX: arreglar los individuos con valores repetidos
            //AlgoritmoArreglo(listaHijos.get(i));
        }
        
        // Volver a agregar (colocar su estado en 1 para que puedan ser tomados) a los padres a la poblacion
        for (int j = 0; j < pop.size(); j++) {
//            pop.setEstado(j,1);
            individuo = pop.getIndividual(j);
            individuo.setEstado(1);
            pop.setTotalFitness(1, individuo.getFitness());
        }
        
        // Si hay elitismo se mantiene el mejor
        if (elitismo) // se selecciona el mejor individuo de la poblacion inicial para asegurar buenos resultados en la siguiente generacion
        {
            Individuo elMejor = pop.getFittest();
            newPopulation.reemplazarIndividual(0, elMejor);
        }
        
        int elitismoOffset = elitismo?1:0; /*Para ya no tomar el individuo que ya fue elegido por elitismo*/ 
                
        // 3.5 CONTROL DE ABERRACIONES eliminar los individuos repetidos
        for (int j = 0; j < listaHijos.size(); j++) {
            individuo = listaHijos.get(j);            
            if (controlDeAberraciones(individuo, pop) != null) { // aca se iran guardando los hijos que no se repitan
//                System.out.println("Entra al control de aberraciones");
                if (elitismoOffset < tamañoPoblación)
                {
//                    System.out.println("Se van agregando");
                    newPopulation.reemplazarIndividual(elitismoOffset,individuo);
                    elitismoOffset++;
                }
                else break;               
            }
        }
        
        if (pop.size() < maxPopulation)   
        {
            numSelecciones = pop.size();
        } else {
            numSelecciones = maxPopulation;
        }
        
        for (int i = elitismoOffset ; i < numSelecciones; i++) {
            individuo = removerAleatorio(pop); //se asume que los padre generadores no son repetidos
            newPopulation.reemplazarIndividual(i,individuo);            
        }     
        
        return newPopulation;                
    }

    // Crossover individuals
    private static Individuo cruzamiento(Individuo indiv1, Individuo indiv2) //casamiento o crossover
    {
        Individuo newSol = new Individuo(1,false);
        if (indiv1 == null || indiv2 == null) 
            throw new Error("Los individuos para cazarse son nulos");         
        //esto pasara cuando no se calibre bien la cantidad de casamientos que se haga 
        //por cada cruzamiento se sacan 2 padres de la poblacion entonces se debe tener 
        //cuidado de seguir sacando cuando se haya excedido el tamaño de la poblacion
        
        /*Para cada interseccion generas 2 tiempos aleatorios de semaforos*/
        for (int i=0; i<Config.N_CROSS; i++){
            
            /*Se genaran los tiempos aleatoriamente o se colocan por defecto solo al inicio*/
            byte tSemaforo1, tSemaforo2;
            if (Math.random() <= crossoverRate)
            {   /*promedio inicios en semaforo1 fines en semaforo2*/
                tSemaforo1 = (byte)((indiv1.getSemaforoInicio()[i] + indiv2.getSemaforoInicio()[i])/2);
                tSemaforo2 = (byte)((indiv1.getSemaforoFin()[i] + indiv2.getSemaforoFin()[i])/2);
            }
            else
            {   /*promedio fines en semaforo1 inicios en semaforo2*/
                tSemaforo1 = (byte)((indiv1.getSemaforoFin()[i] + indiv2.getSemaforoFin()[i])/2);
                tSemaforo2 = (byte)((indiv1.getSemaforoInicio()[i] + indiv2.getSemaforoInicio()[i])/2);
            }

            newSol.representarTiempos(i, tSemaforo1, tSemaforo2);
        }
        return newSol;
    }

    // Mutate an individual
    private static void mutate(Individuo indiv)
    {        
        Random random = new Random();
        double probMutacion = random.nextDouble();
        if (probMutacion >= mutationRate) 
        { // x% de probabilidad de mutacion
            //Si se da la asignacion se seleccionan 2 genes para intercambiarlos       
            
            int numeroMutaciones = (int)(Config.N_PERIOD * mutationRate);
            for (int i=0; i<numeroMutaciones; i++) 
            {
                int pos1 = new Random().nextInt(Config.N_CROSS); /*Para saber a que cruce se refiere*/
                int pos2 = new Random().nextInt(Config.N_CROSS); /*Para saber a que cruce se refiere*/
                
                /*Primer Cambio*/
                byte tSemaforo10 = (byte)(indiv.getSemaforoInicio()[pos1]);
                byte tSemaforo11 = (byte)(indiv.getSemaforoFin()[pos1]);
                
                byte tSemaforo20 = (byte)(indiv.getSemaforoInicio()[pos2]);
                byte tSemaforo21 = (byte)(indiv.getSemaforoFin()[pos2]);
                
                indiv.representarTiempos(pos1, tSemaforo20, tSemaforo21);
                indiv.representarTiempos(pos2, tSemaforo10, tSemaforo11);
            }            
        }
    }

    private static Individuo controlDeAberraciones(Individuo individuo, Poblacion poblacion) 
    { 
        // si es duplicado
        boolean esDuplicado;
        Individuo temp;
        int fitnessIndividuo = individuo.getFitness();
        for (int i = 0; i < poblacion.size(); i++) {
            esDuplicado = true;
            temp = poblacion.getIndividual(i);
            if (fitnessIndividuo != temp.getFitness()) {
//                System.out.println("SIZE: " + individuo.size());
//                if (individuo == null) System.out.println("individuo en control de aberraciones es null");
                for (int j = 0; (j < individuo.size()) && (esDuplicado); j++) {
                    if (individuo.getGen(j) != temp.getGen(j)) {
                        esDuplicado = false;
                    }
                }
            }
            if (esDuplicado) {
                //numDuplicados++;
                return null;
            }
        }
        return individuo;
    }
    
    private static Individuo removerAleatorio(Poblacion pop) 
    {
        // 1. Se genera una ruleta
        // GenerarRuleta(listIndividuo);
        // Se escoge un numeroAleatorio aleatorio del 0 al 1 
        Random rand = new Random();
        double numeroAleatorio = rand.nextDouble();
        // Se ve entre que asignaciones salio para ver que cromosoma gano
        Individuo individuo = null;
        float aux = 0;
        int fitnessTotal = pop.getTotalFitness();
        for (int i = 0; i < pop.size(); i++) 
        {
            //Individuo ant = listIndividuo.get(i - 1);
            individuo = pop.getIndividual(i);
            if (individuo.getEstado()==1) // si es uno quiere decir que no ha sido tomado para la seleccion
            {                   
                int fitnessIndividuo = individuo.getFitness();
                aux += (float)fitnessIndividuo/(float)fitnessTotal;
                if (aux >= numeroAleatorio) {
                    individuo.setEstado(0); // lo pondra en cero porque ya fue tomado
                    pop.setTotalFitness(0,fitnessIndividuo); //se quita del fitness total el fitness del individuo ya tomado
                    return individuo;
                }
            }                       
        }
        return individuo;
    }
    
    public static boolean sonIguales(Individuo ind1, Individuo ind2)
    {        
        return Arrays.equals(ind1.getCromosoma(), ind2.getCromosoma());        
    }
       
}