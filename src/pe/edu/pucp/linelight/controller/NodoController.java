/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author PC-HP
 */
public class NodoController {
 
    public static void agregarNodo(List<Nodo> listanodos)
    {
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            for (Nodo n : listanodos)
            {
                s.save(n);
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
    
    public static List<Nodo> obtenerNodoDistrito(int idDistrito)
    {
        Session s=null;
        List<Tramoxnodo> listatxn=null;
        List<Nodo> listaNodos=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            listatxn=(List<Tramoxnodo>)(s.createCriteria(Tramoxnodo.class).add(Restrictions.eq("idDistrito", idDistrito)).list());
            listaNodos=new ArrayList<>();
            for (Tramoxnodo txn:listatxn)
            {
                listaNodos.add(txn.getNodo());
                
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
        
        return listaNodos;
    }
    
    public static Nodo obtenerNodoPorId(Long idNodo)
    {
        Session s=null;
        Nodo n=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            n=(Nodo)(s.createCriteria(Nodo.class).add(Restrictions.eq("idNodo", idNodo)).list()).get(0);
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
        
        return n;
        
    }
    
    
}
