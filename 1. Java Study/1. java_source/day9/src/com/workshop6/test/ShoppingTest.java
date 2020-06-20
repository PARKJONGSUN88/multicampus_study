package com.workshop6.test;

import com.workshop6.biz.IShoppingBiz;
import com.workshop6.biz.ShoppingBiz;
import com.workshop6.util.CommonUtil;

public class ShoppingTest {

	public static void main(String[] args) {
		IShoppingBiz biz = new ShoppingBiz();
		int menu = 0;
		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력:");
			try {
			     menu = Integer.parseInt(CommonUtil.getUserInput());
			}catch(NumberFormatException e) {
				System.out.println("[에러] 메뉴는 숫자만 입력해야 합니다.");
				continue;
			}
			if (menu==9) {
				System.out.println("프로그램을 종료합니다. Bye~ Bye~");
				break;
			}
			switch(menu) {
			case 1 : biz.printAllProducts(); break;
			case 2: biz.printPricePerProduct(); break;
			case 3 : biz.calculateTotalPrice(); break;
			default: System.out.println("[에러]메뉴를 잘못 입력하였습니다.");
			}
			 
		}

	}
    public static void printMenu() {
    	System.out.println("===== << 메뉴 >> ======");
    	System.out.println("1. 장바구니 목록 출력");
    	System.out.println("2. 품목별 가격 출력");
    	System.out.println("3. 총 구입가격 출력");
    	System.out.println("9. 종료");
    	System.out.println("=======================");
    	
    }
}
