package lab.java.core;

public class For1 {

	public static void main(String[] args) {
		/*
		for(int i=1;i<=10;i++){
			   System.out.println(i);
		}
		*/
		//1. 1~10까지 누적 합
		int hap = 0;
		for(int i=1;i<=10;i++){
		   hap+=i;
		}
		 System.out.println("1~10 누적합은 "+hap);
		
		//2. 1~10까지의 홀수만 출력
		 for(int i=1;i<=10;i++){
			if(i%2==1) System.out.print(i+",");
		 } 
		 System.out.println();
		//3. 1~10까지의 홀수를 역순으로 출력
		 for(int i=10;i>0;i--){
				if(i%2==1) System.out.print(i+",");
			 }
		 System.out.println();
		//4. A~Z까지 출력
		 for(char ch = 'A';ch<='Z';ch++) {
			 System.out.print(ch+" ");
		 }
		 System.out.println();
		//5. A~Z까지 역순으로 출력
		 for(char ch = 'Z';ch>='A';ch--) {
			 System.out.print(ch+" ");
		 }
		 System.out.println(); 

	}

}
