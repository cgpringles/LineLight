/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;
import pe.edu.pucp.linelight.controller.EjecucionAlgoritmoController;
import pe.edu.pucp.linelight.controller.UsuarioController;
import pe.edu.pucp.linelight.controller.VehiculoController;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmo;
import pe.edu.pucp.linelight.model.Ejecucionalgoritmoxsemaforo;
import pe.edu.pucp.linelight.model.Usuario;
import pe.edu.pucp.linelight.model.Usuarioxaccion;
import pe.edu.pucp.linelight.model.Vehiculo;
import pe.edu.pucp.linelight.model.Vehiculoxnodo;
import pe.edu.pucp.linelight.reportClasses.HistoricoReport;
import pe.edu.pucp.linelight.reportClasses.LogsReports;
import pe.edu.pucp.linelight.reportClasses.Semaforo_aux;
import pe.edu.pucp.linelight.reportClasses.SemaforosReport;
import pe.edu.pucp.linelight.reportClasses.UsuariosReport;
import pe.edu.pucp.linelight.reportClasses.logs;
import pe.edu.pucp.linelight.reportClasses.vehiculo_r;

/**
 *
 * @author Charito
 */
public class SeguridadReportes extends javax.swing.JPanel {

    
    JasperPrint jp=new JasperPrint();
    List<Ejecucionalgoritmo> lEjec;
    List<Usuario> users;
    /**
     * Creates new form SeguridadReportes
     */
    public SeguridadReportes() {
        initComponents();
        lEjec=EjecucionAlgoritmoController.obtenerConfiguraciónSimulación();
        simulaciones.removeAllItems();
         simulaciones.addItem("Seleccione");
         simulaciones_dh.removeAllItems();
         simulaciones_dh.addItem("Seleccione");
        for (Ejecucionalgoritmo e:lEjec)
        {
            simulaciones.addItem(e.getNombreSimulacion().split("/")[0]);
            simulaciones_dh.addItem(e.getNombreSimulacion().split("/")[0]);
        }
        users=UsuarioController.getAllUsuarios();
        usuarios.removeAllItems();
        usuarios.addItem("Seleccione");
        for (Usuario e:users)
        {
            usuarios.addItem(e.getIdUsuario());
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

        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        simulaciones = new javax.swing.JComboBox();
        Imprimir = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        usuarios = new javax.swing.JComboBox();
        Imprimir1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        desde = new com.toedter.calendar.JDateChooser();
        hasta = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        simulaciones_dh = new javax.swing.JComboBox();
        Imprimir2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 647));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de semáforos por optimización"));

        jLabel10.setText("Nombre de la simulación:");

        simulaciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("(*)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(36, 36, 36)
                .addComponent(simulaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Imprimir)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(simulaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imprimir)
                    .addComponent(jLabel26))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Logs del Sistema"));

        jLabel11.setText("Usuario:");

        usuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Imprimir1.setText("Imprimir");
        Imprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimir1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Hasta:");

        jLabel13.setText("Desde:");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(41, 41, 41)
                .addComponent(Imprimir1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imprimir1)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Histórica de Vehículos"));

        jLabel14.setText("Nombre de la simulación:");

        simulaciones_dh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        simulaciones_dh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulaciones_dhActionPerformed(evt);
            }
        });

        Imprimir2.setText("Imprimir");
        Imprimir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimir2ActionPerformed(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("(*)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel14)
                .addGap(36, 36, 36)
                .addComponent(simulaciones_dh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(Imprimir2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(simulaciones_dh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imprimir2)
                    .addComponent(jLabel29))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        if(simulaciones.getSelectedIndex()!=0){
        try {
            init_semaforos();

            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte_conf_semaforos.pdf"));
            
            exporter.exportReport();
            
            JasperViewer jviewer= new JasperViewer(jp,false);
            jviewer.setTitle("Reporte_conf_semaforos");
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(SeguridadReportes.class.getName()).log(Level.SEVERE, null, ex);
               }  
        }else{
             JOptionPane.showMessageDialog(SeguridadReportes.this, "Seleccione una simulación", "Error", ERROR_MESSAGE, null);
        }
        
        
    }//GEN-LAST:event_ImprimirActionPerformed

    private void Imprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimir1ActionPerformed
       if(desde.getDate()!=null && hasta.getDate()!=null){
        try {
            init_logs();

            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte_logs.pdf"));
            
            exporter.exportReport();
            
            JasperViewer jviewer= new JasperViewer(jp,false);
            jviewer.setTitle("Reporte_logs");
            jviewer.setVisible(true);
        } catch (   JRException | ParseException ex) {
            Logger.getLogger(SeguridadReportes.class.getName()).log(Level.SEVERE, null, ex);
               }  
        }else{
             JOptionPane.showMessageDialog(SeguridadReportes.this, "Seleccione un rango de fechas", "Error", ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_Imprimir1ActionPerformed

    private void Imprimir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimir2ActionPerformed
        if(simulaciones_dh.getSelectedIndex()!=0){
        try {
            init_historico();

            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte_historico.pdf"));
            
            exporter.exportReport();
            
            JasperViewer jviewer= new JasperViewer(jp,false);
            jviewer.setTitle("Reporte_historico");
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(SeguridadReportes.class.getName()).log(Level.SEVERE, null, ex);
               }  
        }else{
             JOptionPane.showMessageDialog(SeguridadReportes.this, "Seleccione una simulación", "Error", ERROR_MESSAGE, null);
        }
        
        
    }//GEN-LAST:event_Imprimir2ActionPerformed

    private void simulaciones_dhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulaciones_dhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simulaciones_dhActionPerformed

    
    
public void init_semaforos() {
URL in = null;
      try{
          in = this.getClass().getResource("/pe/edu/pucp/linelight/reports/semaforosReport.jasper");
          List<SemaforosReport> lista = new ArrayList<>();
          SemaforosReport raut=new SemaforosReport();

          raut.setSimulacion(lEjec.get(simulaciones.getSelectedIndex()-1).getNombreSimulacion().split("/")[0]);

          
          List<Ejecucionalgoritmoxsemaforo> lista_sem=EjecucionAlgoritmoController.getEjecucionxSemaforoById(lEjec.get(simulaciones.getSelectedIndex()-1).getId().getIdEjecucionAlgoritmo());
          List<Semaforo_aux> semaforos= new ArrayList<>();
          for(int i=0; i< lista_sem.size(); i++){
              Semaforo_aux sem= new Semaforo_aux();
              if(lista_sem.get(i).getSemaforo().getEstado())
                sem.setEstado("activo");
              else
                sem.setEstado("inactivo");
              sem.setId_nodo(String.valueOf(lista_sem.get(i).getId().getIdNodo()));
              sem.setId_semaforo(String.valueOf(lista_sem.get(i).getSemaforo().getId().getIdSemaforo()));
              sem.setT_rojo(lista_sem.get(i).getTrojo().toString());
              sem.setT_verde(lista_sem.get(i).getTverde().toString());
              semaforos.add(sem);
          }
          raut.setSemaforos(semaforos);
         lista.add(raut);
          JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(lista);
          jp=JasperFillManager.fillReport(in.getPath(), new HashMap(),beanCollectionDataSource);    
        } catch(JRException e){
           e.printStackTrace();
      }


}    
public void init_historico() {
URL in = null;
      try{
          in = this.getClass().getResource("/pe/edu/pucp/linelight/reports/historicoReport.jasper");
          List<HistoricoReport> lista = new ArrayList<>();
          HistoricoReport raut=new HistoricoReport();         
          raut.setSimulacion(lEjec.get(simulaciones_dh.getSelectedIndex()-1).getNombreSimulacion());

          
          List<Vehiculo> lista_v=VehiculoController.getVehiculosByIdEjecucion(lEjec.get(simulaciones_dh.getSelectedIndex()-1).getId().getIdEjecucionAlgoritmo());
          List<vehiculo_r> vehiculos= new ArrayList<>();
          for(int i=0; i< lista_v.size(); i++){
              vehiculo_r aux= new vehiculo_r();
              aux.setId(lista_v.get(i).getId().getIdVehiculo());
              List<Vehiculoxnodo> listavn= new ArrayList<>();
             for (Object m : lista_v.get(i).getVehiculoxnodos()) {
                  Vehiculoxnodo vxn = (Vehiculoxnodo)m;
                  listavn.add(vxn);
              }
             aux.setNodos(listavn);
             aux.setPosactual(lista_v.get(i).getPosActual());
             aux.setPosfin(lista_v.get(i).getPosFin());
             aux.setPosini(lista_v.get(i).getPosInit());
             aux.setVelocidad(lista_v.get(i).getVelocidad());
             vehiculos.add(aux);
          }
          raut.setVehiculos(vehiculos);
         lista.add(raut);
          JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(lista);
          jp=JasperFillManager.fillReport(in.getPath(), new HashMap(),beanCollectionDataSource);    
        } catch(JRException e){
           e.printStackTrace();
      }


}    
    
public void init_usuarios() throws JRException, ParseException{
        URL in = null;
      try{
          in = this.getClass().getResource("/pe/edu/pucp/linelight/reports/usuariosReport.jasper");
          List<UsuariosReport> lista = new ArrayList<>();
          UsuariosReport raut=new UsuariosReport();
          raut.setUsuarios(UsuarioController.getAllUsuarios());
        
         
         lista.add(raut);
          JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(lista);
          jp=JasperFillManager.fillReport(in.getPath(), new HashMap(),beanCollectionDataSource);    
        } catch(JRException e){
           e.printStackTrace();
      }
  }

public void init_logs() throws JRException, ParseException{
        URL in = null;
      try{
          in = this.getClass().getResource("/pe/edu/pucp/linelight/reports/logsReport.jasper");
          List<LogsReports> lista = new ArrayList<>();
          String idUsuario;
          LogsReports raut=new LogsReports();
          SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
          raut.setDesde(dt1.format(desde.getDate()));
          raut.setHasta(dt1.format(hasta.getDate()));
          if(usuarios.getSelectedIndex()==0) 
              idUsuario=null;
          else
              idUsuario=users.get(usuarios.getSelectedIndex()-1).getIdUsuario();
          List<Usuarioxaccion> lista_acciones=UsuarioController.getByUserDate(idUsuario,desde.getDate(),hasta.getDate());
          List<logs> logs= new ArrayList<>();
          SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
          for(int i=0;i<lista_acciones.size();i++){
              logs log=new logs();
              log.setAccion(lista_acciones.get(i).getAccion().getDescripcion());
              log.setFecha(dt.format(lista_acciones.get(i).getId().getFecha()));
              log.setTabla(lista_acciones.get(i).getTabla());
              log.setUsuario(lista_acciones.get(i).getUsuario().getIdUsuario());
              log.setIp(lista_acciones.get(i).getIp());
              logs.add(log);
          }
          raut.setLogs(logs);
        
         
         lista.add(raut);
          JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(lista);
          jp=JasperFillManager.fillReport(in.getPath(), new HashMap(),beanCollectionDataSource);    
        } catch(JRException e){
           e.printStackTrace();
      }
  }


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton Imprimir1;
    private javax.swing.JButton Imprimir2;
    private com.toedter.calendar.JDateChooser desde;
    private com.toedter.calendar.JDateChooser hasta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox simulaciones;
    private javax.swing.JComboBox simulaciones_dh;
    private javax.swing.JComboBox usuarios;
    // End of variables declaration//GEN-END:variables
}
