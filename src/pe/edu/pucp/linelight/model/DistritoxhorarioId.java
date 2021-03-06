package pe.edu.pucp.linelight.model;
// Generated 12/06/2014 12:06:23 AM by Hibernate Tools 3.6.0



/**
 * DistritoxhorarioId generated by hbm2java
 */
public class DistritoxhorarioId  implements java.io.Serializable {


     private int idDistrito;
     private int idHorario;

    public DistritoxhorarioId() {
    }

    public DistritoxhorarioId(int idDistrito, int idHorario) {
       this.idDistrito = idDistrito;
       this.idHorario = idHorario;
    }
   
    public int getIdDistrito() {
        return this.idDistrito;
    }
    
    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
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
		 if ( !(other instanceof DistritoxhorarioId) ) return false;
		 DistritoxhorarioId castOther = ( DistritoxhorarioId ) other; 
         
		 return (this.getIdDistrito()==castOther.getIdDistrito())
 && (this.getIdHorario()==castOther.getIdHorario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdDistrito();
         result = 37 * result + this.getIdHorario();
         return result;
   }   


}


