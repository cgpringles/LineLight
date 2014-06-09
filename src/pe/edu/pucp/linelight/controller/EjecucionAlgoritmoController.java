/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.pucp.linelight.algorithm.Config;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Trafico;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author Angel
 */
public class EjecucionAlgoritmoController {
    
    public static List<Object> vehiculosRobot;    
    
    public static int agregarEjecucionAlgoritmo(Ejecucionalgoritmo ejecucionAlgoritmo) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(ejecucionAlgoritmo);
            HibernateUtil.cierraOperacion(s);
            ok = 1;
        } catch (HibernateException e) {
            ok = 0;
            e.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return ok;
    }
    
    public static int getNextId() {
        int id = 0;
        Session s = null;         
        try
        {
            s = HibernateUtil.iniciaOperacion();
                        
            String sequel = "Select max(id.idEjecucionAlgoritmo) from Ejecucionalgoritmo";
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
    
    public static void iniciarSimulacion(){
        
        Paramalgoritmo paramAlgoritmo = ParamAlgoritmoController.getParamAlgoritmoById(1); // podemos usar siempre el primero
        
        int tpi = paramAlgoritmo.getTamPoblacionInicial();
        int tmp = paramAlgoritmo.getMaxTamPoblacion();
        int msc = paramAlgoritmo.getMaxCicloSinCambiar();        
        double tc = paramAlgoritmo.getTasaCasamiento();
        double tm = paramAlgoritmo.getTasaMutacion();
        
        Config.N_CROSS = 0; // para setear en cada simulacion
        GA.trafico.ejecutarAlgoritmo(tpi, tmp, msc, tc, tm); // valores que jala (10, 10, 50, 0.85, 0.1)                
    }
    
    public static void migrarVehiculos(int numVehiculos, List<Object> listaV){
        
        vehiculosRobot = listaV;
        
        GA.trafico = new Trafico(numVehiculos,false); // true vehiculos aleatorio, false vehiculos ya generados        
        GA.trafico.exportarSerializableTrafico();
        GA.trafico.exportarTextoTrafico();
        GA.trafico.imprimirTrafico();
                      
//        GA.trafico = new Trafico(2000,true);
//        GA.trafico.imprimirTrafico();
//        /*Exportar Datos generados en un archivo*/        
//        GA.trafico.exportarSerializableTrafico();
//        GA.trafico.exportarTextoTrafico();
     
//        GA.trafico = new Trafico(numVehiculos);
//        GA.trafico.importarSerializableTrafico();
//        GA.trafico.imprimirTrafico();                
    }
    
}
