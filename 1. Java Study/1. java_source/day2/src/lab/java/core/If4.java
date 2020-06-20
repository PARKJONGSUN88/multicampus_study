package lab.java.core;

import java.util.Scanner;

public class If4 {
	public static void main(String[] args) {
		System.out.print("1~100사이의 점수를 입력하세요:");
		Scanner input = new Scanner(System.in);
		int jumsu= input.nextInt();
		 
		if(jumsu>89) {
			System.out.println(jumsu+"은 A");
		}else if(jumsu>79) {
			System.out.println(jumsu+"은 B");
		}else if(jumsu>69) {
			System.out.println(jumsu+"은 C");
		}else if(jumsu>59) {
			System.out.println(jumsu+"은 D");
		}else {
			System.out.println(jumsu+"은 F");
		}

	}

}





