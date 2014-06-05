package pe.edu.pucp.linelight.model;
// Generated 04/06/2014 09:38:07 PM by Hibernate Tools 3.6.0



/**
 * TramoId generated by hbm2java
 */
public class TramoId  implements java.io.Serializable {


     private int idTramo;
     private int idDistrito;
     private long idVia;

    public TramoId() {
    }

    public TramoId(int idTramo, int idDistrito, long idVia) {
       this.idTramo = idTramo;
       this.idDistrito = idDistrito;
       this.idVia = idVia;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TramoId) ) return false;
		 TramoId castOther = ( TramoId ) other; 
         
		 return (this.getIdTramo()==castOther.getIdTramo())
 && (this.getIdDistrito()==castOther.getIdDistrito())
 && (this.getIdVia()==castOther.getIdVia());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdTramo();
         result = 37 * result + this.getIdDistrito();
         result = 37 * result + (int) this.getIdVia();
         return result;
   }   


}


