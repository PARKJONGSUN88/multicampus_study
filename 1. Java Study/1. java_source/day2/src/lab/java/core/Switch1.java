package lab.java.core;

import java.util.Scanner;

public class Switch1 {
	public static void main(String[] args) {
		System.out.print("1~100사이의 정수를 입력하세요:");
		Scanner input = new Scanner(System.in);
		int num= input.nextInt();
		 
		switch(num%2) {
		case 0:
			System.out.println(num+"은 짝수"); break;
		case 1:
			System.out.println(num+"은 홀수");
		}		

	}

}





