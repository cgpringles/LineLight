package pe.edu.pucp.linelight.model;
// Generated 04/06/2014 09:38:07 PM by Hibernate Tools 3.6.0



/**
 * Distritoxhorario generated by hbm2java
 */
public class Distritoxhorario  implements java.io.Serializable {


     private DistritoxhorarioId id;
     private Horario horario;
     private Distrito distrito;
     private String numCarros;

    public Distritoxhorario() {
    }

	
    public Distritoxhorario(DistritoxhorarioId id, Horario horario, Distrito distrito) {
        this.id = id;
        this.horario = horario;
        this.distrito = distrito;
    }
    public Distritoxhorario(DistritoxhorarioId id, Horario horario, Distrito distrito, String numCarros) {
       this.id = id;
       this.horario = horario;
       this.distrito = distrito;
       this.numCarros = numCarros;
    }
   
    public DistritoxhorarioId getId() {
        return this.id;
    }
    
    public void setId(DistritoxhorarioId id) {
        this.id = id;
    }
    public Horario getHorario() {
        return this.horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public Distrito getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public String getNumCarros() {
        return this.numCarros;
    }
    
    public void setNumCarros(String numCarros) {
        this.numCarros = numCarros;
    }




}


