package pe.edu.pucp.linelight.model;
// Generated 03/06/2014 08:23:06 PM by Hibernate Tools 3.6.0



/**
 * EjecucionalgoritmoxsemaforoId generated by hbm2java
 */
public class EjecucionalgoritmoxsemaforoId  implements java.io.Serializable {


     private int idParamAlgoritmo;
     private int idEjecucionAlgoritmo;
     private String idUsuario;
     private int idConfiguracionSistema;
     private int idSemaforo;
     private long idNodo;

    public EjecucionalgoritmoxsemaforoId() {
    }

    public EjecucionalgoritmoxsemaforoId(int idParamAlgoritmo, int idEjecucionAlgoritmo, String idUsuario, int idConfiguracionSistema, int idSemaforo, long idNodo) {
       this.idParamAlgoritmo = idParamAlgoritmo;
       this.idEjecucionAlgoritmo = idEjecucionAlgoritmo;
       this.idUsuario = idUsuario;
       this.idConfiguracionSistema = idConfiguracionSistema;
       this.idSemaforo = idSemaforo;
       this.idNodo = idNodo;
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
    public int getIdSemaforo() {
        return this.idSemaforo;
    }
    
    public void setIdSemaforo(int idSemaforo) {
        this.idSemaforo = idSemaforo;
    }
    public long getIdNodo() {
        return this.idNodo;
    }
    
    public void setIdNodo(long idNodo) {
        this.idNodo = idNodo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EjecucionalgoritmoxsemaforoId) ) return false;
		 EjecucionalgoritmoxsemaforoId castOther = ( EjecucionalgoritmoxsemaforoId ) other; 
         
		 return (this.getIdParamAlgoritmo()==castOther.getIdParamAlgoritmo())
 && (this.getIdEjecucionAlgoritmo()==castOther.getIdEjecucionAlgoritmo())
 && ( (this.getIdUsuario()==castOther.getIdUsuario()) || ( this.getIdUsuario()!=null && castOther.getIdUsuario()!=null && this.getIdUsuario().equals(castOther.getIdUsuario()) ) )
 && (this.getIdConfiguracionSistema()==castOther.getIdConfiguracionSistema())
 && (this.getIdSemaforo()==castOther.getIdSemaforo())
 && (this.getIdNodo()==castOther.getIdNodo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdParamAlgoritmo();
         result = 37 * result + this.getIdEjecucionAlgoritmo();
         result = 37 * result + ( getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode() );
         result = 37 * result + this.getIdConfiguracionSistema();
         result = 37 * result + this.getIdSemaforo();
         result = 37 * result + (int) this.getIdNodo();
         return result;
   }   


}


