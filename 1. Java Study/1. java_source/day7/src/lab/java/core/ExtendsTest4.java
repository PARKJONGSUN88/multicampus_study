package lab.java.core;

class Parent4 {     
}

class Child4 extends Parent4{ //상속	 
}

class Child1 extends Parent4{ //상속	 
}
public class ExtendsTest4 {
	public static void main(String[] args) {
		  Child4 c4 = new Child4();
		  Child1 c1 = new Child1();
		  Parent4 p = new Parent4();
		  // 레퍼런스변수(객체) instanceof 타입(클래스명, 인터페이스명)
		  System.out.println(c4 instanceof Child4); // is a 관계 체크
		  System.out.println(c4 instanceof Parent4); //상속 관계 체크
		  System.out.println(p instanceof Child4); //상속 관계 체크
		  //System.out.println(c1 instanceof Child4); //직접 상속 관계 없는 경우 컴파일 오류
	}
}

