/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.pucp.linelight.algorithm.Poblacion;
import pe.edu.pucp.linelight.algorithm.Individuo;
import pe.edu.pucp.linelight.algorithm.Config;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Trafico;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmoxsemaforo;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import pe.edu.pucp.linelight.util.HibernateUtil;
import org.hibernate.criterion.Order;

/**
 *
 * @author Angel
 */
public class EjecucionAlgoritmoController {
    
    public static List<Object> vehiculosRobot;    
    
    /**************** CONTROLLER PARA TABLA EJECUCIONALGORITMO *****************/
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
               
    }
       
    
    /************** CONTROLLER PARA TABLA EJECUCIONALGORITMOXSEMAFORO *************/
    public static int agregarEjecucionAlgoritmo(Ejecucionalgoritmoxsemaforo ejecucionAlgoritmoxsemaforo) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(ejecucionAlgoritmoxsemaforo);
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
    
    public static int agregarEjecucionAlgoritmoXSemaforo(int Ejecucionalgoritmoid, int horarioid) {
        
        int ok = 0;
        Poblacion poblacion = GA.poblacion;
        int tamPoblacion = GA.poblacion.size(); // longitud del arreglo Individuos o la cantidad de Individuos de la poblacion
        
        for (int i=0; i< tamPoblacion; i++){            
            /*Para cada individuo de la poblacion*/
            Individuo individuo = poblacion.getIndividual(i);
        }
        
        return 0;
    }
    
    public static List<Ejecucionalgoritmo> obtenerConfiguraciónSimulación()
    {
        List<Ejecucionalgoritmo> ejecAlg=new ArrayList<>();
        
        Session s = null;         
        try
        {
            s = HibernateUtil.iniciaOperacion();
            ejecAlg=(List<Ejecucionalgoritmo>)s.createCriteria(Ejecucionalgoritmo.class)
                    .addOrder(Order.asc("id.idEjecucionAlgoritmo")).list();
            HibernateUtil.cierraOperacion(s);
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
        
        return ejecAlg;
    }
}
