package lab.java.basic;

public class InterfaceTest {

	public static void main(String[] args) {
		//Animal animal = new Animal();
		System.out.println(Animal.EYES);//static속성임을 증명
		Animal animal = new Cat(); //다형성 객체
		animal.move();
		((Cat)animal).eat();
		
	}

}
