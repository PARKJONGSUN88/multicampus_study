package lab.java.core;

public class TvTest {

	public static void main(String[] args) {
		 Tv t =new Tv(); //객체 생성
		 System.out.println(t.color); //속성값 접근
		 System.out.println(t.power);
		 System.out.println(t.channel);
		 t.power(); //메소드 호출
		 System.out.println(t.power);//전원 상태 확인
		 t.power(); //메소드 호출
		 System.out.println(t.power);//전원 상태 확인
		 t.channel = 3;
		 System.out.println(t.channel);
		 t.channelUp();
		 System.out.println(t.channel);
	}

}
