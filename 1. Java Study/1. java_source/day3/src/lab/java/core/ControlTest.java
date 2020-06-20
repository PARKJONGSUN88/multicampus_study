package lab.java.core;

public class ControlTest {

	public static void main(String[] args) {
		a1:
		for(int i=0;i<3;i++) {
			a2:
			for(int j=0;j<3;j++) {
				//if(j==1) continue;
				if(j==1) break a1;  //가장 가까운 반복문 탈출
				System.out.println("i="+i+", j="+j);
			}
		}
       //continue를 이용해서 1~10사이의 짝수만 출력합니다.
	   int num = 0;
	   while(num<10) {
		   num++;
		   if(num%2==1) continue;
		   System.out.println(num);		   
	   }
	}

}
