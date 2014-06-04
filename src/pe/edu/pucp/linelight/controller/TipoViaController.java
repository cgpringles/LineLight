/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.ArrayList;
import java.util.List;
import javax.management.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.model.Tipovia;

/**
 *
 * @author PC-HP
 */
public class TipoViaController {
    
    public static Tipovia obtenerTipoCalle()
    {
        Session s=null;
        Tipovia t=null;
        try
        {
            
            s=HibernateUtil.iniciaOperacion();
            List lt=s.createCriteria(Tipovia.class).add(Restrictions.like("descripcion", "Calle")).list();
            t=(Tipovia)lt.get(0);
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
        
        return t;
    }
    
    public static Tipovia obtenerTipoAvenida()
    {
        Session s=null;
        Tipovia t=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            List lt=s.createCriteria(Tipovia.class).add(Restrictions.like("descripcion", "Avenida")).list();
            t=(Tipovia)lt.get(0);
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
        
        return t;
    }
     public static ArrayList<Tipovia> obtenerTipos(){
        Session s=null;
        ArrayList<Tipovia> lista= new ArrayList<Tipovia>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Tipovia";
            lista=(ArrayList<Tipovia>) s.createQuery(hql).list();
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
        return lista;
    
    }
     public static int obteneridTipo(String nombVia){
        Session s=null;
        ArrayList<Tipovia> lista= new ArrayList<Tipovia>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
           String hql= "FROM Tipovia WHERE descripcion = :nombTipo";
           org.hibernate.Query q= s.createQuery(hql);
           q.setParameter("nombTipo", nombVia);
           lista=(ArrayList<Tipovia>) q.list();
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
        return lista.get(0).getIdTipoVia();
     
     
     
     }
     public static String obtenernombTipo(int idTipo){
        Session s=null;
        ArrayList<Tipovia> lista= new ArrayList<Tipovia>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
           String hql= "FROM Tipovia WHERE idTipoVia = :id";
           org.hibernate.Query q= s.createQuery(hql);
           q.setParameter("id", idTipo);
           lista=(ArrayList<Tipovia>) q.list();
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
        return lista.get(0).getDescripcion();     
     }
          public static int obtenerVeloc(int idTipo){
        Session s=null;
        ArrayList<Tipovia> lista= new ArrayList<Tipovia>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
           String hql= "FROM Tipovia WHERE idTipoVia = :id";
           org.hibernate.Query q= s.createQuery(hql);
           q.setParameter("id", idTipo);
           lista=(ArrayList<Tipovia>) q.list();
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
        return lista.get(0).getVelocidadMaxima();     
     }
     
     
    
}
