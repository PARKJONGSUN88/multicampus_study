package lab.java.core;

public class StaticTest {
    static int snum; //클래스변수
    int num; //인스턴스 변수
    
    public static void staticMethod() {
    	snum++; //클래스 변수 처리 가능
    //	num++;  //인스턴변수 처리 불가능
    }
    public void method() {
    	snum++;
    	num++;
    }
	public static void main(String[] args) {
		StaticTest test = new StaticTest();
		test.method();
		staticMethod();
		System.out.println(snum);
		System.out.println(test.num);

	}

}
