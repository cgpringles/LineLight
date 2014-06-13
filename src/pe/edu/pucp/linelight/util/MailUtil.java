
package pe.edu.pucp.linelight.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author roomm
 */
public class MailUtil {

    // partes del mail
    private String user, pass, destino, subject, mensaje;
    //objeto Propierties (parametros del servidor X_X)
    private Properties props;


    public MailUtil() {
        props = new Properties();

    }

    public boolean send(String mensaje, String correo) {
        boolean ok;
        Properties props = new Properties();

// Nombre del host de correo, es smtp.gmail.com
props.setProperty("mail.smtp.host", "smtp.gmail.com");

// TLS si está disponible
props.setProperty("mail.smtp.starttls.enable", "true");

// Puerto de gmail para envio de correos
props.setProperty("mail.smtp.port","587");

// Nombre del usuario
props.setProperty("mail.smtp.user", "linelight2014@gmail.com");

// Si requiere o no usuario y password para conectarse.
props.setProperty("mail.smtp.auth", "true");

        try {
            
            Session session = Session.getDefaultInstance(props);
session.setDebug(true);



MimeMessage message = new MimeMessage(session);

// Quien envia el correo
message.setFrom(new InternetAddress("linelight2014@gmail.com"));

// A quien va dirigido
message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));

message.setSubject("Sistema de Optimización del Tráfico - LineLight");



            message.setContent(mensaje, "text/html");
           
          Transport t = session.getTransport("smtp");
          t.connect("linelight2014@gmail.com","grupo1dp1");
          t.sendMessage(message,message.getAllRecipients());
          t.close();
            ok=true;
        } catch (Exception e) {
            e.printStackTrace();
            ok=false;
        }
        return ok;
    }

    
    
   
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
