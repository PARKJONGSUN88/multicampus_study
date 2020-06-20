package exercise.class2.BaseBall;

public class BaseBallTest {

	public static void main(String[] args) {
		a1:
		for (BaseBall.player=0;  ;BaseBall.player++) {
			System.out.println("***** "+ ++BaseBall.player+ "번째 선수 출격 ****");
		   b1:
			while(true) {			
			if(BaseBall.outCount==3) {
				System.out.println("쓰리아웃! 공수교체");
				break a1;
			}		
			 
			if(BaseBall.isStrike()) {
				System.out.println("공 던짐 => 볼!!");
				++BaseBall.ball;
				BaseBall.getStatus();
				if(BaseBall.ball==4) {
					System.out.println("\n1루 출루");	
					break b1;
				}
			}else {
				System.out.println("공 던짐 => 스크라이크!!");
				++BaseBall.strike;	
				BaseBall.getStatus();
				if(BaseBall.strike==3) {
					System.out.println("\n"+ ++BaseBall.outCount +"아웃");
					System.out.println("선수 교체");	
					break b1;
				}
			}		
			
		}//while end
	  }//for end
	}//main end

}
