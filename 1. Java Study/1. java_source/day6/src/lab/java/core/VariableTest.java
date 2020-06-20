package lab.java.core;

public class VariableTest {
    int a;
    final int B=2;
    static int c;
	public static void main(String[] args) {
		VariableTest test = new VariableTest(); 
		System.out.println(test.a);
		System.out.println(test.B);
		System.out.println(test.c++);
		System.out.println(VariableTest.c++);//객체 생성없이 클래스이름으로 참조 가능
		System.out.println(c++);
	}
	
	

}
