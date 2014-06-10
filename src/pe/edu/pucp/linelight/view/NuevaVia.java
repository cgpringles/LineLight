/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.dom4j.DocumentException;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.ViaController;
import pe.edu.pucp.linelight.controller.jcThread;
import pe.edu.pucp.linelight.controller.parseViasStructure;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Via;
import pe.edu.pucp.linelight.structure.MapParser;

/**
 *
 * @author USER
 */
public class NuevaVia extends javax.swing.JFrame {

    /**
     * Creates new form NuevaVia
     */
    public NuevaVia() {
        initComponents();
        jProgressBar1.setVisible(false);
        lblprogreso.setVisible(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        cmbDistrito.setEnabled(true);
        cmbDistrito.addItem("Seleccione");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        ArrayList<Distrito> listDist=new ArrayList<Distrito>();
        listDist=DistritoController.obtenerDistritos();
       for (int i=0; i<listDist.size();i++){
            cmbDistrito.addItem(listDist.get(i).getNombre());          
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

        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblprogreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Vías");

        jLabel21.setText("Selecciona un archivo:");

        jLabel1.setText("Distrito:");

        cmbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDistritoActionPerformed(evt);
            }
        });

        jLabel23.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("(*)");

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("(*) Datos Obligatorios");

        jButton4.setText("Registrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lblprogreso.setText("Registrando vías... ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel1))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDistrito, 0, 133, Short.MAX_VALUE)
                                    .addComponent(txtFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblprogreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblprogreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        //Cargar masivo
        String nombDistrito=(String)cmbDistrito.getSelectedItem();
                     
         //Fin carga Masiva 
        int seleccion = JOptionPane.showOptionDialog(
                    NuevaVia.this, // Componente padre
                    "¿Esta seguro que desea registrar las vias?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
        //Dependiendo de la seleccion
        if (seleccion != -1)//si ha seleccionado alguna opcion
                {
                   if(seleccion == 1)//si ha seleccionado no
                   {
                      NuevaVia.this.dispose();
                   }
                   else //si ha seleccionado si
                   {
                       //Distrito ya tiene vias?
                       boolean viasCargadas = false;
                       viasCargadas = DistritoController.verificarViasDistrito(nombDistrito);
                       //
                       if (viasCargadas == true)
                            seleccion = JOptionPane.showOptionDialog(
                            NuevaVia.this, // Componente padre
                            "El distrito ya cuenta con vias registras. ¿Desea sobreescribir la información?", //Mensaje
                            "Mensaje de confirmación", // Título
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                            "Si");
                       if (seleccion == 0 || viasCargadas == false){
                           //borrar toda la data
                           if (viasCargadas == true)
                               ViaController.eliminarVias(nombDistrito);
                                    JFileChooser fc = new JFileChooser();
                                          FileNameExtensionFilter filter = new FileNameExtensionFilter("XML","xml");
                                          fc.setFileFilter(filter);
                                          int returnVal = fc.showOpenDialog(this);
                                              if (returnVal == JFileChooser.APPROVE_OPTION) {
                                                  File sourceFile = fc.getSelectedFile();
                                                  Distrito d=DistritoController.obtenerDistrito(nombDistrito);

                                                  try {
                                                      jProgressBar1.setVisible(true);
                                                      lblprogreso.setVisible(true);
                                                      jButton4.setEnabled(false);
                                                      jButton5.setEnabled(false);
                                                      cmbDistrito.setEnabled(false);
                                                      new Thread(new jcThread( this.jProgressBar1 , 250) ).start();
                                                      new Thread(new parseViasStructure(sourceFile,d,this)).start();
                                                  } catch (DocumentException ex) {
                                                      Logger.getLogger(WindowPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                                  }

                                              } 
                                              else {
                                                  System.out.print("Open command cancelled by user.");
                                              }
                        }
                   }
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         int seleccion = JOptionPane.showOptionDialog(
                    NuevaVia.this, // Componente padre
                    "¿Esta seguro que desea salir sin guardar los cambios?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
        //Dependiendo de la seleccion
        if (seleccion != -1)//si ha seleccionado alguna opcion
                {
                   if(seleccion == 1)//si ha seleccionado no
                   {
                     // EditarVia.this.dispose();
                   }
                   else //si ha seleccionado si
                   {
                       
                       this.dispose();

                   }
                }  
        
        
        //this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void cmbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDistritoActionPerformed
        // TODO add your handling code here:
        if (cmbDistrito.getSelectedIndex() != 0){
        Distrito distrito = DistritoController.obtenerDistrito((String)cmbDistrito.getSelectedItem());
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
        txtFecha.setText(sdf.format(distrito.getFecRegistro()));
        }else{
            txtFecha.setText("");
        }
        
    }//GEN-LAST:event_cmbDistritoActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaVia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaVia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaVia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaVia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaVia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDistrito;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblprogreso;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
