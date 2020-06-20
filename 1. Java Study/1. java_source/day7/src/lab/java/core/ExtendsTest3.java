package lab.java.core;

class Parent3 {
    int age = 55;    
}

class Child3 extends Parent3{ //상속
	int age = 26;
	public void printAge() {
		int age = 23;
		System.out.println(age);//가장 가까운 범위(scope)에서 검색
		System.out.println(this.age);//메서드의 멤버인 속성을 읽기
		System.out.println(super.age); //상속받은 속성을 읽기
		//자식객체가 생성될때 부모를 참조하는 변수가 자동 생성 : super
	}
}

public class ExtendsTest3 {
	public static void main(String[] args) {
		  Child3 c = new Child3();
		  c.printAge();
	}
}

