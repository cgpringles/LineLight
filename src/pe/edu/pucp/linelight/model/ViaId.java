package pe.edu.pucp.linelight.model;
// Generated 12/06/2014 12:06:23 AM by Hibernate Tools 3.6.0



/**
 * ViaId generated by hbm2java
 */
public class ViaId  implements java.io.Serializable {


     private int idDistrito;
     private long idVia;

    public ViaId() {
    }

    public ViaId(int idDistrito, long idVia) {
       this.idDistrito = idDistrito;
       this.idVia = idVia;
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
		 if ( !(other instanceof ViaId) ) return false;
		 ViaId castOther = ( ViaId ) other; 
         
		 return (this.getIdDistrito()==castOther.getIdDistrito())
 && (this.getIdVia()==castOther.getIdVia());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdDistrito();
         result = 37 * result + (int) this.getIdVia();
         return result;
   }   


}


