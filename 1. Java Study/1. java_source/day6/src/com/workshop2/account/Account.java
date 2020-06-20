package com.workshop2.account;

public class Account {
private String custId;
private String custName;
private String accountNumber;
int balance; //예금 잔액
public Account() {
	
}
public Account(String custId, String custName, String accountNumber, int balance) {	
	this.custId = custId;
	this.custName = custName;
	this.accountNumber = accountNumber;
	if(balance<1) {
		System.out.println("잔액 오류입니다.: 0 원");
		System.exit(0);
	}
	this.balance = balance;
}
public String getCustId() {
	return custId;
}
public void setCustId(String custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}

public void addBalance(int amount) {
	if(amount<1) {
		System.out.println("금액 오류입니다.: 0 원");		
	}else if(amount >=1) {
		balance += amount;
	}
	
}
public void subtractBalance(int amount) {
	if(amount<1) {
		System.out.println("금액 오류입니다.: 0 원");		
	}else if(amount >=1) {
		if( balance>=amount) {
			balance -= amount;
	    }else {
	    	System.out.println("출금 불가!! 잔금 부족입니다.");	
	    }
	}
}
public void printAccount() {
	System.out.println("===========================");
	System.out.println("고객번호 : "+custId);
	System.out.println("고객명 : "+custName);
	System.out.println("계좌번호 : "+accountNumber);
	System.out.println("잔액 : "+balance);
	System.out.println("===========================");
}
}






