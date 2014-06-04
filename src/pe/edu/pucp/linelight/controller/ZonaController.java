/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.util.HibernateUtil;

public class ZonaController {
    
    public static void agregarZona(Zona z)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            s.save(z);
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
    
    public static Zona obtenerZonaCentral(int idDistrito)
    {
        Session s=null;
        Zona z=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            List t=s.createCriteria(Zona.class).add(Restrictions.eq("id.idZona", 0)).
                    add(Restrictions.eq("id.idDistrito", idDistrito)).list();
            z=(Zona)(t.get(0));
            HibernateUtil.cierraOperacion(s);
            
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
        
        return z;
    }
    
    public static void eliminarZona(Zona z)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            s.delete(z);
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
    
    
}
