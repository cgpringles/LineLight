/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.filechooser.FileNameExtensionFilter;
import linelight.ImagenFondo;
import org.dom4j.DocumentException;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.MapaController;
import pe.edu.pucp.linelight.structure.MapParser;
import pe.edu.pucp.linelight.model.Distrito;

/**
 *
 * @author Charito
 */
public class WindowPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form WindowPrincipal
     */
    private final Dimension smallsize = new Dimension(800,700);
    private final Dimension bigsize = new Dimension(1200,700); 

    
    public WindowPrincipal() {
        initComponents();
        panel_principal .setBorder(new ImagenFondo());
        getContentPane().setBackground(new java.awt.Color(165, 211, 226));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       
    }
    
    
    public void setMenus(int seg, int mant, int conf, int opt){
            if(seg==0) this.seguridad_menu.setVisible(false);
            if(mant==0) this.mantenimiento_menu.setVisible(false);
            if(conf==0) this.config_menu.setVisible(false);
            if(opt==0) this.optim_menu.setVisible(false);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        panel_principal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menu_principal = new javax.swing.JMenuBar();
        seguridad_menu = new javax.swing.JMenu();
        usuarios_menu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mantenimiento_menu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        config_menu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        optim_menu = new javax.swing.JMenu();
        sesion_menu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LineLight");

        panel_principal.setPreferredSize(new java.awt.Dimension(800, 647));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        menu_principal.setBackground(new java.awt.Color(204, 204, 204));
        menu_principal.setPreferredSize(new java.awt.Dimension(800, 53));

        seguridad_menu.setBackground(new java.awt.Color(204, 204, 204));
        seguridad_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/candado-electronico.png"))); // NOI18N
        seguridad_menu.setText("Seguridad");

        usuarios_menu.setText("Usuarios");
        usuarios_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarios_menuMouseClicked(evt);
            }
        });
        usuarios_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_menuActionPerformed(evt);
            }
        });
        seguridad_menu.add(usuarios_menu);

        jMenuItem2.setText("Perfiles");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        seguridad_menu.add(jMenuItem2);

        menu_principal.add(seguridad_menu);

        mantenimiento_menu.setBackground(new java.awt.Color(204, 204, 204));
        mantenimiento_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapa.PNG"))); // NOI18N
        mantenimiento_menu.setText("Mantenimiento");

        jMenuItem3.setText("Semáforos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mantenimiento_menu.add(jMenuItem3);

        jMenuItem5.setText("Vías");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mantenimiento_menu.add(jMenuItem5);

        jMenuItem6.setText("Mapas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mantenimiento_menu.add(jMenuItem6);

        menu_principal.add(mantenimiento_menu);

        config_menu.setBackground(new java.awt.Color(204, 204, 204));
        config_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuracion_mapa.png"))); // NOI18N
        config_menu.setText("Configuración");
        config_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                config_menuActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Variables");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        config_menu.add(jMenuItem1);

        jMenuItem8.setText("Parámetros");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        config_menu.add(jMenuItem8);

        menu_principal.add(config_menu);

        optim_menu.setBackground(new java.awt.Color(204, 204, 204));
        optim_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rendimiento.png"))); // NOI18N
        optim_menu.setText("Optimización");
        optim_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optim_menuMouseClicked(evt);
            }
        });
        menu_principal.add(optim_menu);

        sesion_menu.setBackground(new java.awt.Color(204, 204, 204));
        sesion_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        sesion_menu.setText("Usuario");
        sesion_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sesion_menuMouseClicked(evt);
            }
        });

        jMenuItem4.setText("Cambiar Contraseña");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        sesion_menu.add(jMenuItem4);

        jMenuItem7.setText("Cerrar Sesión");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        sesion_menu.add(jMenuItem7);

        menu_principal.add(sesion_menu);

        jMenu2.setBackground(new java.awt.Color(204, 204, 204));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reportes.png"))); // NOI18N
        jMenu2.setText("Reportes");

        jMenuItem9.setText("Vías");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Seguridad");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        menu_principal.add(jMenu2);

        setJMenuBar(menu_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarios_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_menuActionPerformed
        System.out.print("ikikikiki2");
        this.setSize(smallsize);
        this.setTitle("Usuarios");
        BuscarUsuario panel_usuario= new BuscarUsuario();
        panel_principal.setSize(smallsize.width,647);
        panel_usuario.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_usuario);
        panel_principal.revalidate();
        panel_usuario.revalidate();
         panel_principal.repaint();
        panel_usuario.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_usuarios_menuActionPerformed

    private void usuarios_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarios_menuMouseClicked

    }//GEN-LAST:event_usuarios_menuMouseClicked

    private void config_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_config_menuActionPerformed
       
    }//GEN-LAST:event_config_menuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         System.out.print("ikikikiki2");
        this.setSize(smallsize);
        this.setTitle("Configuración");
        panel_principal.setSize(smallsize.width,647);    
        PanelConfiguracion panel_config= new PanelConfiguracion();
        panel_config.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_config);
        panel_principal.revalidate();
        panel_config.revalidate();
         panel_principal.repaint();
        panel_config.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        this.setSize(smallsize);
        panel_principal.setSize(smallsize.width,647);
        this.setTitle("Perfiles");
        BuscarPerfil panel_perfiles= new BuscarPerfil();
        panel_perfiles.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_perfiles);
        panel_principal.revalidate();
        panel_perfiles.revalidate();
         panel_principal.repaint();
        panel_perfiles.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       this.setSize(smallsize);
       panel_principal.setSize(smallsize.width,647);
        this.setTitle("Semáforos");
        buscarSemaforo panel_semaforos= new buscarSemaforo();
        panel_semaforos.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_semaforos);
        panel_principal.revalidate();
        panel_semaforos.revalidate();
         panel_principal.repaint();
        panel_semaforos.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void optim_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optim_menuMouseClicked
        // TODO add your handling code here:
        
        try{
            this.setSize(bigsize);
            this.setTitle("Optimización");
            panel_principal.setSize(bigsize.width, bigsize.height-75);
            panel_principal.revalidate();
            PanelSimulacionMonitoreo panelSimulacionMonitoreo = new PanelSimulacionMonitoreo();
            panelSimulacionMonitoreo.setSize(panel_principal.getSize());
            System.out.println(panel_principal.getSize());
            System.out.println(panel_principal.getBounds());

            panel_principal.removeAll();
            panel_principal.add(panelSimulacionMonitoreo);

            panel_principal.revalidate();
        }
        catch(Exception e){
            this.setSize(smallsize);
            JOptionPane.showMessageDialog(WindowPrincipal.this, "No hay ningun mapa activo.", "Error", INFORMATION_MESSAGE, null);
        }
    }//GEN-LAST:event_optim_menuMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //Despliego el panel de vía
        this.setSize(smallsize);
        panel_principal.setSize(smallsize.width,647);
        this.setTitle("Vías");
        BuscarVias panel_vias= new BuscarVias();
        panel_vias.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_vias);
        panel_principal.revalidate();
        panel_vias.revalidate();
         panel_principal.repaint();
        panel_vias.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        this.setSize(smallsize);
        panel_principal.setSize(smallsize.width,647);
        this.setTitle("Mapas");
        buscarMapa panel_mapa= new buscarMapa();
        panel_mapa.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_mapa);
        panel_principal.revalidate();
        panel_mapa.revalidate();
        panel_principal.repaint();
        panel_mapa.repaint();
        panel_principal.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void sesion_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesion_menuMouseClicked

    }//GEN-LAST:event_sesion_menuMouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        WindowLogin login = new WindowLogin();
        
        this.setVisible(false);
        
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       WindowCambiarContrasena cambiar= new WindowCambiarContrasena();
        cambiar.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        
        System.out.print("ikikikiki2");
        this.setSize(smallsize);
        this.setTitle("Configuración");
        panel_principal.setSize(smallsize.width,647);    
        PanelParametrosAlgoritmo panel_config= new PanelParametrosAlgoritmo();
        panel_config.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_config);
        panel_principal.revalidate();
        panel_config.revalidate();
         panel_principal.repaint();
        panel_config.repaint();
        panel_principal.setVisible(true);       
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.setSize(smallsize);
        this.setTitle("Reportes - Seguridad");
        panel_principal.setSize(smallsize.width,647);    
        SeguridadReportes panel_config= new SeguridadReportes();
        panel_config.setSize(panel_principal.getSize());
        panel_principal.removeAll();
        panel_principal.add(panel_config);
        panel_principal.revalidate();
        panel_config.revalidate();
         panel_principal.repaint();
        panel_config.repaint();
        panel_principal.setVisible(true);    
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(WindowPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu config_menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu mantenimiento_menu;
    private javax.swing.JMenuBar menu_principal;
    private javax.swing.JMenu optim_menu;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JMenu seguridad_menu;
    private javax.swing.JMenu sesion_menu;
    private javax.swing.JMenuItem usuarios_menu;
    // End of variables declaration//GEN-END:variables
}
