package com.grade.test;

import com.grade.biz.GradeManager;
import com.grade.biz.IGradeManager;
import com.grade.util.CommonUtil; 

public class GradeTest {

	public static void main(String[] args) {
		IGradeManager manager = new GradeManager();
		int menu =0;
		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력 ==>");
			try {
			     menu = Integer.parseInt(CommonUtil.getUserInput());
			}catch(NumberFormatException e) {
				System.out.println("## 숫자를 입력하세요!");
				continue;
			}
			if (menu==9) {				 
				System.out.println("##성적 관리 시스템을 종료합니다.!!");				 
				break;
			}
			switch(menu) {
			case 1:
			case 2:
			case 3: manager.printStudents(menu-1); break;
			default : System.out.println("##없는 메뉴를 선택하였습니다.!!");			 
			}
		}//while end

	}
	
	public static void printMenu() {
		System.out.println("===== << 성적 관리 시스템 메뉴 >> ======");
    	System.out.println("1. 전체 수강생 출력");
    	System.out.println("2. 합격 수강생 출력");
    	System.out.println("3. 불합격 수강생 출력");
    	System.out.println("9. 종료");
    	System.out.println("=======================================");
	}

}
