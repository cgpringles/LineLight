/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.util.HibernateUtil;
/**
 *
 * @author PC-HP
 */
public class DistritoController {
    //private static List listDistrito;
    //private static List<Distrito> listDistrito;
    
    public static Distrito agregarDistrito(String nombreDistrito, boolean activo)
    {
        Session s=null;
        int idDistrito=-1;
        Distrito d=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            d=new Distrito();
            d.setNombre(nombreDistrito);
            d.setFecRegistro(new Date());
            d.setActivo(new byte[] {(byte)(activo?1:0)});
            if (activo){
                String queryString = "UPDATE Distrito SET activo=?";
                
                Query query = s.createQuery(queryString);
                query.setParameter(0, new byte[] {(byte)0});
                System.out.println("dslnkfdslk ju ja");
                int result = query.executeUpdate();
                System.out.println("dslnkfdslk ju ja "+result);
            }
            
            idDistrito=(int)(s.save(d));
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
        return d;
    }
    
        public static boolean verificarViasDistrito(String nombDistrito){
        boolean viasCargadas = false;
        Session s = null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            List distrito = s.createCriteria(Via.class).add(Restrictions.like("id.idDistrito", 
                    DistritoController.obteneridDistrito(nombDistrito))).list();
            HibernateUtil.cierraOperacion(s); 
            if (distrito.isEmpty()) 
                return false;
            else 
                return true;         
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
        return viasCargadas; 
    }
        
    public static Distrito obtenerDistrito(String nombreDistrito)
    {
        Session s=null;
        Distrito d=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
//            String hq="FROM Distrito WHERE nombre = :nombreDistrito";
//            Query q=s.createQuery(hq);
//            q.setParameter("nombreDistrito", nombreDistrito);
//            List<?> l=q.list();
//            d=(Distrito)(l.get(0));
            List distrito=s.createCriteria(Distrito.class).add(Restrictions.like("nombre", nombreDistrito)).list();
            d=(Distrito)distrito.get(0);
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
        return d;
    }
    
    public static ArrayList<Distrito> obtenerDistritos(){
        Session s=null;
        ArrayList<Distrito> lista= new ArrayList<Distrito>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Distrito order by nombre ";
            lista=(ArrayList<Distrito>) s.createQuery(hql).list();
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
    public static int obteneridDistrito(String nombreDistrito){
        Session s=null;
        int id = 0;
        ArrayList<Distrito> lista= new ArrayList<Distrito>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Distrito WHERE nombre= :nombDistrito";
            Query q=s.createQuery(hql);
            q.setParameter("nombDistrito",nombreDistrito);
            lista=(ArrayList<Distrito>) q.list();
            id = lista.get(0).getIdDistrito();
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
        return id;
    }
    public static String obtenerNombDistrito(Integer idDist){
        Session s=null;
        int id;
        String n=null;
        ArrayList<Distrito> lista= new ArrayList<Distrito>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Distrito WHERE idDistrito= :id";
            Query q=s.createQuery(hql);
            q.setParameter("id",idDist);
            lista=(ArrayList<Distrito>) q.list();
            n=(lista.get(0)).getNombre();
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
    
    
    public static List<Distrito> getDistritos(String nombre) throws HibernateException {
        List<Distrito> listaDistritos = null;
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Distrito u WHERE u.nombre LIKE ?");
            query.setParameter(0, "%" + nombre + "%");

            listaDistritos = query.list();

        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            HibernateUtil.cierraOperacion(s);
        }

        return listaDistritos;
    }
    
    public static Distrito obtenerDistritoActivo()
    {
        Distrito d = null;
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            List<Distrito> distrito=(List<Distrito>)(s.createCriteria(Distrito.class).list());
            
            for (Distrito di:distrito)
            {
                if (di.getActivo()[0]!=0) return di;
            }
            
            d=(Distrito)distrito.get(0);
            HibernateUtil.cierraOperacion(s);

        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            HibernateUtil.cierraOperacion(s);
        }

        return d;
        
    }
    
    static void editarDistrito(Distrito distrito, String nombreDistrito, boolean activo) {
        
        Session s=null;
        s=HibernateUtil.iniciaOperacion();
        
        distrito.setActivo(new byte[] {(byte)(activo?1:0)});
        distrito.setNombre(nombreDistrito);
        if (activo){
            String queryString = "UPDATE Distrito SET activo=?";
            Query query = s.createQuery(queryString);
            query.setParameter(0, new byte[] {(byte)0});
            System.out.println("dslnkfdslk ju ja");
            int result = query.executeUpdate();
            System.out.println("dslnkfdslk ju ja "+result);
        }
        
        s.update(distrito);
        
        HibernateUtil.cierraOperacion(s);
        
    }
    
    public static Distrito obtenerDistritoById(int idDistrito)
    {
        Session s=null;
        Distrito d=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            List distrito=s.createCriteria(Distrito.class).add(Restrictions.eq("idDistrito", idDistrito)).list();
            d=(Distrito)distrito.get(0);
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
        return d;
    }
  
    public static void eliminarDistrito(Distrito distrito){
        Session s=null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            s.delete(distrito);
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
