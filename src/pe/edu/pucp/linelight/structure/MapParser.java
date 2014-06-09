/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.structure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.NodoController;
import pe.edu.pucp.linelight.controller.TipoViaController;
import pe.edu.pucp.linelight.controller.TramoController;
import pe.edu.pucp.linelight.controller.ViaController;
import pe.edu.pucp.linelight.controller.ZonaController;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.model.ZonaId;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Tipovia;
import pe.edu.pucp.linelight.model.TramoId;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.TramoxnodoId;
import pe.edu.pucp.linelight.model.ViaId;
/**
 *
 * @author Julio
 */
public class MapParser {
   
    public static void parseFileGenericMap(File file, int idDistrito) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        
        Element root = document.getRootElement();
        String nombreDistrito=root.attribute("nombre").getStringValue();
//        Element distrito=root.element("Distrito");
       
       
//        for ( Iterator i = root.elementIterator("distrito"); i.hasNext(); ) {
//                Element element = (Element) i.next();
//                nombreDistrito = (element.attribute("nombre").getStringValue());
//
//        }   
        
        Distrito dRef=DistritoController.obtenerDistrito(nombreDistrito);
        for ( Iterator i = root.elementIterator("Zona"); i.hasNext(); ) {
                Element element = (Element) i.next();
                int idZona=Integer.parseInt(element.attribute("id").getStringValue());
                String latIni=element.attribute("latitudIni").getStringValue();
                String lonIni=element.attribute("longitudIni").getStringValue();
                String latFin=element.attribute("latitudFin").getStringValue();
                String lonFin=element.attribute("longitudFin").getStringValue();
                String imgRef=element.attribute("img").getStringValue();
                
                Zona z=new Zona();
                z.setId(new ZonaId(idZona, idDistrito));
                z.setIniLatitud(Double.parseDouble(latIni));
                z.setIniLongitud(Double.parseDouble(lonIni));
                z.setFinLatitud(Double.parseDouble(latFin));
                z.setFinLongitud(Double.parseDouble(lonFin));
                File imagen = new File(imgRef);
                try {
                    z.setImagen(Files.readAllBytes(imagen.toPath()));
                } catch (IOException ex) {
                    Logger.getLogger(MapParser.class.getName()).log(Level.SEVERE, null, ex);
                }
//                z.setImgReferencia(null);
                ZonaController.agregarZona(z);
        }
        
        /*for ( Iterator i = root.elementIterator("Vias"); i.hasNext(); ) {
                Element element = (Element) i.next();
                String dirFile=element.attribute("src").getStringValue();
                dirFile=file.getPath()+dirFile;
                File fVias=new File(dirFile);
                parseViasStructure(fVias,dRef);
        }*/
        
        
    }
    
    public static void parseViasStructure(File file,Distrito dRef) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        List<Nodo> nodes=new ArrayList<>();
        
        List<Tramo> listaTramos=new ArrayList<>();
        List<Tramoxnodo> listaTramoxNodo=new ArrayList<>();
        List<Via> listaVias=new ArrayList<>();
        
        Element root = document.getRootElement();
        
            for ( Iterator i = root.elementIterator("node"); i.hasNext(); ) {
                Element element = (Element) i.next();                
                Nodo node = parseNode( element);
//                NodoController.agregarNodo(node);
                nodes.add(node);
            }
            
            //Lista de nodos para almacenarlos en una sola sesión
            NodoController.agregarNodo(nodes);
            
            for ( Iterator i = root.elementIterator("way"); i.hasNext(); ) {
                Element element = (Element) i.next();
//                Long idVia=Long.parseLong(element.attribute("id").getStringValue());
                parseEdge(element, dRef,listaVias,listaTramos,listaTramoxNodo);
            }
            
            ViaController.agregarVia(listaVias);
            TramoController.agregarTramo(listaTramos);
            TramoController.agregarTramoxNodo(listaTramoxNodo);
            System.out.println("Fin carga de xml");
    }
    
    private static Nodo parseNode(Element element){
         Long id = Long.parseLong(element.attribute("id").getStringValue());
        double lat=Double.parseDouble(element.attribute("lat").getStringValue());
        double lon=Double.parseDouble(element.attribute("lon").getStringValue());
//        int x = Integer.parseInt(element.attribute("posX").getStringValue());
//        int y = Integer.parseInt(element.attribute("posY").getStringValue());
        Nodo node = new Nodo();
        node.setIdNodo(id);
        node.setLatitud(lat);
        node.setLongitud(lon);
        return node;
    }
    
    private static void parseEdge(Element element, Distrito dRef, List<Via> listaVias,
                                List<Tramo>listaTramos,List<Tramoxnodo> listaTramoxNodo){
        
        Via v=new Via();
        ArrayList<Long> l=new ArrayList<>();
        
        //Leemos el id de la via
        Long idVia=Long.parseLong(element.attribute("id").getStringValue());
        v.setId(new ViaId(dRef.getIdDistrito(),idVia));
        
        //Leemos todos los nodos pertenecientes a la via
        for ( Iterator i = element.elementIterator("nd"); i.hasNext(); ) {
                Element e = (Element) i.next();                
                Long r=Long.parseLong(e.attribute("ref").getStringValue());
                l.add(r);
            }
        
        Tipovia tt;
        if (l.size()>0) 
        {
            boolean f;
            //COnfiguración de clase VIA
            for ( Iterator i = element.elementIterator("tag"); i.hasNext(); ) {
                    Element e = (Element) i.next();                
                    String k=e.attribute("k").getStringValue();
                    f=false;
                    tt=TipoViaController.obtenerTipoAvenida();
                    if (k.equalsIgnoreCase("highway"))
                    {
                        //Avenida
//                        if (e.attribute("v").getStringValue().equalsIgnoreCase("secondary"))
//                        {v.setTipovia(TipoViaController.obtenerTipoAvenida());
//                         f=true;
//                        }
                        
                        //Calle
                        if (e.attribute("v").getStringValue().equalsIgnoreCase("residential"))
                        {
                            v.setTipovia(TipoViaController.obtenerTipoCalle());
                            f=true;
                        }

                        //Avenida por dfault}
                        if (!f)
                            v.setTipovia(tt);
                    }   

                    if (k.equalsIgnoreCase("name"))
                    {
                        String nombreVia=e.attribute("v").getStringValue();
                        if (nombreVia.toString().contains("Av.") || nombreVia.toString().contains("Avenida"))
                            v.setTipovia(tt);
                        v.setNombre(nombreVia);
                    }
                }

            listaVias.add(v);
    //        ViaController.agregarVia(v);

    //        List<Tramo> listaTramos=new ArrayList<>();
    //        List<Tramoxnodo> listaTramoxNodo=new ArrayList<>();

            for (int i=0;i<l.size()-1;i++)
            { 
                Long origin_node_id = l.get(i);
                Long end_node_id = l.get(i+1);
    //            Nodo origin_node = findByNodeId(nodes, origin_node_id);
    //            Nodo end_node = findByNodeId(nodes, end_node_id);

                int idTramo=i+1;
                Tramo t=new Tramo();
                t.setId(new TramoId(idTramo, dRef.getIdDistrito(),idVia));
                t.setEstado(Boolean.TRUE);

                listaTramos.add(t);


                //TramoXNodoIncial
                Tramoxnodo txn1=new Tramoxnodo();
                txn1.setId(new TramoxnodoId(idTramo,dRef.getIdDistrito(), idVia,origin_node_id));
                txn1.setPosicionTramo('I');

                listaTramoxNodo.add(txn1);

                //TramoXNodoFinal

                Tramoxnodo txn2=new Tramoxnodo();
                txn2.setId(new TramoxnodoId(idTramo,dRef.getIdDistrito(),idVia, end_node_id));
                txn2.setPosicionTramo('F');

                listaTramoxNodo.add(txn2);
            }

    //        TramoController.agregarTramo(listaTramos);
    //        TramoController.agregarTramoxNodo(listaTramoxNodo);
        }
        
    }

    private static Nodo findByNodeId(List<Nodo> nodes, Long node_id) {
        for (Nodo node : nodes) {
            if (((Long)(node.getIdNodo())).equals(node_id)) return node;
        }
        return null;
    }
    
}
