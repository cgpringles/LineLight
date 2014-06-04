/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.structure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.DocumentException;

/**
 *
 * @author Julio
 */
public class Map {
    private List<Node> nodes;
    private List<Edge> edges;
    private float width;
    private float height;

    public Map(File file){
        nodes = new ArrayList();
        edges = new ArrayList();
        try {
//            MapParser.parseFile(file, nodes, edges);
        } catch (Exception  ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //width = calculateWidth();
        //width = calculateHeight();
    }

    public Map() {
        nodes = new ArrayList();
        edges = new ArrayList();
    }
    
    /**
     * @return the nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }


    /*private float calculateWidth() {
        float minX = (float) Double.POSITIVE_INFINITY;
        float maxX = 0;
        for (Node node : nodes) {
            if(node.getX())
	}
    }*/

    /**
     * @return the edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * @param edges the edges to set
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    
}
