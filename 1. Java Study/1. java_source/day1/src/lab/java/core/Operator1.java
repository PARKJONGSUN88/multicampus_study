package lab.java.core;

public class Operator1 {

	public static void main(String[] args) {
		//산술연산자(*, /, +, -, %)         
        int a = 5, b = 7;         
        System.out.println(b%a);
        System.out.println(b/a);//   정수/정수는 정수결과를 리턴함
        System.out.println((float)b/a); //   실수/정수는 실수를 리턴함
        
        //문자열 + 모든 타입은 문자열로 결합됩니다.
        System.out.println("java"+8);
        System.out.println("java"+true);
        
        
	}

}








