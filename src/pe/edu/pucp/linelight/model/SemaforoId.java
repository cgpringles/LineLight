package pe.edu.pucp.linelight.model;
// Generated 11/06/2014 07:24:50 PM by Hibernate Tools 3.2.1.GA



/**
 * SemaforoId generated by hbm2java
 */
public class SemaforoId  implements java.io.Serializable {


     private long idSemaforo;
     private long idNodo;

    public SemaforoId() {
    }

    public SemaforoId(long idSemaforo, long idNodo) {
       this.idSemaforo = idSemaforo;
       this.idNodo = idNodo;
    }
   
    public long getIdSemaforo() {
        return this.idSemaforo;
    }
    
    public void setIdSemaforo(long idSemaforo) {
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
		 if ( !(other instanceof SemaforoId) ) return false;
		 SemaforoId castOther = ( SemaforoId ) other; 
         
		 return (this.getIdSemaforo()==castOther.getIdSemaforo())
 && (this.getIdNodo()==castOther.getIdNodo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdSemaforo();
         result = 37 * result + (int) this.getIdNodo();
         return result;
   }   


}


