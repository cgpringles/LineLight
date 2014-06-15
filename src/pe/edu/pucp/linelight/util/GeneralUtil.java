/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import pe.edu.pucp.linelight.controller.UsuarioController;
import pe.edu.pucp.linelight.model.Accion;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.Usuarioxaccion;
import pe.edu.pucp.linelight.model.UsuarioxaccionId;

/**
 *
 * @author Charito
 */
public class GeneralUtil {
    static Usuario usuario_sesion;

    public static void setUsuario_sesion(Usuario usuario_sesion) {
        GeneralUtil.usuario_sesion = usuario_sesion;
    }
    
  

    public static Usuario getUsuario_sesion() {
        return usuario_sesion;
    }

 public static String generatePassword() {
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String pswd = "";
        for (int i = 0; i < 12; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }
        return pswd;
    }
    
 public static void insertaLog(int idAccion, String tabla) throws UnknownHostException{
        
         InetAddress IP=InetAddress.getLocalHost();
         UsuarioxaccionId id= new UsuarioxaccionId();
         id.setIdAccion(idAccion);
         id.setIdUsuario(usuario_sesion.getIdUsuario());
         Accion accion=UsuarioController.getAccionByid(idAccion);
         Usuarioxaccion item=new Usuarioxaccion();
         item.setId(id);
         item.setFecha(new java.sql.Timestamp(new java.util.Date().getTime()));
         item.setUsuario(usuario_sesion);
         item.setAccion(accion);
         item.setIp(IP.getHostAddress());
         item.setTabla(tabla);
         UsuarioController.agregarAccionxUsuario(item);
 }
}
