package lab.java.core;

import java.util.Scanner;

public class If1 {
	public static void main(String[] args) {
		System.out.print("한문자만 입력하세요:");
		Scanner input = new Scanner(System.in);
		String st = input.next();
		char ch = st.charAt(0);
		if(ch>47 && ch<58) {
			System.out.println(st+"는 숫자입니다.");
		}else {
			System.out.println(st+"는 문자입니다.");
		}		

	}

}
