/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.util;


import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author PC-HP
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private Transaction tx;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static Session iniciaOperacion()
    {
        Session s=getSessionFactory().openSession();
        s.beginTransaction();
        return s;
    }
    
    public static void manejaExcepcion(Session s)
    {
        s.getTransaction().rollback();
    }
    
    public static void cierraOperacion(Session s)
    {
        s.getTransaction().commit();
    }
}
