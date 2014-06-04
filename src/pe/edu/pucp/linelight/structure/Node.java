/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.structure;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.util.ConvertUtil;

/**
 *
 * @author Cesar
 */
public class Node{
    private Long id;
    private double latitud;
    private double longitud;
    private double x;
    private double y;

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
 
    
    //Listado de cuadras donde el nodo es nodo inicial
    private List<Edge> listaCuadras;

    public List<Edge> getListaCuadras() {
        return listaCuadras;
    }

    public void setListaCuadras(List<Edge> listaCuadras) {
        this.listaCuadras = listaCuadras;
    }


    public Node(Long id,double lat, double lon,Zona z) {
        this.id = id;
        this.latitud=lat;
        this.longitud=lon;
        Point2D p=ConvertUtil.convertirGPStoPixel(lat, lon,z);
        this.x=p.getX();
        this.y=p.getY();
        listaCuadras=new ArrayList<>();
    }
    
    public void agregarListaCuadra(Edge e)
    {
        listaCuadras.add(e);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }
    
}
