package lab.java.core;

public class MethodCall {
	public void plus(int a, int b) {
		System.out.println(a+b);
	}
	public void plus(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	public void plus(int a, int b, int c, int d) {
		System.out.println(a+b+c+d);
	}

	public static void main(String[] args) {
		MethodCall call = new MethodCall();
		int x=3, y=4;
		call.plus(x, y);
		call.plus(1, 2, 3);
		call.plus(x,  y, 5, 6);
	}
}






