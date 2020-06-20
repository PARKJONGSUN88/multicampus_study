package lab.java.basic;

class Outer2 {
	private int outVar= 5;
	static int  staticOutVar = 100;
	public void outerMethod() {
		 Inner.innerMethod();
	}
   static class Inner {		 
		public static void innerMethod() {
			//System.out.println("outVar="+outVar);
			System.out.println("staticOutVar="+staticOutVar);
		}
	}
//   static class Inner2 {
//	   static int staticInVar = 1;
//   }
}
public class StaticInnerTest {
	public static void main(String[] args) {
		 Outer2.Inner.innerMethod();		 
		 Outer2 outer = new Outer2();
		 outer.outerMethod();
	}

}





