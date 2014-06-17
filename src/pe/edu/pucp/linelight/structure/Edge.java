/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.structure;

import pe.edu.pucp.linelight.util.ConvertUtil;

/**
 *
 * @author Cesar
 */
public class Edge{
    private int id;
    private Node originNode;
    private Node endNode;
    private int capacidad;
    private int flujoActual;
    private double velMax=60;
    private double velocidadCuadra;
    private int distancia;
//    private int[] matrizCuadra;
    
    public static final int HABILITADO=1;
    public static final int DESHABILITADO=0;
    private int status;
    private String tipoVia;
    
    public void ocuparEspacioCuadra(int i)
    {
//        matrizCuadra[i]=1;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public Edge(int id, Node originNode, Node endNode,int capacidad,String tipovia) {
        this.id = id;
        this.originNode = originNode;
        this.endNode = endNode;
        this.tipoVia=tipovia;
        this.flujoActual=0;
        this.distancia=ConvertUtil.getDistanceLatLong(originNode.getLatitud(), endNode.getLatitud(),
                                        originNode.getLongitud(), endNode.getLongitud());
        this.status=HABILITADO;
        this.capacidad=20;
        if (tipovia.equalsIgnoreCase("Avenida"))
        {
            this.capacidad=40;
            
        }
        
//        this.matrizCuadra=new iad,nt[100];
    }
    
    public int getDirX()
    {
        int val=(int)(endNode.getX()-originNode.getX());
        if (val==0) return 0;
        return ((val)/Math.abs(val));
    }
    
    
    public int getDirY()
    {
        int val=(int)(endNode.getY()-originNode.getY());
        if (val==0) return 0;
        return ((val)/Math.abs(val));
    }
    
    public double getVelocidad()
    {
        if (getFlujoActual()>=getCapacidad()) return 10;
        
        velocidadCuadra=(1-((double)getFlujoActual()/(double)getCapacidad()))*(getVelMax());
//        System.out.println(getFlujoActual()+"-"+getCapacidad());
        return velocidadCuadra;
    }

    public int getFlujoActual() {
        return flujoActual;
    }

    public void setFlujoActual(int flujoActual) {
        this.flujoActual = flujoActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getVelMax() {
        return velMax;
    }

    public void setVelMax(double velMax) {
        this.velMax = velMax;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the originNode
     */
    public Node getOriginNode() {
        return originNode;
    }

    /**
     * @param originNode the originNode to set
     */
    public void setOriginNode(Node originNode) {
        this.originNode = originNode;
    }

    /**
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }

    /**
     * @param endNode the endNode to set
     */
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
    
    
    public void aumentarFlujoActual()
    {
        flujoActual++;
    }
    
    public void disminuirFlujoActual()
    {
        flujoActual--;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
