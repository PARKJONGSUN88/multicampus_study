package lab.java.basic;

class Outer {
	private int outVar= 5;
	public void outerMethod() {
		//System.out.println("outVar="+outVar);
		Inner inner = new Inner();
		System.out.println("inVar="+inner.inVar);
	}
    protected class Inner {
		private int inVar = 10;
		public void innerMethod() {
			System.out.println("outVar="+outVar);
		}
	}
}
public class MemberInnerTest {

	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.innerMethod();
		Outer outer = new Outer();
		outer.outerMethod();
		//Outer.Inner inner2 = outer.new Inner();
	}

}





