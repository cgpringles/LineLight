package pe.edu.pucp.linelight.model;
// Generated 11/06/2014 07:24:50 PM by Hibernate Tools 3.2.1.GA



/**
 * EjecucionalgoritmoId generated by hbm2java
 */
public class EjecucionalgoritmoId  implements java.io.Serializable {


     private int idParamAlgoritmo;
     private int idEjecucionAlgoritmo;
     private String idUsuario;
     private int idConfiguracionSistema;
     private int idHorario;

    public EjecucionalgoritmoId() {
    }

    public EjecucionalgoritmoId(int idParamAlgoritmo, int idEjecucionAlgoritmo, String idUsuario, int idConfiguracionSistema, int idHorario) {
       this.idParamAlgoritmo = idParamAlgoritmo;
       this.idEjecucionAlgoritmo = idEjecucionAlgoritmo;
       this.idUsuario = idUsuario;
       this.idConfiguracionSistema = idConfiguracionSistema;
       this.idHorario = idHorario;
    }
   
    public int getIdParamAlgoritmo() {
        return this.idParamAlgoritmo;
    }
    
    public void setIdParamAlgoritmo(int idParamAlgoritmo) {
        this.idParamAlgoritmo = idParamAlgoritmo;
    }
    public int getIdEjecucionAlgoritmo() {
        return this.idEjecucionAlgoritmo;
    }
    
    public void setIdEjecucionAlgoritmo(int idEjecucionAlgoritmo) {
        this.idEjecucionAlgoritmo = idEjecucionAlgoritmo;
    }
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdConfiguracionSistema() {
        return this.idConfiguracionSistema;
    }
    
    public void setIdConfiguracionSistema(int idConfiguracionSistema) {
        this.idConfiguracionSistema = idConfiguracionSistema;
    }
    public int getIdHorario() {
        return this.idHorario;
    }
    
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EjecucionalgoritmoId) ) return false;
		 EjecucionalgoritmoId castOther = ( EjecucionalgoritmoId ) other; 
         
		 return (this.getIdParamAlgoritmo()==castOther.getIdParamAlgoritmo())
 && (this.getIdEjecucionAlgoritmo()==castOther.getIdEjecucionAlgoritmo())
 && ( (this.getIdUsuario()==castOther.getIdUsuario()) || ( this.getIdUsuario()!=null && castOther.getIdUsuario()!=null && this.getIdUsuario().equals(castOther.getIdUsuario()) ) )
 && (this.getIdConfiguracionSistema()==castOther.getIdConfiguracionSistema())
 && (this.getIdHorario()==castOther.getIdHorario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdParamAlgoritmo();
         result = 37 * result + this.getIdEjecucionAlgoritmo();
         result = 37 * result + ( getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode() );
         result = 37 * result + this.getIdConfiguracionSistema();
         result = 37 * result + this.getIdHorario();
         return result;
   }   


}


