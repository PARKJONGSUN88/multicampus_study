package lab.java.core;

import java.util.Scanner;

public class If5 {
	public static void main(String[] args) {
		System.out.print("년도를 입력하세요:");
		Scanner input = new Scanner(System.in);
		int year= input.nextInt();
		 
		if(year%4==0) {			 
		    if(year%400==0) {
			   System.out.println(year+"은 윤년");
		    }else if(year%100==0) {
		       System.out.println(year+ "은 평년");
		    }else {
		       System.out.println(year+ "은 윤년");
		    }
		}else {
			System.out.println(year+"은 평년");
		} 
		System.out.println("방법2");
		if(year%4==0 && year%400==0 ) {			
			System.out.println(year+"은 윤년");
		}else if(year%4==0 && year%100==0 ) {			
			System.out.println(year+"은 평년");
		}else if(year%4==0){
			System.out.println(year+"은 윤년");
		}else {
			System.out.println(year+"은 평년");
		}

	}//main end
}//class end









