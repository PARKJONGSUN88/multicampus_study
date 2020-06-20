package lab.java.core;

public class OverloadTest {
    public void plus(int a, int b) {
    	System.out.println("(int, int)");
    }
    public void plus(double a, double b) {
    	System.out.println("(double, double)");
    }
    protected String plus(String a, String b) {
    	System.out.println("(String, String)");
    	return null;
    }    
    protected int plus(int a, int b, int c) {
    	System.out.println("(int, int, int)");
    	return a+b+c;
    }
	public static void main(String[] args) {
		OverloadTest test = new OverloadTest();
		test.plus(3,  4);
		test.plus('A', 0.5f);
//		1.컴파일 에러
//		2. runtime exception
//		3. 정상 실행
	}

}



