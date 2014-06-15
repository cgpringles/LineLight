/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.controller.PerfilController;
import pe.edu.pucp.linelight.model.Menu;
import pe.edu.pucp.linelight.model.Perfil;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author USER
 */
public class editarPerfil extends javax.swing.JFrame {

    
    Perfil perfil= new Perfil();
    int seguridad=1;
    int configuracion=2;
    int optimizacion=3;
    int mantenimiento=4;
    int reportes=5;
    /**
     * Creates new form nuevoUsuario
     */
    public editarPerfil() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/images/semaforo.png")).getImage();
        setIconImage(icon);
        getContentPane().setBackground(new java.awt.Color(240, 240, 240));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public void setPerfil(Perfil perfil){
        this.perfil=perfil;
        this.nombreTxt.setText(perfil.getNombre());
        this.descripcionTxt.setText(perfil.getDescripcion());
        if(perfil.getEstado()==0) this.estadoCmb.setSelectedIndex(1);
        if(perfil.getEstado()==1) this.estadoCmb.setSelectedIndex(0);
        for (Object m : perfil.getMenus()) {
            Menu menu=(Menu)m;
            if(menu.getIdMenu()==1)this.jCheckBox_seguridad.doClick();
            if(menu.getIdMenu()==2)this.jCheckBox_conf.doClick();
            if(menu.getIdMenu()==3)this.jCheckBox_opt.doClick();
            if(menu.getIdMenu()==4)this.jCheckBox_mant.doClick();
            if(menu.getIdMenu()==5)this.jCheckBox_rep.doClick();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        descripcionTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        estadoCmb = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox_seguridad = new javax.swing.JCheckBox();
        jCheckBox_mant = new javax.swing.JCheckBox();
        jCheckBox_opt = new javax.swing.JCheckBox();
        jCheckBox_conf = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCheckBox_rep = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Perfil");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Perfil"));

        jLabel1.setText("Nombre:");

        nombreTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTxtKeyTyped(evt);
            }
        });

        jLabel6.setText("Descripción:");

        descripcionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionTxtKeyTyped(evt);
            }
        });

        jLabel12.setText("Estado:");

        estadoCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel2.setText("Permisos:");

        jCheckBox_seguridad.setText("Seguridad");
        jCheckBox_seguridad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_seguridadStateChanged(evt);
            }
        });
        jCheckBox_seguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_seguridadActionPerformed(evt);
            }
        });

        jCheckBox_mant.setText("Mantenimiento");

        jCheckBox_opt.setText("Optimización");

        jCheckBox_conf.setText("Configuración");

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("(*)");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        jCheckBox_rep.setText("Reportes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26))
                            .addComponent(estadoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_mant)
                            .addComponent(jCheckBox_opt)
                            .addComponent(jCheckBox_conf)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox_seguridad)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel27))
                            .addComponent(jCheckBox_rep))
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(descripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(estadoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox_seguridad)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_mant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_opt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_conf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_rep)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
        if(this.jCheckBox_seguridad.isSelected() || this.jCheckBox_conf.isSelected() 
                || this.jCheckBox_mant.isSelected() || this.jCheckBox_opt.isSelected() || this.jCheckBox_rep.isSelected() ){
        
        int seleccion = JOptionPane.showOptionDialog(
                    editarPerfil.this, // Componente padre
                    "¿Esta seguro que desea guardar los cambios?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
                
                if (seleccion != -1)
                {
                   if(seleccion == 0)
                   {
                      try{
                      Perfil editar_perfil= this.perfil;
                      Set permisos= new HashSet();
                      editar_perfil.setDescripcion(this.descripcionTxt.getText());
                      if(this.estadoCmb.getSelectedIndex()==0)editar_perfil.setEstado(1);
                      if(this.estadoCmb.getSelectedIndex()==1)editar_perfil.setEstado(0);
                      editar_perfil.setNombre(this.nombreTxt.getText());
                      if(this.jCheckBox_conf.isSelected()) permisos.add(PerfilController.getMenuById(configuracion));
                      if(this.jCheckBox_mant.isSelected()) permisos.add(PerfilController.getMenuById(mantenimiento));
                      if(this.jCheckBox_opt.isSelected()) permisos.add(PerfilController.getMenuById(optimizacion));
                      if(this.jCheckBox_seguridad.isSelected()) permisos.add(PerfilController.getMenuById(seguridad));
                      if(this.jCheckBox_rep.isSelected()) permisos.add(PerfilController.getMenuById(reportes));
                      
                      editar_perfil.setMenus(permisos);
                     
                      PerfilController.editarPerfil(editar_perfil);
                      JOptionPane.showMessageDialog(editarPerfil.this, "Perfil editado","Acción",INFORMATION_MESSAGE,null);
                      editarPerfil.this.dispose();
                      GeneralUtil.insertaLog(2, "perfil");
                      } catch(Exception e){
                          e.printStackTrace();
                           JOptionPane.showMessageDialog(editarPerfil.this, "Imposible editar perfil","Error",ERROR_MESSAGE,null);
                
                      
                      }
                      editarPerfil.this.dispose();
                   }
                }
        
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int seleccion = JOptionPane.showOptionDialog(
                    editarPerfil.this, // Componente padre
                    "¿Esta seguro que desea salir sin guardar?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
                
                if (seleccion != -1)
                {
                   if(seleccion == 0)
                   {
                      editarPerfil.this.dispose();
                   }
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox_seguridadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_seguridadStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_seguridadStateChanged

    private void jCheckBox_seguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_seguridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_seguridadActionPerformed

    private void nombreTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTxtKeyTyped
        ValidationUtil.validateLenght(this.nombreTxt.getText(), 20, evt);
    }//GEN-LAST:event_nombreTxtKeyTyped

    private void descripcionTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionTxtKeyTyped
       ValidationUtil.validateLenght(this.descripcionTxt.getText(), 20, evt);
    }//GEN-LAST:event_descripcionTxtKeyTyped

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
            java.util.logging.Logger.getLogger(editarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descripcionTxt;
    private javax.swing.JComboBox estadoCmb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox_conf;
    private javax.swing.JCheckBox jCheckBox_mant;
    private javax.swing.JCheckBox jCheckBox_opt;
    private javax.swing.JCheckBox jCheckBox_rep;
    private javax.swing.JCheckBox jCheckBox_seguridad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreTxt;
    // End of variables declaration//GEN-END:variables
}
