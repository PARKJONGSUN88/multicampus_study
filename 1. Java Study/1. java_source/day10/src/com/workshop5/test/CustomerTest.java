package com.workshop5.test;

import com.workshop5.biz.CustomerBiz;
import com.workshop5.biz.ICustomerBiz;
import com.workshop5.entity.Customer;
import com.workshop5.util.CustomerUtil;
 

public class CustomerTest {
	public static void main(String[] args) {
		ICustomerBiz  biz = new CustomerBiz();
		biz.initializeCustomer();
		int menu = 0;
		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력:");
			try {
			     menu = Integer.parseInt(CustomerUtil.getUserInput());
			}catch(NumberFormatException e) {
				System.out.println("[에러] 메뉴는 숫자만 입력해야 합니다.");
				continue;
			}
			if (menu==9) {
				System.out.println("-------------------------------");
				System.out.println("프로그램을 종료합니다. Bye~ ");
				System.out.println("-------------------------------");
				break;
			}
			switch(menu) {
			case 1 : biz.printAllCustomer(); ; break;
			case 2:
				System.out.println("-------------------------------");
				System.out.println("새로운 고객 정보를 추가합니다.");
				System.out.println("새로운 고객의 정보를 입력하세요");
				System.out.println("-------------------------------");
				System.out.print(">이름:");
				String name= CustomerUtil.getUserInput();
				System.out.print("나이:");
				int age = Integer.parseInt(CustomerUtil.getUserInput());
				System.out.print(">전화번호:");
				String phone= CustomerUtil.getUserInput();
				Customer cust = new Customer(name, age, phone);
				biz.insertCustomer(cust);
				System.out.println("@ 고객 정보를 추가하였습니다");
                break;
			case 3 : biz.deleteCustomer(); break;
			default: System.out.println("[에러]메뉴를 잘못 입력하였습니다.");
			}
			 
		}
	}
	
	public static void printMenu() {
		System.out.println("===== <<고객 관리 프로그램>> ======");
    	System.out.println("1. 전체 고객 정보 조회");
    	System.out.println("2. 고객 정보 추가");
    	System.out.println("3. 고객 정보 삭제");
    	System.out.println("9. 시스템 종료");
    	System.out.println("=======================");
	}
}
