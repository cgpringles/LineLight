package pe.edu.pucp.linelight.model;
// Generated 03/06/2014 08:23:06 PM by Hibernate Tools 3.6.0



/**
 * TramoxnodoId generated by hbm2java
 */
public class TramoxnodoId  implements java.io.Serializable {


     private int idTramo;
     private int idDistrito;
     private long idVia;
     private long idNodo;

    public TramoxnodoId() {
    }

    public TramoxnodoId(int idTramo, int idDistrito, long idVia, long idNodo) {
       this.idTramo = idTramo;
       this.idDistrito = idDistrito;
       this.idVia = idVia;
       this.idNodo = idNodo;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TramoxnodoId) ) return false;
		 TramoxnodoId castOther = ( TramoxnodoId ) other; 
         
		 return (this.getIdTramo()==castOther.getIdTramo())
 && (this.getIdDistrito()==castOther.getIdDistrito())
 && (this.getIdVia()==castOther.getIdVia())
 && (this.getIdNodo()==castOther.getIdNodo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdTramo();
         result = 37 * result + this.getIdDistrito();
         result = 37 * result + (int) this.getIdVia();
         result = 37 * result + (int) this.getIdNodo();
         return result;
   }   


}


