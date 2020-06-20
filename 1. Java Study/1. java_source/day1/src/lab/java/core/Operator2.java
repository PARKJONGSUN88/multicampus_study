package lab.java.core;

public class Operator2 {

	public static void main(String[] args) {
		//비교연산자( >, >=, <,<=, ==, !=)의 결과는 항상 boolean값 입니다.         
        int a = 5, b = 7;         
        System.out.println(b==a);
        System.out.println(b!=a);
        //Primitive Data Type은 값을 비교합니다.
        //Reference Data Type은 주소값이 비교됩니다.
        String s1 = new String("java");
        String s2 = new String("java");
        System.out.println(s1==s2);
        
        String s3 = "java" ;//String 상수 pool 영역에 객체 생성
        String s4 = "java";
        System.out.println(s3==s4);
        
        //논리합, 논리곱 ex) true&true,   true&false
        //비트연산자 1&1=>1 , 1&0=>0 , 0&0=>0, 1|1=>1, 1|0=>1, 0|0=>0, 1^1=>0, 1^0=>1
        System.out.println(b&a);
        System.out.println(b|a);
        System.out.println(b^a); //비트연산후에 정수로 출력
         
        System.out.println(true&true);
        System.out.println(false|false);
        System.out.println(true^false); //비트연산후에 논리값으로 출력
        
        
	}

}








