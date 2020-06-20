package lab.java.core;

import java.util.Scanner;

public class While3 {

	public static void main(String[] args) {		
		int even=0, odd =0;		
		Scanner input = new Scanner(System.in);
		while(true){
		   int num = input.nextInt();
		   if(num==0) break;		   		     
		   if(num%2==0) {			    
			    even++;
		   }else if	(num%2==1) {			    
			    odd++;
		   }	   
		}
		System.out.println("礎熱 偃熱 :"+even);
		System.out.println("�汝� 偃熱 :"+odd);
	}
}






