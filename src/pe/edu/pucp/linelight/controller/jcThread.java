/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.linelight.controller;



import javax.swing.JProgressBar;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class jcThread implements Runnable{

    private JProgressBar jProgressBar;
    private int i = 1;
    private int value = 250;
    private int ventana = 0;

    /**
 * Constructor de clase
 */
    public jcThread( JProgressBar jProgressBar , int value, int ventana )
    {
        this.jProgressBar = jProgressBar;
        this.value = value;
        this.ventana = ventana;
    }

    @Override
    public void run() {
        i = 1;        
        if (ventana == 0){
            while( !parseViasStructure.band )
            {
                i = (i > 100) ? 1 : i+1;
                jProgressBar.setValue(i);
                jProgressBar.repaint();  
                try{Thread.sleep( this.value );}            
                catch (InterruptedException e){ System.err.println( e.getMessage() ); }            
                if( parseViasStructure.band )
                {
                    jProgressBar.setValue(100);
                    System.out.println("Trabajo finalizado...");
                    break;
                }            
            }
        }else{
            while( !parseSemaforosStructure.band )
            {
                i = (i > 100) ? 1 : i+1;
                jProgressBar.setValue(i);
                jProgressBar.repaint();  
                try{Thread.sleep( this.value );}            
                catch (InterruptedException e){ System.err.println( e.getMessage() ); }            
                if( parseSemaforosStructure.band )
                {
                    jProgressBar.setValue(100);
                    System.out.println("Trabajo finalizado...");
                    break;
                }            
            }
        }
    }

}

