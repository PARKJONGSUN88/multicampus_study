package lab.java.core;

public class Person {
	public String  id;
    private String name;
    //생성자 메서드를 명시적으로 정의하지 않으면
    //default 생성자를 컴파일시에 JDK라 생성해줍니다.
    public void setName(String n) {
    	name = n;
    }
    
    public String getName() {
    	return name;
    }
}
