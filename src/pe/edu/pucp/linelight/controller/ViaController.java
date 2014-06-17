/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Horario;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.model.Viaxhorario;
import pe.edu.pucp.linelight.util.HibernateUtil;
/**
 *
 * @author Servidor
 */
public class ViaController {
        public static ArrayList<Via> obtenerVias(int idDistrito){
        
    Session s=null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via WHERE idDistrito = :id";
            Query q= s.createQuery(hql);
            q.setParameter("id", idDistrito);
            lista=(ArrayList<Via>) q.list();
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
        
        public static void eliminarVias(String nombDistrito){
        
    Session s=null;
        ArrayList<Long> idNodos = new ArrayList<Long>();
        try
        {
        s = HibernateUtil.iniciaOperacion();
        
        String hql= "SELECT id.idNodo FROM Tramoxnodo WHERE id.idDistrito = :id GROUP BY id.idNodo";
            Query q = s.createQuery(hql);
            q.setParameter("id", DistritoController.obteneridDistrito(nombDistrito));            
            idNodos = (ArrayList<Long>)q.list();

            hql= "DELETE FROM Viaxhorario WHERE id.idDistrito = :id";
            q = s.createQuery(hql);
            q.setParameter("id", DistritoController.obteneridDistrito(nombDistrito));            
            q.executeUpdate();
            
            hql= "DELETE FROM Tramoxnodo WHERE id.idDistrito = :id";
            q = s.createQuery(hql);
            q.setParameter("id", DistritoController.obteneridDistrito(nombDistrito));            
            q.executeUpdate();
            
            hql= "DELETE FROM Tramo WHERE id.idDistrito = :id";
            q = s.createQuery(hql);
            q.setParameter("id", DistritoController.obteneridDistrito(nombDistrito));            
            q.executeUpdate();
            
            hql= "DELETE FROM Via WHERE idDistrito = :id";
            q = s.createQuery(hql);
            q.setParameter("id", DistritoController.obteneridDistrito(nombDistrito));            
            q.executeUpdate();
            
            for (int i = 0; i < idNodos.size(); i++){
                hql= "DELETE FROM Nodo WHERE idNodo = :id";
                q = s.createQuery(hql);
                long idnodo = (long)idNodos.get(i);
                q.setParameter("id", idnodo);            
                q.executeUpdate();
            }
            
            for (int i = 0; i < idNodos.size(); i++){
                hql= "DELETE FROM Semaforo WHERE id.idNodo = :id";
                q = s.createQuery(hql);
                long idnodo = (long)idNodos.get(i);
                q.setParameter("id", idnodo);            
                q.executeUpdate();
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
        
    public static ArrayList<Via> obtenerViasxId(int idTipo){
        
    Session s=null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via WHERE idTipoVia = :id";
            Query q= s.createQuery(hql);
            q.setParameter("id", idTipo);
            lista=(ArrayList<Via>) q.list();
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
     public static ArrayList<Via> obtenerViasxIdxDistrito(int idTipo,int idDistrito){
        
    Session s=null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via WHERE idTipoVia = :id AND idDistrito =:idDist";
            Query q= s.createQuery(hql);
            q.setParameter("id", idTipo);
            q.setParameter("idDist", idDistrito);
            lista=(ArrayList<Via>) q.list();
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
     public static ArrayList<Via> obtenerVias(){
        Session s=null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via order by nombre";
            lista=(ArrayList<Via>) s.createQuery(hql).list();
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
     
     public static ArrayList<Via> buscarVias(String id, String distrito, String tipoVia,String via){
         Session s=null;
         ArrayList<Via> lista= new ArrayList<Via>();
         try
            {
            s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via WHERE idVia ";
            lista=(ArrayList<Via>) s.createQuery(hql).list();
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
     
     public static void agregarVia(List<Via> listaVia)
     {
         Session s=null;
         ArrayList<Via> lista= new ArrayList<Via>();
         try
            {
            s=HibernateUtil.iniciaOperacion();
            
            for (Via v: listaVia)
                s.save(v);
            
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
     
     public static void modificarVia(long idVia,String desc){
        Session s=null;
        try
        {
        s=HibernateUtil.iniciaOperacion();
        String hql="update Via set descripcion= :descrip where idVia= :id";
        Query q= s.createQuery(hql);
        q.setParameter("descrip", desc);
        q.setParameter("id", idVia);
        int result = q.executeUpdate();
        //s.getTransaction().commit();
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
     public static long obtenerIdVia(String nombre, int idTipo, int idDist){
        Session s=null;
        long id = 0;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
            s=HibernateUtil.iniciaOperacion();
            //Criteria crit=s.createCriteria(Via.class);
            //crit.add(Restrictions.conjunction().add(Restrictions.eq("nombre", nombre))).add(Restrictions.conjunction().add(Restrictions.eq("idTipoVia", idTipo))).
              //      add(Restrictions.conjunction().add(Restrictions.eq("idDist", idDist)));
            String hql= "FROM Via WHERE nombre= :nombVia AND idTipoVia= :tipo AND idDistrito= :dist";
            Query q=s.createQuery(hql);
            q.setParameter("nombVia",nombre,Hibernate.STRING);
            q.setParameter("tipo",idTipo);
            q.setParameter("dist",idDist);
            lista=(ArrayList<Via>) q.list();
            id = (long)(((Via)(lista.get(0))).getId().getIdVia());
            
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
     
     public static ArrayList<Tramo> obtenerTramosxVias(long idVia,int idDist){
         Session s=null;
         ArrayList<Tramo> lista= new ArrayList<Tramo>();
          try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Tramo WHERE idVia = :id AND idDistrito =:idDist";
            Query q= s.createQuery(hql);
            q.setParameter("id", idVia);
            q.setParameter("idDist", idDist);
            lista=(ArrayList<Tramo>) q.list();
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
     
     public static void cambiarEstadoTramo(Boolean estado, long idVia,int idDist,int idTramo){
     Session s=null;
        try
        {
        s=HibernateUtil.iniciaOperacion();
        String hql="update Tramo set estado= :estado where idVia= :id AND idDistrito= :dist AND idTramo= :tramo";
        Query q= s.createQuery(hql);
        q.setParameter("estado", estado,Hibernate.BOOLEAN);
        q.setParameter("id", idVia);
        q.setParameter("dist", idDist);
        q.setParameter("tramo", idTramo);
        int result = q.executeUpdate();
        //s.getTransaction().commit();
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

     
    public static ArrayList<Via> obtenerViaCriteria(String identificador, String distrito,String tipoVia, String via){
        ArrayList<Via> vias = new ArrayList<Via>();
        Session s = null;
         
         try{
         s = HibernateUtil.iniciaOperacion();
         Criteria criteria = s.createCriteria(Via.class);
         int idDistrito = 0;
         if (distrito != null)
            idDistrito = DistritoController.obteneridDistrito(distrito);
         int idTipoVia = 0;
         if (tipoVia != null)
                 idTipoVia = TipoViaController.obteneridTipo(tipoVia);
         
         Criterion idViaCriteria = (identificador != null ? Restrictions.eq("id.idVia", Long.parseLong(identificador)) : null);
         Criterion distritoCriteria = (distrito != null ? Restrictions.eq("distrito.idDistrito", idDistrito) : null);
         Criterion viaCriteria = (via != null ? Restrictions.like("nombre", via) : null);
         Criterion tipoViaCriteria = (tipoVia != null ? Restrictions.like("tipovia.idTipoVia", idTipoVia) : null);
         
         if (idViaCriteria != null)
             criteria.add(Restrictions.conjunction().add(idViaCriteria));
         if (distritoCriteria != null)
             criteria.add(Restrictions.conjunction().add(distritoCriteria));
         if (viaCriteria != null)
             criteria.add(Restrictions.conjunction().add(viaCriteria));
         if (tipoViaCriteria != null)
             criteria.add(Restrictions.conjunction().add(tipoViaCriteria));
         criteria.addOrder(Order.desc("nombre"));
         if (idViaCriteria == null && distritoCriteria == null && viaCriteria == null && tipoViaCriteria == null)
             return vias;
         
         vias = (ArrayList<Via>)criteria.list();
         return vias;
         }
         catch (HibernateException e)
         {
            HibernateUtil.manejaExcepcion(s);
         }        
         
        return vias;
    }
    public static int BuscarIdHorario(String hora,String dia){
        Session s=null;
        int id=0;
         ArrayList<Horario> lista= new ArrayList<Horario>();
          try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Horario WHERE hora = :h AND dia =:d";
            Query q= s.createQuery(hql);
            q.setParameter("h", hora);
            q.setParameter("d", dia);
            lista=(ArrayList<Horario>) q.list();
            id=lista.get(0).getIdHorario();
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
    
    public static void modificarNumerodeCarros(Viaxhorario viaxHorario){
      Session s=null;
        try
        {
            
             s = HibernateUtil.iniciaOperacion();
            Transaction nuevoViaxHorario = s.beginTransaction();
            s.update(viaxHorario);
            System.out.println("Se inserto correctamente");
            nuevoViaxHorario.commit();
  
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
    public static int obtenerNumerodeCarros(int idDistrito,int idHorario,long idVia){
        Session s=null;
        int id=0;
         ArrayList<Viaxhorario> lista= new ArrayList<Viaxhorario>();
          try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Viaxhorario WHERE idHorario = :hor AND idVia =:via AND idDistrito= :dist";
            Query q= s.createQuery(hql);
            q.setParameter("hor", idHorario);
            q.setParameter("dist", idDistrito);
            q.setParameter("via", idVia);
            lista=(ArrayList<Viaxhorario>) q.list();
            id=lista.get(0).getNumCarros();
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
    public static ArrayList<Via> obtenerViasxIdDist(int idDist){
        Session s=null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Via WHERE idDistrito = :dist";
            Query q= s.createQuery(hql);
            q.setParameter("dist", idDist);
            lista=(ArrayList<Via>) q.list();
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
    public static ArrayList<Horario> ObtenerHorarios(){
        Session s=null;
        ArrayList<Horario> lista= new ArrayList<Horario>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Horario";
            lista=(ArrayList<Horario>) s.createQuery(hql).list();
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
  public static void InsertarHorariosxvia(ArrayList<Viaxhorario> lista){
          Session s=null;
         //ArrayList<Via> lista= new ArrayList<Via>();
         try
            {
            s=HibernateUtil.iniciaOperacion();
            
            for (Viaxhorario v: lista)
                s.save(v);
            
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
   public static Tramo obtenerTramos(long idVia,int idDist, int idTramo){
         Session s=null;
         Tramo tramo=null;
          try
        {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Tramo WHERE idVia = :id AND idDistrito =:idDist AND idTramo=:idTram";
            Query q= s.createQuery(hql);
            q.setParameter("id", idVia);
            q.setParameter("idDist", idDist);
            q.setParameter("idTram", idTramo);
            tramo= (Tramo) q.list().get(0);
            
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
         
         return tramo;
         
         
     }
  public static ArrayList<Tramoxnodo> obtenerTramoxnodo(long idVia,int idDist,int idTramo){
         Session s=null;
         ArrayList<Tramoxnodo> lista= new ArrayList<Tramoxnodo>();
         try
         {
        s=HibernateUtil.iniciaOperacion();
            String hql= "FROM Tramoxnodo WHERE idVia = :id AND idDistrito =:idDist AND idTramo= :idTram";
            Query q= s.createQuery(hql);
            q.setParameter("id", idVia);
            q.setParameter("idDist", idDist);
            q.setParameter("idTram", idTramo);
            lista=(ArrayList<Tramoxnodo>) q.list();
            
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
    
    
}
