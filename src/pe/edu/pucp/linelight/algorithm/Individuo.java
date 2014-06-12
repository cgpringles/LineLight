/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

import java.util.Random;

/**
 *
 * @author Angel
 */
public class Individuo  
{    
    /*Atributos*/
    private int distancia = -1;
    private int tiempo = -1;
    
    private int id; // servira para colocar al primer individuo de la poblacion los valores de tiempos de semaforo por defecto    
    private int estado = -1; //servirar para saber si considerar o no el individuo en la ruleta por que pueda haber sido ya seleccionado    
    private int fitness = -1;
    private float velocidadPromedio = -1;
    private byte[] cromosoma;
    private byte[] tSemaforoInicio;
    private byte[] tSemaforoFin;
    private long[] idNodoSemaforo;

    /*Constructor*/
    public Individuo(int numIndividuo, boolean crearGenesRandom)
    {
        MethodConfig.setSizeAllGen(); //cambiara la longitud de cruces o intersecciones
        cromosoma = new byte [Config.size_allGen];
        tSemaforoInicio = new byte[Config.N_CROSS]; /*Se alamcena los tiempos de los semaforos generados en decimal*/
        tSemaforoFin = new byte[Config.N_CROSS];
        idNodoSemaforo = new long[Config.N_CROSS];
        id = numIndividuo;
        estado = 1;
        establecerIdNodos();
        generarIndividuos(crearGenesRandom);        
        
//        MethodConfig.setSizeAllGen(); //para calcular la cantidad de semaforos que habran y por lo tanto la longitud del cromosoma
//        cromosoma = new byte[Config.size_allGen]; /*Aca vemos la longitud asignada al cromosoma*/
//        tSemaforoInicio = new byte[Config.N_CROSS]; /*Se alamcena los tiempos de los semaforos generados en decimal*/
//        tSemaforoFin = new byte[Config.N_CROSS]; /*Se alamcena los tiempos de los semaforos generados en decimal*/
//        id = numIndividuo;
//        estado = 1; //individuo con true y false igual seteara sus estados
//        generarIndividuos(crearGenesRandom);
    }
    
    /*Métodos*/ 
    private void generarIndividuos(boolean crearGenesRandom)
    {
        /*True: crear valores aleatorios, util en la poblacion inicial
         * False: crear individuos vacios para el casamiento*/        
        if(crearGenesRandom)
        {
            crearGenes(true);
        }
        
        fitness = -1;
        distancia = -1;
        velocidadPromedio = -1;
    }
    
    private void crearGenes(boolean random)
    {
        
        /*Para cada interseccion generas 2 tiempos aleatorios de semaforos*/
        for (int i=0; i<Config.N_CROSS; i++){
            
            /*Se genaran los tiempos aleatoriamente o se colocan por defecto solo al inicio*/
            byte tSemaforo1, tSemaforo2;
            if (id >0 && random) 
            {                
                tSemaforo1 = (byte) (Config.tiempoVerdeMin + (new Random()).nextInt(Config.tiempoVerdeMax-Config.tiempoVerdeMin));                
                tSemaforo2 = (byte) (Config.tiempoRojoMin + (new Random()).nextInt(Config.tiempoRojoMax-Config.tiempoRojoMin));
            }
            else 
            {
                tSemaforo1 = (byte) (Config.defaultTime);
                tSemaforo2 = (byte) (Config.defaultTime);
            }         
                        
            representarTiempos(i,tSemaforo1,tSemaforo2);            
        }
    }
    
    private void establecerIdNodos()
    {               
        Vehiculo [] vehiculos = GA.trafico.getVehiculos();        
        
        int j=0;
        for (int i=0; i<getIdNodoSemaforo().length; ){
            Ruta ruta = vehiculos[j].getRoute();
            for (int k=0; k< ruta.getIdNodoRuta().size(); k++) {
                getIdNodoSemaforo()[i] = ruta.getIdNodoRuta().get(k);
                i++;
            }
            j++;
        }
    }

    public int getEstado()
    {
        return estado;
    }   
        
    public void setEstado(int value)
    {
        estado = value;
//        fitness = -1; //para poder volver a calular la fitness de ser necesario
    }
    
    public float getVelocidadPromedio()
    {
        return velocidadPromedio;     
    }
    
    public byte getGen(int i)
    {
        return cromosoma[i];
    }   
        
    public void setGen(int i, byte value)
    {
        cromosoma[i] = value;
        fitness = -1; //para poder volver a calular la fitness de ser necesario
    }
    
    public byte[] getCromosoma()
    {
        return cromosoma;
    }
    
    public byte[] getSemaforoInicio()
    {
        return tSemaforoInicio;
    }
    
    public byte[] getSemaforoFin()
    {
        return tSemaforoFin;
    }
    
    public byte getTiempoSemaforoInicio(int i)
    {
        return tSemaforoInicio[i];
    }
    
    public void setTiempoSemaforoInicio(int i, byte value)
    {
        tSemaforoInicio[i]=value;
    }

    public byte getTiempoSemaforoFin(int i)
    {
        return tSemaforoFin[i];
    }
    
    public void setTiempoSemaforoFin(int i, byte value)
    {
        tSemaforoFin[i]=value;
    }
    
    public long[] getIdNodoSemaforo() {
        return idNodoSemaforo;
    }
    
    public long getNodoSemaforo(int i)
    {
        return idNodoSemaforo[i];
    }

    public void setIdNodoSemaforo(long[] idNodoSemaforo) {
        this.idNodoSemaforo = idNodoSemaforo;
    }
        
    public int size() 
    {
        return cromosoma.length;
    }

    public int getFitness()
    {                
        Vehiculo [] vehiculos = GA.trafico.getVehiculos();        
        fitness = 0;                
        
        for (Vehiculo vehiculo : vehiculos)
        {               
            distancia = 0;            
            tiempo = 0;            
            Ruta ruta = vehiculo.getRoute();            
            
            if(ruta.getActualPosX()<0 && ruta.getActualPosY() <= 0)//Inicializar el recorrido
            {
                ruta.setActualPosX(ruta.getPosIniX());
                ruta.setActualPosY(ruta.getPosIniY());
            }

            fitness += obtenerDemora(vehiculo,0);
//            System.out.println("Resultado Fitness Vehiculo (Distancia,Tiempo): "
//                    + "(" + distancia + "," + tiempo + ") -- " +  distancia/tiempo + " -- " 
//                    + (distancia/tiempo)/Config.kmAms );
            
            if (tiempo < 1) tiempo = 1;
            velocidadPromedio += (float)((distancia/tiempo)/Config.kmAms)*10;
            
            //reset para el próximo gen
            ruta.setActualPosRoute(-1);
            ruta.setActualPosX(-1);
            ruta.setActualPosY(-1);
//            ruta.setPosIniX(-1);
//            ruta.setPosIniY(-1);
//            ruta.setPosFinX(-1);
//            ruta.setPosFinY(-1);
//            ruta.setLastdecision(-1);
        }

        velocidadPromedio = (velocidadPromedio/vehiculos.length)/2;
        return fitness;
    }
    
    private int obtenerDemora(Vehiculo vehículo, int current_time)
    {        
        int time_restante = Config.T_CYCLIC - current_time;
        
        if(time_restante<=0) return 0; //Si ya no hay más tiempo devolver 0
        
        int demora = 0;
        
        Double _vel = vehículo.getVelocidad()*Config.kmAms; //Velocidad de km/h a m/s
        int vel = _vel.intValue();
        
        Ruta ruta = vehículo.getRoute();
        int actualPosX = ruta.getActualPosX(); /*saber donde se encuentra actualmente el vehiculo*/
        int actualPosY = ruta.getActualPosY();
        
        int[] next = ruta.getNextPosXY(); /*sacas la siguiente posicion de ruta a donde se dirige el vehiculo*/
        
        if(next.length != 2) return 0; //Si no puede calcular el siguiente retornar 0
        
        int next_x = next[0]; /*saber hacia que punto se dirige el vehiculo*/
        int next_y = next[1];
        
        long idNext_Nodo = ruta.getNextIdNodo(); //sacar el idNodo de la Ruta
        
        int direction=0;
        int difX = next_x - actualPosX;
        int difY = next_y - actualPosY;
        
        if (difX >= 0 && difY >= 0) direction = 2;
        if (difX <  0 && difY <  0) direction = 3;
        if (difX <  0 && difY >= 0) direction = 1;
        if (difX >= 0 && difY <  0) direction = 0;
        
        /*direccion: 0(abajo N->S), 1(arriba S->N), 2(derecha O->E), 3(izquierda E->O)*/
//        int direction = actualPosX-next_x==0?(next_y-actualPosY>=0?1:0):(next_x-actualPosX>=0?2:3);
//        
//        int distante_next=0;
//        switch(direction)
//        {
//            case 0:
//                distante_next = actualPosY - next_y ;
//                break;
//            case 1:
//                distante_next = next_y - actualPosY;
//                break;
//            case 2:
//                distante_next = next_x - actualPosX;
//                break;
//            case 3:
//                distante_next = actualPosX - next_x;
//                break;
//        }
        /**/
        int distante_next;
        
        long res1 = actualPosX - next_x;
        long res2 = actualPosY - next_y;
        distante_next = ((int) (Math.sqrt ((Math.pow(res1, 2) + Math.pow(res2, 2)))))/100 + 1;
        /**/        
        
        int time_to_next = distante_next / vel; //tiempo para el siguiente semáforo
               
        /*** Si aún hay tiempo para llegar a un semaforo ***/
        if(time_restante > time_to_next)
        {
            time_restante -= time_to_next;  /*se quita al tiempo total el tiempo que ya transcurrio*/          
            current_time += time_to_next;  /*se acumula el tiempo ya transcurrido*/

//            /*Esta fórmula permitirá obtener el indice al que llega el vehiculo*/
//            int i = ((next_y/Config.entreCallesY)*((Config.mapX+Config.entreCallesX)/Config.entreCallesX)) + 
//                    (next_x/Config.entreCallesX);
                               
//            int index_time = (i*Config.size_oneGen)+current_time;
            int i = obtenerInterseccionEnCromosoma(idNext_Nodo);
            int index_time = (i*Config.size_oneGen) + current_time;

            
//            if(index_time < 0 || index_time > cromosoma.length)
//            {                
//                throw new Error("Se calculo mal, obtener demora por error de index time: " + index_time);
//            }
            
            ruta.setActualPosRoute(ruta.getActualPosRoute()+1);
            
            //Situar posición del vehiculo en la posicion del semáforo a la que acaba de llegar o pasar
            ruta.setActualPosX(next_x);
            ruta.setActualPosY(next_y);
            int time_red=0;
            
            //cuando i es -1 quiere decir que el nodo que se esta evaluando no posee semaforos
            if (index_time >= 0 && index_time < cromosoma.length) {
            
                byte gentime = cromosoma[index_time];            

//                //Avanzar para el siguinte punto de la ruta
//                ruta.setActualPosRoute(ruta.getActualPosRoute()+1);

                time_red = calcularTiempoRojo(index_time, direction, gentime);
            }
            else 
                index_time = 0;
            
            current_time += (time_red-index_time);
            demora += (time_red-index_time);
            
            distancia += distante_next;
            tiempo += time_to_next + (time_red-index_time); 
            
            demora += obtenerDemora(vehículo, current_time);
        }
        /*** Si el tiempo que resta no llega a ningun semaforo ***/
        else
        {
            int dist_recorrer = vel * time_restante;
            switch(direction)
            {
                case 0:
                    ruta.setActualPosY(actualPosY-dist_recorrer);
                    break;
                case 1:
                    ruta.setActualPosY(actualPosY+dist_recorrer);
                    break;
                case 2:
                    ruta.setActualPosX(actualPosX+dist_recorrer);
                    break;
                case 3:
                    ruta.setActualPosX(actualPosX-dist_recorrer);
                    break;
            }
            
            /*cuando ya no alcanza el tiempo para llegar al semaforo se debe acumular 
             *la velocidad teorica del vehiculo*/
            distancia += distante_next;
            tiempo += time_to_next;
        }
        
        return demora;
    }
    private int obtenerInterseccionEnCromosoma(long id)
    {
        /*Buscara si el nodo de la ruta posee un semaforo, un nodo Semaforo*/
        for(int i=0; i<getIdNodoSemaforo().length; i++){
            if (getIdNodoSemaforo()[i] == id) return i;
        }        
        return -1;        
    }
    
    
    private int calcularTiempoRojo(int index_time, int direction, byte gentime)
    {
        int time_red = index_time;
        if( (direction==0||direction==1) && (gentime==2 || gentime==3) ) 
        {            
            //Calcular el tiempo en rojo            
            if(direction == 0 || direction == 1)
            {
                while(time_red<Config.size_allGen && ( cromosoma[time_red] == 2 || cromosoma[time_red] == 3 ) )
                {
                    time_red++;
                }
            }
            else
            {
                while(cromosoma[time_red] == 0 || cromosoma[time_red] == 0 )
                {
                    time_red++;
                }
            }
        }
        /*Llego en rojo al semáforo de derecha a izquierda o viceversa*/
        else if  ( (direction==2||direction==3) && (gentime==0 || gentime==1) ) 
        { 
            //calcular el tiempo en rojo            
            if(direction == 2 || direction == 3)
            {
                while(time_red<Config.size_allGen && ( cromosoma[time_red] == 0 || cromosoma[time_red] == 1 ) )
                {
                    time_red++;
                }
            }
            else
            {
                while(cromosoma[time_red] == 2 || cromosoma[time_red] == 2 )
                {
                    time_red++;
                }
            }
        }
        /*cuando llega en verde se debe acumular la velocidad 
         return 0; no hay tiempo en rojo*/
        
        return time_red;        
    }    
    
    public void representarTiempos(int i, byte tSemaforo1, byte tSemaforo2)
    {
        tSemaforoInicio[i] = tSemaforo1; /*guarda el tiempo del primer semaforo(el que inicia) en el cruce*/
        tSemaforoFin[i] = tSemaforo2; /*guarda el tiempo del segundos semaforo*/       
        
//        System.out.println("Tiempos Cruce " + i +": ["+tSemaforoInicio[i]+","+tSemaforoFin[i]+"]");
        
        /*Representacion de tiempos en cromosoma*/
        byte tipo2;
        byte tipo1 = (byte)new Random().nextInt(4);
        if (tipo1>=2) tipo2 = (byte)new Random().nextInt(2);
        else tipo2 = (byte)(new Random().nextInt(2)+2);

        int aux1 = tSemaforo1, aux2 =0;
        boolean flag1 = false, flag2 = true;
        /*Sea aplican conceptos de semaforos*/
        for (int j=i*Config.N_PERIOD; j<(i+1)*Config.N_PERIOD; j++)
        {
            if (aux1>0 && flag2) {
                cromosoma[j] = tipo1;
                aux1--;
                aux2 = tSemaforo2;
            }
            else {
                flag1 = true;
                flag2 = false;
            }

            if (aux2>0 && flag1){
                cromosoma[j] = tipo2;
                aux2--;
                aux1 = tSemaforo1;
            }
            else {
                flag2 = true;
                flag1 = false;
            }
        }
    }
        
    public void imprimirAllGen()
    {
        System.out.println("NumeroPeriodos=" + Config.N_PERIOD + 
                            "  TiempoPeriodo=" + Config.T_PERIOD +
                            "  NumeroCruces=" + Config.N_CROSS + 
                            "  LongitudCromosoma=" + Config.size_allGen);
        System.out.print("[");
        for (int i=0; i<cromosoma.length; i++)
        {
            if (i%Config.N_PERIOD==0)
                System.out.println();
            System.out.print(cromosoma[i]);
        }
        System.out.println("] ");
    }
    
    public void imprimirTiempoSemaforos()
    {
        System.out.println("Tiempos de Semaforos en Cromosoma ");
        for (int i=0; i<Config.N_CROSS; i++)        
            System.out.println("Cruce " + i +": ["+tSemaforoInicio[i]+","+tSemaforoFin[i]+"]");        
    }


    
}