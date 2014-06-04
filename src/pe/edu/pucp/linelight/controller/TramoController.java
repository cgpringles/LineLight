/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;

/**
 *
 * @author PC-HP
 */
public class TramoController {
 
    public static void agregarTramo(List<Tramo> listaTramos)
    {
        Session s=null;
        Long idVia=0L;
        int idDistrito=0;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            
            for (Tramo t : listaTramos)
            {s.save(t);
            idVia=t.getId().getIdVia();
            idDistrito=t.getId().getIdDistrito();
            }
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
    }
    
    
    public static void agregarTramoxNodo(List<Tramoxnodo> listaTramoxNodo)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            for (Tramoxnodo tn: listaTramoxNodo)
                s.save(tn);
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
    }
    
    public static List<Tramoxnodo> obtenerTramosPorDistrito(int idDistrito)
    {
        Session s=null;
        List<Tramoxnodo> listaTramosxNodo=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
//            Query q=s.createQuery("FROM TramoxNodo t left join fetch t.tramoxnodos WHERE t.id.idDistrito = ?");
//            Query q=s.createQuery("FROM Tramoxnodo WHERE TramoxnodoId.idDistrito = ? "
//                                 + "order by txn.TramoxnodoId.idTramo, txn.posicionTramo");
//            q.setParameter(0, idDistrito);
            
            List t=s.createCriteria(Tramoxnodo.class).add(Restrictions.eq("id.idDistrito", idDistrito)).
                    addOrder(Order.asc("id.idVia")).
                    addOrder(Order.asc("id.idTramo")).
                    addOrder(Order.desc("posicionTramo")).list();
            
            listaTramosxNodo=(List<Tramoxnodo>)t;
            
//            for (Tramoxnodo txn: listaTramosxNodo)
//            {
//                Hibernate.initialize(txn.getNodo());
//                Hibernate.initialize(txn.getTramo());
//            }
//            listaTramos=(List<Tramo>)(s.createCriteria(Tramo.class).add(Restrictions.eq("Distrito.idDistrito", idDistrito)).list());
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
        
        return listaTramosxNodo;
    }
    
    
    
}
