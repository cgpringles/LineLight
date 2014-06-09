/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;
import pe.edu.pucp.linelight.structure.Node;

/**
 *
 * @author Angel
 */
public class Ruta implements Serializable
{
    /*Atributos*/
    private ArrayList<Integer> posX = new ArrayList<>();
    private ArrayList<Integer> posY = new ArrayList<>();
    private ArrayList<Long> idNodoRuta = new ArrayList<>();
    
    private int posIniX = -1;
    private int posIniY = -1;
    
    private int posFinX = -1;
    private int posFinY = -1;
    
    private int actualPosX = -1;
    private int actualPosY = -1;
    private int actualPosRoute = -1;
   
    private boolean isPrepared = false;    
    private int lastdecision = -1;
    
    /*Constructor*/    
    public Ruta (boolean random, int id)
    {
        if (random)
            generarRandomRoute();
        else
            // utilizado para migrar
            agregarGeneradaRoute(id);
    }
    
    /*Metodos*/ 
    public int[] getNextPosXY()
    {
        if(actualPosRoute == posX.size()-1) return new int[]{};
        return new int[]{posX.get(actualPosRoute+1),posY.get(actualPosRoute+1)};
    }
    
    public long getNextIdNodo()
    {        
        return idNodoRuta.get(actualPosRoute+1);
    }
    
    private void generarRandomRoute()
    {
        reset();
        generarRandomPosIni();
        int lengthRoute = new Random().nextInt(Config.lengthRouteMax-Config.lengthRouteMin)+Config.lengthRouteMin;
        while(lengthRoute-- >= 0)
        {
            addNextRandomRoute();
        }
        generarRandomPosFin();
    }
    
    private void agregarGeneradaRoute(int id)
    {
        // utilizado para migrar
        reset();
        agregarGeneradaPosIni(id);
        int lengthRoute = ((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(id))).size(); // sacar el tamaño de la lista de ruta para el vehiculo "id"
        int j=0;        
        while(lengthRoute-- > 0)
        {            
            addNextGeneradaRoute(id,j);
            j++;
        }       
        agregarGeneradaPosFin(id);
    }
    
        
    private void generarRandomPosIni()
    {
        setPosIniX(new Random().nextInt(Config.mapX));
        setPosIniY(new Random().nextInt(Config.mapY));
        boolean adjustX = new Random().nextBoolean();
        if(adjustX)
        {
            setPosIniX((getPosIniX() / Config.entreCallesX) * Config.entreCallesX);
        }
        else
        {
            setPosIniY((getPosIniY() / Config.entreCallesY) * Config.entreCallesY);
        }
    }
    
    private void agregarGeneradaPosIni(int i)
    {
        // se accede al get(0) debido a que ahi se ecnontrara la posicion inicial
        int posIniX = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(i))).get(0).getLongitud()*Config.factorPos);
        int posIniY = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(i))).get(0).getLatitud()*Config.factorPos);
        
        setPosIniX(posIniX);
        setPosIniY(posIniY);
    }
    
    
    private void generarRandomPosFin()
    {
        int i = getPosX().size()-1;
        
        int decision = new Random().nextInt(4);
        int newPosX = getPosX().get(i);
        int newPosY = getPosY().get(i);
        
        int prohibited = (getLastdecision()==0)?1:(getLastdecision()==1?0:(getLastdecision()==2?3:(getLastdecision()==3?2:-1)));
        while(decision == prohibited)
        {
            decision = new Random().nextInt(4);
        }
        
        switch(decision)
        {
            case 0 :
            {
                newPosY -= new Random().nextInt(Config.entreCallesY);
                break;
            }
            case 1 :
            {
                newPosY += new Random().nextInt(Config.entreCallesY);
                break;
            }
            case 2 :
            {
                newPosX += new Random().nextInt(Config.entreCallesX);
                break;
            }
            case 3 :
            {
                newPosX -= new Random().nextInt(Config.entreCallesX);
                break;
            }
        }
        
        setPosFinX(newPosX);
        setPosFinY(newPosY);
        
        isPrepared = true;

    }
    
    private void agregarGeneradaPosFin(int i)
    {
        int j = ((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(i))).size() - 1;
         
        int newPosX = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(i))).get(j).getLongitud()*Config.factorPos);
        int newPosY = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(i))).get(j).getLatitud()*Config.factorPos);
        
        setPosFinX(newPosX);
        setPosFinY(newPosY);
        
        isPrepared = true;       
    }    
        
        
    private void reset()
    {
        setActualPosRoute(-1);
        setActualPosX(-1);
        setActualPosY(-1);
        isPrepared = false;
        setPosIniX(-1);
        setPosIniY(-1);
        setPosFinX(-1);
        setPosFinY(-1);
        posX = new ArrayList<>();
        posY = new ArrayList<>();
        setLastdecision(-1);
    }
     
    private void addNextRandomRoute()
    {
        int i = getPosX().size()-1;
        
        int decision;
        int newPosX;
        int newPosY;
        if(i>=0)
        {
            newPosX = getPosX().get(i);
            newPosY = getPosY().get(i);
        }
        else
        {
            newPosX = getPosIniX();
            newPosY = getPosIniY();
        }
        
        if(i>=0)
        {
            decision  = new Random().nextInt(4);
            int prohibited = (getLastdecision()==0)?1:(getLastdecision()==1?0:(getLastdecision()==2?3:(getLastdecision()==3?2:-1)));
            while(decision == prohibited)
                decision = new Random().nextInt(4);
            
            switch(decision)
            {
                case 0 :
                {
                    newPosY -= Config.entreCallesY;
                    break;
                }
                case 1 :
                {
                    newPosY += Config.entreCallesY;
                    break;
                }
                case 2 :
                {
                    newPosX += Config.entreCallesX;
                    break;
                }
                case 3 :
                {
                    newPosX -= Config.entreCallesX;
                    break;
                }
            }
        }
        else //Generar el primer paso
        {
            decision = new Random().nextInt(4);
            if(newPosX % 400==0)
            {
                decision = new Random().nextBoolean()?0:1;
            }
            if(newPosY % 400==0)
            {
                decision = new Random().nextBoolean()?2:3;
            }
            
            switch(decision)
            {
                case 0 :
                {
                    while(newPosY!=0 && (newPosY % Config.entreCallesY != 0))
                        newPosY--;
                    break;
                }
                case 1 :
                {
                    while(newPosY!=Config.mapY && (newPosY % Config.entreCallesY != 0))
                        newPosY++;
                    break;
                }
                case 2 :
                {
                    while(newPosX!=Config.mapX && (newPosX % Config.entreCallesX != 0))
                        newPosX ++;
                    break;
                }
                case 3 :
                {
                    while(newPosX!=0 && (newPosX % Config.entreCallesX != 0))
                        newPosX --;
                    break;
                }
            }
        }
        addRoute(newPosX, newPosY);
        setLastdecision(decision);
    }
    
    private void addNextGeneradaRoute(int id, int j)
    {       
        
        int newPosX = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(id))).get(j).getLongitud()*Config.factorPos);
        int newPosY = (int) (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(id))).get(j).getLatitud()*Config.factorPos);
        int decision  = new Random().nextInt(4); // probaremos la descicion tomada
        long idNodo = (((List<Node>)(EjecucionAlgoritmoController.vehiculosRobot.get(id))).get(j).getId());
        
        addGeneradaRoute(newPosX, newPosY, idNodo);
        setLastdecision(decision);
    }    
    
    public void addRoute(int newPosX, int newPosY)
    {
        if(newPosX>=0 && newPosX <= Config.mapX && newPosY>=0 && newPosY <= Config.mapY)
        {
            getPosX().add(newPosX);
            getPosY().add(newPosY);
        }
    }

    public void addGeneradaRoute(int newPosX, int newPosY, long idNodo)
    {
        getPosX().add(newPosX); // el get() entrega la lista de posiciones X del vehiculo
        getPosY().add(newPosY); // el get() entrega la lista de posiciones Y del vehiculo
        getIdNodoRuta().add(idNodo);
    }
    
    
    public int getActualPosX() 
    {
        return actualPosX;
    }

    public int getActualPosY() 
    {
        return actualPosY;
    }

    public int getActualPosRoute() 
    {
        return actualPosRoute;
    }

    public int getPosIniX() 
    {
        return posIniX;
    }

    public int getPosIniY() 
    {
        return posIniY;
    }

    public int getPosFinX()
    {
        return posFinX;
    }

    public int getPosFinY() 
    {
        return posFinY;
    }

    public ArrayList<Integer> getPosX() 
    {
        return posX;
    }

    public ArrayList<Integer> getPosY() 
    {
        return posY;
    }

    public void setActualPosX(int actualPosX)
    {
        this.actualPosX = actualPosX;
    }

    public void setActualPosY(int actualPosY) 
    {
        this.actualPosY = actualPosY;
    }

    public void setActualPosRoute(int actualPosRoute) 
    {
        this.actualPosRoute = actualPosRoute;
    }

    public void setPosIniX(int posIniX) 
    {
        this.posIniX = posIniX;
    }

    public void setPosIniY(int posIniY) 
    {
        this.posIniY = posIniY;
    }

    public void setPosFinX(int posFinX) 
    {
        this.posFinX = posFinX;
    }

    public void setPosFinY(int posFinY) 
    {
        this.posFinY = posFinY;
    }

    public int getLastdecision() 
    {
        return lastdecision;
    }

    public void setLastdecision(int lastdecision) 
    {
        this.lastdecision = lastdecision;
    }

    public ArrayList<Long> getIdNodoRuta() {
        return idNodoRuta;
    }

    public void setIdNodoRuta(ArrayList<Long> idNodoRuta) {
        this.idNodoRuta = idNodoRuta;
    }
}
