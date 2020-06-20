package exercise.inheritance;

public class LanguageTest {

	public static void main(String[] args) {
/*다형성 객체 -상속관계가 있는 경우 부모로 타입을 선언하고
		 생성은 자식클래스타입으로 생성 
부모와 자식에 동일한 속성이 존재할 때 부모 우선적 access합니다.
부모에 선언되어 있지 않은 변수는 객체 캐스팅을 해야 접근 가능합니다.
부모의 메서드를 자식클래스에서 override한 경우, 메서드를 호출하면 
자식클래스의 override메서드가 존재하면 자식 클래스의 메서드를 우선적으로 
호출합니다.
부모에 선언되어 있지 않은 메서드는 객체 캐스팅을 해야 호출가능합니다.
	 */
		Language k = new Korean();
		System.out.println(k.region);
		Language e = new English();
		System.out.println(e.region);
		Language j = new Japanese();
		System.out.println(j.region);
		k.sayHello();
		e.sayHello();
		j.sayHello();

	}

}
