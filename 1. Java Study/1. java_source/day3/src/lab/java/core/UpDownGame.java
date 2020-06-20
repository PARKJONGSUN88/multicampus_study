package lab.java.core;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		int computer = (int)(Math.random()*100+1);		
		int count =0;
		Scanner input = new Scanner(System.in);
		System.out.println("Game Start");		
		do {
			count++;
			System.out.print("내가 생각한 수는?");		
		    int num = input.nextInt();
		    if(computer==num ) {
		    	System.out.println("You Win!!!!");
		    	break;
		    }else if(computer<num) {
		    	System.out.println("Down!!!");
		    }else if(computer>num) {
		    	System.out.println("Up!!!");
		    }
		}while(count<5);		
		if(count>=5) { 
			System.out.println("number is "+computer);
	    	System.out.println("I Win^^!!!");
	    }
		System.out.println("Game End");	
	}

}
