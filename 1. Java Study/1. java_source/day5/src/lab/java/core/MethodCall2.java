package lab.java.core;

public class MethodCall2 {
	public void change(int a, int b) {
		 int temp = a;
		 a = b;
		 b = temp;
	}
	 

	public static void main(String[] args) {
		MethodCall2 call = new MethodCall2();
		int x=3, y=4;
		call.change(x, y); 
		System.out.println("x="+x+", y="+y);
	}
}






