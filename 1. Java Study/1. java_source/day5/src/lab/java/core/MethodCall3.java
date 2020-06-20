package lab.java.core;

public class MethodCall3 {
	public void change(int[] a, int b[]) {
		 int temp = a[0];
		 a[0] = b[0];
		 b[0] = temp;
	}
	 

	public static void main(String[] args) {
		MethodCall3 call = new MethodCall3();
		int x[]= {3}, y[]= {4};
		call.change(x, y); 
		System.out.println("x[0]="+x[0]+", y[0]="+y[0]);
	}
}






