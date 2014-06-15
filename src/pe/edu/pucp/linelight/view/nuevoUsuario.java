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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.controller.PerfilController;
import pe.edu.pucp.linelight.controller.UsuarioController;
import pe.edu.pucp.linelight.model.Perfil;
import pe.edu.pucp.linelight.model.Usuario;
import java.awt.Toolkit;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;
import pe.edu.pucp.linelight.util.MailUtil;

/**
 *
 * @author USER
 */
public class nuevoUsuario extends javax.swing.JFrame {
    
    List<Integer> perfiles_id = new ArrayList<>();
    
    public String generatePassword() {
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String pswd = "";
        for (int i = 0; i < 12; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }
        return pswd;
    }
    
    public nuevoUsuario() {
        initComponents();
        //cargar perfiles
        Image icon = new ImageIcon(getClass().getResource("/images/semaforo.png")).getImage();
        setIconImage(icon);
        List<Perfil> perfiles = new ArrayList<>();
        perfiles = PerfilController.getAllPerfiles();
        this.perfilCmb.removeAllItems();
        this.perfiles_id.add(0);
        perfilCmb.addItem("Seleccione");
        for (Perfil perfile : perfiles) {
            perfilCmb.addItem(perfile.getNombre());
            perfiles_id.add(perfile.getIdPerfil());
        }
        getContentPane().setBackground(new java.awt.Color(240, 240, 240));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        perfilCmb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        app = new javax.swing.JTextField();
        apm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        cel = new javax.swing.JTextField();
        direcc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));

        jLabel1.setText("Usuario:");

        jLabel2.setText("Perfil:");

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });

        perfilCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Regular" }));

        jLabel6.setText("Correo Electrónico:");

        correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoFocusLost(evt);
            }
        });
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoKeyTyped(evt);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perfilCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(perfilCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombresKeyTyped(evt);
            }
        });

        app.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                appKeyTyped(evt);
            }
        });

        apm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apmKeyTyped(evt);
            }
        });

        jLabel7.setText("N° DNI: ");

        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });
        dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dniKeyTyped(evt);
            }
        });

        jLabel8.setText("Fecha de Nac:");

        jDateChooser1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("(*)");

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("(*)");

        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("(*)");

        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("(*)");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(nombres)
                            .addComponent(apm)
                            .addComponent(dni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(apm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Extras:"));

        jLabel9.setText("Teléfono:");

        jLabel10.setText("Celular:");

        jLabel11.setText("Dirección:");

        telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telfKeyTyped(evt);
            }
        });

        cel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celKeyTyped(evt);
            }
        });

        direcc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccKeyTyped(evt);
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
                    .addComponent(telf)
                    .addComponent(cel)
                    .addComponent(direcc, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(direcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setText("Registrar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton2)
                .addGap(72, 72, 72))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ok = 0;
        
        if (this.usuario.getText().trim().length() != 0 && this.perfilCmb.getSelectedIndex() != 0
                && this.correo.getText().trim().length() != 0 && this.dni.getText().trim().length() != 0
                && this.nombres.getText().trim().length() != 0 && this.app.getText().trim().length() != 0
                && this.apm.getText().trim().length() != 0 && ValidationUtil.isEmailvalido()) {
            
            int seleccion = JOptionPane.showOptionDialog(
                    nuevoUsuario.this, // Componente padre
                    "¿Esta seguro que desea guardar los cambios?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                    "Si");
            
            if (seleccion != -1) {
                if (seleccion == 0) {
                    Usuario nuevo_usuario = new Usuario();
                    int seleccion_perfil = this.perfilCmb.getSelectedIndex();
                    nuevo_usuario.setNombre(this.nombres.getText());
                    nuevo_usuario.setApm(this.apm.getText());
                    nuevo_usuario.setApp(this.app.getText());
                    nuevo_usuario.setCelular(this.cel.getText());
                    nuevo_usuario.setCorreo(this.correo.getText());
                    nuevo_usuario.setDni(this.dni.getText());
                    nuevo_usuario.setFechaNac(this.jDateChooser1.getDate());
                    nuevo_usuario.setPerfil(PerfilController.getPerfilId(this.perfiles_id.get(seleccion_perfil)));
                    nuevo_usuario.setPassword(generatePassword());
                    nuevo_usuario.setDireccion(this.direcc.getText());
                    nuevo_usuario.setTelefono(this.telf.getText());
                    nuevo_usuario.setIdUsuario(this.usuario.getText());
                    nuevo_usuario.setEstado(1);
                    nuevo_usuario.setEstadobd(1);
                    nuevo_usuario.setPrimerAcceso(1);
                    ok = UsuarioController.agregarUsuario(nuevo_usuario);
                    //creamos el objeto correo 
                    MailUtil mail = new MailUtil();
                    //llamamos al metodo send() para enviar el mensaje
                    String mensaje =
                            "<head>\n"
                            + "	<title> --LineLight--</title>\n"
                            + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "<p>Bienvenid@ al Sistema de Optimización de Tráfico. </p>\n"
                            + "<p>Se le ha registrado en el sistema con las siguientes credenciales:</p>\n"
                            + "	<p>Usuario: " + nuevo_usuario.getIdUsuario() + "</p>\n"
                            + "	<p>Contraseña: " + nuevo_usuario.getPassword() + " </p>\n"
                            + "</body>";
                    
                    if(mail.send(mensaje, nuevo_usuario.getCorreo())){
                        JOptionPane.showMessageDialog(nuevoUsuario.this, "Correo enviado","Acción",INFORMATION_MESSAGE,null);
                    }else{
                    
                         JOptionPane.showMessageDialog(nuevoUsuario.this, "No se pudo enviar el correo","Error",ERROR_MESSAGE,null);
                    }
                    if (ok == 1) {
                        JOptionPane.showMessageDialog(nuevoUsuario.this, "Usuario agregado", "Acción", INFORMATION_MESSAGE, null);
                        try {
                            GeneralUtil.insertaLog(1, "usuario");
                        } catch (UnknownHostException ex) {
                            Logger.getLogger(nuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        nuevoUsuario.this.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(nuevoUsuario.this, "Imposible agregar usuario", "Error", ERROR_MESSAGE, null);
                    }
                    
                }
                
            }
            
        } else {
            JOptionPane.showMessageDialog(nuevoUsuario.this, "Campos obligatorios incompletos", "Error", ERROR_MESSAGE, null);
            
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int seleccion = JOptionPane.showOptionDialog(
                nuevoUsuario.this, // Componente padre
                "¿Esta seguro que desea salir sin guardar?", //Mensaje
                "Mensaje de confirmación", // Título
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                "Si");
        
        if (seleccion != -1) {
            if (seleccion == 0) {
                nuevoUsuario.this.dispose();
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed

    }//GEN-LAST:event_usuarioActionPerformed

    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        ValidationUtil.validateLenght2(this.usuario.getText(), 10, evt);
    }//GEN-LAST:event_usuarioKeyTyped

    private void dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniKeyTyped
        ValidationUtil.validateNumTam(this.dni.getText(), 8, evt);
    }//GEN-LAST:event_dniKeyTyped

    private void nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresKeyTyped
        ValidationUtil.validateLenght(this.nombres.getText(), 45, evt);
    }//GEN-LAST:event_nombresKeyTyped

    private void appKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_appKeyTyped
        ValidationUtil.validateLenght(this.app.getText(), 45, evt);
    }//GEN-LAST:event_appKeyTyped

    private void apmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apmKeyTyped
        ValidationUtil.validateLenght(this.apm.getText(), 45, evt);
    }//GEN-LAST:event_apmKeyTyped

    private void telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telfKeyTyped
        ValidationUtil.validateNumTam(this.telf.getText(), 7, evt);
    }//GEN-LAST:event_telfKeyTyped

    private void celKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celKeyTyped
        ValidationUtil.validateNumTam(this.cel.getText(), 9, evt);
    }//GEN-LAST:event_celKeyTyped

    private void direccKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccKeyTyped
        ValidationUtil.validateLenght2(this.direcc.getText(), 45, evt);
    }//GEN-LAST:event_direccKeyTyped

    private void correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyTyped
        
    }//GEN-LAST:event_correoKeyTyped

    private void correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoFocusLost
        ValidationUtil.validateEmail(this.correo.getText(), evt);
    }//GEN-LAST:event_correoFocusLost

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
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apm;
    private javax.swing.JTextField app;
    private javax.swing.JTextField cel;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direcc;
    private javax.swing.JTextField dni;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombres;
    private javax.swing.JComboBox perfilCmb;
    private javax.swing.JTextField telf;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
