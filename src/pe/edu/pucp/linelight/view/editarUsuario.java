/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.controller.PerfilController;
import pe.edu.pucp.linelight.controller.UsuarioController;
import pe.edu.pucp.linelight.model.Perfil;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author USER
 */
public class editarUsuario extends javax.swing.JFrame {

    Usuario usuario=new Usuario();
    List<Integer> perfiles_id = new ArrayList<>();
    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
        this.nombres_e.setText(usuario.getNombre());
        this.usuario_e.setText(usuario.getIdUsuario());
        this.correo_e.setText(usuario.getCorreo());
        this.dni_e.setText(usuario.getDni());
        this.app_e.setText(usuario.getApp());
        this.apm_e.setText(usuario.getApm());
        this.cel_e.setText(usuario.getCelular());
        this.direc_e.setText(usuario.getDireccion());
        this.telf_e.setText(usuario.getTelefono());
        this.jDateChooser1.setDate(usuario.getFechaNac());
        this.nombres_e.setText(usuario.getNombre());
        if(usuario.getEstado()==0) this.combo_estado.setSelectedIndex(1);
        if(usuario.getEstado()==1) this.combo_estado.setSelectedIndex(0);
        
        int i;
        for(i=0;i<perfiles_id.size();i++){
            if(Objects.equals(usuario.getPerfil().getIdPerfil(), perfiles_id.get(i)))break;
        }
        this.perfilCmb.setSelectedIndex(i);
    }
    
    public editarUsuario() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/images/semaforo.png")).getImage();
        setIconImage(icon);
        List<Perfil>perfiles=new ArrayList<>();
        perfiles=PerfilController.getAllPerfiles();
        this.perfilCmb.removeAllItems();
        perfilCmb.addItem("Seleccione");
        perfiles_id.add(0);
        for (Perfil perfile : perfiles) {
            perfilCmb.addItem(perfile.getNombre());
            perfiles_id.add(perfile.getIdPerfil());
        } 
        getContentPane().setBackground(new java.awt.Color(240, 240, 240));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
        jLabel2 = new javax.swing.JLabel();
        usuario_e = new javax.swing.JTextField();
        perfilCmb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        correo_e = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        combo_estado = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombres_e = new javax.swing.JTextField();
        app_e = new javax.swing.JTextField();
        apm_e = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dni_e = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        telf_e = new javax.swing.JTextField();
        cel_e = new javax.swing.JTextField();
        direc_e = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Usuario");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos del Usuario"));

        jLabel1.setText("Usuario:");

        jLabel2.setText("Perfil:");

        usuario_e.setEditable(false);
        usuario_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuario_eKeyTyped(evt);
            }
        });

        perfilCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Regular" }));

        jLabel6.setText("Correo Electrónico:");

        correo_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correo_eFocusLost(evt);
            }
        });
        correo_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correo_eKeyTyped(evt);
            }
        });

        jLabel12.setText("Estado:");

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        combo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estadoActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("(*)");

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("(*)");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(correo_e)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(usuario_e, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perfilCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuario_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(perfilCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(correo_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos Personales"));

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        nombres_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombres_eKeyTyped(evt);
            }
        });

        app_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                app_eKeyTyped(evt);
            }
        });

        apm_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apm_eKeyTyped(evt);
            }
        });

        jLabel7.setText("N° DNI: ");

        dni_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dni_eActionPerformed(evt);
            }
        });
        dni_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dni_eKeyTyped(evt);
            }
        });

        jLabel8.setText("Fecha de Nac:");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("(*)");

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("(*)");

        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(app_e, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(nombres_e)
                            .addComponent(dni_e)
                            .addComponent(apm_e, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dni_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombres_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(app_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(apm_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Teléfono:");

        jLabel10.setText("Celular:");

        jLabel11.setText("Dirección:");

        telf_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telf_eKeyTyped(evt);
            }
        });

        cel_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cel_eKeyTyped(evt);
            }
        });

        direc_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direc_eActionPerformed(evt);
            }
        });
        direc_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direc_eKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telf_e)
                    .addComponent(cel_e)
                    .addComponent(direc_e, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(telf_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cel_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(direc_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*) Datos Obligatorios");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("(*) Datos Obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel17)
                    .addContainerGap(151, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(255, 255, 255)
                    .addComponent(jLabel17)
                    .addContainerGap(256, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dni_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dni_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dni_eActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
          if (this.usuario_e.getText().trim().length() != 0 
                && this.correo_e.getText().trim().length() != 0 && this.dni_e.getText().trim().length() != 0
                && this.nombres_e.getText().trim().length() != 0 && this.app_e.getText().trim().length() != 0
                && this.apm_e.getText().trim().length() != 0) {
          
              int seleccion = JOptionPane.showOptionDialog(
                    editarUsuario.this, // Componente padre
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
                      Usuario editar_usuario= this.usuario;
                      int seleccion_perfil=this.perfilCmb.getSelectedIndex();
                      
                      editar_usuario.setNombre(this.nombres_e.getText());
                      editar_usuario.setApm(this.apm_e.getText());
                      editar_usuario.setApp(this.app_e.getText());
                      editar_usuario.setCelular(this.cel_e.getText());
                      editar_usuario.setCorreo(this.correo_e.getText());
                      editar_usuario.setDni(this.dni_e.getText());
                      editar_usuario.setFechaNac(this.jDateChooser1.getDate());
                      editar_usuario.setPerfil(PerfilController.getPerfilId(this.perfiles_id.get(seleccion_perfil)));
                      editar_usuario.setDireccion(this.direc_e.getText());
                      editar_usuario.setTelefono(this.telf_e.getText());
                      int estado = 0;
                      if (this.combo_estado.getSelectedIndex() == 0) estado = 1;
                      else estado = 0;
                      editar_usuario.setEstado(estado);
                      
                      UsuarioController.editarUsuario(editar_usuario);
                      JOptionPane.showMessageDialog(editarUsuario.this, "Item editado","Acción",INFORMATION_MESSAGE,null);
                      GeneralUtil.insertaLog(2, "usuario");
                      editarUsuario.this.dispose();
                      } catch(Exception e){
                          e.printStackTrace();
                           JOptionPane.showMessageDialog(editarUsuario.this, "Imposible editar item","Error",ERROR_MESSAGE,null);
                
                      
                      }
                      editarUsuario.this.dispose();
                   }

                }
          
          
          
          
          }else {
            JOptionPane.showMessageDialog(editarUsuario.this, "Campos obligatorios incompletos", "Error", ERROR_MESSAGE, null);

        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int seleccion = JOptionPane.showOptionDialog(
                    editarUsuario.this, // Componente padre
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
                      editarUsuario.this.dispose();
                   }
                   else
                   {
                      
                   }
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_estadoActionPerformed

    private void usuario_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuario_eKeyTyped
         ValidationUtil.validateLenght2(this.usuario_e.getText(), 10, evt);
    }//GEN-LAST:event_usuario_eKeyTyped

    private void correo_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correo_eKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_correo_eKeyTyped

    private void correo_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correo_eFocusLost
         ValidationUtil.validateEmail(this.correo_e.getText(), evt);
    }//GEN-LAST:event_correo_eFocusLost

    private void dni_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dni_eKeyTyped
        ValidationUtil.validateNumTam(this.dni_e.getText(),8, evt);
    }//GEN-LAST:event_dni_eKeyTyped

    private void nombres_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombres_eKeyTyped
         ValidationUtil.validateLenght(this.nombres_e.getText(), 45, evt);
    }//GEN-LAST:event_nombres_eKeyTyped

    private void app_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_app_eKeyTyped
        ValidationUtil.validateLenght(this.app_e.getText(), 45, evt);
    }//GEN-LAST:event_app_eKeyTyped

    private void apm_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apm_eKeyTyped
        ValidationUtil.validateLenght(this.apm_e.getText(), 45, evt);
    }//GEN-LAST:event_apm_eKeyTyped

    private void telf_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telf_eKeyTyped
        ValidationUtil.validateNumTam(this.telf_e.getText(),7, evt);
    }//GEN-LAST:event_telf_eKeyTyped

    private void cel_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cel_eKeyTyped
        ValidationUtil.validateNumTam(this.cel_e.getText(),9, evt);
    }//GEN-LAST:event_cel_eKeyTyped

    private void direc_eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direc_eKeyTyped
         ValidationUtil.validateLenght3(this.direc_e.getText(), 45, evt);
    }//GEN-LAST:event_direc_eKeyTyped

    private void direc_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direc_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direc_eActionPerformed

    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(editarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apm_e;
    private javax.swing.JTextField app_e;
    private javax.swing.JTextField cel_e;
    private javax.swing.JComboBox combo_estado;
    private javax.swing.JTextField correo_e;
    private javax.swing.JTextField direc_e;
    private javax.swing.JTextField dni_e;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombres_e;
    private javax.swing.JComboBox perfilCmb;
    private javax.swing.JTextField telf_e;
    private javax.swing.JTextField usuario_e;
    // End of variables declaration//GEN-END:variables
}
