/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.linelight.controller.PerfilController;
import pe.edu.pucp.linelight.model.Perfil;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author USER
 */

public class BuscarPerfil extends javax.swing.JPanel {

    /**
     * Creates new form BuscarUsuario
     */
    
    Perfil perfil_seleccionado=new Perfil();
    public BuscarPerfil() {
        initComponents();
        this.setBackground(new java.awt.Color(240, 240, 240));
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        descrip = new javax.swing.JTextField();
        buscar_perfil_button = new javax.swing.JButton();
        jComboBoxEstado = new javax.swing.JComboBox();
        jCheckBox_seguridad = new javax.swing.JCheckBox();
        jCheckBox_conf = new javax.swing.JCheckBox();
        jCheckBox_Opt = new javax.swing.JCheckBox();
        jCheckBox_Mant = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 647));
        setRequestFocusEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Busqueda"));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 457));

        jLabel1.setText("Descripción:");

        jLabel2.setText("Permisos:");

        jLabel3.setText("Estado:");

        descrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripActionPerformed(evt);
            }
        });
        descrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripKeyTyped(evt);
            }
        });

        buscar_perfil_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar_opt.png"))); // NOI18N
        buscar_perfil_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_perfil_buttonActionPerformed(evt);
            }
        });

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Activo", "Inactivo" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        jCheckBox_seguridad.setText("Seguridad");
        jCheckBox_seguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_seguridadActionPerformed(evt);
            }
        });

        jCheckBox_conf.setText("Configuración");

        jCheckBox_Opt.setText("Optimización");
        jCheckBox_Opt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_OptActionPerformed(evt);
            }
        });

        jCheckBox_Mant.setText("Mantenimientos");

        jLabel4.setText("Nombre:");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscar_perfil_button)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_seguridad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jCheckBox_conf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombre)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jCheckBox_Opt)
                                .addGap(31, 31, 31)
                                .addComponent(jCheckBox_Mant)))
                        .addContainerGap(51, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscar_perfil_button)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox_seguridad)
                            .addComponent(jCheckBox_conf)
                            .addComponent(jCheckBox_Opt)
                            .addComponent(jCheckBox_Mant))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identificador", "Nombre", "Descripción", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_opt.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar_opt.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar_opt.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(596, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripActionPerformed

    private void buscar_perfil_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_perfil_buttonActionPerformed
       List<Perfil> perfiles_b= new ArrayList<>();
        perfiles_b=PerfilController.getPerfiles(this.nombre.getText(),this.descrip.getText(), this.jComboBoxEstado.getSelectedIndex());
        DefaultTableModel modelo=new DefaultTableModel();
        String[] colName = { "Identificador", "Nombre", "Descripción", "Estado"};
        modelo.setColumnIdentifiers(colName);
      
        for (Perfil perfil : perfiles_b) {
            Object fila[]=new Object [6];
            fila[0] = perfil.getIdPerfil();
            fila[1] = perfil.getNombre();
            fila[2] = perfil.getDescripcion();
            if(perfil.getEstado()==1)
                fila[3] = "Activo";
            else
                fila[3] = "Inactivo";

            modelo.addRow(fila);
        }
        jTable2.setModel(modelo);
        jTable2.repaint();
    }//GEN-LAST:event_buscar_perfil_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nuevoPerfil nuevo= new nuevoPerfil();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               
        if (jTable2.getSelectedRow() != -1) {
        int seleccion = JOptionPane.showOptionDialog(
                    BuscarPerfil.this, // Componente padre
                    "¿Esta seguro que desea borrar el perfil seleccionado?", //Mensaje
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
                       perfil_seleccionado= PerfilController.getPerfilId((int)jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0));
                      if(perfil_seleccionado.getUsuarios().isEmpty()){
                           PerfilController.eliminarPerfil(perfil_seleccionado);
                          JOptionPane.showMessageDialog(BuscarPerfil.this, "Perfil borrado","Acción",INFORMATION_MESSAGE,null);
                      } 
                      else
                          JOptionPane.showMessageDialog(BuscarPerfil.this, "Imposible borrar Perfil","Error",ERROR_MESSAGE,null);
                      
                      buscar_perfil_buttonActionPerformed(evt);

                   }
                }
                } else {
            JOptionPane.showMessageDialog(BuscarPerfil.this, "Debe seleccionar un perfil", "Error", ERROR_MESSAGE, null);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Perfil perfil = new Perfil();
        if (jTable2.getSelectedRow() != -1) {
        int idPerfil=(int)jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0);
        perfil=PerfilController.getPerfilId(idPerfil);
        editarPerfil editar=new editarPerfil();
        editar.setPerfil(perfil);
        editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(BuscarPerfil.this, "Debe seleccionar un perfil", "Error", ERROR_MESSAGE, null);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jCheckBox_seguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_seguridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_seguridadActionPerformed

    private void jCheckBox_OptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_OptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_OptActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        ValidationUtil.validateLenght(this.nombre.getText(), 20, evt);
    }//GEN-LAST:event_nombreKeyTyped

    private void descripKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripKeyTyped
        ValidationUtil.validateLenght(this.nombre.getText(), 45, evt);
    }//GEN-LAST:event_descripKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_perfil_button;
    private javax.swing.JTextField descrip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox_Mant;
    private javax.swing.JCheckBox jCheckBox_Opt;
    private javax.swing.JCheckBox jCheckBox_conf;
    private javax.swing.JCheckBox jCheckBox_seguridad;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
