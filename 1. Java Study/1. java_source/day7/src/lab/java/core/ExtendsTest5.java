package lab.java.core;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent5 {   
	protected  int add(int a, int b) throws IOException{
		return a+b;
	}
}

class Child5 extends Parent5{ //상속	 
	void  add(int a, int b, int c) {//overload한 메서드
		 System.out.println((a+b)*0.9);
	}
	protected int add(int a, int b) {//override메서드
		return (int)((a+b)*0.9);
	}
}


public class ExtendsTest5 {
	public static void main(String[] args) {
		  Child5 c5 = new Child5();
		  System.out.println(c5.add(3,  4));
	}
}

