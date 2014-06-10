/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.model.Vehiculo;
import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.algorithm.Trafico;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.VehiculoId;
import pe.edu.pucp.linelight.util.GeneralUtil;

/**
 *
 * @author Angel
 */
public class VehiculoController {
    
    public static int agregarVehiculo(Vehiculo vehiculo)
    {        
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(vehiculo);
            HibernateUtil.cierraOperacion(s);
            ok = 1;
        } catch (HibernateException e) {
            ok = 0;
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return ok;       
    }
    
    public static int agregarGeneracionVehiculos(int Ejecucionalgoritmoid, int horarioid)
    {
        int ok = 0;
        
        for (int i=0; i< GA.trafico.getVehiculos().length; i++){
            /*Para cada vehiculo*/
            
            Vehiculo vehiculo = new Vehiculo();
            Usuario user = GeneralUtil.getUsuario_sesion();
            
            VehiculoId vehiculoId = new VehiculoId();
            int idVehiculo= getNextId();
            
            vehiculoId.setIdVehiculo(idVehiculo);                        
            vehiculoId.setIdParamAlgoritmo(1);
            vehiculoId.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
            vehiculoId.setIdConfiguracionSistema(1);
            vehiculoId.setIdUsuario(user.getIdUsuario());
            vehiculoId.setIdHorario(horarioid);
            
            vehiculo.setId(vehiculoId);
            
            int posX = GA.trafico.getVehiculos()[i].getRoute().getPosIniX();
            int posY = GA.trafico.getVehiculos()[i].getRoute().getPosIniY();            
            vehiculo.setPosInit("" + posX + "," + posY);
            
            posX = GA.trafico.getVehiculos()[i].getRoute().getPosFinX();
            posY = GA.trafico.getVehiculos()[i].getRoute().getPosFinY();             
            vehiculo.setPosFin("" + posX + "," + posY);
            
            posX = GA.trafico.getVehiculos()[i].getRoute().getActualPosX();
            posY = GA.trafico.getVehiculos()[i].getRoute().getActualPosY();            
            vehiculo.setPosActual("" + posX + "," + posY);
            
            int vel = GA.trafico.getVehiculos()[i].getVelocidad();
            vehiculo.setVelocidad("" + vel);
            
            ok = agregarVehiculo(vehiculo); //basta que no se pueda guardar un vehiculo entonces saldra      
            if (ok == 0) break;            
        }

        return ok;       
    }
    
     public static int getNextId() {
        int id = 0;
        Session s = null;         
        try
        {
            s = HibernateUtil.iniciaOperacion();
                        
            String sequel = "Select max(id.idVehiculo) from Vehiculo";
            Query q = s.createQuery(sequel);
            List currentSeq = q.list();
            HibernateUtil.cierraOperacion(s);            
            if  (currentSeq.get(0) == null) {
                id = 0;               
            }
            else {                
                id = (int) currentSeq.get(0);
            }
            
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         
         return id + 1;
    }
    
    
}
