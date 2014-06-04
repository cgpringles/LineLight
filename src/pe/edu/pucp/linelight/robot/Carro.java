/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.robot;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.linelight.structure.Edge;
import pe.edu.pucp.linelight.structure.MatrizMap;
import pe.edu.pucp.linelight.util.ConvertUtil;

/**
 *
 * @author Cesar
 */
public class Carro{
    
    Edge cuadra;
    double posX;
    double bufferPosX=0;
    double posY;
    double bufferPosY=0;
    int dirX;
    int dirY;
    public static int OUTMAP=-1;
    public static int INMAP=1;
    public int status;
    double velocidad;
    //Ubicación en formato de porcentaje de cuadra
    double positionPorc;

    public void setStartPoint(Edge c)
    {
        cuadra=c;
        
        Random rnd=new Random();
        
        //Ubicación randómica de los vehículos
//        if (c.getOriginNode().getX()!=c.getEndNode().getX())
//            posX=Math.min(c.getOriginNode().getX(), c.getEndNode().getX())
//                    + rnd.nextInt(Math.abs(c.getOriginNode().getX()-c.getEndNode().getX()));
//        else posX=c.getOriginNode().getX();
//        
//        if (c.getOriginNode().getY()!=c.getEndNode().getY())
//            posY=Math.min(c.getOriginNode().getY(), c.getEndNode().getY())
//                    + rnd.nextInt(Math.abs(c.getOriginNode().getY()-c.getEndNode().getY()));
//        else posY=c.getOriginNode().getY();
        
        cuadra.aumentarFlujoActual();
        //En que porcentaje de la cuadra está ubicado...
        positionPorc=rnd.nextInt(100);
        bufferPosX=posX;
        bufferPosY=posY;
    }
    
    
    public double getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    public Carro()
    {
        this.status=INMAP;
    }
    
    public Edge getCuadra() {
        return cuadra;
    }

    public void setCuadra(Edge cuadra) {
        this.cuadra = cuadra;
    }
    
    public int cambiarCuadra(List<Edge> listaCuadras)
    {
       if (listaCuadras.size()==0)
           return OUTMAP;
       
       int i=listaCuadras.size();
       Random rnd=new Random();
       int r;
       if (i==0) r=0;
       else
       r=rnd.nextInt(i);
       
       Edge c=listaCuadras.get(r);
       setCuadra(c);
       c.aumentarFlujoActual();
       setVelocidad(c.getVelocidad());
       positionPorc=0;
//       System.out.println("Velocidad: "+velocidad);
       return INMAP;
    } 
    
    public void moveCar(int T_PAUSA)
    {
            velocidad=cuadra.getVelocidad();
            double nextPos=ConvertUtil.convertirVelocidad(velocidad)*T_PAUSA/1000; //velocidad * tempo
            positionPorc+=(nextPos/cuadra.getDistancia())*100;
            
            if (positionPorc>=100)
            { 
//                System.out.println("D: "+cuadra.getFlujoActual());
                cuadra.disminuirFlujoActual();
                if (cuadra.getFlujoActual()<0)
                {
                    System.out.println("?");
                    
                    
                }
                status=cambiarCuadra(cuadra.getEndNode().getListaCuadras());
            }
    }
}
