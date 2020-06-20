package lab.java.core;

import java.util.Scanner;

public class JuminCheck {

	public static void main(String[] args) {
		System.out.print("주민번호 입력(예:123456-7891234):");
		Scanner input = new Scanner(System.in);
		String juminStr = input.next();

		int[] jumin = new int[13];
		// 입력받은 주민번호 숫자를 - 제외하고 배열에 저장합니다.
		for (int i = 0, j = 0; i < juminStr.length(); i++) {
			if (i == 6)
				continue;
			jumin[j++] = juminStr.charAt(i) - 48; // juminStr.charAt(i)-'0'
		}
		
		int digit =2, hap = 0;
		for (int i = 0, j = 0; i < jumin.length-1; i++, digit++) {
			if (digit == 10) digit =2;			
			hap += jumin[i]* digit;
		}
		
		//System.out.println(hap);		 
		int result=(11-(hap%11))%10;
		if(result==jumin[12]) {
			System.out.println("올바른 주민등록번호입니다.");
		}else {
			System.out.println("잘못된 주민등록번호입니다.");
		}		

		if (jumin[6] == 9 || jumin[6] == 1 || jumin[6] == 3) {
			System.out.println("당신의 성별은 남성입니다.");
		} else if (jumin[6] == 0 || jumin[6] == 2 || jumin[6] == 4) {
			System.out.println("당신의 성별은 여성입니다.");
		}
		if (jumin[6] == 3 || jumin[6] == 4 ) {
			System.out.println("당신은 2000년대 출생자입니다.");
		} else if (jumin[6] == 2 || jumin[6] == 1) {
			System.out.println("당신은 1900년대 출생자입니다.");
		}

	}// main end

}// class end
