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
import pe.edu.pucp.linelight.model.Menu;
import pe.edu.pucp.linelight.model.Perfil;
import pe.edu.pucp.linelight.util.HibernateUtil;

/**
 *
 * @author Charito
 */
public class PerfilController {

    public static void eliminarPerfil(Perfil perfil) {
        Session s = HibernateUtil.iniciaOperacion();
        perfil.setEstadobd(0);
        try {

            s.update(perfil);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }

    }

    public static void editarPerfil(Perfil perfil) {
        Session s = HibernateUtil.iniciaOperacion();

        try {

            s.update(perfil);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }

    }

    public static int agregarPerfil(Perfil perfil) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(perfil);
            HibernateUtil.cierraOperacion(s);
            ok = 1;
        } catch (HibernateException e) {
            ok = 0;
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return ok;
    }

    public static List<Perfil> getPerfiles(String nombre, String descripcion, int estado) throws HibernateException {
        List<Perfil> listaPerfiles = new ArrayList<>();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            Query query = null;
            if (estado != 0) {
                query = s.createQuery("FROM Perfil p WHERE p.descripcion LIKE ? AND p.nombre LIKE ?"
                        + " AND p.estado = ? AND p.estadobd = 1");
                query.setParameter(0, "%" + descripcion + "%");
                query.setParameter(1, "%" + nombre + "%");
                if (estado == 1) {
                    query.setParameter(2, 1);
                } else {
                    query.setParameter(2, 0);
                }

            } else {
                query = s.createQuery("FROM Perfil p WHERE p.descripcion LIKE ? AND p.nombre LIKE ?"
                        + " AND p.estadobd=1");
                query.setParameter(0, "%" + descripcion + "%");
                query.setParameter(1, "%" + nombre + "%");
            }
            listaPerfiles = query.list();
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return listaPerfiles;
    }
    
    public static List<Perfil> getAllPerfiles() throws HibernateException {
        List<Perfil> listaPerfiles = new ArrayList<>();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            Query query = null;
         
                query = s.createQuery("FROM Perfil p");

            listaPerfiles = query.list();
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return listaPerfiles;
    }
    
    
    public static Perfil getPerfilId(int idPerfil) throws HibernateException {
        Perfil perfil = new Perfil();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Perfil p WHERE p.idPerfil = ?");
            query.setParameter(0, idPerfil);

            if (!query.list().isEmpty()) {
                perfil = new Perfil();
                Hibernate.initialize(perfil.getMenus());
                perfil=(Perfil) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return perfil;
    }

    public static Menu getMenuById(int idMenu) throws HibernateException {
        Menu menu = new Menu();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Menu p WHERE p.idMenu = ?");
            query.setParameter(0, idMenu);

            if (!query.list().isEmpty()) {
                menu = (Menu) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return menu;
    }

    public static int getNextId() {
        int appId=0;
        Session s = null;
        try {
             s = HibernateUtil.iniciaOperacion();
            
            String sequel = "Select max(idPerfil) from Perfil";
            Query q = s.createQuery(sequel);
            List currentSeq = q.list();
            HibernateUtil.cierraOperacion(s);
            if (currentSeq == null) {
                return appId;
            } else {
                appId = (int) currentSeq.get(0);
                return appId + 1;
            }
            
        } catch (HibernateException exc) {
            System.out.print("Unable to get latestID");
            exc.printStackTrace();

        }finally{
            s.close();
        }
        return 0;

    }
}
