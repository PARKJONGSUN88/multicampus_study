package lab.java.core;

import java.util.Scanner;

public class If2 {
	public static void main(String[] args) {
		System.out.print("한문자만 입력하세요:");
		Scanner input = new Scanner(System.in);
		String st = input.next();
		char ch = st.charAt(0);
		
		if(ch>47 && ch<58) {
			System.out.println(st+"는 숫자입니다.");
		}else if(ch>64 && ch<91) {
			System.out.println(st+"는 영문대문자입니다.");
		}else if(ch>96 && ch<123) {
			System.out.println(st+"는 영문소문자입니다.");
		}		

	}

}





