/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.linelight.reportClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rzuniga
 */
public class LogsReports {
    String desde;
    String hasta;
    List<logs> logs= new ArrayList<>();

    public LogsReports() {
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public List<logs> getLogs() {
        return logs;
    }

    public void setLogs(List<logs> logs) {
        this.logs = logs;
    }


    
    
}
