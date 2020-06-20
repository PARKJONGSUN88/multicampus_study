package lab.java.core;

import java.util.Scanner;

public class While2 {

	public static void main(String[] args) {		
		int count =0;		
		Scanner input = new Scanner(System.in);
		while(true){
		   int num = input.nextInt();
		   if(num==0) break;		   		     
		   if((num%3==1 || num%3==2) && num%5!=0) {			    
			    count++;
		      }		   
		}
		System.out.println("3과5의 배수를 제외한 수들의 개수 :"+count);
		 

	}

}






