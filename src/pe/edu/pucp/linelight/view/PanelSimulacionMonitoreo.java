/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import org.dom4j.DocumentException;
import java.awt.Dimension;
import java.io.File;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pe.edu.pucp.linelight.algorithm.GA;
import pe.edu.pucp.linelight.algorithm.Individuo;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;
import pe.edu.pucp.linelight.controller.HorarioController;
import pe.edu.pucp.linelight.controller.VehiculoController;
import pe.edu.pucp.linelight.controller.jcThread;
import pe.edu.pucp.linelight.controller.semaforoController;
import pe.edu.pucp.linelight.model.Distrito;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.model.EjecucionalgoritmoId;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmoxsemaforo;
import pe.edu.pucp.linelight.model.Horario;
import pe.edu.pucp.linelight.model.Semaforo;
import pe.edu.pucp.linelight.model.SemaforoId;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.Vehiculo;
import pe.edu.pucp.linelight.robot.GeneradorRobot;
import pe.edu.pucp.linelight.structure.Node;
import pe.edu.pucp.linelight.util.ConfigPanelMapa;
import pe.edu.pucp.linelight.util.GeneralUtil;
import pe.edu.pucp.linelight.util.ValidationUtil;

/**
 *
 * @author Angel
 */
public class PanelSimulacionMonitoreo extends javax.swing.JPanel {

    List<Integer> dias_id = new ArrayList<>();
    List<Integer> horas_id = new ArrayList<>();
    
    WindowsMapPanel mapPanel;
    GeneradorRobot gr;
    Distrito d;
    int zona=0;
    List<Ejecucionalgoritmo> lEjec;
    
    /**
     * Creates new form PanelSimulacionMonitoreo
     */
    
    public PanelSimulacionMonitoreo() throws Exception {
        initComponents();
        
        List<Horario> horarios = new ArrayList<>();
        horarios = HorarioController.getAllHorarios();
        txtVelProm.setText("");
        /*Agregar dias en combobox*/
        this.jComboBox1.removeAllItems();
        this.dias_id.add(0);
        jComboBox1.addItem("Seleccione");
        String diaAnt = null;
        for (Horario horario : horarios) { 
            String dia = horario.getDia();
            if (!dia.equalsIgnoreCase(diaAnt)) {
                jComboBox1.addItem(horario.getDia());
                dias_id.add(horario.getIdHorario());
                diaAnt = horario.getDia();
            }
        }
        
        /*Agregar horas en combobox*/
        this.jComboBox2.removeAllItems();
        this.horas_id.add(0);
        jComboBox2.addItem("Seleccione");
        int hora=0;        
        for (Horario horario : horarios) {
            if (hora < 3) {
                jComboBox2.addItem(horario.getHora());
                horas_id.add(horario.getIdHorario());
                hora++;
            }
        }
                
        this.setBackground(new java.awt.Color(240, 240, 240));
        
//        lEjec=EjecucionAlgoritmoController.obtenerConfiguraciónSimulación();
//        
//        configuracionComboBox.addItem("--Configuración por defecto--");
//        for (Ejecucionalgoritmo e:lEjec)
//        {
//            configuracionComboBox.addItem(e.getNombreSimulacion());
//            
//        }
        
        mapPanel = new WindowsMapPanel(new Dimension(ConfigPanelMapa.width,ConfigPanelMapa.height));
        mapContainerPanel.setVisible(true);
        mapPanel.setVisible(true);        
        
        mapContainerPanel.removeAll();
        mapContainerPanel.add(mapPanel);
                
        d = DistritoController.obtenerDistritoActivo();
        
        if (d == null){
            throw new Exception();
        }
        
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
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
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
        txtVelProm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mapContainerPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        zoomInButton = new javax.swing.JButton();
        zoomOutButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSemaforo = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();

        setPreferredSize(new java.awt.Dimension(1206, 700));
        setRequestFocusEnabled(false);

        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabbedPaneMousePressed(evt);
            }
        });

        iniciarSimulacionButton.setText("Iniciar Simulación");
        iniciarSimulacionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarSimulacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSimulacionButtonActionPerformed(evt);
            }
        });

        fechaLabel.setText("Día de Simulación:");

        jLabel1.setText("Velocidad promedio:");

        jTextField3.setEditable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel11.setText("km/h");

        jLabel13.setText("Nombre Siimulación:");

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
                                .addGap(72, 72, 72)
                                .addComponent(agregarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(simulacionPanelLayout.createSequentialGroup()
                                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fechaLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(simulacionPanelLayout.createSequentialGroup()
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(simulacionPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        simulacionPanelLayout.setVerticalGroup(
            simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iniciarSimulacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Simulación", simulacionPanel);

        iniciarMonitoreoButton.setText("Iniciar Monitoreo");
        iniciarMonitoreoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarMonitoreoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarMonitoreoButtonActionPerformed(evt);
            }
        });

        configuracionLabel.setText("Configuracion a usar:");

        configuracionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Velocidad promedio:");

        txtVelProm.setEditable(false);
        txtVelProm.setText("30.00");

        jLabel6.setText("Km/h");

        javax.swing.GroupLayout monitoreoPanelLayout = new javax.swing.GroupLayout(monitoreoPanel);
        monitoreoPanel.setLayout(monitoreoPanelLayout);
        monitoreoPanelLayout.setHorizontalGroup(
            monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(monitoreoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iniciarMonitoreoButton)
                    .addGroup(monitoreoPanelLayout.createSequentialGroup()
                        .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(configuracionLabel)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(monitoreoPanelLayout.createSequentialGroup()
                                .addComponent(txtVelProm, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(configuracionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        monitoreoPanelLayout.setVerticalGroup(
            monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitoreoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configuracionLabel)
                    .addComponent(configuracionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(monitoreoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVelProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addComponent(iniciarMonitoreoButton)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Monitoreo", monitoreoPanel);

        mapContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mapContainerPanel.setName("svdv"); // NOI18N

        javax.swing.GroupLayout mapContainerPanelLayout = new javax.swing.GroupLayout(mapContainerPanel);
        mapContainerPanel.setLayout(mapContainerPanelLayout);
        mapContainerPanelLayout.setHorizontalGroup(
            mapContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        mapContainerPanelLayout.setVerticalGroup(
            mapContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Leyenda"));

        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("Trafico Ligero");

        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Trafico Intermedio");

        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Trafico Lento");

        jLabel10.setText("Trafico Muerto");

        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("-----------");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("-----------");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel19.setForeground(new java.awt.Color(51, 204, 0));
        jLabel19.setText("-----------------");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("-----------");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel21.setText("----------");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel3))
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jLabel19)
                    .addContainerGap(247, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21))
                .addGap(40, 40, 40))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)))
        );

        zoomInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoomIn.png"))); // NOI18N
        zoomInButton.setToolTipText("");
        zoomInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInButtonActionPerformed(evt);
            }
        });

        zoomOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoomOut.png"))); // NOI18N
        zoomOutButton.setToolTipText("");
        zoomOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutButtonActionPerformed(evt);
            }
        });

        tablaSemaforo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Semaforo", "Vía P", "Vía S", "T.Verde", "T.Rojo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSemaforo.setToolTipText("");
        jScrollPane2.setViewportView(tablaSemaforo);
        if (tablaSemaforo.getColumnModel().getColumnCount() > 0) {
            tablaSemaforo.getColumnModel().getColumn(0).setResizable(false);
            tablaSemaforo.getColumnModel().getColumn(1).setResizable(false);
            tablaSemaforo.getColumnModel().getColumn(3).setResizable(false);
            tablaSemaforo.getColumnModel().getColumn(4).setResizable(false);
            tablaSemaforo.getColumnModel().getColumn(5).setResizable(false);
        }

        jProgressBar1.setToolTipText("");
        jProgressBar1.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zoomInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoomOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(zoomInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zoomOutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarMonitoreoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarMonitoreoButtonActionPerformed
        // TODO add your handling code here:
        if (configuracionComboBox.getSelectedIndex()>0)
        {
//            Ejecucionalgoritmo ea= lEjec.get(configuracionComboBox.getSelectedIndex()-1);
//            Horario h=HorarioController.obtenerHorarioPorID(d.getIdDistrito(), ea.getId().getIdHorario());
//            String[] c=configuracionComboBox.getSelectedItem().toString().split("/");
            String c[]=lEjec.get(configuracionComboBox.getSelectedIndex()-1).getNombreSimulacion().split("/");
            String[] f=c[1].split(" ");
            List<Ejecucionalgoritmoxsemaforo> listaAlgxSem=EjecucionAlgoritmoController.obtenerAlgoritmoxSemaforo();
            
            gr=new GeneradorRobot(mapPanel,d.getIdDistrito(),f[0],f[1],listaAlgxSem);
        }
        else
            JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Debe seleccionar una configuración de semáforos", "Error", ERROR_MESSAGE, null);

    }//GEN-LAST:event_iniciarMonitoreoButtonActionPerformed

    private void iniciarSimulacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSimulacionButtonActionPerformed
        // TODO add your handling code here:
        if (this.jComboBox1.getSelectedIndex() != 0 && this.jComboBox2.getSelectedIndex() != 0) {
            
            new Thread (new Runnable() {

                @Override
                public void run() {
                    
                    /*Inicializar y bloquear campos y botones*/
                    jProgressBar1.setValue(0);
                    jProgressBar1.setStringPainted(true);                    
                    jProgressBar1.setString("Ejecutando Simulacion ...");                                    
                    jTextField3.setText(" ");                    
                    jTextField7.setText(" ");
                    iniciarSimulacionButton.setEnabled(false);
                    agregarSimulacion.setEnabled(false);
                    jComboBox1.setEnabled(false);
                    jComboBox2.setEnabled(false);
                    zoomInButton.setEnabled(false);
                    zoomOutButton.setEnabled(false);
                    
                    DefaultTableModel tbm= new DefaultTableModel();
                    String [] titulos={"Id Semaforo","Vía P", "Vía S", "T.verde", "T.Rojo", "Estado"};
                    tbm.setColumnIdentifiers(titulos);
                    tablaSemaforo.setModel(tbm);     
                    /**/
                                             
                    int seleccion_dia = jComboBox1.getSelectedIndex(); // se captura el dia de simulacion del combobox
                    int seleccion_hora = jComboBox2.getSelectedIndex();  // se captura la hora de simulacion del combobox

                    Horario horario = HorarioController.getHorarioId(seleccion_dia, seleccion_hora);
                    Distrito distrito = DistritoController.obtenerDistritoActivo();
                    int numVehiculos = HorarioController.obtenerCarrosxHorarioxDistrito(horario.getIdHorario(),distrito.getIdDistrito());
                                            
                    Thread t =  new Thread(new jcThread(jProgressBar1, 100, 1) );
                    t.start();      
                    gr = new GeneradorRobot(numVehiculos, d.getIdDistrito(), mapPanel);
                    List<Object> vehiculos = gr.getListaVehiculosRuta();                                       
                    ArrayList<Semaforo> semaforos = semaforoController.obtenerSemaforosxdistrito(distrito.getNombre());
                    int numSemaforos = semaforos.size();
                    EjecucionAlgoritmoController.migrarVehiculos(numVehiculos , vehiculos);
                    EjecucionAlgoritmoController.iniciarSimulacion(numSemaforos, semaforos);                    
                    t.stop();
                    jProgressBar1.setValue(100);
                    
                    /*Hablitar bbotones y campos de ventana y actualziar valores*/
                    jTextField3.setText("" + GA.velocidad);                    
                    jTextField7.setText("" + GA.velocidadHistorica); 
                    
                    JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Simulación Exitosa","Acción",INFORMATION_MESSAGE,null);
                    
                    jProgressBar1.setValue(0);
                    jProgressBar1.setStringPainted(false);
                    iniciarSimulacionButton.setEnabled(true);
                    agregarSimulacion.setEnabled(true);
                    jComboBox1.setEnabled(true);
                    jComboBox2.setEnabled(true);
                    zoomInButton.setEnabled(true);
                    zoomOutButton.setEnabled(true);
                    /**/
                                                           
                    Individuo individuo = GA.mejorIndividuo;
                    int tamano = individuo.getIdNodoSemaforo().length;
                                        
                    tbm.setColumnIdentifiers(titulos); 
                    tablaSemaforo.setModel(tbm);
                    int j=0;
                    for (int i=0; i< tamano; i++){
                        
                        String datosSemaforoInicio[] = new String[6];
                        datosSemaforoInicio[0] = "" + semaforos.get(j).getId().getIdSemaforo();
                        datosSemaforoInicio[1] = "" + semaforos.get(j).getVia1();
                        datosSemaforoInicio[2] = "" + semaforos.get(j).getVia2();
                        /************************* Setear Semaforos *******************************/
                        if (semaforos.get(j).getEstado()) {
                            /*Si el semaforo esta habilitado se considera los tiempos del algoritmo*/
                            datosSemaforoInicio[3] = "" + individuo.getTiempoSemaforoInicio(i);
                            datosSemaforoInicio[4] = "" + individuo.getTiempoSemaforoFin(i);
                        }
                        else { 
                            datosSemaforoInicio[3] = "" + 0;
                            datosSemaforoInicio[4] = "" + 0;
                        }
                        /*************************************************************************/                        
                        if (semaforos.get(j).getEstado()) datosSemaforoInicio[5] = "Habilitado";
                        else datosSemaforoInicio[5] = "Deshabilitado";
                        tbm.addRow(datosSemaforoInicio);
                        
                        
                        String datosSemaforoFin[] = new String[6];
                        datosSemaforoFin[0] = " " + semaforos.get(j+1).getId().getIdSemaforo();
                        datosSemaforoFin[1] = "" + semaforos.get(j+1).getVia1();
                        datosSemaforoFin[2] = "" + semaforos.get(j+1).getVia2();
                        /*************************** Setear Semaforos ***************************/
                        if (semaforos.get(j+1).getEstado()) {
                            /*Si el semaforo esta habilitado se considera los tiempos del algoritmo*/
                            datosSemaforoFin[3] = "" + individuo.getTiempoSemaforoFin(i);
                            datosSemaforoFin[4] = "" + individuo.getTiempoSemaforoInicio(i);
                        }
                        else { 
                            datosSemaforoFin[3] = "" + 0;
                            datosSemaforoFin[4] = "" + 0;
                        }                        
                        /****************************************************************************/
                        if (semaforos.get(j+1).getEstado()) datosSemaforoFin[5] = "Habilitado";
                        else datosSemaforoFin[5] = "Deshabilitado";
                        tbm.addRow(datosSemaforoFin);
                        
                        j+=2;
                    }
                    tablaSemaforo.setModel(tbm);
                }               
            }) .start();
                               
        }
        else {
            JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Seleccione el dia y la hora para la Simulación", "Error", ERROR_MESSAGE, null);
        }
        
    }//GEN-LAST:event_iniciarSimulacionButtonActionPerformed

    private void zoomInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInButtonActionPerformed
        // TODO add your handling code here:
        
        Zona zona_obj = d.getZona(zona+1);
        if(zona_obj!=null){
            zona++;
            mapPanel.changeMapFile(zona_obj.getImagen());
            mapPanel.zoomIn();
        }
    }//GEN-LAST:event_zoomInButtonActionPerformed

    private void zoomOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutButtonActionPerformed
        // TODO add your handling code here:
        Zona zona_obj = d.getZona(zona-1);
        if(zona_obj!=null){
            zona--;
            mapPanel.changeMapFile(zona_obj.getImagen());
            mapPanel.zoomOut();
        }
    }//GEN-LAST:event_zoomOutButtonActionPerformed

    private void agregarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSimulacionActionPerformed
        // TODO add your handling code here:
        
        if (this.jTextField6.getText().trim().length() != 0 &&
                this.jComboBox1.getSelectedIndex() != 0 && this.jComboBox2.getSelectedIndex() != 0 &&
                this.jTextField7.getText().trim().length() != 0 && this.jTextField3.getText().trim().length() != 0) 
        {
            
            new Thread (new Runnable() {
                
                @Override
                public void run() {          
                       
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

                        /*Inicializar y bloquear campos y botones*/
                        jProgressBar1.setValue(0);
                        jProgressBar1.setStringPainted(true);
                        jProgressBar1.setString("Guardando Simulacion ...");                        
                        iniciarSimulacionButton.setEnabled(false);
                        agregarSimulacion.setEnabled(false);                        
                        jTextField6.setEnabled(false);
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(false);
                        zoomInButton.setEnabled(false);
                        zoomOutButton.setEnabled(false);
                        /**/       

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

                        int seleccion_dia = jComboBox1.getSelectedIndex(); // se captura el dia de simulacion del combobox
                        int seleccion_hora = jComboBox2.getSelectedIndex();  // se captura la hora de simulacion del combobox
                        Horario horario = HorarioController.getHorarioId(seleccion_dia, seleccion_hora);
                        int horarioid = horario.getIdHorario();
                        idEjecucionalgoritmo.setIdHorario(horarioid);

                        //Registramos la ejecucion
                        ejecucionAlgoritmo.setId(idEjecucionalgoritmo);                    
                        ejecucionAlgoritmo.setFecha(new Date());
                        ejecucionAlgoritmo.setVelocidadMaxima(Double.parseDouble(jTextField3.getText()));
                        ejecucionAlgoritmo.setVelocidadHistoria(Double.parseDouble(jTextField7.getText()));

                        String nombre = jTextField6.getText() + "/" + horario.getDia() + " " + horario.getHora() + " Vel:" + (int)(GA.velocidad) + "km/h" ;
                        ejecucionAlgoritmo.setNombreSimulacion(nombre);
                        ejecucionAlgoritmo.setTiempoEjecucion((double)(GA.tiempoEjecucion));

                        int ok = EjecucionAlgoritmoController.agregarEjecucionAlgoritmo(ejecucionAlgoritmo);
                        if(ok == 1)
                           {
                             
                               Thread t2 =  new Thread(new jcThread(jProgressBar1 , 100, 1) );
                               t2.start();
                               int idInicio = VehiculoController.agregarGeneracionVehiculos(Ejecucionalgoritmoid, horarioid);
                               VehiculoController.agregarGeneracionVehiculosXNodo(idInicio, Ejecucionalgoritmoid, horarioid); // esto es para la tabla VehiculoXNodo
                               EjecucionAlgoritmoController.agregarEjecucionAlgoritmoXSemaforo(Ejecucionalgoritmoid, horarioid);                               
                               t2.stop();
                               jProgressBar1.setValue(100);
//                               
                               JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Simulación agregada","Acción",INFORMATION_MESSAGE,null);

                               /*Hablitar botones y campos de ventana y actualziar valores*/                               
                               jProgressBar1.setStringPainted(false);
                               jProgressBar1.setValue(0);
                               //jProgressBar1.setVisible(false);
                               iniciarSimulacionButton.setEnabled(true);
                               agregarSimulacion.setEnabled(true);
                               jComboBox1.setEnabled(true);
                               jComboBox2.setEnabled(true);
                               jTextField6.setEnabled(true);
                               jTextField3.setText(" ");                               
                               jTextField7.setText(" ");
                               jTextField6.setText(" ");
                               zoomInButton.setEnabled(true);
                               zoomOutButton.setEnabled(true);
                               /**/ 
                               
                               
                               List<Horario> horariosNuevo = new ArrayList<>();
                               horariosNuevo = HorarioController.getAllHorarios();                                                   

                               /*Agregar dias en combobox*/
                               jComboBox1.removeAllItems();
                               dias_id.add(0);
                               jComboBox1.addItem("Seleccione");
                               String diaAnt = null;
                               for (Horario horarioNuevo : horariosNuevo) { 
                                   String dia = horarioNuevo.getDia();
                                   if (!dia.equalsIgnoreCase(diaAnt)) {
                                       jComboBox1.addItem(horarioNuevo.getDia());
                                       dias_id.add(horarioNuevo.getIdHorario());
                                       diaAnt = horarioNuevo.getDia();
                                   }
                               }                           

                               /*Agregar horas en combobox*/
                               jComboBox2.removeAllItems();
                               horas_id.add(0);
                               jComboBox2.addItem("Seleccione");
                               int hora=0;           
                               for (Horario horarioNuevo : horariosNuevo) {
                                   if (hora < 3) {
                                       jComboBox2.addItem(horarioNuevo.getHora());
                                       horas_id.add(horarioNuevo.getIdHorario());
                                       hora++;
                                   }
                               }

                               DefaultTableModel tbm= new DefaultTableModel();
                               String [] titulos={"Id Semaforo", "Via P", "Vía S", "T.Verde", "T.Rojo", "Estado"};
                               tbm.setColumnIdentifiers(titulos);
                               tablaSemaforo.setModel(tbm);
                               /********************************************************************************************/

                           }
                           else
                           {
                               JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Imposible agregar Simulación","Acción",ERROR_MESSAGE,null);
                           }
                    }
                }
                
                }
            }) .start();
            
        }      
        else {
            JOptionPane.showMessageDialog(PanelSimulacionMonitoreo.this, "Ingrese los campos para agregar Simulación", "Error", ERROR_MESSAGE, null);
        }
        
    }//GEN-LAST:event_agregarSimulacionActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
        ValidationUtil.validateCaracteresNumerosSpace(jTextField6.getText(), 15, evt);
        
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void configuracionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionComboBoxActionPerformed
        
        System.out.println(configuracionComboBox.getSelectedIndex());
        if (configuracionComboBox.getSelectedIndex()>0)
        {
            Ejecucionalgoritmo ejecAlg=lEjec.get(configuracionComboBox.getSelectedIndex()-1);

            List<Ejecucionalgoritmoxsemaforo> lEjecAlgSem=EjecucionAlgoritmoController.
                                                            getEjecucionxSemaforoById(ejecAlg.getId().getIdEjecucionAlgoritmo());

            DefaultTableModel tbm= new DefaultTableModel();
            String [] titulos={"Id Semaforo","Vía P", "Vía S", "T.verde", "T.Rojo", "Estado"};
            tbm.setColumnIdentifiers(titulos);
            tablaSemaforo.setModel(tbm); 
            
            List<Semaforo> sMod=new ArrayList<>();
            for (Ejecucionalgoritmoxsemaforo eas:lEjecAlgSem)
            {
                String datosSemaforoInicio[] = new String[6];
                Semaforo s=eas.getSemaforo();
                datosSemaforoInicio[0] = "" + s.getId().getIdSemaforo();
                //V. Principal.
                datosSemaforoInicio[1] = "" + s.getVia1();
                //V. Secundaria
                datosSemaforoInicio[2] = "" + s.getVia2();
                datosSemaforoInicio[3] = "" + eas.getTverde();
                datosSemaforoInicio[4] = "" + eas.getTrojo();
//                if (s.getEstado()) datosSemaforoInicio[4] = "" + 1;
//                else datosSemaforoInicio[4] = "" + 0;
                if (s.getEstado()) datosSemaforoInicio[5] = "Habilitado";
                else datosSemaforoInicio[5] = "Deshabilitado";
                tbm.addRow(datosSemaforoInicio);

                tablaSemaforo.setModel(tbm);
                Semaforo sm=new Semaforo();
                sm.setId(new SemaforoId(eas.getId().getIdSemaforo(), eas.getId().getIdNodo(), eas.getId().getIdDistrito()));
                sm.setTrojo(eas.getTrojo());
                sm.setTverde(eas.getTverde());
                sm.setEstado(true);
                sMod.add(sm);
            }
            semaforoController.actualizarSemaforosMonitoreo(sMod);
            txtVelProm.setText(ejecAlg.getVelocidadMaxima().toString());
        }
        else txtVelProm.setText("");
    }//GEN-LAST:event_configuracionComboBoxActionPerformed

    private void tabbedPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMousePressed
        
        if (tabbedPane.getSelectedIndex()==0)
        {
            if (gr!=null)
                {
                    System.out.println("Hilo stop");
                    gr.detenerHilo();
                    txtVelProm.setText("");
                }
        }
        System.out.println("Index: "+tabbedPane.getSelectedIndex());
        
        if (tabbedPane.getSelectedIndex() == 1) { 
            
            jTextField3.setText(" ");            
            jTextField7.setText(" ");
            jTextField6.setText(" ");
            
            List<Horario> horarios = new ArrayList<>();
            horarios = HorarioController.getAllHorarios();
            
            /*Agregar dias en combobox*/
            this.jComboBox1.removeAllItems();
            this.dias_id.add(0);
            jComboBox1.addItem("Seleccione");
            String diaAnt = null;
            for (Horario horario : horarios) { 
                String dia = horario.getDia();
                if (!dia.equalsIgnoreCase(diaAnt)) {
                    jComboBox1.addItem(horario.getDia());
                    dias_id.add(horario.getIdHorario());
                    diaAnt = horario.getDia();
                }
            }
            
            /*Agregar horas en combobox*/
            this.jComboBox2.removeAllItems();
            this.horas_id.add(0);
            jComboBox2.addItem("Seleccione");
            int hora=0;           
            for (Horario horario : horarios) {
                if (hora < 3) {
                    jComboBox2.addItem(horario.getHora());
                    horas_id.add(horario.getIdHorario());
                    hora++;
                }
            }
            
        }
        
        DefaultTableModel tbm= new DefaultTableModel();
        String [] titulos={"Id Semaforo","Vía P", "Vía S", "T.verde", "T.Rojo", "Estado"};
        tbm.setColumnIdentifiers(titulos);
        tablaSemaforo.setModel(tbm);
        Distrito d=DistritoController.obtenerDistritoActivo();
        lEjec=EjecucionAlgoritmoController.obtenerConfiguraciónSimulación();
        configuracionComboBox.removeAllItems();
        configuracionComboBox.addItem("--Configuración por defecto--");
        for (Ejecucionalgoritmo e:lEjec)
        {
            Ejecucionalgoritmoxsemaforo eas=EjecucionAlgoritmoController.getEjecucionxSemaforoById(e.getId().getIdEjecucionAlgoritmo()).get(0);
            
            if (eas.getId().getIdDistrito()==d.getIdDistrito())
                configuracionComboBox.addItem(e.getNombreSimulacion().split("/")[0]);
            
        }
    }//GEN-LAST:event_tabbedPaneMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarSimulacion;
    private javax.swing.JComboBox configuracionComboBox;
    private javax.swing.JLabel configuracionLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel fechaLabel1;
    private javax.swing.JButton iniciarMonitoreoButton;
    private javax.swing.JButton iniciarSimulacionButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel mapContainerPanel;
    private javax.swing.JPanel monitoreoPanel;
    private javax.swing.JPanel simulacionPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaSemaforo;
    private javax.swing.JTextField txtVelProm;
    private javax.swing.JButton zoomInButton;
    private javax.swing.JButton zoomOutButton;
    // End of variables declaration//GEN-END:variables
}
