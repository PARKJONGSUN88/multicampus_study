package lab.java.core;

public class Calc {
   public int plus(int a, int b) {
	   return a+b;
   }
   
   public int minus(int a, int b) {
	   if(a < b)  {
		   int temp = a;
		   a = b;
		   b = temp;
	   }
	   return a-b;
   }
   public int multiply(int a, int b) {
	   return a* b;
   }
   public int div(int a, int b) {
	   if(a < b)  {
		   int temp = a;
		   a = b;
		   b = temp;
	   }
	   return a / b;
   }
   
   public int mod(int a, int b) {
	   if(a < b)  {
		   int temp = a;
		   a = b;
		   b = temp;
	   }
	   return a % b;
   }
}
