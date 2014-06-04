/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.model.ZonaId;
import pe.edu.pucp.linelight.structure.MapParser;
import pe.edu.pucp.linelight.util.ConvertUtil;

/**
 *
 * @author PC-HP
 */
public class MapaController {
    
    public static void agregarViasMapa(String nombreDistrito, File f)
    {
        int idDistrito=0;
        try {
            MapParser.parseFileGenericMap(f, idDistrito);
        } catch (DocumentException ex) {
            Logger.getLogger(MapaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void agregarMapaDistritoZonas(String nombreDistrito, boolean activo,File f)
    {
        Distrito d = DistritoController.agregarDistrito(nombreDistrito, activo);
        
        agregarZonasADistrito(d,f);

        
    }
    
    public static void agregarZonasADistrito (Distrito distrito, File f){
               
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(f);
            Element root = document.getRootElement();
            for ( Iterator i = root.elementIterator("Zona"); i.hasNext(); ) {
                Element element = (Element) i.next();
                int idZona=Integer.parseInt(element.attribute("id").getStringValue());
                String latIni=element.attribute("latitudIni").getStringValue();
                String lonIni=element.attribute("longitudIni").getStringValue();
                String latFin=element.attribute("latitudFin").getStringValue();
                String lonFin=element.attribute("longitudFin").getStringValue();
                String imgRef=element.attribute("img").getStringValue();
                
                Zona z=new Zona();
                System.out.println("kdfmskd "+ idZona + " " + distrito.getIdDistrito());
                z.setId(new ZonaId(distrito.getIdDistrito(),idZona)); // se cambio el orden de parametros
                z.setIniLatitud(Double.parseDouble(latIni));
                z.setIniLongitud(Double.parseDouble(lonIni));
                z.setFinLatitud(Double.parseDouble(latFin));
                z.setFinLongitud(Double.parseDouble(lonFin));
                File imagen = new File(imgRef);
                try {
                    BufferedImage bi= ImageIO.read(imagen);
                    z.setImagen(ConvertUtil.convertirImageToBytesArray(bi));
                } catch (IOException ex) {
                    Logger.getLogger(MapParser.class.getName()).log(Level.SEVERE, null, ex);
                }
//                z.setImgReferencia(null);
                ZonaController.agregarZona(z);
        }
        } catch (DocumentException ex) {
            Logger.getLogger(MapaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void editarMapa(Distrito distrito, String nombreDistrito, boolean activo, File sourceFile) {
        
        DistritoController.editarDistrito(distrito, nombreDistrito, activo);
        
        if (sourceFile!=null){
            
            for (Object zona : distrito.getZonas()) {
                ZonaController.eliminarZona((Zona)zona);
            }
            
            agregarZonasADistrito(distrito,sourceFile);
            
            
        }
        
    }
}
