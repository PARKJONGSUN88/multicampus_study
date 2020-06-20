package lab.java.basic;

public class AnnoymousTest {

	public static void main(String[] args) {
		//public class Bird implements Animal 선언 없이
		//생성과 동시에 구현이 되는 클래스
		Animal bird = new Animal() {//익명클래스 시작
			@Override
			public void move() {
				System.out.println("Flying");				
			}			
			public void eat() {
				System.out.println("벌레");
			}			
		};//익명클래스 끝
		bird.move();
		//bird.eat();
		 

}
