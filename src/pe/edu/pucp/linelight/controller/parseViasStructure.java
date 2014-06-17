/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
import pe.edu.pucp.linelight.model.Horario;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tipovia;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.TramoId;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.TramoxnodoId;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.model.ViaId;
import pe.edu.pucp.linelight.model.Viaxhorario;
import pe.edu.pucp.linelight.model.ViaxhorarioId;
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
            //
            //Obtener todos los id de los horarios que estan en base de datos.
            ArrayList <Horario> listaHor= new ArrayList <Horario>();
            listaHor=ViaController.ObtenerHorarios();
            //por cada via agrego 21 registrosl
         
            for (int i=0;i<listaVias.size();i++){
            Tipovia tipo=new Tipovia();
            tipo=listaVias.get(i).getTipovia();
            ArrayList <Viaxhorario> nuevaListaHorarios= new ArrayList <Viaxhorario>();
                for (int j=0; j<listaHor.size();j++){
                    Viaxhorario nuevo=new Viaxhorario();
                    ViaxhorarioId nuevoId= new ViaxhorarioId();
                    nuevoId.setIdDistrito(listaVias.get(i).getId().getIdDistrito());
                    nuevoId.setIdHorario(listaHor.get(j).getIdHorario());
                    nuevoId.setIdVia(listaVias.get(i).getId().getIdVia());
                    nuevo.setVia(listaVias.get(i));
                    nuevo.setHorario(listaHor.get(j));
                    nuevo.setId(nuevoId);
                    Random ran= new Random ();
                    if (tipo!=null){
                        if (tipo.getIdTipoVia()==1){
                            if (listaHor.get(j).getDia().equals("Lunes"))nuevo.setNumCarros(ran.nextInt(5)+30);
                            if (listaHor.get(j).getDia().equals("Martes"))nuevo.setNumCarros(ran.nextInt(5)+25);
                            if (listaHor.get(j).getDia().equals("Miercoles"))nuevo.setNumCarros(ran.nextInt(5)+20);
                            if (listaHor.get(j).getDia().equals("Jueves"))nuevo.setNumCarros(ran.nextInt(5)+20);
                            if (listaHor.get(j).getDia().equals("Viernes"))nuevo.setNumCarros(ran.nextInt(5)+50);
                            if (listaHor.get(j).getDia().equals("Sabado"))nuevo.setNumCarros(ran.nextInt(5)+20);
                            if (listaHor.get(j).getDia().equals("Domingo"))nuevo.setNumCarros(ran.nextInt(5)+15);
                        }
                        if (tipo.getIdTipoVia()==2){
                            if (listaHor.get(j).getDia().equals("Lunes"))nuevo.setNumCarros(ran.nextInt(5)+100);
                            if (listaHor.get(j).getDia().equals("Martes"))nuevo.setNumCarros(ran.nextInt(5)+70);
                            if (listaHor.get(j).getDia().equals("Miercoles"))nuevo.setNumCarros(ran.nextInt(5)+70);
                            if (listaHor.get(j).getDia().equals("Jueves"))nuevo.setNumCarros(ran.nextInt(5)+65);
                            if (listaHor.get(j).getDia().equals("Viernes"))nuevo.setNumCarros(ran.nextInt(5)+70);
                            if (listaHor.get(j).getDia().equals("Sabado"))nuevo.setNumCarros(ran.nextInt(5)+50);
                            if (listaHor.get(j).getDia().equals("Domingo"))nuevo.setNumCarros(ran.nextInt(5)+45);
                        }                   
                    }
                    else{
                        nuevo.setNumCarros(30);
                    }
                    nuevaListaHorarios.add(nuevo);
                }
                
               //Metodo para insertar
                ViaController.InsertarHorariosxvia(nuevaListaHorarios);
                
            }

            //
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
            band = false;
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
             String nombre = v.getNombre();
            
             if (nombre == null)
                v.setNombre(Long.toString(v.getId().getIdVia()) + Integer.toString(v.getId().getIdDistrito()));                       
            //agregar velocidad maxima (aleatorio)
            Random ran = new Random();
            if (v.getTipovia()!=null){
                
                if (v.getTipovia().getIdTipoVia() == 1)
                    v.setVelocidad(ran.nextInt(10) + 30);
                if (v.getTipovia().getIdTipoVia() == 2)
                    v.setVelocidad(ran.nextInt(30) + 30);  
            }else{
                v.setVelocidad(30);
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