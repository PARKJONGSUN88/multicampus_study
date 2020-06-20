package lab.java.core;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		int base=0, height =0;		
	    char answer='\u0000';
		do {		
		Scanner input = new Scanner(System.in);
		System.out.print("Base = ");
		base =input.nextInt(); 
		System.out.print("Height = ");
		height =input.nextInt(); 		
		
		System.out.printf("Triangle Width = %.1f\n",(base*height)*0.5);
		//Math함수의 round()함수는 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴시켜줍니다
		//소수점 둘째 자리까지 나타내고싶으시면 100.0을 곱하였다가 나눠주시면 되고
		//소수점 셋째 자리까지 나타내고싶으시면 1000.0을 곱하였다가 나눠주면 됩니다.
		System.out.println("Triangle Width ="+ Math.round((base*height)*0.5*100)/100.0);
		// String클래스의 format 메소드는 리턴되는 문자열 형태를 지정하는 함수인데
		//이 함수를 활용하면 Math.round() 함수와 같이 소수점 n번째 자리까지 반올림하여 나타낼 수 있습니다.
		System.out.println("Triangle Width = "+String.format("%.1f", (base*height)*0.5));
		System.out.print("Continue ? ");
		answer = input.next().charAt(0);
		}while(answer=='Y'||answer=='y');

	}

}




