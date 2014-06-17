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
import static pe.edu.pucp.linelight.controller.parseViasStructure.band;
import static pe.edu.pucp.linelight.controller.parseViasStructure.parseEdge;
import static pe.edu.pucp.linelight.controller.parseViasStructure.parseNode;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Semaforo;
import pe.edu.pucp.linelight.model.SemaforoId;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.view.DetalleSemaforo;
import pe.edu.pucp.linelight.view.DetalleVias;
import pe.edu.pucp.linelight.view.NuevaVia;
import pe.edu.pucp.linelight.view.NuevoSemaforo;

/**
 *
 * @author Servidor
 */
public class parseSemaforosStructure implements Runnable{
        public static boolean band=false;
        File file;
        Distrito dRef;
        NuevoSemaforo ventana;
        Document document;
        public parseSemaforosStructure(File file, Distrito dRef, NuevoSemaforo ventana) throws DocumentException{
            this.file = file;
            this.dRef = dRef;
            SAXReader reader = new SAXReader();
            this.document = reader.read(file);
            this.ventana = ventana;
            band=false;
        }
    public void run() 
    {
        int numSem = 0;
        
        List<Semaforo> semaforo = new ArrayList<>();        
        Element root = document.getRootElement();
            for ( Iterator i = root.elementIterator("semaforo"); i.hasNext(); ) {
                Element element = (Element) i.next();                
                //int id = Long.parseInt(element.attribute("id").getStringValue());
                long idNodo = Long.parseLong(element.attribute("idNodo").getStringValue());
                Nodo nodo = semaforoController.buscarNodo(idNodo);
                //Obtener datos
                //int distritoId = semaforoController.buscarDistritoNodo(idNodo);
                ArrayList<String> vias = semaforoController.buscarViasNodo(idNodo);               
                //Semaforo 1
               String idSem1 = Long.toString(idNodo) + "1";
               String idSem2 = Long.toString(idNodo) + "2";
               Semaforo semaf = new Semaforo();
               SemaforoId semaforoId = new SemaforoId();
               semaforoId.setIdSemaforo(Long.parseLong(idSem1));
               semaforoId.setIdNodo(idNodo);
               semaforoId.setIdDistrito(dRef.getIdDistrito());
               semaf.setId(semaforoId);
               semaf.setEstado(true);
               semaf.setTrojo(60);
               semaf.setTverde(60);
               semaf.setNodo(nodo);
               semaf.setDistrito_1(dRef.getNombre());
               semaf.setVia1(vias.get(0));
               semaf.setVia2(vias.get(1));
               semaf.setTipo(0);
                //Semaforo 2
               Semaforo semaf2 = new Semaforo();
               SemaforoId semaforoId2 = new SemaforoId();
               semaforoId2.setIdSemaforo(Long.parseLong(idSem2));
               semaforoId2.setIdNodo(idNodo);
               semaforoId2.setIdDistrito(dRef.getIdDistrito());
               semaf2.setId(semaforoId2);
               semaf2.setEstado(true);
               semaf2.setTrojo(60);
               semaf2.setTverde(60);
               semaf2.setNodo(nodo);
               semaf2.setDistrito_1(dRef.getNombre());
               semaf2.setVia1(vias.get(1));
               semaf2.setVia2(vias.get(0));
               semaf2.setTipo(1);
              
               semaforoController.registrarSemaforo(semaf2);
               semaforoController.registrarSemaforo(semaf);
               System.out.print(dRef.getIdDistrito());
               numSem = numSem + 2;  
            }
            System.out.println("Fin carga de xml");
            band=true;
            DetalleSemaforo nuevo = new DetalleSemaforo(numSem,dRef.getNombre());
            this.ventana.dispose();
            nuevo.setVisible(true);
            band = false;
          
    }
}
