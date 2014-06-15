/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import pe.edu.pucp.linelight.model.Configuracionsistema;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author Angel
 */
public class ConfiguracionSistemaController {
    
    public static void editarConfiguracionSistema(Configuracionsistema configuracionSistema) {
        Session s = null;

        try {
            s=HibernateUtil.iniciaOperacion();
            s.update(configuracionSistema);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }
    }
    
    public static int agregarConfiguracionSistema(Configuracionsistema configuracionSistema) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(configuracionSistema);
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
    
    public static Configuracionsistema getConfiguracionSistemaById(int id) throws HibernateException {
        Configuracionsistema configuracionSistema = new Configuracionsistema();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Configuracionsistema c WHERE c.idConfiguracionSistema = ?");
            query.setParameter(0, id);

            if (!query.list().isEmpty()) {
                configuracionSistema = (Configuracionsistema) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }
        
        return configuracionSistema;
    }
    
    public static int getNextId() {
        int appId=0;
        Session s = null;
        try {
             s = HibernateUtil.iniciaOperacion();
            
            String sequel = "Select max(idConfiguracionSistema) from Configuracionsistema";
            Query q = s.createQuery(sequel);
            List currentSeq = q.list();
            HibernateUtil.cierraOperacion(s);
            if (currentSeq == null) {
                return appId;
            } else {
                appId = (int) currentSeq.get(0);
                return appId + 1;
            }
            
        } catch (HibernateException exc) {
            System.out.print("Unable to get latestID");
            exc.printStackTrace();

        }finally{
            s.close();
        }
        return 0;
    }
    
}