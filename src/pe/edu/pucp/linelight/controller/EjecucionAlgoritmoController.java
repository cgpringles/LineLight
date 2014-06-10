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
            
//            for (int j=)
//            
//            Vehiculo vehiculo = new Vehiculo();
//            Usuario user = GeneralUtil.getUsuario_sesion();
//            
//            VehiculoId vehiculoId = new VehiculoId();
//            int idVehiculo= getNextId();
//            
//            vehiculoId.setIdVehiculo(idVehiculo);                        
//            vehiculoId.setIdParamAlgoritmo(1);
//            vehiculoId.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
//            vehiculoId.setIdConfiguracionSistema(1);
//            vehiculoId.setIdUsuario(user.getIdUsuario());
//            vehiculoId.setIdHorario(horarioid);
//            
//            vehiculo.setId(vehiculoId);
//            
//            int posX = GA.trafico.getVehiculos()[i].getRoute().getPosIniX();
//            int posY = GA.trafico.getVehiculos()[i].getRoute().getPosIniY();            
//            vehiculo.setPosInit("" + posX + "," + posY);
//            
//            posX = GA.trafico.getVehiculos()[i].getRoute().getPosFinX();
//            posY = GA.trafico.getVehiculos()[i].getRoute().getPosFinY();             
//            vehiculo.setPosFin("" + posX + "," + posY);
//            
//            posX = GA.trafico.getVehiculos()[i].getRoute().getActualPosX();
//            posY = GA.trafico.getVehiculos()[i].getRoute().getActualPosY();            
//            vehiculo.setPosActual("" + posX + "," + posY);
//            
//            int vel = GA.trafico.getVehiculos()[i].getVelocidad();
//            vehiculo.setVelocidad("" + vel);
//            
//            ok = agregarVehiculo(vehiculo); //basta que no se pueda guardar un vehiculo entonces saldra      
//            if (ok == 0) break;            
//        }
//              
//        
//        /*Se necesita nombre de simulacion, tiempo de ejecucion*/
//        Ejecucionalgoritmo ejecucionAlgoritmo = new Ejecucionalgoritmo();
//        Usuario user = GeneralUtil.getUsuario_sesion();
//
//        //El id de la ejecucion
//        EjecucionalgoritmoId idEjecucionalgoritmo = new EjecucionalgoritmoId();
//        int Ejecucionalgoritmoid = EjecucionAlgoritmoController.getNextId();
//        idEjecucionalgoritmo.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);                  
//        idEjecucionalgoritmo.setIdParamAlgoritmo(1); // Tome el primer registro de parametros
//        idEjecucionalgoritmo.setIdConfiguracionSistema(1); // Tome el rpimer registro de configuracion
//        idEjecucionalgoritmo.setIdUsuario(user.getIdUsuario());
//
//        int seleccion_dia = this.jComboBox1.getSelectedIndex(); // se captura el dia de simulacion del combobox
//        int seleccion_hora = this.jComboBox2.getSelectedIndex();  // se captura la hora de simulacion del combobox
//        int horarioid = HorarioController.getHorarioId(seleccion_dia, seleccion_hora).getIdHorario();
//        idEjecucionalgoritmo.setIdHorario(horarioid);
//
//        //Registramos la ejecucion
//        ejecucionAlgoritmo.setId(idEjecucionalgoritmo);
//
//        ejecucionAlgoritmo.setFecha(new Date());
//        ejecucionAlgoritmo.setVelocidadMaxima(Double.parseDouble(this.jTextField3.getText()));
//        ejecucionAlgoritmo.setVelocidadHistoria(Double.parseDouble(this.jTextField7.getText()));
//        ejecucionAlgoritmo.setNombreSimulacion(this.jTextField6.getText());
//        ejecucionAlgoritmo.setTiempoEjecucion(Double.parseDouble(this.jTextField4.getText()));
           
}
