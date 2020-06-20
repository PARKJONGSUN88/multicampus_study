package lab.java.core;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.id);
		p1.id="korea";
		System.out.println(p1.id);
		//p1.name="¥Î«—πŒ±π";
		p1.setName("¥Î«—πŒ±π");
		//System.out.println(p1.name);
		System.out.println(p1.getName());
	}

}
