package com.workshop2.account;

public class Account {
	private String customerId;
	private String customerName;
	private String accountNumber;
	private int balance;

	public Account(String customerId, String customerName, String accountNumber, int balance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void withdraw(int money) {
		System.out.println("[출금] " + money + "원을 출금합니다.");
		if (money < 0) {
			System.out.println("[에러] 음수는 출금할 수 없습니다.");
		} else if (balance < money) {
			System.out.println("[에러] 잔액이 부족합니다.");
		} else {
			balance -= money;
		}
	}

	public void deposit(int money) {
		System.out.println("[입금] " + money + "원을 입금합니다.");
		if (money < 0) {
			System.out.println("[에러] 음수는 입금할 수 없습니다.");
		} else {
			balance += money;
		}
	}

	public void printAccountInfo() {
		System.out.println("========================");
		System.out.println("고객번호:"+customerId);
		System.out.println("고객명:"+customerName);
		System.out.println("계좌번호:"+accountNumber);
		System.out.println("잔액:"+balance);
		System.out.println("========================");
	}
}
