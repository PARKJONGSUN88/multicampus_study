package lab.java.core;

import java.util.Scanner;

public class Switch2 {
	public static void main(String[] args) {
		System.out.print("1~100사이의 점수를 입력하세요:");
		Scanner input = new Scanner(System.in);
		int jumsu= input.nextInt();
		 
		switch(jumsu/10) {
		case 10:
		case 9:
			System.out.println(jumsu+"은 A"); break;
		case 8:
			System.out.println(jumsu+"은 B"); break;		
		case 7:
			System.out.println(jumsu+"은 C"); break;
		case 6:
			System.out.println(jumsu+"은 D"); break;
		default:
			System.out.println(jumsu+"은 F");
		}		

	}

}





