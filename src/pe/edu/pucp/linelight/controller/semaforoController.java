/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Semaforo;
import pe.edu.pucp.linelight.model.SemaforoId;
import pe.edu.pucp.linelight.model.Tipovia;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.util.HibernateUtil;


/**
 *
 * @author Servidor
 */
public class semaforoController {
    
     public static boolean registrarSemaforo(Semaforo semaforo)
    {
        Session s = null;
        try
        {
            s = HibernateUtil.iniciaOperacion();
            Transaction nuevoSemaforo = s.beginTransaction();
            s.save(semaforo);
            System.out.println("Se inserto correctamente");
            nuevoSemaforo.commit();
           
            //HibernateUtil.cierraOperacion(s);
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
     return true;
    }
     
     public static boolean actualizarSemaforo(Semaforo semaforo)
    {
        Session s = null;
        try
        {
            s = HibernateUtil.iniciaOperacion();
            Transaction nuevoSemaforo = s.beginTransaction();
            s.update(semaforo);
            System.out.println("Se inserto correctamente");
            nuevoSemaforo.commit();
            
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
     return true;
    }
     
     public static Nodo buscarNodo (long nodoId){
         Nodo nodo = new Nodo();
         Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Nodo WHERE idNodo =" + nodoId);         
            List resList = query.list();
            
            HibernateUtil.cierraOperacion(s);
            
            return (Nodo)resList.get(0);
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         return nodo;
     }
         
     public static int obtenerIdSemaforo(){
         int id = 0;
         Session s = null;
         
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Semaforo ORDER BY id.idSemaforo desc");         
            List resList = null;
            resList = query.list();
            if (resList == null)
                id = ((Semaforo)query.list().get(0)).getId().getIdSemaforo();
            else
                id = 0;
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
         
         return id + 1;
     }    
     
     public static Semaforo obtenerSemaforo(int idSemaforo){
         Semaforo semaforo = new Semaforo();
         Session s = null;
         
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Semaforo WHERE id.idSemaforo = :semaforoId");   
            query.setParameter("semaforoId", idSemaforo);
            semaforo = (Semaforo)query.list().get(0);
            
            HibernateUtil.cierraOperacion(s);
            return semaforo;
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         
         return semaforo;
     } 
          
     public static long obtenerIdNodo (Via via1, Via via2){
        Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("SELECT t.id.idNodo FROM Via v, Tramoxnodo t WHERE v.id.idVia = :via2 and v.id.idVia = t.id.idVia");
            query.setParameter("via2", via2.getId().getIdVia());
            List resList = query.list();
            //Obtenemos el idNodo
            query = s.createQuery("SELECT t.id.idNodo FROM Via v, Tramoxnodo t WHERE v.id.idVia = :via1 and v.id.idVia = t.id.idVia and t.id.idNodo IN (:resList)");
            query.setParameter("via1", via1.getId().getIdVia());
            query.setParameterList("resList", resList);
            List nodoEncontrado = query.list();
            if (nodoEncontrado.isEmpty())
                return 0;
            long nodoId = (long)nodoEncontrado.get(0);
            //
            HibernateUtil.cierraOperacion(s);
            
            return nodoId;
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         return 0;
     }
     
     public static String obtenerDistritoxNombreVia(String nombreVia){
        Session s=null;
        String nombreDistrito = null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
        Query query = s.createQuery("SELECT d.nombre FROM Via v, Distrito d WHERE v.id.idDistrito = d.idDistrito and v.nombre = :nombreVia");
        query.setParameter("nombreVia", nombreVia);
        nombreDistrito = (String)query.list().get(0);
        
        HibernateUtil.cierraOperacion(s);   
        return nombreDistrito;
        }
        catch (HibernateException e)
        {
        HibernateUtil.manejaExcepcion(s);
        }
        finally
        {
            s.close();  
        }
        return nombreDistrito;
     }
     
     public static ArrayList<Semaforo> obtenerSemaforosCoincidencia(String busquedaCoincidencia){
         Session s = null;
         ArrayList<Semaforo> semaforosCriteria = new ArrayList<Semaforo>();
         try{
         s = HibernateUtil.iniciaOperacion();
         Criteria criteria = s.createCriteria(Semaforo.class);
         
 
         Criterion via1Criteria = (busquedaCoincidencia == null ? Restrictions.isNotNull("via1") : Restrictions.like("via1", "%"+busquedaCoincidencia+"%"));
         Criterion via2Criteria = (busquedaCoincidencia == null ? Restrictions.isNotNull("via2") : Restrictions.like("via2", "%"+busquedaCoincidencia+"%"));
         
         
         
         Criterion completaCriteria = Restrictions.disjunction().add(via1Criteria)
                                        .add(via2Criteria);
         criteria.add(completaCriteria);
         
         semaforosCriteria = (ArrayList<Semaforo>)criteria.list();
         return semaforosCriteria;
         }
         catch (HibernateException e)
         {
            HibernateUtil.manejaExcepcion(s);
         }        
         return semaforosCriteria;
     }
             
             
             
     public static ArrayList<Semaforo> obtenerSemaforosCriteria(String estado, String identificador, String distrito,String tipoVia1,String tipoVia2,String via1,String via2){
         Session s = null;
         ArrayList<Semaforo> semaforosCriteria = new ArrayList<Semaforo>();
         try{
         s = HibernateUtil.iniciaOperacion();
         Criteria criteria = s.createCriteria(Semaforo.class);
         ArrayList<String> nombreVias = new ArrayList<String>();  
         ArrayList<String> nombreViasTipo1 = new ArrayList<String>();  
         ArrayList<String> nombreViasTipo2 = new ArrayList<String>();  
         
         if (distrito != null){
         int idDistrito = DistritoController.obteneridDistrito(distrito);
                   ArrayList<Via> vias = ViaController.obtenerVias(idDistrito);
                          
                   //Cargamos lista de vias para la criteria de vias que pertenecen a un distrito
                   for (int i = 0; i < vias.size(); i++)
                       nombreVias.add(vias.get(i).getNombre());
         }
         int estadoSemaforo = -1;
         boolean estadoSem = true;
         if (estado != null && estado.equals("Habilitado")) {estadoSem = true; estadoSemaforo = 1;}
         if (estado != null && estado.equals("Deshabilitado")) {estadoSem = false; estadoSemaforo = 1;}
         
         Criterion idSemaforoCriteria = (identificador == null ? Restrictions.isNotNull("id.idSemaforo") : Restrictions.eq("id.idSemaforo", Integer.parseInt(identificador)));
         
         Criterion distritoCriteria = Restrictions.or(distrito == null ? Restrictions.isNotNull("via1") : Property.forName("via1").in(nombreVias), 
                 distrito == null ? Restrictions.isNotNull("via2") : Property.forName("via2").in(nombreVias));
         
         Criterion via1Criteria =  (via1 == null ? Restrictions.isNotNull("via1") : Restrictions.eq("via1", via1));
         
         Criterion via2Criteria = (via2 == null ? Restrictions.isNotNull("via2") : Restrictions.eq("via2", via2));
         
         Criterion estadoCriteria = (estadoSemaforo == -1 ? Restrictions.isNotNull("estado") : Restrictions.eq("estado", estadoSem));
         
         Criterion completaCriteria = Restrictions.conjunction().add(idSemaforoCriteria)
                                        .add(distritoCriteria)
                                        .add(via1Criteria)
                                        .add(via2Criteria)
                                        .add(estadoCriteria);
         criteria.add(completaCriteria);
         
         semaforosCriteria = (ArrayList<Semaforo>)criteria.list();
         return semaforosCriteria;
         }
         catch (HibernateException e)
         {
            HibernateUtil.manejaExcepcion(s);
         }        
         return semaforosCriteria;
     }
     
      public static int obteneridTipo(String nombVia){
        Session s=null;
        int idTipo = 0;
        ArrayList<Tipovia> lista= new ArrayList<Tipovia>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
           String hql= "FROM Tipovia WHERE descripcion = :nombTipo";
           org.hibernate.Query q= s.createQuery(hql);
           q.setParameter("nombTipo", nombVia);
           lista=(ArrayList<Tipovia>) q.list();
           idTipo = lista.get(0).getIdTipoVia();
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
        return idTipo;
     }
          
          
          
        public static String obtenerNombreTipoViaxVia(String nombreTipoVia){
        Session s=null;
        String nombreDistrito = null;
        ArrayList<Via> lista= new ArrayList<Via>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
        Query query = s.createQuery("SELECT d.descripcion FROM Via v, Tipovia d WHERE v.tipovia.idTipoVia = d.idTipoVia and v.nombre = :nombreVia");
        query.setParameter("nombreVia", nombreTipoVia);
        nombreDistrito = (String)query.list().get(0);
        
        HibernateUtil.cierraOperacion(s);   
        return nombreDistrito;
        }
        catch (HibernateException e)
        {
        HibernateUtil.manejaExcepcion(s);
        }
        finally
        {
            s.close();  
        }
        return nombreDistrito;
     }
        
        public static int buscarDistritoNodo (long nodoId){
         int idDistrito = 0;
         Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Tramoxnodo WHERE id.idNodo =" + nodoId);         
            List resList = query.list();
            
            HibernateUtil.cierraOperacion(s);
            
            return ((Tramoxnodo)resList.get(0)).getId().getIdDistrito();
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         return idDistrito;
     }
        public static String obtenerNombreViaxId (long viaId){
         String nombreVia = null;
         Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Via WHERE id.idVia =" + viaId);         
            List resList = query.list();
            
            HibernateUtil.cierraOperacion(s);
            
            return ((Via)resList.get(0)).getNombre();
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         return nombreVia;
     }
        
         public static ArrayList<String> buscarViasNodo (long nodoId){
         ArrayList<String> vias = new ArrayList<String>();
         Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Tramoxnodo WHERE id.idNodo =" + nodoId + "GROUP BY id.idVia");         
            List resList = query.list();
            
            HibernateUtil.cierraOperacion(s);
            String via1 = semaforoController.obtenerNombreViaxId(((Tramoxnodo)resList.get(0)).getId().getIdVia());
            String via2 = semaforoController.obtenerNombreViaxId(((Tramoxnodo)resList.get(1)).getId().getIdVia());         
            vias.add(via1);
            vias.add(via2);
            return vias;
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
         return vias;
     }
         
        public static int parseSemaforos(File file,Distrito dRef) throws DocumentException
    {
        int numSem = 0;
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        List<Semaforo> semaforo = new ArrayList<>();
        
        Element root = document.getRootElement();
        
            for ( Iterator i = root.elementIterator("semaforo"); i.hasNext(); ) {
                Element element = (Element) i.next();                
                int id = Integer.parseInt(element.attribute("id").getStringValue());
                long idNodo = Long.parseLong(element.attribute("idNodo").getStringValue());
                Nodo nodo = semaforoController.buscarNodo(idNodo);
                //Obtener datos
                int distritoId = semaforoController.buscarDistritoNodo(idNodo);
                ArrayList<String> vias = semaforoController.buscarViasNodo(idNodo);
                
                //Semaforo 1
               Semaforo semaf = new Semaforo();
               SemaforoId semaforoId = new SemaforoId();
               semaforoId.setIdSemaforo(id);
               semaforoId.setIdNodo(idNodo);
               semaf.setId(semaforoId);
               semaf.setEstado(true);
               semaf.setTrojo(60);
               semaf.setTverde(60);
               semaf.setNodo(nodo);
               semaf.setDistrito(DistritoController.obtenerNombDistrito(distritoId));
               semaf.setVia1(vias.get(0));
               semaf.setVia2(vias.get(1));
                //Semaforo 2
               Semaforo semaf2 = new Semaforo();
               SemaforoId semaforoId2 = new SemaforoId();
               semaforoId2.setIdSemaforo(id + 1);
               semaforoId2.setIdNodo(idNodo);
               semaf2.setId(semaforoId2);
               semaf2.setEstado(true);
               semaf2.setTrojo(60);
               semaf2.setTverde(60);
               semaf2.setNodo(nodo);
               semaf2.setDistrito(DistritoController.obtenerNombDistrito(distritoId));
               semaf2.setVia1(vias.get(1));
               semaf2.setVia2(vias.get(0));
               semaforoController.registrarSemaforo(semaf2);
               semaforoController.registrarSemaforo(semaf);
               numSem = numSem + 2;
               
            }
            
           // TramoController.agregarTramoxNodo(listaTramoxNodo);
            System.out.println("Fin carga de xml");
            return numSem;
    }

    public static Semaforo obtenerHermano(Semaforo semaforo) {
    Semaforo semaforoHermano = new Semaforo();
    Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            Criteria semaforoCriteria = s.createCriteria(Semaforo.class);
            Criterion via1Criteria =  (Restrictions.eq("via1", semaforo.getVia2()));       
            Criterion via2Criteria = (Restrictions.eq("via2", semaforo.getVia1()));
            semaforoCriteria.add(Restrictions.and(via2Criteria, via1Criteria));
            semaforoHermano = (Semaforo)semaforoCriteria.list().get(0);          
            HibernateUtil.cierraOperacion(s);
            return semaforoHermano;
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
    return semaforoHermano;
    }
    
     public static boolean verificarSemaforoDistrito(String nombDistrito){
        boolean semaforosCargadas = false;
        Session s = null;
        try
        {
            s=HibernateUtil.iniciaOperacion();
            List semaforo = s.createCriteria(Semaforo.class).add(Restrictions.like("distrito", 
                    nombDistrito)).list();
            HibernateUtil.cierraOperacion(s); 
            if (semaforo.isEmpty()) 
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
        return semaforosCargadas; 
    }

    public static void eliminarSemaforos(String nombDistrito) {
    Session s=null;
        ArrayList<Long> idNodos = new ArrayList<Long>();
        try
        {
        s = HibernateUtil.iniciaOperacion();
       
            String hql= "DELETE FROM Semaforo WHERE distrito like :nombre";
            Query q = s.createQuery(hql);
            q.setParameter("nombre", nombDistrito);            
            q.executeUpdate();
            ;
            
            
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

    public static ArrayList<Semaforo> obtenerSemaforosxdistrito(String nombreDist) {
        Session s=null;
        ArrayList<Semaforo> lista= new ArrayList<Semaforo>();
        try
        {
        s=HibernateUtil.iniciaOperacion();
        Query query = s.createQuery("FROM Semaforo WHERE distrito like (:nombreVia)");
        query.setParameter("nombreVia", nombreDist);
        lista = (ArrayList<Semaforo>)query.list();
        
        HibernateUtil.cierraOperacion(s);   
        return lista;
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

    public static boolean verificarSemaforo(long nodoId) {
        Session s = null;
        
        try
        {
            s = HibernateUtil.iniciaOperacion();
            
            //Obtenemos lista de restriccion
            Query query = s.createQuery("FROM Semaforo WHERE id.idNodo = :nodoId");
            query.setParameter("nodoId", nodoId);
          
            
            List nodoEncontrado = query.list();
            HibernateUtil.cierraOperacion(s);
            if (nodoEncontrado.isEmpty())
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
         return true;
    }
    
    
    public static ArrayList<Semaforo> obtenerSemaforobyNodo(long nodoId) {
    ArrayList<Semaforo> semaforoHermano = new ArrayList<Semaforo>();
    Session s = null;       
        try
        {
            s = HibernateUtil.iniciaOperacion();
            Criteria semaforoCriteria = s.createCriteria(Semaforo.class);
            Criterion nodoIdCriteria =  (Restrictions.eq("via1", nodoId));       
            semaforoCriteria.add(nodoIdCriteria);
            semaforoHermano = (ArrayList<Semaforo>)semaforoCriteria.list(); 
            HibernateUtil.cierraOperacion(s);
            if (semaforoHermano.isEmpty())
                return null;
            return semaforoHermano;
        }
        catch (HibernateException e)
        {
            HibernateUtil.manejaExcepcion(s);
        }
        finally 
        {
            s.close();
        }
    return semaforoHermano;
    }    
   
}
