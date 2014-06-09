/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Distritoxhorario;
import pe.edu.pucp.linelight.model.Horario;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author PC-HP
 */
public class HorarioController {
    
    public static Horario obtenerHorario(String dia, String hora)
    {
        Session s=null;
        Horario h=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            h=(Horario)s.createCriteria(Horario.class).add(Restrictions.eq("hora", hora)).add(Restrictions.eq("dia", dia))
                    .list().get(0);
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
        
        return h;
    }
    
    public static int obtenerCarrosxHorarioxDistrito(int idHorario,int idDistrito)
    {
        Session s=null;
        Distritoxhorario dh=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            dh=(Distritoxhorario)s.createCriteria(Distritoxhorario.class)
               .add(Restrictions.eq("id.idDistrito", idDistrito))
               .add(Restrictions.eq("id.idHorario", idHorario))
               .list().get(0);
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
        
        return dh.getNumCarros();
        
        
    }
    
    
}
