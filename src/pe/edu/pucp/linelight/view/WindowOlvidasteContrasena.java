/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import org.jdesktop.xswingx.PromptSupport;
import pe.edu.pucp.linelight.controller.UsuarioController;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;
import pe.edu.pucp.linelight.util.MailUtil;

/**
 *
 * @author Julio
 */
public class WindowOlvidasteContrasena extends javax.swing.JFrame {

    /**
     * Creates new form WindowOlvidasteContrasena
     */
    public WindowOlvidasteContrasena() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/images/semaforo.png")).getImage();
        setIconImage(icon);
        getContentPane().setBackground(new java.awt.Color(165, 211, 226));
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        PromptSupport.setPrompt("Correo electrónico", emailTextField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailTextField = new javax.swing.JTextField();
        sendPasswordButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusLost(evt);
            }
        });

        sendPasswordButton.setText("Enviar nueva contraseña");
        sendPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPasswordButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Correo electrónico:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(166, Short.MAX_VALUE)
                        .addComponent(sendPasswordButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void sendPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendPasswordButtonActionPerformed
       
        if(ValidationUtil.isEmailvalido()){
            Usuario usuario_correo= UsuarioController.getUsuarioByEmail(this.emailTextField.getText());
        if(usuario_correo.getIdUsuario()!=null){
        String password= GeneralUtil.generatePassword();
        usuario_correo.setPassword(password);
        UsuarioController.editarUsuario(usuario_correo);
                //creamos el objeto correo 
                    MailUtil mail = new MailUtil();
                    //llamamos al metodo send() para enviar el mensaje
                    String mensaje = "<head>\n"
                            + "	<title> --LineLight--</title>\n"
                            + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "	Se le ha generado una nueva contraseña:\n"
                            + "	<p>Usuario: " + usuario_correo.getIdUsuario() + "</p>\n"
                            + "	<p>Contraseña: " + usuario_correo.getPassword() + " </p>\n"
                            + "</body>";
                    
                    if(mail.send(mensaje, usuario_correo.getCorreo())){
                        JOptionPane.showMessageDialog(WindowOlvidasteContrasena.this, "Correo enviado","Acción",INFORMATION_MESSAGE,null);
                        this.dispose();
                    }else{
                    
                         JOptionPane.showMessageDialog(WindowOlvidasteContrasena.this, "No se pudo enviar el correo","Error",ERROR_MESSAGE,null);
                    }
                   
        }else{
            JOptionPane.showMessageDialog(WindowOlvidasteContrasena.this, "Correo no registrado", "Error", ERROR_MESSAGE, null);

        
        }
        
        }
        
 
    }//GEN-LAST:event_sendPasswordButtonActionPerformed

    private void emailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusLost
        ValidationUtil.validateEmail(this.emailTextField.getText(), evt);
    }//GEN-LAST:event_emailTextFieldFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowOlvidasteContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowOlvidasteContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowOlvidasteContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowOlvidasteContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowOlvidasteContrasena().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton sendPasswordButton;
    // End of variables declaration//GEN-END:variables
}
