/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.view;

import javax.swing.JOptionPane;
import pe.edu.pucp.linelight.controller.ParamAlgoritmoController;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author Angel
 */
public class PanelParametrosAlgoritmo extends javax.swing.JPanel {

    /**
     * Creates new form PanelParametrosAlgoritmo
     */
    
    public PanelParametrosAlgoritmo() {
        initComponents();
        
        Paramalgoritmo paramAlgoritmo = ParamAlgoritmoController.getParamAlgoritmoById(1);
        this.jTextField1.setText("" + paramAlgoritmo.getTamPoblacionInicial());
        this.jTextField2.setText("" + paramAlgoritmo.getMaxTamPoblacion());
        this.jTextField3.setText("" + paramAlgoritmo.getMaxCicloSinCambiar());
        this.jTextField4.setText("" + paramAlgoritmo.getTasaCasamiento());
        this.jTextField5.setText("" + paramAlgoritmo.getTasaMutacion());
        this.checkbox1.setState(true);
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
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkbox1 = new java.awt.Checkbox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmo"));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 226));

        jLabel1.setText("Tamaño de Población Inicial: ");

        jLabel2.setText("Máximo Tamaño de Población: ");

        jLabel3.setText("Tasa Casamiento:");

        jLabel4.setText("Máximos Ciclos sin Cambiar:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar_opt.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tasa Mutación:");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel6.setText("Elitismo :");

        checkbox1.setLabel("Sí");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addComponent(jLabel6))
                        .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(
                PanelParametrosAlgoritmo.this, // Componente padre
                "¿Esta seguro que desea guardar los Parámetros?", //Mensaje
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
                   /*Se necesita nombre de simulacion, tiempo de ejecucion*/
                   Paramalgoritmo editar_paramAlgoritmo = ParamAlgoritmoController.getParamAlgoritmoById(1);
 
//                 ejecucionAlgoritmo.setId(new EjecucionalgoritmoId(1,1,user.getIdUsuario(),1));                   
                   editar_paramAlgoritmo.setTamPoblacionInicial(Integer.parseInt(this.jTextField1.getText()));
                   editar_paramAlgoritmo.setMaxTamPoblacion(Integer.parseInt(this.jTextField2.getText()));                   
                   editar_paramAlgoritmo.setMaxCicloSinCambiar(Integer.parseInt(this.jTextField3.getText()));
                   
                   editar_paramAlgoritmo.setTasaCasamiento(Double.parseDouble(this.jTextField4.getText()));
                   editar_paramAlgoritmo.setTasaMutacion(Double.parseDouble(this.jTextField5.getText()));
                   editar_paramAlgoritmo.setElitismo(true);
                   
                   ParamAlgoritmoController.editarParamAlgoritmo(editar_paramAlgoritmo);
                   JOptionPane.showMessageDialog(PanelParametrosAlgoritmo.this, "Item editado","Acción",INFORMATION_MESSAGE,null);
                   } 
                   catch(Exception e){
                       e.printStackTrace();
                       JOptionPane.showMessageDialog(PanelParametrosAlgoritmo.this, "Imposible editar item","Acción",ERROR_MESSAGE,null);                    
                   }
                   
                   
                   
                   
                   /*CODIGO PARA AGREGAR UN Paramalgoritmo Y LLAMA AL CONTROLLER**/
//                   /*Se necesita nombre de simulacion, tiempo de ejecucion*/
//                   Paramalgoritmo paramAlgoritmo = new Paramalgoritmo();                   
//                   
//                  //El id de la ejecucion                  
//                  int id = ParamAlgoritmoController.getNextId();
//                  
//                  //Registramos la ejecucion
//                  paramAlgoritmo.setIdParamAlgoritmo(id);
//                   
////                   ejecucionAlgoritmo.setId(new EjecucionalgoritmoId(1,1,user.getIdUsuario(),1));                   
//                   paramAlgoritmo.setTamPoblacionInicial(Integer.parseInt(this.jTextField1.getText()));
//                   paramAlgoritmo.setMaxTamPoblacion(Integer.parseInt(this.jTextField2.getText()));                   
//                   paramAlgoritmo.setMaxCicloSinCambiar(Integer.parseInt(this.jTextField3.getText()));
//                   
//                   paramAlgoritmo.setTasaCasamiento(Double.parseDouble(this.jTextField4.getText()));
//                   paramAlgoritmo.setTasaMutacion(Double.parseDouble(this.jTextField5.getText()));
//                   paramAlgoritmo.setElitismo(true);
//                   
//                   int ok =ParamAlgoritmoController.agregarParamAlgoritmo(paramAlgoritmo);
//                   if(ok == 1)
//                   
//                   {
//                       JOptionPane.showMessageDialog(PanelParametrosAlgoritmo.this, "Item agregado","Acción",INFORMATION_MESSAGE,null);
//                       //PanelSimulacionMonitoreo.this.dispose();
//                   }
//                   else
//                   {
//                       JOptionPane.showMessageDialog(PanelParametrosAlgoritmo.this, "Imposible agregar item","Acción",ERROR_MESSAGE,null);
//                   }             

               }
        }            

    }//GEN-LAST:event_jButton1ActionPerformed

    /*Eventos de validacion de ingreso de datos*/
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateNumTam(jTextField1.getText(), 3, evt);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateNumTam(jTextField2.getText(), 3, evt);
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateNumTam(jTextField3.getText(), 2, evt);
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateDouble(jTextField4.getText(), 6, evt);
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateDouble(jTextField5.getText(), 6, evt);
    }//GEN-LAST:event_jTextField5KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
