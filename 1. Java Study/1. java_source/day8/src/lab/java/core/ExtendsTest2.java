package lab.java.core;

class Parent2 {
   int num = 1;
   public void method() {
	   System.out.println("Parent2.method() called");
   }
   public void parentMethod() {
	   System.out.println("Parent2.parentMethod() called");
   }
}

class Child2 extends Parent2{
   int num = 2;
   public void method() {
	   System.out.println("Child2.method() called");
   }
   public void childMethod() {
	   System.out.println("Child2.childMethod() called");
   }
}


public class ExtendsTest2 {
	public static void main(String[] args) {
		Parent2 p = new Parent2();
		System.out.println(p.num);
		p.method();
		p.parentMethod();
//부모로 선언되고, 생성한 객체는 자식클래스의 메서드 호출 불가
		//p.childMethod(); 
		
		Child2  c = new Child2();
		System.out.println(c.num);
		c.method();
		c.parentMethod();
		c.childMethod(); 
		
		Parent2 p2 = new Child2();//다형성 객체
		System.out.println(p2.num);//선언된 부모의 멤버변수에 우선적으로 접근
		p2.method();
		p2.parentMethod();
		//p2.childMethod(); 
		((Child2)p2).parentMethod();
		System.out.println(((Child2)p2).num);
	}

}






