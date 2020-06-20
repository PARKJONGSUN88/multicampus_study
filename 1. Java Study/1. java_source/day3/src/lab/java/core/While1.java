package lab.java.core;

public class While1 {

	public static void main(String[] args) {
		int count =0;		
		while(count<10){
		  System.out.print(++count +" ");
		}
		System.out.println();
		//1. 1~10까지 누적 합
		count =0;  //다시 0으로 초기화
		int hap = 0;  //누적합을 저장할 변수 선언과 초기화
		while(count<10){
		  hap +=++count;
		}
		System.out.println("1~10까지의 누적합은 "+hap);
		//2. 1~10까지의 홀수만 출력
		count =0;  //다시 0으로 초기화
		while(count<10){
		   if(++count%2==1) System.out.println(count);
		}
		System.out.println();
		//3. 1~10까지의 홀수를 역순으로 출력
		while(count>0){
			   if(count%2==1) System.out.println(count);
			   count--;
			}

	}

}






