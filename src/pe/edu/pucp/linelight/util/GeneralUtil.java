/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.util;

import pe.edu.pucp.linelight.model.Usuario;

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
    
}
