package lab.java.core;

public class TvTest2 {

	public static void main(String[] args) {
		 Tv t =new Tv(); //객체 생성
		 System.out.println(t);
		 t.channel = 7;
		 Tv t2 =new Tv(); //객체 생성
		 System.out.println(t2); 
		 t2.channel = 16;
		 //인스턴스 변수의 값은 동일한 객체일지라도 다른 값을 가질 수 있습니다.
		 System.out.println(t.channel);
		 System.out.println(t2.channel);
		 
		 t2.channel = t.channel;
		 System.out.println(t.channel);
		 System.out.println(t2.channel);
		 
		 Tv t3 = t;
		 System.out.println(t );
		 System.out.println(t3);
		 t.channel = 10;
		 System.out.println(t.channel);
		 System.out.println(t3.channel);
		 
		 
	}

}
