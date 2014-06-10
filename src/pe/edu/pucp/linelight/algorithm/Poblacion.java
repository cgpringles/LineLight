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
public class Poblacion
{
    /*Atributos*/
    private Individuo[] individuos;
    private Individuo elMejor = null;
    private int totalFitness = -1;
    
    /*Constructor*/
    public Poblacion(int tamPoblacion, boolean inicializa)
    {
        totalFitness = 0;
        individuos = new Individuo[tamPoblacion];        
        generarPoblacion(tamPoblacion, inicializa);
    }
    
    /*Métodos*/
    private void generarPoblacion(int tamPoblacion, boolean inicializa)
    {
        if (inicializa)
        {
            //utilizado para la poblacion inicial
            for (int i = 0; i < tamPoblacion; i++)
            {   
                int auxFitness;
//                System.out.println("Individuo "+i);             
                Individuo newIndividual = new Individuo(i,true); //se coloca un indice a cada individuo para colocar los tiempos por defecto como un individuo inicial, individuo id=0                
                individuos[i] = newIndividual;
                auxFitness = newIndividual.getFitness(); // al momento de crearse los individuos aleatoriamente, se irá acmulando la totalFitness total
                if (i == 0) {
                    float auxVelocidad = newIndividual.getVelocidadPromedio();
                    GA.velocidadHistorica = auxVelocidad;
                    System.out.println("Valor Fitness de Individuo "+i+": "+ auxFitness);
                    System.out.println("Velocidad Promedio de Individuo "+i+": "+ auxVelocidad);
                }
                totalFitness += auxFitness;
//                System.out.println("Valor Fitness de Individuo "+i+": "+ auxFitness);
//                System.out.println("Velocidad Promedio de Individuo "+i+": "+ newIndividual.getVelocidadPromedio());                
//                newIndividual.imprimirAllGen();
            }
        }
    }

    public Individuo getIndividual(int index) 
    {
        return individuos[index];
    }

    public Individuo getFittest() 
    {
        if(elMejor == null)
        {
            calculateFittest();
        }
        return elMejor;
    }
    
    public int getTotalFitness()
    {
        return totalFitness;
    }
    
    public void setTotalFitness(int tipo, int valorFitness)
    {
        if (tipo == 1){
            totalFitness += valorFitness;
        }
        else {
            //tipo 0
            totalFitness -= valorFitness;
        }        
    }
    
    private Individuo calculateFittest()
    {
        elMejor = individuos[0];
        
        int size = size();
        for (int i = 0; i < size; i++) 
        {
//            System.out.println("Individuo " + i);
            int valorMejor = elMejor.getFitness();
            float velValorMejor = elMejor.getVelocidadPromedio();
            
            Individuo posibleMejor = getIndividual(i);
            int valorPosibleMejor = posibleMejor.getFitness();
            float velValorPosible = posibleMejor.getVelocidadPromedio();
            
//            System.out.println("Fitness : " + valorPosibleMejor + "   Velocidad : " + velValorPosible);
            
            if (valorPosibleMejor <= valorMejor) /*un individuo es mejor si ofrece menor tiempo de demora*/
            {
                elMejor = posibleMejor;
            }
        }
        return elMejor;
    }

    public int size() 
    {
        return individuos.length;
    }

    void reemplazarIndividual(int i, Individuo one) 
    {
        individuos[i] = one;
        elMejor = null;
    }

}