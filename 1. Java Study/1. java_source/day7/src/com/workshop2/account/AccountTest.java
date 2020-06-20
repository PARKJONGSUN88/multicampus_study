package com.workshop2.account;

public class AccountTest {

	public static void main(String[] args) {
		System.out.println("[공지] 계좌를 개설합니다." );
		Account hong = new Account("CUST01", "홍길동", "11-222-3333", 100000);
		hong.printAccountInfo();
		System.out.println();
		hong.deposit(30000);
		hong.printAccountInfo();
		System.out.println();
		hong.deposit(-10000);
		hong.printAccountInfo();
		System.out.println();
		hong.withdraw(50000);
		hong.printAccountInfo();
		System.out.println();
		hong.withdraw(100000);
		hong.printAccountInfo();
		System.out.println();
		hong.withdraw(-10000);
		hong.printAccountInfo();
		System.out.println();
		hong.deposit(20000);
		hong.printAccountInfo();
		System.out.println();
	}

}
