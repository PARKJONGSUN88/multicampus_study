package lab.java.core;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent5 {   
	protected  int add(int a, int b) throws IOException{
		return a+b;
	}
}

class Child5 extends Parent5{ //���	 
	void  add(int a, int b, int c) {//overload�� �޼���
		 System.out.println((a+b)*0.9);
	}
	protected int add(int a, int b) {//override�޼���
		return (int)((a+b)*0.9);
	}
}


public class ExtendsTest5 {
	public static void main(String[] args) {
		  Child5 c5 = new Child5();
		  System.out.println(c5.add(3,  4));
	}
}
