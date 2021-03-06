/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.util;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Charito
 */
public class ValidationUtil {

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail.com";
    
    private static boolean emailvalido;

    public static void validateEmail(String email, java.awt.event.FocusEvent evt) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches() && email.length()!=0 ) {
            Toolkit.getDefaultToolkit().beep();
            evt.getComponent().requestFocus();
            evt.getComponent().setForeground(Color.red);
            emailvalido=false;
        }else{
            evt.getComponent().setForeground(Color.black);
            emailvalido=true;
        }

    }

    public static boolean isEmailvalido() {
        return emailvalido;
    }

    public static void setEmailvalido(boolean emailvalido) {
        ValidationUtil.emailvalido = emailvalido;
    }
    
    

    public static void validateLenght(String cadena, int tam, java.awt.event.KeyEvent evt) {
        if (cadena.length() > tam - 1 || ((evt.getKeyChar()<'a' || evt.getKeyChar()>'z') && (evt.getKeyChar()<'A' || evt.getKeyChar()>'Z'))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

    }
    
    public static void validateLenght2(String cadena, int tam, java.awt.event.KeyEvent evt){
    if (cadena.length() > tam - 1 || ((evt.getKeyChar()<'a' || evt.getKeyChar()>'z') && (evt.getKeyChar() != (char)KeyEvent.VK_SPACE) && 
            (evt.getKeyChar() != (char)KeyEvent.VK_0)
            && (evt.getKeyChar() != (char)KeyEvent.VK_1)
            && (evt.getKeyChar() != (char)KeyEvent.VK_2)
            && (evt.getKeyChar() != (char)KeyEvent.VK_3)
            && (evt.getKeyChar() != (char)KeyEvent.VK_4)
            && (evt.getKeyChar() != (char)KeyEvent.VK_5)
            && (evt.getKeyChar() != (char)KeyEvent.VK_6)
            && (evt.getKeyChar() != (char)KeyEvent.VK_7)
            && (evt.getKeyChar() != (char)KeyEvent.VK_8)
            && (evt.getKeyChar() != (char)KeyEvent.VK_9)
            && (evt.getKeyChar()<'A' || evt.getKeyChar()>'Z'))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }
    
public static void validateLenght3(String cadena, int tam, java.awt.event.KeyEvent evt){
    if (cadena.length() > tam - 1 || ((evt.getKeyChar()<'a' || evt.getKeyChar()>'z') && (evt.getKeyChar() != (char)KeyEvent.VK_SPACE) && 
            (evt.getKeyChar() != (char)KeyEvent.VK_0)
            && (evt.getKeyChar() != (char)KeyEvent.VK_1)
            && (evt.getKeyChar() != '.')
            && (evt.getKeyChar() != (char)KeyEvent.VK_2)
            && (evt.getKeyChar() != (char)KeyEvent.VK_3)
            && (evt.getKeyChar() != (char)KeyEvent.VK_4)
            && (evt.getKeyChar() != (char)KeyEvent.VK_5)
            && (evt.getKeyChar() != (char)KeyEvent.VK_6)
            && (evt.getKeyChar() != (char)KeyEvent.VK_7)
            && (evt.getKeyChar() != (char)KeyEvent.VK_8)
            && (evt.getKeyChar() != (char)KeyEvent.VK_9)
            && (evt.getKeyChar()<'A' || evt.getKeyChar()>'Z'))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }
public static void validateLenght4(String cadena, int tam, java.awt.event.KeyEvent evt){
    if (cadena.length() > tam - 1 || ((evt.getKeyChar()<'a' || evt.getKeyChar()>'z')&& 
            (evt.getKeyChar() != (char)KeyEvent.VK_0)
            && (evt.getKeyChar() != (char)KeyEvent.VK_1)
            && (evt.getKeyChar() != (char)KeyEvent.VK_2)
            && (evt.getKeyChar() != (char)KeyEvent.VK_3)
            && (evt.getKeyChar() != (char)KeyEvent.VK_4)
            && (evt.getKeyChar() != (char)KeyEvent.VK_5)
            && (evt.getKeyChar() != (char)KeyEvent.VK_6)
            && (evt.getKeyChar() != (char)KeyEvent.VK_7)
            && (evt.getKeyChar() != (char)KeyEvent.VK_8)
            && (evt.getKeyChar() != (char)KeyEvent.VK_9)
            && (evt.getKeyChar() != (char)KeyEvent.VK_DELETE)
            
            
            && (evt.getKeyChar()<'A' || evt.getKeyChar()>'Z'))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }
    public static void validateNumTam(String cadena, int tam, java.awt.event.KeyEvent evt) {

        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            if (cadena.length() > tam - 1) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }

    public static void validateDouble(String cadena, int tam, java.awt.event.KeyEvent evt) {
        
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && cadena.contains(".")) {
            if (cadena.length() > tam - 1) {                
                evt.consume();
            }
            evt.consume();
        } else 
            if((car<'0' || car>'9') && (car!='.')){
                evt.consume();
            }
    }
    
    public static void validateCaracteresNumerosSpace(String cadena, int tam, java.awt.event.KeyEvent evt) {

        char car = evt.getKeyChar();        
        if(cadena.length() > tam - 1 || ((car<'0' || car>'9') && (car<'a' || car>'z') && (car<'A' || car>'Z') &&
                    (car!=(char)KeyEvent.VK_SPACE)) )  {
            if (cadena.length() > tam - 1) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
            evt.consume();            
        }           
    }

}
