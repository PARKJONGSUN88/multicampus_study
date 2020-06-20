package lab.java.basic;

class Outer3 {
	private int outVar= 5;
	 
	public void outerMethod() {	
		method();
		//Inner inner = new Inner();
	}
	
	public void method() {
		int local = 10;
		class Inner {	//Local Inner Class	 
			public void innerMethod() {			 
				 System.out.println("local="+local);
				 //local +=3;
				 //Local Inner Class가 참조하는 local변수는 final이어야 합니다.
			}
		}
		Inner inner = new Inner();
		inner.innerMethod();
	}
   
 
}
public class LocalInnerTest {
	public static void main(String[] args) {
		  Outer3 outer = new Outer3();
		  outer.method();
	}

}





