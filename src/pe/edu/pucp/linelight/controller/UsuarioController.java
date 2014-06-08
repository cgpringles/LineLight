/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.controller;

import java.util.Arrays;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.pucp.linelight.util.HibernateUtil;
import pe.edu.pucp.linelight.model.Usuario;

/**
 *
 * @author PC-HP
 */
public class UsuarioController {
    
    public static void eliminarUsuario(Usuario usuario) {
        Session s = HibernateUtil.iniciaOperacion();
        usuario.setEstadobd(0);
        try {

            s.update(usuario);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }

    }
    
    
    public static List<Usuario> getAllUsuarios() throws HibernateException {
        List<Usuario> listaUsuarios = null;
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            Query query=null;
            
                query = s.createQuery("FROM Usuario u");

            
            
            listaUsuarios = query.list();
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return listaUsuarios;
    }

    public static void editarUsuario(Usuario usuario) {
        Session s = null;

        try {
            s=HibernateUtil.iniciaOperacion();
            s.update(usuario);
            HibernateUtil.cierraOperacion(s);
        } catch (Exception e) {
            HibernateUtil.manejaExcepcion(s);
            throw e;
        } finally {
            s.close();
        }

    }

    public static int agregarUsuario(Usuario usuario) {
        Session s = null;
        int ok = 0;
        try {
            s = HibernateUtil.iniciaOperacion();
            s.save(usuario);
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

    public static boolean validarUsuario(String idUser, char[] password) {
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            Usuario u = (Usuario) (s.get(Usuario.class, idUser));
            HibernateUtil.cierraOperacion(s);
            if (u != null) {
                String pass = u.getPassword();
                return (Arrays.equals(pass.toCharArray(), password));
            }
            return false;
        } catch (HibernateException e) {
            e.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }
        return false;
    }

    public static List<Usuario> getUsuarios(String usuario, String nombre, String app, String apm, String correo, Integer perfil) throws HibernateException {
        List<Usuario> listaUsuarios = null;
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();
            Query query=null;
            if(perfil==0){
                 query = s.createQuery("FROM Usuario u WHERE u.idUsuario LIKE ?"
                    + " AND u.nombre LIKE ? AND u.app LIKE ? AND u.apm LIKE ? AND u.correo LIKE ?"
                    + " AND u.estadobd=1");
                 query.setParameter(0, "%" + usuario + "%");
            query.setParameter(1, "%" + nombre + "%");
            query.setParameter(2, "%" + app + "%");
            query.setParameter(3, "%" + apm + "%");
            query.setParameter(4, "%" + correo + "%");
            }else{
                query = s.createQuery("FROM Usuario u WHERE u.idUsuario LIKE ?"
                    + " AND u.nombre LIKE ? AND u.app LIKE ? AND u.apm LIKE ? AND u.correo LIKE ?"
                    + " AND u.estadobd=1 AND u.perfil.idPerfil=?");
                query.setParameter(0, "%" + usuario + "%");
            query.setParameter(1, "%" + nombre + "%");
            query.setParameter(2, "%" + app + "%");
            query.setParameter(3, "%" + apm + "%");
            query.setParameter(4, "%" + correo + "%");
                query.setParameter(5, perfil);
            }
            
            listaUsuarios = query.list();
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return listaUsuarios;
    }

    public static Usuario getUsuarioById(String idUsuario) throws HibernateException {
        Usuario usuario = new Usuario();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Usuario u WHERE u.idUsuario = ?");
            query.setParameter(0, idUsuario);

            if (!query.list().isEmpty()) {
                usuario = (Usuario) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return usuario;
    }
    
     public static Usuario getUsuarioByEmail(String email) throws HibernateException {
        Usuario usuario = new Usuario();
        Session s = null;
        try {
            s = HibernateUtil.iniciaOperacion();

            Query query = s.createQuery("FROM Usuario u WHERE u.correo = ?");
            query.setParameter(0, email);

            if (!query.list().isEmpty()) {
                usuario = (Usuario) query.list().get(0);
            }
            HibernateUtil.cierraOperacion(s);
        } catch (HibernateException he) {
            he.printStackTrace();
            HibernateUtil.manejaExcepcion(s);
        } finally {
            s.close();
        }

        return usuario;
    }

}
