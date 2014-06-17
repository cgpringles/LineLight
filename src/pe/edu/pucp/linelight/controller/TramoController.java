/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.ArrayList;
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
            
            List t=s.createCriteria(Tramoxnodo.class,"txn").
                    createAlias("txn.tramo", "tramo").
                    add(Restrictions.eq("txn.id.idDistrito", idDistrito)).
                    add(Restrictions.eq("tramo.estado",true )).
                    addOrder(Order.asc("txn.id.idVia")).
                    addOrder(Order.asc("txn.id.idTramo")).
                    addOrder(Order.desc("txn.posicionTramo")).list();
            
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
    
    public static List<Tramoxnodo> obtenerTramoxNodoXSemaforo(Long idNodo)
    {
        Session s=null;
        List<Tramoxnodo> ltxn=new ArrayList<>();
        List<Tramoxnodo> ltxnInicial=new ArrayList<>();
        try
        {
            s=HibernateUtil.iniciaOperacion();
            ltxn=(List<Tramoxnodo>)s.createCriteria(Tramoxnodo.class).add(Restrictions.eq("posicionTramo", 'F')).
                        add(Restrictions.eq("id.idNodo", idNodo)).
                        list();
            
            
            for (Tramoxnodo txn:ltxn)
            {
                Tramoxnodo t=(Tramoxnodo)s.createCriteria(Tramoxnodo.class).add(Restrictions.eq("id.idVia", txn.getId().getIdVia()))
                        .add(Restrictions.eq("posicionTramo", 'I')).
                        add(Restrictions.eq("id.idTramo", txn.getId().getIdTramo())).list().get(0);
                ltxnInicial.add(t);
            }
            
            //Validamos que tenga fin
            if (ltxn.size()<2)
            {
                Tramoxnodo tn=(Tramoxnodo)s.createCriteria(Tramoxnodo.class).
                                add(Restrictions.ne("id.idVia", ltxn.get(0).getId().getIdVia())).
                                add(Restrictions.eq("posicionTramo",'I' )).list().get(0);
                ltxnInicial.add(tn);
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
        
        return ltxnInicial;
    }
    
    
    
}
