package lab.java.core;

public class AbnormalValueException extends Exception{
     private double oldTall = 161.2;      
     
     public AbnormalValueException(String message) {
    	 super(message);
     }
     
     public double getOldTall() {
    	 return oldTall;
     }
     
}
