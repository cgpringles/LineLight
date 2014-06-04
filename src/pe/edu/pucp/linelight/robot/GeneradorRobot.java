/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.NodoController;
import pe.edu.pucp.linelight.controller.TramoController;
import pe.edu.pucp.linelight.controller.ZonaController;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.Vehiculo;
import pe.edu.pucp.linelight.model.VehiculoId;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.structure.Edge;
import pe.edu.pucp.linelight.structure.Map;
import pe.edu.pucp.linelight.structure.MatrizMap;
import pe.edu.pucp.linelight.structure.Node;
import pe.edu.pucp.linelight.view.WindowsMapPanel;

/**
 *
 * @author PC-HP
 */
public class GeneradorRobot extends Thread{
    
    private int T_PAUSA=10;
    int cantRobots;
    int hh;
    int mm;
    List<Carro> listaCarros;
    List<Edge> listaEdge;
//    List<Node> listaNode;
    WindowsMapPanel wmp;
    boolean monitorear=true;
    Map map;
    static int ONLINE=1;
    static int SIMULACION=2;
    List<Object> listaVehiculosRuta;

    public List<Object> getListaVehiculosRuta() {
        return listaVehiculosRuta;
    }

    public void setListaVehiculosRuta(List<Object> listaVehiculosRuta) {
        this.listaVehiculosRuta = listaVehiculosRuta;
    }
    
    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }
    
    
    public GeneradorRobot(int cantRobots,WindowsMapPanel wmp,int idDistrito)
    {
        this.cantRobots=cantRobots;
        this.hh=hh;
        this.mm=mm;;
        this.listaCarros=new ArrayList<>();
        this.wmp=wmp;
        this.map=wmp.getMap();
        
        llenarEstructuraAutomatas(TramoController.obtenerTramosPorDistrito(idDistrito));
        
        int numTramos=listaEdge.size();
        Random rnd=new Random();
        for (int i=0;i<cantRobots;i++)
        {
            Carro c=new Carro();
            c.setStartPoint(listaEdge.get(rnd.nextInt(numTramos)));
            listaCarros.add(c);
        }
        start();
    }
    
    //Mode Simulación
    public GeneradorRobot(int cantRobots,int idDistrito,WindowsMapPanel wmp)
    {
        if (cantRobots>0) 
        {
            this.wmp=wmp;
            this.map=wmp.getMap();
            llenarEstructuraAutomatas(TramoController.obtenerTramosPorDistrito(idDistrito));
            listaVehiculosRuta=new ArrayList<>();
            for (int i=0;i<cantRobots;i++)
            {
                int numTramos=listaEdge.size();
                Random rnd=new Random();
                //Obtenemos tramo inicial
                Edge tramo=listaEdge.get(rnd.nextInt(numTramos));

                //Creamos la ruta del vehiculo
                List<Node> listaNodosRuta=generarRuta(tramo);
                listaVehiculosRuta.add(listaNodosRuta);
            }
        }
    }
    
    public List<Node> generarRuta(Edge tramoInicial)
    {
        Random rnd=new Random();
        List<Node> listaNodosRuta=new ArrayList<>();
        
        //Agregamos los nodos del tramo inicial
        listaNodosRuta.add(tramoInicial.getOriginNode());
        listaNodosRuta.add(tramoInicial.getEndNode());
        Edge tramoTemp=tramoInicial;
        //Probabilidad de 20% de que el siguiente tramo sea el último
        int x=rnd.nextInt(100);
        while ((x<=40)||(x>=50))
        {
            Node n=tramoTemp.getEndNode();
            List<Edge> listaPosiblesTramos=n.getListaCuadras();
            
            if ((listaPosiblesTramos!=null) && (listaPosiblesTramos.size()>0))
            {
                int tam=listaPosiblesTramos.size();
                tramoTemp=listaPosiblesTramos.get(rnd.nextInt(tam));
                listaNodosRuta.add(tramoTemp.getOriginNode());
                listaNodosRuta.add(tramoTemp.getEndNode());
                x=rnd.nextInt(100);
            }
            else
                break;
        }
        
        return listaNodosRuta;
    }
    
    
    
    public void llenarEstructuraAutomatas(List<Tramoxnodo> lt)
    {
        listaEdge=new ArrayList<>();
        int tam=lt.size();
        Zona z=ZonaController.obtenerZonaCentral(DistritoController.obtenerDistritoActivo().getIdDistrito());
        List<Node> listaNodosLocal=new ArrayList<>();
               
        for (Tramoxnodo tn : lt)
        {
            Nodo nbd=tn.getNodo();
            Node n=findNodeById(nbd.getIdNodo(),listaNodosLocal);
            if (n==null)
            {
               n=new Node(nbd.getIdNodo(), nbd.getLatitud(), nbd.getLongitud(), z);
               listaNodosLocal.add(n);
            }
        }
        
        for (int i=0;i<tam;i+=2)
        {
            //Nodo inicial
            Tramoxnodo txni=lt.get(i);
            //Nodo final
            Tramoxnodo txnf=lt.get(i+1);
            
//            System.out.println(txni.getId().getIdTramo()+"-"+txni.getPosicionTramo());
            
            Node nodeOrigin=null;
            Node nodeFinal=null;
//            
            Nodo ni=txni.getNodo();
//            nodeOrigin=new Node(ni.getIdNodo(),ni.getLatitud(),ni.getLongitud(),z);
            nodeOrigin=findNodeById(ni.getIdNodo(), listaNodosLocal);
            
            Nodo nf=txnf.getNodo();
//            nodeFinal=new Node(nf.getIdNodo(),nf.getLatitud(),nf.getLongitud(),z);
            nodeFinal=findNodeById(nf.getIdNodo(), listaNodosLocal);
//            String tvia=txni.getTramo().getVia().getDescripcion();
            String tvia="";
            Edge e=new Edge(txni.getTramo().getId().getIdTramo(),nodeOrigin,nodeFinal,50,tvia);
            
            //Agregamos a lista de posibles caminos
            e.getOriginNode().agregarListaCuadra(e);
            listaEdge.add(e);
        }
       
        map.setEdges(listaEdge);
    }
    
    public Node findNodeById(Long id,List<Node> listan)
    {
        for (Node n:listan)
        {
            if (n.getId().equals(id))
                return n;
        }
        
        return null;
    }
    
    
    
    
    public int getCantRobots() {
        return cantRobots;
    }

    public void setCantRobots(int cantRobots) {
        this.cantRobots = cantRobots;
    }
    
    
    public void detenerHilo()
    {
        monitorear=false;
    }
    
    @Override
    public void run()
    {   
        
        int cont=0;
        while (monitorear)
        {
            for (Carro c: listaCarros)
            {
                //Vehiculo fuera del mapa
                if (c.status!=Carro.OUTMAP)
                    c.moveCar(T_PAUSA);
            }
            
            //Removemos los vehículos fuera del mapa
            for (int i=0;i<listaCarros.size();i++)
            {
                //Vehiculo fuera del mapa
                if (listaCarros.get(i).status==Carro.OUTMAP)
                {
                    listaCarros.remove(i);
                    i--;
                }
            }
            
            if (cont>=100)
            {
                cont=0;
                wmp.repaint();
            }
//            wmp.drawCars(listaCarros);
            
            try {
                Thread.sleep(T_PAUSA);
                cont++;
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneradorRobot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
