/*{
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.util;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.ZonaController;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Zona;

/**
 *
 * @author PC-HP
 */
public class ConvertUtil {
    
    public static int panelHeight;
    public static int panelWidth;

    //Converit KM/H a M/S
    public static double convertirVelocidad(double vKmH)
    {
        return (vKmH*0.278);
        
    }
    
    public static Point2D convertirGPStoPixel(double lat,double lon,Zona z)
    {   
//        double x = (lat * panelHeight / 180.0) + (panelHeight / 2);
        
        
//        double pixelLat=ConfigPanelMapa.height/Math.abs(-12.0618000+12.0746000);
//        double pixelLon=ConfigPanelMapa.width/Math.abs(-77.0490000+77.0708000 );
//        
//        double x=((lon-(-77.0708000))*pixelLon)-3;
//        double y=(Math.abs(lat+12.0618000)*pixelLat)-5;
       Image imagenmapa = new ImageIcon(z.getImagen()).getImage();
        
        //double pixelLat=ConfigPanelMapa.imageHeight/Math.abs(z.getIniLatitud()-z.getFinLatitud());
        //double pixelLon=ConfigPanelMapa.imageWidth/Math.abs(z.getIniLongitud()- z.getFinLongitud());
        
        double pixelLat=imagenmapa.getHeight(null)/Math.abs(z.getIniLatitud()-z.getFinLatitud());
        double pixelLon=imagenmapa.getWidth(null)/Math.abs(z.getIniLongitud()- z.getFinLongitud());
        
        double x=((lon-z.getIniLongitud())*pixelLon)-5;
        double y=(Math.abs(lat - z.getIniLatitud())*pixelLat)-5;
        
        Point2D d = new Point2D.Double(x,y);
        return d;
    }
    
    
    public static int getDistanceLatLong(double lat1,double lat2, double lon1,double lon2)
    {
        double D=Math.pow((lat1-lat2),2) + Math.pow((lon1-lon2), 2);
        double distancia=Math.sqrt(D/2)*157.4*1000;//metros
        return (int) Math.round(distancia);
    }
    
    public static byte[] convertirImageToBytesArray(BufferedImage b)
    {
        byte[] imageInByte=null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( b, "png", baos );
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException ex) {
            Logger.getLogger(ConvertUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageInByte;
    }
    
    public static String convertirNombreSimulacion(String nombreSimulacionBD)
    {
        String[] c=nombreSimulacionBD.split("/");
        return c[0];
    }
    
}
