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
import pe.edu.pucp.linelight.model.EjecucionalgoritmoxsemaforoId;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.HibernateUtil;
import org.hibernate.criterion.Order;
import pe.edu.pucp.linelight.model.Semaforo;

/**
 *
 * @author Angel
 */
public class EjecucionAlgoritmoController {
    
    public static List<Object> vehiculosRobot;
    public static ArrayList<Semaforo> semaforosMapa;
    
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
    
    public static void iniciarSimulacion(int numSemaforos, ArrayList<Semaforo> listaS){
        
        semaforosMapa = listaS;        
        
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
    public static int agregarEjecucionXSemaforo(Ejecucionalgoritmoxsemaforo ejecucionAlgoritmoxsemaforo) {
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
        Individuo individuo = GA.mejorIndividuo;
        int numIdNodos = individuo.getIdNodoSemaforo().length;
        byte[] semafIni = individuo.getSemaforoInicio();
        byte[] semafFin = individuo.getSemaforoFin();
        long[] nodos = individuo.getIdNodoSemaforo();
        
        for (int i=0; i< numIdNodos; i++){
            /*Para cada idNodo del Mejor Individuo*/

            long idNodo = nodos[i];           
            ArrayList<Semaforo> listaSemaforos = semaforoController.obtenerSemaforobyNodo(idNodo);
            if (listaSemaforos != null) {
            
                /* Primer Semaforo de Interseccion*/
                Ejecucionalgoritmoxsemaforo eaxsemaforo = new Ejecucionalgoritmoxsemaforo();
                Usuario user = GeneralUtil.getUsuario_sesion();

                EjecucionalgoritmoxsemaforoId eaxsemaforoId = new EjecucionalgoritmoxsemaforoId();

                eaxsemaforoId.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
                eaxsemaforoId.setIdParamAlgoritmo(1);
                eaxsemaforoId.setIdConfiguracionSistema(1);
                eaxsemaforoId.setIdUsuario(user.getIdUsuario());
                eaxsemaforoId.setIdHorario(horarioid);            

                /*Falta obtener la data real de idNodo y idSemaforo - PARTE DE LUIS*/
                eaxsemaforoId.setIdNodo(idNodo);
                
                System.out.println("Valor de IdSemaforo 1: " + listaSemaforos.get(0).getId().getIdSemaforo());                
                eaxsemaforoId.setIdSemaforo(listaSemaforos.get(0).getId().getIdSemaforo());
                eaxsemaforoId.setIdDistrito(listaSemaforos.get(0).getId().getIdDistrito());
                eaxsemaforo.setId(eaxsemaforoId);

                int tiempoIni = semafIni[i] ;
                int tiempoFin = semafFin[i];
                eaxsemaforo.setTverde(tiempoIni);
                eaxsemaforo.setTrojo(tiempoFin);

                ok = agregarEjecucionXSemaforo(eaxsemaforo); //basta que no se pueda guardar un semaforo entonces saldra      
                if (ok == 0)  {
                    System.out.println("EJECUCIOALGORITMOXSEMAFORO RAZON EN NODO: " + idNodo);
                    //break;
                }
                
                /* Segundo Semaforo de Interseccion*/
                Ejecucionalgoritmoxsemaforo eaxsemaforo2 = new Ejecucionalgoritmoxsemaforo();                

                EjecucionalgoritmoxsemaforoId eaxsemaforoId2 = new EjecucionalgoritmoxsemaforoId();

                eaxsemaforoId2.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
                eaxsemaforoId2.setIdParamAlgoritmo(1);
                eaxsemaforoId2.setIdConfiguracionSistema(1);
                eaxsemaforoId2.setIdUsuario(user.getIdUsuario());
                eaxsemaforoId2.setIdHorario(horarioid);            

                /*Falta obtener la data real de idNodo y idSemaforo - PARTE DE LUIS*/
                eaxsemaforoId2.setIdNodo(idNodo);
                                
                System.out.println("Valor de IdSemaforo 2: " + listaSemaforos.get(1).getId().getIdSemaforo());
                eaxsemaforoId2.setIdSemaforo(listaSemaforos.get(1).getId().getIdSemaforo());
                eaxsemaforoId2.setIdDistrito(listaSemaforos.get(1).getId().getIdDistrito());
                eaxsemaforo2.setId(eaxsemaforoId2);

                tiempoIni = semafFin[i] ;
                tiempoFin = semafIni[i];
                eaxsemaforo2.setTverde(tiempoIni);
                eaxsemaforo2.setTrojo(tiempoFin);

                ok = agregarEjecucionXSemaforo(eaxsemaforo2); //basta que no se pueda guardar un semaforo entonces saldra      
                if (ok == 0)  {
                    System.out.println("EJECUCIOALGORITMOXSEMAFORO RAZON EN NODO: " + idNodo);
                    //break;
                }

            }
        }
        
        return ok;
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
    
    public static List<Ejecucionalgoritmoxsemaforo> obtenerAlgoritmoxSemaforo()
    {
        List<Ejecucionalgoritmoxsemaforo> ejecAlgSem=new ArrayList<>();
        
        Session s = null;         
        try
        {
            s = HibernateUtil.iniciaOperacion();
            ejecAlgSem=(List<Ejecucionalgoritmoxsemaforo>)s.createCriteria(Ejecucionalgoritmoxsemaforo.class)
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
        
        return ejecAlgSem;        
    }
    
        public static List<Ejecucionalgoritmoxsemaforo> getEjecucionxSemaforoById(int idEjecucion) throws HibernateException {
        List<Ejecucionalgoritmoxsemaforo> lista = new ArrayList<>();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM EjecucionalgoritmoxSemaforo u WHERE u.idEjecucionAlgoritmo = ?");
            query.setParameter(0, idEjecucion);

            lista= query.list();
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return lista;
    }
    
}
