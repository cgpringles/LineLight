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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Ruta;
import pe.edu.pucp.linelight.model.Vehiculo;

import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.algorithm.Trafico;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.VehiculoId;
import pe.edu.pucp.linelight.model.Vehiculoxnodo;
import pe.edu.pucp.linelight.model.VehiculoxnodoId;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.view.PanelSimulacionMonitoreo;

/**
 *
 * @author Angel
 */
public class VehiculoController {

    /**
     * ************** CONTROLLER PARA TABLA VEHICULO ****************
     */
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

    public static int agregarGeneracionVehiculos(int Ejecucionalgoritmoid, int horarioid) {
        int ok = 0;
        pe.edu.pucp.linelight.algorithm.Vehiculo[] vehiculos = GA.trafico.getVehiculos();
        int numVehiculos = vehiculos.length;
        int idInicio = 0;

        for (int i = 0; i < numVehiculos; i++) {
            /*Para cada vehiculo*/

            Vehiculo vehiculo = new Vehiculo();
            Usuario user = GeneralUtil.getUsuario_sesion();

            VehiculoId vehiculoId = new VehiculoId();
            int idVehiculo = getNextId();
            if (i == 0) {
                idInicio = idVehiculo;
            }

            vehiculoId.setIdVehiculo(idVehiculo);
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

            ok = agregarVehiculo(vehiculo); //basta que no se pueda guardar un vehiculo entonces saldra
            if (ok == 0) {
                System.out.println("ERROR AL INTENTAR GUARDAR VEHICULO " + i);
            }

        }
        
        try {
            GeneralUtil.insertaLog(1, "vehiculo"); // 1 por la accion de insertar y 
        } catch (UnknownHostException ex) {
            Logger.getLogger(PanelSimulacionMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idInicio;
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

    /**
     * ************** CONTROLLER PARA TABLA VEHICULOXNODO ****************
     */
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

    public static int agregarGeneracionVehiculosXNodo(int idInicio, int Ejecucionalgoritmoid, int horarioid) {
        int ok = 0;
        pe.edu.pucp.linelight.algorithm.Vehiculo[] vehiculos = GA.trafico.getVehiculos();
        int numVehiculos = vehiculos.length;

        for (int i = 0; i < numVehiculos; i++) {

            Ruta ruta = vehiculos[i].getRoute();
            ArrayList<Long> Nodos = ruta.getIdNodoRuta();
            int numNodos = Nodos.size();

            for (int j = 0; j < numNodos; j++) {
                /*Para cada Nodo de la Ruta*/

                Vehiculoxnodo vehiculoxnodo = new Vehiculoxnodo();
                Usuario user = GeneralUtil.getUsuario_sesion();

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

                ok = agregarVehiculoXNodo(vehiculoxnodo); //basta que no se pueda guardar un vehiculo entonces saldra      
                if (ok == 0) {
                    System.out.println("VEHICULOXNODO RAZON EN NODO: " + valor);
                    //break;
                }
            }
            idInicio++;
            
         }
         
         try {
             GeneralUtil.insertaLog(1, "vehiculoXNodo"); // 1 por la accion de insertar y 
         } catch (UnknownHostException ex) {
             Logger.getLogger(PanelSimulacionMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return ok;        
     }
     
//   

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
