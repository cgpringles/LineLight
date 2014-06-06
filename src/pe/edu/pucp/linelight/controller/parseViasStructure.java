/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.NodoController;
import pe.edu.pucp.linelight.controller.TipoViaController;
import pe.edu.pucp.linelight.controller.TramoController;
import pe.edu.pucp.linelight.controller.ViaController;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.TramoId;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.TramoxnodoId;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.model.ViaId;
import pe.edu.pucp.linelight.structure.MapParser;
import pe.edu.pucp.linelight.view.DetalleVias;
import pe.edu.pucp.linelight.view.NuevaVia;

public class parseViasStructure implements Runnable{
        public static boolean band=false;
        File file;
        Distrito dRef;
        NuevaVia ventana;
        Document document;
        public parseViasStructure(File file, Distrito dRef, NuevaVia ventana) throws DocumentException{
            this.file = file;
            this.dRef = dRef;
            SAXReader reader = new SAXReader();
            this.document = reader.read(file);
            this.ventana = ventana;
            band=false;
        }
    public void run() 
    {
        List<Nodo> nodes=new ArrayList<>();        
        List<Tramo> listaTramos=new ArrayList<>();
        List<Tramoxnodo> listaTramoxNodo=new ArrayList<>();
        List<Via> listaVias=new ArrayList<>();
        Element root = document.getRootElement();
            for ( Iterator i = root.elementIterator("node"); i.hasNext(); ) {
                Element element = (Element) i.next();                
                Nodo node = parseNode( element);
                nodes.add(node);
            }

            NodoController.agregarNodo(nodes);
            
            for ( Iterator i = root.elementIterator("way"); i.hasNext(); ) {
                Element element = (Element) i.next();
                parseEdge(element, dRef,listaVias,listaTramos,listaTramoxNodo);
            }           
            ViaController.agregarVia(listaVias);
            TramoController.agregarTramo(listaTramos);
            TramoController.agregarTramoxNodo(listaTramoxNodo);
            band=true;
            System.out.println("Fin carga de xml");
            int id_n= DistritoController.obteneridDistrito(dRef.getNombre());
            ArrayList<Via> list=new ArrayList<Via>();
            list=ViaController.obtenerVias(dRef.getIdDistrito());
            int numVias=list.size();
            DetalleVias nuevo=new DetalleVias(numVias,dRef.getNombre());
            this.ventana.dispose();
            nuevo.setVisible(true);
    }
    
    
    public static Nodo parseNode(Element element){
         Long id = Long.parseLong(element.attribute("id").getStringValue());
        double lat=Double.parseDouble(element.attribute("lat").getStringValue());
        double lon=Double.parseDouble(element.attribute("lon").getStringValue());
        Nodo node = new Nodo();
        node.setIdNodo(id);
        node.setLatitud(lat);
        node.setLongitud(lon);
        return node;
    }
    
    public static void parseEdge(Element element, Distrito dRef, List<Via> listaVias,
                                List<Tramo>listaTramos,List<Tramoxnodo> listaTramoxNodo){
        
        Via v=new Via();
        ArrayList<Long> l=new ArrayList<>();
        Long idVia=Long.parseLong(element.attribute("id").getStringValue());
        v.setId(new ViaId(dRef.getIdDistrito(),idVia));
        for ( Iterator i = element.elementIterator("nd"); i.hasNext(); ) {
                Element e = (Element) i.next();                
                Long r=Long.parseLong(e.attribute("ref").getStringValue());
                l.add(r);
            }
        
        if (l.size()>0) 
        {
            boolean f=false;
            for ( Iterator i = element.elementIterator("tag"); i.hasNext(); ) {
                    Element e = (Element) i.next();                
                    String k=e.attribute("k").getStringValue();

                    if (k.equalsIgnoreCase("highway"))
                    {
                        if (e.attribute("v").getStringValue().equalsIgnoreCase("secondary"))
                        {v.setTipovia(TipoViaController.obtenerTipoAvenida());
                         f=true;
                        }
                        if (e.attribute("v").getStringValue().equalsIgnoreCase("residential"))
                        {
                            v.setTipovia(TipoViaController.obtenerTipoCalle());
                            f=true;
                        }
                        if (!f)
                            v.setTipovia(TipoViaController.obtenerTipoAvenida());
                    }   

                    if (k.equalsIgnoreCase("name"))
                    {
                        String nombreVia=e.attribute("v").getStringValue();
                        v.setNombre(nombreVia);
                    }
                }
            listaVias.add(v);
            for (int i=0;i<l.size()-1;i++)
            { 
                Long origin_node_id = l.get(i);
                Long end_node_id = l.get(i+1);
                int idTramo=i+1;
                Tramo t=new Tramo();
                t.setId(new TramoId(idTramo, dRef.getIdDistrito(),idVia));
                t.setEstado(Boolean.TRUE);

                listaTramos.add(t);
                Tramoxnodo txn1=new Tramoxnodo();
                txn1.setId(new TramoxnodoId(idTramo,dRef.getIdDistrito(), idVia,origin_node_id));
                txn1.setPosicionTramo('I');
                listaTramoxNodo.add(txn1);
                Tramoxnodo txn2=new Tramoxnodo();
                txn2.setId(new TramoxnodoId(idTramo,dRef.getIdDistrito(),idVia, end_node_id));
                txn2.setPosicionTramo('F');

                listaTramoxNodo.add(txn2);
            }
        }
        
    }

    
}