/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.structure;

/**
 *
 * @author Cesar
 */
public class MatrizMap {
    
    //columnas=x
    //filas=y
    //MATRIZ[filas][columnas]
    
    int[][] matriz;
    int numFilas;
    int numColumnas;
    public static int PISTA = 0;
    public static int NODO=100;
    

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }
    

    public MatrizMap(int sizex, int sizey) {
        matriz=new int[sizey][sizex];
        numFilas=sizey;
        numColumnas=sizex;
        for (int i=0;i<sizey;i++)
        {
            for (int j=0;j<sizex;j++)
            {
                matriz[i][j]=-1; //restringido para vehiculos: parques, edificios, etc
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    public void setValueXY(int x, int y, int val)
    {
        matriz[y][x]=val;
    }
    
    public int getValueXY(int x,int y)
    {
        return matriz[y][x];
    }
    
    
    public boolean esPista(int x, int y)
    {
        if (matriz[x][y]==PISTA) return true;
        return false;
    }
    
    public void mostrarMatriz()
    {
        for (int i=0;i<numFilas;i++)
        {
            for (int j=0;j<numColumnas;j++)
                System.out.print(matriz[i][j]);
            
            System.out.println("");
        }
        
        
    }
    
}
