package lab.java.core;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		//삼항연산자 조건표현식?표현식1:표현식2
		//정수를 입력받아서 짝수인지 홀수인지 출력
		Scanner input = new Scanner(System.in);
		System.out.print("정수 입력하세요=>");
		int num = input.nextInt();
		System.out.print(num%2==0?"짝수":"홀수");
		
		//연산식내에서 자동으로 가장 큰 타입으로 형변환promotion이 일어납니다.
		double result = 3>4?99.9:90;		
		int result2 = (int)(3>4?99.9:90);

	}

}
