package lab.java.core;

import java.io.*;
    
   
 public void checkDigit(){  
	int digit = 2; 
	int sum = 0;      
	for(int i=0; i<ch.length-1;i++){   
		if(i==6) continue;   
		if(digit == 10) digit=2;   
		sum += ((int)ch[i]-48)*digit;   
		digit++;  }      
	int result=(11-sum%11)%10;
  if(result == ((int)ch[13]-48)) {   System.out.println("\n CORRECT");  }else{   System.out.println("\n INCORRECT");  } }
 public static void main(String[] args) throws IOException {   CheckJumin cj = new CheckJumin();   cj.inputData();   cj.genderCheck();   cj.checkDigit();   }}


