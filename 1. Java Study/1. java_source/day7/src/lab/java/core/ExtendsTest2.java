package lab.java.core;

class Parent2 {
   public Parent2() {
	   System.out.println(1);   
 	   }
   public Parent2(String talent) {
	   System.out.println(2);
   }
}

class Child2 extends Parent2{ //»ó¼Ó
	public Child2() {
		super("IT"); //super()
		System.out.println(3);
	}
	public Child2(String talent) {		
		 System.out.println(4);
	}
}

public class ExtendsTest2 {
	public static void main(String[] args) {
		 Child2 c2 = new Child2();
		 Child2 c3 = new Child2("DB");
	}
}

