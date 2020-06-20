package com.workshop1.one;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		while(true) {
			System.out.print("숫자를 입력하세요(종료:0):");
			int num = getUserInput();
			if(num==0) {
				System.out.println("Bye~~");
				break;
			}
			if(num==1) {
				System.out.println(num+"은 소수가 아닙니다.");	
				continue;
			}
			if(num==2) {
				System.out.println(num+"은 소수 입니다.");	
				continue;
			}
			for(int i=2;i<num;i++) {
				if(num%i==0 ) {					 
					System.out.println(num+"은 소수가 아닙니다.");
					break;
				} 	
				System.out.println(num+"은 소수 입니다.");
				break;
			}			 
			
		}
		
	}
	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

}
