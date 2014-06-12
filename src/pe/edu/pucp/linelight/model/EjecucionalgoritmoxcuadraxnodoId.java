package pe.edu.pucp.linelight.model;
// Generated 11/06/2014 07:24:50 PM by Hibernate Tools 3.2.1.GA



/**
 * EjecucionalgoritmoxcuadraxnodoId generated by hbm2java
 */
public class EjecucionalgoritmoxcuadraxnodoId  implements java.io.Serializable {


     private int idParamAlgoritmo;
     private int idEjecucionAlgoritmo;
     private String idUsuario;
     private int idConfiguracionSistema;
     private int idTramo;
     private int idDistrito;
     private long idVia;
     private long idNodo;
     private int idHorario;

    public EjecucionalgoritmoxcuadraxnodoId() {
    }

    public EjecucionalgoritmoxcuadraxnodoId(int idParamAlgoritmo, int idEjecucionAlgoritmo, String idUsuario, int idConfiguracionSistema, int idTramo, int idDistrito, long idVia, long idNodo, int idHorario) {
       this.idParamAlgoritmo = idParamAlgoritmo;
       this.idEjecucionAlgoritmo = idEjecucionAlgoritmo;
       this.idUsuario = idUsuario;
       this.idConfiguracionSistema = idConfiguracionSistema;
       this.idTramo = idTramo;
       this.idDistrito = idDistrito;
       this.idVia = idVia;
       this.idNodo = idNodo;
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
    public int getIdTramo() {
        return this.idTramo;
    }
    
    public void setIdTramo(int idTramo) {
        this.idTramo = idTramo;
    }
    public int getIdDistrito() {
        return this.idDistrito;
    }
    
    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }
    public long getIdVia() {
        return this.idVia;
    }
    
    public void setIdVia(long idVia) {
        this.idVia = idVia;
    }
    public long getIdNodo() {
        return this.idNodo;
    }
    
    public void setIdNodo(long idNodo) {
        this.idNodo = idNodo;
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
		 if ( !(other instanceof EjecucionalgoritmoxcuadraxnodoId) ) return false;
		 EjecucionalgoritmoxcuadraxnodoId castOther = ( EjecucionalgoritmoxcuadraxnodoId ) other; 
         
		 return (this.getIdParamAlgoritmo()==castOther.getIdParamAlgoritmo())
 && (this.getIdEjecucionAlgoritmo()==castOther.getIdEjecucionAlgoritmo())
 && ( (this.getIdUsuario()==castOther.getIdUsuario()) || ( this.getIdUsuario()!=null && castOther.getIdUsuario()!=null && this.getIdUsuario().equals(castOther.getIdUsuario()) ) )
 && (this.getIdConfiguracionSistema()==castOther.getIdConfiguracionSistema())
 && (this.getIdTramo()==castOther.getIdTramo())
 && (this.getIdDistrito()==castOther.getIdDistrito())
 && (this.getIdVia()==castOther.getIdVia())
 && (this.getIdNodo()==castOther.getIdNodo())
 && (this.getIdHorario()==castOther.getIdHorario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdParamAlgoritmo();
         result = 37 * result + this.getIdEjecucionAlgoritmo();
         result = 37 * result + ( getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode() );
         result = 37 * result + this.getIdConfiguracionSistema();
         result = 37 * result + this.getIdTramo();
         result = 37 * result + this.getIdDistrito();
         result = 37 * result + (int) this.getIdVia();
         result = 37 * result + (int) this.getIdNodo();
         result = 37 * result + this.getIdHorario();
         return result;
   }   


}


