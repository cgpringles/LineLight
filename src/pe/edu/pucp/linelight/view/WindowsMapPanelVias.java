/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import pe.edu.pucp.linelight.controller.DistritoController;
import pe.edu.pucp.linelight.controller.TramoController;
import pe.edu.pucp.linelight.controller.ZonaController;
import pe.edu.pucp.linelight.model.Nodo;
import pe.edu.pucp.linelight.model.Semaforo;
import pe.edu.pucp.linelight.model.Tipovia;
import pe.edu.pucp.linelight.model.Tramo;
import pe.edu.pucp.linelight.model.Tramoxnodo;
import pe.edu.pucp.linelight.model.Zona;
import pe.edu.pucp.linelight.robot.Carro;
import pe.edu.pucp.linelight.structure.Edge;
import pe.edu.pucp.linelight.structure.Map;
import pe.edu.pucp.linelight.structure.MatrizMap;
import pe.edu.pucp.linelight.structure.Node;
import pe.edu.pucp.linelight.util.ConfigPanelMapa;
import pe.edu.pucp.linelight.util.ConvertUtil;

/**
 *
 * @author Julio
 */
public class WindowsMapPanelVias extends javax.swing.JPanel {

    private Map map;
    private Image bgImage;

    //private static final int NODE_SIZE = 5;
    private int x_offset = 0;
    private int y_offset = 0;
    private Point mousePt;
    private float scale = (float) 1.0;
    public Nodo nodoOrigen = null;
    public Nodo nodoFin = null;
    private final Color traficoLigero=Color.decode("#52E645");
    private final Color traficoMediano=Color.decode("#DB7A2A");
    private final Color traficoPesado=Color.decode("#B51417");
    private final Color traficoMuerto=Color.decode("#471011");
    
    private List<Carro> listaCarros=null;

    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }
   
    /**
     * Creates new form MapPanel
     */
    public WindowsMapPanelVias(Dimension d) {
        initComponents();
        setBackground(new Color(236,233,222));
        //Doble buffer gráfico - Hilos
        this.setDoubleBuffered(true);
        setSize(d);
        map = new Map();
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
                setCursor(cursor);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = mousePt.x - e.getX();
                int dy = mousePt.y - e.getY();
                
//                if((x_offset+dx>=0)&&(x_offset +dx+ ConfigPanelMapa.width <= bgImage.getWidth(null))){
//                    x_offset -= dx;
//                }
//                if((y_offset+dy>=0)&&(y_offset +dy+ ConfigPanelMapa.height <= bgImage.getHeight(null))){
//                    y_offset -= dy;
//                }
                
                if((x_offset+dx>=0)&&(x_offset +dx+ ConfigPanelMapa.width <= bgImage.getWidth(null))){
                    x_offset += dx;
                }
                if((y_offset+dy>=0)&&(y_offset +dy+ ConfigPanelMapa.height <= bgImage.getHeight(null))){
                    y_offset += dy;
                }
                mousePt = e.getPoint();
                repaint();
            }
        });
        this.addMouseWheelListener(new MouseWheelListener(){
            @Override
            public void mouseWheelMoved( MouseWheelEvent e )
            {
                if (e.getWheelRotation() < 0){
                    zoomIn();
                }
                else{
                    zoomOut();
                }
            }
        });
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bgImage,  0, 0,ConfigPanelMapa.width,ConfigPanelMapa.height
                , x_offset, y_offset, x_offset+ConfigPanelMapa.width, y_offset+ConfigPanelMapa.height, null);
        
        g2d.setStroke(new BasicStroke(2f));
        g2d.setColor(Color.green);
        Zona z=ZonaController.obtenerZonaCentral(DistritoController.obtenerDistritoActivo().getIdDistrito());
        if (nodoOrigen != null && nodoFin != null){ 
        Point2D p=ConvertUtil.convertirGPStoPixel(nodoOrigen.getLatitud(), nodoOrigen.getLongitud(),z);
        Point2D p2=ConvertUtil.convertirGPStoPixel(nodoFin.getLatitud(), nodoFin.getLongitud(),z);
         
        g2d.drawLine((int) ((p.getX() + x_offset)*scale),
                        (int) ((p.getY() + y_offset)*scale),
                        (int) ((p2.getX() + x_offset)*scale), 
                        (int) ((p2.getY() + y_offset)*scale));    
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Color getColorTraffic(double v)
    {
        if (v<=10) return traficoMuerto;
        if (v>10 && v<=25) return traficoPesado;
        if (v>25 && v<=40) return traficoMediano;
        
        return traficoLigero;
    }
    
    public void zoomIn(){
        scale *= 1.2;
        repaint();
    }
    
    public void zoomOut(){
        scale =1;
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        /*System.out.println("ksdjnsd");
        JPopupMenu menu = new JPopupMenu();
        
        JMenuItem menuItem = new JMenuItem("Agregar...");
        menu.add(menuItem);
        
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int seleccion = JOptionPane.showOptionDialog(
                    WindowsMapPanel.this, // Componente padre
                    "¿Esta seguro que desea agregar un semaforo?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
                
                if (seleccion != -1)
                {
                   if(seleccion == 0)
                   {
                      int seleccion2 = JOptionPane.showOptionDialog(
                            WindowsMapPanel.this, // Componente padre
                            "El semaforo ha sido agregado exitosamente", //Mensaje
                            "Mensaje de confirmación", // Título
                            JOptionPane.OK_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            null,    // null para icono por defecto.
                            new Object[] { "Aceptar"},    // null para YES, NO y CANCEL
                            "Si");
                   }
                   else
                   {
                      // PRESIONO NO
                   }
                }
            }
          };
        
        menuItem.addActionListener(menuListener);
        JMenuItem menuItem2 = new JMenuItem("Informacion...");
        menu.add(menuItem2);
        
        ActionListener menuListenerInformacion = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                WindowInformacionSemaforo semaforo = new WindowInformacionSemaforo();
                semaforo.setVisible(true);
            }
          };
        menuItem2.addActionListener(menuListenerInformacion);
        
        JMenuItem menuItem3 = new JMenuItem("Deshabilitar");
        menu.add(menuItem3);
        ActionListener menuListenerDeshabilitar = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int seleccion = JOptionPane.showOptionDialog(
                    WindowsMapPanel.this, // Componente padre
                    "¿Esta seguro que desea deshabilitar el semaforo?", //Mensaje
                    "Mensaje de confirmación", // Título
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                    "Si");
                
                if (seleccion != -1)
                {
                   if(seleccion == 0)
                   {
                      int seleccion2 = JOptionPane.showOptionDialog(
                            WindowsMapPanel.this, // Componente padre
                            "El semaforo ha sido deshabilitado exitosamente", //Mensaje
                            "Mensaje de confirmación", // Título
                            JOptionPane.OK_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            null,    // null para icono por defecto.
                            new Object[] { "Aceptar"},    // null para YES, NO y CANCEL
                            "Si");
                   }
                   else
                   {
                      // PRESIONO NO
                   }
                }
            }
          };
        menuItem3.addActionListener(menuListenerDeshabilitar);
        
        
        menu.show(evt.getComponent(), evt.getX(), evt.getY());
        */
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    void changeMapFile(byte[] imagen) {
//        map = new Map(sourceFile);
//        this.bgImage=new ImageIcon("C:\\Users\\PC-HP\\Desktop\\Linelight2\\LineLight2\\test.png").getImage();
        this.bgImage=new ImageIcon(imagen).getImage();
        x_offset = 0;
        y_offset = 0;
        scale = (float) 1.0;
        repaint();
    }
    
    public Node findNodeById(Long id,List<Node> listan)
    {
        
        for (Node n:listan)
        {
            if (n.getId().equals(id))
                return n;
        }
        
        return null;
    }
    
    @Override
    public void update(Graphics g)
    {
         
        Image offscreen;
        Graphics offgc;
        
        offscreen=createImage(ConfigPanelMapa.width, ConfigPanelMapa.height);
        
	offgc = offscreen.getGraphics();
	// clear the exposed area
	offgc.setColor(getBackground());
	offgc.fillRect(0, 0, ConfigPanelMapa.width,ConfigPanelMapa.height);
	offgc.setColor(getForeground());
	// do normal redraw
	paint(offgc);
	// transfer offscreen to window
	g.drawImage(offscreen, 0, 0, this);
        
    }
    
    public void drawCars(List<Carro> listaCarros)
    {
        this.listaCarros=listaCarros;
        repaint();
//        for (Carro c: listaCarros)
//        {
//            this.getGraphics().drawOval (c.getPosX(), c.getPosY(), 5, 5);
////            System.out.println(c.getPosX()+" - "+c.getPosY());
//        }
    }
    
    
}
