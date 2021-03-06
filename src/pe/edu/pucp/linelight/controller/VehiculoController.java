/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Ruta;
import pe.edu.pucp.linelight.model.Vehiculo;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.VehiculoId;
import pe.edu.pucp.linelight.model.Vehiculoxnodo;
import pe.edu.pucp.linelight.model.VehiculoxnodoId;
import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.view.PanelSimulacionMonitoreo;

/**
 *
 * @author Angel
 */
public class VehiculoController {

    /**************** CONTROLLER PARA TABLA VEHICULO *****************/
    /*Agrega vehiculo por vehiculo, uno por uno*/
    public static int agregarVehiculo(Vehiculo vehiculo) {
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
    
    /*Agrega lista de vehiculos*/
    public static void agregarVehiculoLista(List<Vehiculo> listaVehiculo)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            for (Vehiculo v : listaVehiculo)
            {
                s.save(v);
            }
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
    }   

    public static int agregarGeneracionVehiculos(int Ejecucionalgoritmoid, int horarioid) {
        
        pe.edu.pucp.linelight.algorithm.Vehiculo[] vehiculos = GA.trafico.getVehiculos();
        int numVehiculos = vehiculos.length;        
        int idVehiculo = getNextId();
        Usuario user = GeneralUtil.getUsuario_sesion();        
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        
        for (int i = 0; i < numVehiculos; i++) {
            
            /*Para cada vehiculo*/
            Vehiculo vehiculo = new Vehiculo();
            VehiculoId vehiculoId = new VehiculoId();

            vehiculoId.setIdVehiculo(idVehiculo + i);
            vehiculoId.setIdParamAlgoritmo(1);
            vehiculoId.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
            vehiculoId.setIdConfiguracionSistema(1);
            vehiculoId.setIdUsuario(user.getIdUsuario());
            vehiculoId.setIdHorario(horarioid);

            vehiculo.setId(vehiculoId);

            Ruta ruta = vehiculos[i].getRoute();

            int posX = ruta.getPosIniX();
            int posY = ruta.getPosIniY();
            vehiculo.setPosInit("" + posX + "," + posY);

            posX = ruta.getPosFinX();
            posY = ruta.getPosFinY();
            vehiculo.setPosFin("" + posX + "," + posY);

            posX = ruta.getActualPosX();
            posY = ruta.getActualPosY();
            vehiculo.setPosActual("" + posX + "," + posY);

            int vel = vehiculos[i].getVelocidad();
            vehiculo.setVelocidad("" + vel);

            listaVehiculos.add(vehiculo);
        }
        
        System.out.println("Cantidad de Vehiculos : " +  listaVehiculos.size());
        VehiculoController.agregarVehiculoLista(listaVehiculos);
             
        /*Guardar el log de insertar*/
        try {
            GeneralUtil.insertaLog(1, "vehiculo"); // 1 por la accion de insertar y 
        } catch (UnknownHostException ex) {
            Logger.getLogger(PanelSimulacionMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idVehiculo;
    }

    public static int getNextId() {
        int id = 0;
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            String sequel = "Select max(id.idVehiculo) from Vehiculo";
            Query q = s.createQuery(sequel);
            List currentSeq = q.list();
            HibernateUtil.cierraOperacion(s);
            if (currentSeq.get(0) == null) {
                id = 0;
            } else {
                id = (int) currentSeq.get(0);
            }

        } catch (HibernateException e) {
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return id + 1;
    }

    /**************** CONTROLLER PARA TABLA VEHICULOXNODO *****************/
    /*Agrega vehiculoxnodo, uno por uno*/
    public static int agregarVehiculoXNodo(Vehiculoxnodo vehiculoxnodo) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(vehiculoxnodo);
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
    
    /*Agrega lista de vehiculoxnodo, toda la ruta del vehiculo*/   
    public static void agregarVehiculoXNdodoLista(List<Vehiculoxnodo> listaVehiculosXNodo)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            for (Vehiculoxnodo vxn : listaVehiculosXNodo)
            {
                s.save(vxn);
            }
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
    }    

    public static int agregarGeneracionVehiculosXNodo(int idInicio, int Ejecucionalgoritmoid, int horarioid) {
        int ok = 0;
        pe.edu.pucp.linelight.algorithm.Vehiculo[] vehiculos = GA.trafico.getVehiculos();
        int numVehiculos = vehiculos.length;
        Usuario user = GeneralUtil.getUsuario_sesion();
        
        for (int i = 0; i < numVehiculos; i++) {

            Ruta ruta = vehiculos[i].getRoute();
            ArrayList<Long> Nodos = ruta.getIdNodoRuta();
            List<Vehiculoxnodo> listaVehiculosXNodo = new ArrayList<>();
            int numNodos = Nodos.size();

            for (int j = 0; j < numNodos; j++) {
                
                /*Para cada Nodo de la Ruta*/
                Vehiculoxnodo vehiculoxnodo = new Vehiculoxnodo();
                VehiculoxnodoId vehiculoxnodoId = new VehiculoxnodoId();

                vehiculoxnodoId.setIdVehiculo(idInicio);
                vehiculoxnodoId.setIdParamAlgoritmo(1);
                vehiculoxnodoId.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);
                vehiculoxnodoId.setIdConfiguracionSistema(1);
                vehiculoxnodoId.setIdUsuario(user.getIdUsuario());
                vehiculoxnodoId.setIdHorario(horarioid);

                long valor = Nodos.get(j);
                vehiculoxnodoId.setIdNodo(valor);

                vehiculoxnodo.setId(vehiculoxnodoId);
                vehiculoxnodo.setTest("Punto " + j);

                listaVehiculosXNodo.add(vehiculoxnodo);
            }            
  
            System.out.println("Cantidad de VehiculosXNodo : " +  listaVehiculosXNodo.size());
            VehiculoController.agregarVehiculoXNdodoLista(listaVehiculosXNodo);
            
            idInicio++;
        }
                
         try {
             GeneralUtil.insertaLog(1, "vehiculoXNodo"); // 1 por la accion de insertar y 
         } catch (UnknownHostException ex) {
             Logger.getLogger(PanelSimulacionMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
         return ok;        
     }

    public static List<Vehiculo> getVehiculosByIdEjecucion(int idEjecucionAlgoritmo) {
             List<Vehiculo> lista = new ArrayList<>();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Vehiculo WHERE idEjecucionAlgoritmo = :id ");
            query.setParameter("id", idEjecucionAlgoritmo);

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