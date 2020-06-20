package lab.java.core;

public class MethodTest {
	int member = 0;
	MethodTest(){
	   System.out.println ("MethodTest() called");
	}
    MethodTest(int a){
    	this();    
    	System.out.println ("MethodTest(int) called");    	
	}
	
    public int method1() {
    	int local = 1;
    	return local;
    }
    public void method2(int member) {
    	System.out.println(method1()); 
    	System.out.println(member);
    	//클래스 내부에서 자신을 객체 생성하지 않고 this를 사용합니다.
    	//this는 객체 생성될때 자신을 참조하는 reference변수입니다.
    	System.out.println(this.member);
    	//메서드내에 선언된 local변수는 메모리에 메서드가 호출될때 생성되고,
    	//메서드 수행이 종료되면 GC되므로, local변수는 메서드 외부에서 참조 불가합니다.
    	System.out.println(this.method1()); 
    	//클래스 내부에서 멤버들간에 메서드 호출은 객체 생성없이 호출 가능
    	
    }
	public static void main(String[] args) {
		MethodTest  test = new MethodTest (3);
		test.method2(100);
	}

}


