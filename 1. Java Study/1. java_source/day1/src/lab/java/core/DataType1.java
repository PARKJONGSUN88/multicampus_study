package lab.java.core;

public class DataType1 {

	public static void main(String[] args) {
		boolean success = false;//정수와 호환 불가, 키워드 false 또는 true만 값으로 저장 가능합니다.
		//메모리는 1byte할당
		System.out.println(success);
		//success = 1;
		
		//byte 정수자료형 , 1byte 할당, sign bit, binary , -2^7 ~ 2^7-1, -128 ~ 127
		byte num1 = 127;
		System.out.println(num1);
		//num1 = 128; 
		
		//short 정수자료형 , 2byte 할당, -2^15 ~ 2^15-1, -32768~32767
		short num2 = 32767;
		System.out.println(num2);
		//num2 = 32768;
		
		//int 정수자료형, 4byte 할당, -2^31 ~ 2^31-1, -2147483648~2147483647
		int num3 = 2147483647; //정수 literal의 기본형은 int
		System.out.println(num3);
		//num3 = 2147483648;
		num3 = 077;//8진수
		System.out.println(num3);//출력은 decimal 10진수로
		num3 = 0xff;//16진수
		System.out.println(num3);//출력은 decimal 10진수로
		
		//long 정수자료형, -2^63 ~2^63-1
		long num4 = 2147483648L; 
		System.out.println(num4);
		
		
		//char 문자 자료형, 자바는 unicode지원 ,  2byte할당, 0~2^16-1, 0~65535
		char ch1 = 'A';
		System.out.println(ch1);
		ch1 = 97; //ascii코드값
		System.out.println(ch1);
		ch1 = '\u0063'; //unicode 코드값
		System.out.println(ch1);
		
		//실수 자료형 , 부동소수점 형식 (가수부, 지수부) , 4byte할당
		float num5 = 3.14F;  //실수 literal의 default 유형은 double(8byte)
		System.out.println(num5);
		double num6 = 3.14;
		System.out.println(num6);
		num6 = 1.204307E-5; //IEEE표기형식, 과학적 수치 표기형식
		System.out.println(num6);
		num6 = 1.204307E+9;
		System.out.println(num6);
		
		//문자열은 Reference Data Type (객체)
		String st = new String("java"); //st는 객체명, heap메모리에 객체 생성
		System.out.println(st);
		System.out.println(st.length());
		
		String st2 = "java";  //String 상수 pool 메모리 영역에 생성
		System.out.println(st2);
		
		final int PORT = 9000; //상수
		System.out.println(PORT);
		//PORT = 5555;
		
	}

}









