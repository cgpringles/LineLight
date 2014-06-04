/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author Angel
 */
public class ParamAlgoritmoController {
    
    public static void editarParamAlgoritmo(Paramalgoritmo paramAlgoritmo) {
        Session s = null;

        try {
            s=HibernateUtil.iniciaOperacion();
            s.update(paramAlgoritmo);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }
    }    
    
    public static int agregarParamAlgoritmo(Paramalgoritmo paramAlgoritmo) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(paramAlgoritmo);
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
    
    public static Paramalgoritmo getParamAlgoritmoById(int id) throws HibernateException {
        Paramalgoritmo paramAlgoritmo = new Paramalgoritmo();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Paramalgoritmo p WHERE p.idParamAlgoritmo = ?");
            query.setParameter(0, id);

            if (!query.list().isEmpty()) {
                paramAlgoritmo = (Paramalgoritmo) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }
        
        return paramAlgoritmo;
    }
    
    public static int getNextId() {
        int appId=0;
        Session s = null;
        try {
             s = HibernateUtil.iniciaOperacion();
            
            String sequel = "Select max(idParamAlgoritmo) from Paramalgoritmo";
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
