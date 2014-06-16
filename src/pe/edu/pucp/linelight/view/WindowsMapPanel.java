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
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import pe.edu.pucp.linelight.model.Semaforo;
import pe.edu.pucp.linelight.robot.Carro;
import pe.edu.pucp.linelight.structure.Edge;
import pe.edu.pucp.linelight.structure.Map;
import pe.edu.pucp.linelight.structure.MatrizMap;
import pe.edu.pucp.linelight.structure.Node;
import pe.edu.pucp.linelight.util.ConfigPanelMapa;

/**
 *
 * @author Julio
 */
public class WindowsMapPanel extends javax.swing.JPanel {

    private Map map;
    private Image bgImage;

    //private static final int NODE_SIZE = 5;
    private int x_offset = 0;
    private int y_offset = 0;
    private Point mousePt;
    private float scale = (float) 1.0;
    
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
    public WindowsMapPanel(Dimension d) {
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
        for (Edge edge : map.getEdges()) {
            
            Semaforo s=edge.getOriginNode().getS();
            if (s!=null)
            {
                if (s.getEstado()==Semaforo.ROJO) g2d.setColor(Color.red);
                else g2d.setColor(Color.YELLOW);
                
                //Semaforos deshabilitados
                if (s.getTverde()==0) g2d.setColor(Color.DARK_GRAY);
                g2d.fillOval((int)edge.getOriginNode().getX()+x_offset,(int)edge.getOriginNode().getY()+y_offset,5,5); 
                
                if (s.getEstado()==Semaforo.ROJO) g2d.setColor(Color.YELLOW);
                else g2d.setColor(Color.red);
                
                //Semaforos deshabilitados - espejo
                if (s.getTverde()==0) g2d.setColor(Color.DARK_GRAY);
                g2d.fillOval((int)edge.getOriginNode().getX()+5,(int)edge.getOriginNode().getY()+5,5,5);
            }
            
            if (edge.getFlujoActual()==0) continue;
            //Mostrar detalle velocidad
            
//            int textX=Math.round((edge.getEndNode().getX()-edge.getOriginNode().getX())/2)+edge.getOriginNode().getX();
//            int textY=Math.round((edge.getEndNode().getY()-edge.getOriginNode().getY())/2)+edge.getOriginNode().getY();
            
//            g2d.drawString("Holaaaaaaaaaaa", 0, 0);
            
            g2d.setColor(getColorTraffic(edge.getVelocidad()));
//            g2d.setColor(getColorTraffic(Math.random()*80));
            g2d.drawLine((int) ((edge.getOriginNode().getX())*scale - x_offset),
                        (int) ((edge.getOriginNode().getY())*scale - y_offset),
                        (int) ((edge.getEndNode().getX())*scale - x_offset), 
                        (int) ((edge.getEndNode().getY())*scale - y_offset));
            
            //Cargamos la data de la estructura matriz
            
//            Node n1=edge.getOriginNode();
//            Node n2=edge.getEndNode();
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
//        return traficoLigero;
        if (v<=10) return traficoMuerto;
        if (v>10 && v<=25) return traficoPesado;
        if (v>25 && v<=40) return traficoMediano;
        
        return traficoLigero;
    }
    
    public void zoomIn(){
        scale *= 1.5;
        repaint();
    }
    
    public void zoomOut(){
        scale /= 1.5;
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
