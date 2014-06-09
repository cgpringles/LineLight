/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.Dimension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Trafico;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.robot.GeneradorRobot;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.controller.ParamAlgoritmoController;
import pe.edu.pucp.linelight.model.Configuracionsistema;
import pe.edu.pucp.linelight.model.EjecucionalgoritmoId;
import pe.edu.pucp.linelight.model.Paramalgoritmo;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.structure.Node;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author Julio
 */
public class PanelSimulacionMonitoreo extends javax.swing.JPanel {

    WindowsMapPanel mapPanel;
    GeneradorRobot gr;
    Distrito d;
    /**
     * Creates new form PanelSimulacionMonitoreo
     */
    public PanelSimulacionMonitoreo() {
        initComponents();
        Date fecha=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
//        txtFecha.setText(sdf.format(fecha));
        this.setBackground(new java.awt.Color(240, 240, 240));
        
        mapPanel = new WindowsMapPanel(new Dimension(728,568));
        mapContainerPanel.setVisible(true);
        mapPanel.setVisible(true);        
        
        mapContainerPanel.removeAll();
        mapContainerPanel.add(mapPanel);
                
        d = DistritoController.obtenerDistritoActivo();
        
        /*Se debe validar que haya un mapa activo*/
        byte[] imagen=null;
        for (Object z:d.getZonas())
        {
            //Validamos que sea zona 0 = mapa general
            if (((Zona)z).getId().getIdZona()==0)
            {
                imagen=((Zona)z).getImagen();
            }
        }
        mapPanel.changeMapFile(imagen);
//        File sourceFile = new File("C:\\Users\\PC-HP\\Desktop\\Linelight2\\LineLight2\\test.png");        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        simulacionPanel = new javax.swing.JPanel();
        iniciarSimulacionButton = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        buscar_usuario_button = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        agregarSimulacion = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        fechaLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        monitoreoPanel = new javax.swing.JPanel();
        iniciarMonitoreoButton = new javax.swing.JButton();
        configuracionLabel = new javax.swing.JLabel();
        configuracionComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mapContainerPanel = new javax.swing.JPanel();
        busquedaTextField = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        zoomInButton = new javax.swing.JButton();
        zoomOutButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();

        iniciarSimulacionButton.setBackground(new java.awt.Color(0, 153, 204));
        iniciarSimulacionButton.setText("Iniciar Simulación");
        iniciarSimulacionButton.setBorderPainted(false);
        iniciarSimulacionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarSimulacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSimulacionButtonActionPerformed(evt);
            }
        });

        fechaLabel.setText("Día de Simulación:");

        jLabel1.setText("Velocidad promedio:");

        jLabel2.setText("Tiempo de demora:");

        jTextField3.setEditable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);

        buscar_usuario_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar_opt.png"))); // NOI18N
        buscar_usuario_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_usuario_buttonActionPerformed(evt);
            }
        });

        jLabel11.setText("km/h");

        jLabel12.setText("segundos");

        jLabel13.setText("Nombre Siimulación:");

        jTextField6.setText("simulation3042014_5pm");
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        agregarSimulacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_opt.png"))); // NOI18N
        agregarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSimulacionActionPerformed(evt);
            }
        });

        jLabel14.setText("Velocidad Histórica:");

        jTextField7.setEditable(false);

        jLabel15.setText("km/h");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fechaLabel1.setText("Horario:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout simulacionPanelLayout = new javax.swing.GroupLayout(simulacionPanel);
        simulacionPanel.setLayout(simulacionPanelLayout);
        simulacionPanelLayout.setHorizontalGroup(
            simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulacionPanelLayout.createSequentialGroup()
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(simulacionPanelLayout.createSequentialGroup()
                        .addContainerGap(276, Short.MAX_VALUE)
                        .addComponent(iniciarSimulacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(simulacionPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(simulacionPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(buscar_usuario_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agregarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(simulacionPanelLayout.createSequentialGroup()
                                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fechaLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(simulacionPanelLayout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(simulacionPanelLayout.createSequentialGroup()
                                        .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField7)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        simulacionPanelLayout.setVerticalGroup(
            simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscar_usuario_button)
                    .addComponent(agregarSimulacion)
                    .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(iniciarSimulacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        tabbedPane.addTab("Simulación", simulacionPanel);

        monitoreoPanel.setBackground(new java.awt.Color(165, 211, 226));

        iniciarMonitoreoButton.setBackground(new java.awt.Color(0, 153, 204));
        iniciarMonitoreoButton.setText("Iniciar Monitoreo");
        iniciarMonitoreoButton.setBorderPainted(false);
        iniciarMonitoreoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarMonitoreoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarMonitoreoButtonActionPerformed(evt);
            }
        });

        configuracionLabel.setText("Configuracion a usar:");

        configuracionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30/04/14 5 pm (Veloc: 30 km/h)", "05/05/14 2 pm (Veloc: 40 km/h)", "10/05/14 7 pm (Veloc: 25 km/h)" }));

        jLabel4.setText("Velocidad promedio:");

        jLabel5.setText("Cantidad de vehiculos:");

        jTextField2.setText("30.00");

        jLabel6.setText("Km/h");

        javax.swing.GroupLayout monitoreoPanelLayout = new javax.swing.GroupLayout(monitoreoPanel);
        monitoreoPanel.setLayout(monitoreoPanelLayout);
        monitoreoPanelLayout.setHorizontalGroup(
            monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitoreoPanelLayout.createSequentialGroup()
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monitoreoPanelLayout.createSequentialGroup()
                        .addContainerGap(264, Short.MAX_VALUE)
                        .addComponent(iniciarMonitoreoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(monitoreoPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(configuracionLabel))
                        .addGap(18, 18, 18)
                        .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(configuracionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(monitoreoPanelLayout.createSequentialGroup()
                                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        monitoreoPanelLayout.setVerticalGroup(
            monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monitoreoPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configuracionLabel)
                    .addComponent(configuracionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(iniciarMonitoreoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        tabbedPane.addTab("Monitoreo", monitoreoPanel);

        mapContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout mapContainerPanelLayout = new javax.swing.GroupLayout(mapContainerPanel);
        mapContainerPanel.setLayout(mapContainerPanelLayout);
        mapContainerPanelLayout.setHorizontalGroup(
            mapContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        mapContainerPanelLayout.setVerticalGroup(
            mapContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        buscarButton.setBackground(new java.awt.Color(0, 153, 204));
        buscarButton.setText("Buscar");
        buscarButton.setBorderPainted(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Leyenda"));

        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("Trafico Ligero");

        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Trafico intermedio");

        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Trafico Lento");

        jLabel10.setText("Trafico muerto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        zoomInButton.setBackground(new java.awt.Color(0, 153, 204));
        zoomInButton.setText("+");
        zoomInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInButtonActionPerformed(evt);
            }
        });

        zoomOutButton.setBackground(new java.awt.Color(0, 153, 204));
        zoomOutButton.setText("-");
        zoomOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutButtonActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de visualizacion"));

        jCheckBox1.setText("Satelite");

        jCheckBox2.setText("Trafico");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Vehiculos");

        jCheckBox4.setText("Semaforos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(13, 13, 13)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zoomInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoomOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarButton))
                    .addComponent(mapContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(busquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarButton)
                            .addComponent(zoomInButton)
                            .addComponent(zoomOutButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mapContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarMonitoreoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarMonitoreoButtonActionPerformed
        // TODO add your handling code here:
        
        gr=new GeneradorRobot(mapPanel,d.getIdDistrito(),"Lunes","8:00");

    }//GEN-LAST:event_iniciarMonitoreoButtonActionPerformed

    private void iniciarSimulacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSimulacionButtonActionPerformed
        // TODO add your handling code here:
        
        int numVehiculos = 2000;
        Usuario user = GeneralUtil.getUsuario_sesion();
        gr = new GeneradorRobot(numVehiculos, d.getIdDistrito(), mapPanel);
        List<Object> vehiculos = gr.getListaVehiculosRuta();
        
        EjecucionAlgoritmoController.migrarVehiculos(numVehiculos , vehiculos);
        EjecucionAlgoritmoController.iniciarSimulacion();
        
        this.jTextField3.setText("" + GA.velocidad);
        this.jTextField4.setText("" + GA.tiempoEjecucion);
        
    }//GEN-LAST:event_iniciarSimulacionButtonActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void zoomInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInButtonActionPerformed
        // TODO add your handling code here:
        mapPanel.zoomIn();
    }//GEN-LAST:event_zoomInButtonActionPerformed

    private void zoomOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutButtonActionPerformed
        // TODO add your handling code here:
        mapPanel.zoomOut();
    }//GEN-LAST:event_zoomOutButtonActionPerformed

    private void agregarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSimulacionActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(
                PanelSimulacionMonitoreo.this, // Componente padre
                "¿Esta seguro que desea guardar la simulacion?", //Mensaje
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
                   
                   /*Se necesita nombre de simulacion, tiempo de ejecucion*/
                   Ejecucionalgoritmo ejecucionAlgoritmo = new Ejecucionalgoritmo();
                   Usuario user = GeneralUtil.getUsuario_sesion();
                   
                  //El id de la ejecucion
                  EjecucionalgoritmoId idEjecucionalgoritmo = new EjecucionalgoritmoId();
                  int Ejecucionalgoritmoid = EjecucionAlgoritmoController.getNextId();
                  idEjecucionalgoritmo.setIdEjecucionAlgoritmo(Ejecucionalgoritmoid);                  
                  idEjecucionalgoritmo.setIdParamAlgoritmo(1); // Tome el primer registro de parametros
                  idEjecucionalgoritmo.setIdConfiguracionSistema(1); // Tome el rpimer registro de configuracion
                  idEjecucionalgoritmo.setIdUsuario(user.getIdUsuario());
                  
                  //Registramos la ejecucion
                  ejecucionAlgoritmo.setId(idEjecucionalgoritmo);                                                     

                   ejecucionAlgoritmo.setFecha(null);
                   ejecucionAlgoritmo.setVelocidadMaxima(Double.parseDouble(this.jTextField3.getText()));
//                   ejecucionAlgoritmo.setUsuario(user);
//                   ejecucionAlgoritmo.setParamalgoritmo(new Paramalgoritmo(10, 10, 0.85, 0.1)); //no debe existir 
                   
                   Set permisos = new HashSet();
//                   ejecucionAlgoritmo.setConfiguracionsistema(new Configuracionsistema(1, 120, 120, 90, 20, 50, 10, 60, 0.2777777, permisos) ); //no debe existir                   
                   
//                   ejecucionAlgoritmo.setVehiculos(null);
//                   ejecucionAlgoritmo.setEjecucionalgoritmoxcuadraxnodos(null);
//                   ejecucionAlgoritmo.setEjecucionalgoritmoxsemaforos(null);
                   
                   int ok =EjecucionAlgoritmoController.agregarEjecucionAlgoritmo(ejecucionAlgoritmo);
                   if(ok == 1)
                   
                   {
                       JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Item agregado","Acción",INFORMATION_MESSAGE,null);
                       //PanelSimulacionMonitoreo.this.dispose();
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Imposible agregar item","Acción",ERROR_MESSAGE,null);
                   }
               }
        }            
        
    }//GEN-LAST:event_agregarSimulacionActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateCaracteres(jTextField6.getText(), 12, evt);
        
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void buscar_usuario_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_usuario_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_usuario_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarSimulacion;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton buscar_usuario_button;
    private javax.swing.JTextField busquedaTextField;
    private javax.swing.JComboBox configuracionComboBox;
    private javax.swing.JLabel configuracionLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel fechaLabel1;
    private javax.swing.JButton iniciarMonitoreoButton;
    private javax.swing.JButton iniciarSimulacionButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel mapContainerPanel;
    private javax.swing.JPanel monitoreoPanel;
    private javax.swing.JPanel simulacionPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton zoomInButton;
    private javax.swing.JButton zoomOutButton;
    // End of variables declaration//GEN-END:variables
}
