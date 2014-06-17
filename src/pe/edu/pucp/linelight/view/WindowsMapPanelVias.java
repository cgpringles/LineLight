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
import pe.edu.pucp.linelight.controller.NodoController;
import pe.edu.pucp.linelight.controller.TramoController;
import pe.edu.pucp.linelight.controller.ViaController;
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
    public ArrayList<Integer> idTramos = null;
    public Nodo nodoOrigen = null;
    public Nodo nodoFin = null;
    public long idViaGen = 0; 
    public int idDistrito = 0;
   
    /**
     * Creates new form MapPanel
     */
    public WindowsMapPanelVias(Dimension d) {
        initComponents();
        setBackground(new Color(236,233,222));
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
        g2d.setColor(Color.RED);
        Zona z=ZonaController.obtenerZonaCentral(idDistrito);
        if (idTramos != null){ 
            for (int i = 0; i < idTramos.size(); i++){
            ArrayList<Tramoxnodo> listaNodos = ViaController.obtenerTramoxnodo(idViaGen, idDistrito, idTramos.get(i));
            nodoOrigen = NodoController.obtenerNodoPorId(listaNodos.get(1).getId().getIdNodo());
            nodoFin = NodoController.obtenerNodoPorId(listaNodos.get(0).getId().getIdNodo());
            Point2D p = ConvertUtil.convertirGPStoPixel(nodoOrigen.getLatitud(), nodoOrigen.getLongitud(),z);
            Point2D p2 = ConvertUtil.convertirGPStoPixel(nodoFin.getLatitud(), nodoFin.getLongitud(),z);
//            g2d.drawLine((int) ((p.getX() + x_offset)*scale),
//                            (int) ((p.getY() + y_offset)*scale),
//                            (int) ((p2.getX() + x_offset)*scale), 
//                            (int) ((p2.getY() + y_offset)*scale));  
            
            g2d.drawLine((int) ((p.getX()+5)*scale -x_offset),
                            (int) ((p.getY()+5)*scale - y_offset),
                            (int) ((p2.getX()+5)*scale - x_offset), 
                            (int) ((p2.getY()+5)*scale  - y_offset));  
            }
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void zoomIn(){
        scale *= 2.0;
        repaint();
    }
    
    public void zoomOut(){
        scale =1;
        repaint();
    }
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
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    void changeMapFile(byte[] imagen) {
        this.bgImage=new ImageIcon(imagen).getImage();
        x_offset = 0;
        y_offset = 0;
        scale = (float) 1.0;
        repaint();
    }
        
    @Override
    public void update(Graphics g)
    {
        Image offscreen;
        Graphics offgc;
        offscreen=createImage(ConfigPanelMapa.width, ConfigPanelMapa.height);
	offgc = offscreen.getGraphics();
	offgc.setColor(getBackground());
	offgc.fillRect(0, 0, ConfigPanelMapa.width,ConfigPanelMapa.height);
	offgc.setColor(getForeground());
	paint(offgc);
	g.drawImage(offscreen, 0, 0, this);
        
    }
}
