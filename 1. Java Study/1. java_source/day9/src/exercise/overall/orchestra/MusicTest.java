package exercise.overall.orchestra;

public class MusicTest {

	public static void main(String[] args) {
		Instrument[] e =new Instrument[] {
				new Piano(),
				new Flute(),
				new Drum(),
				new Timpani(),
				new Trumpet()
		};//e[0] ~e[4] 모든 객체는 다형성 객체
		
		playAll(e);		
		summary(e);		
	}
	
	private static void playAll(Instrument[] e) { //Instrument인터페이스의 구현 클래스들을 인자로 전달할 경우 자동으로 Upcasting이되고, Downcasting할 수 있습니다.
		System.out.println("==============연주 시작=============");
		for(Instrument instrument : e) {
			instrument.playStart();
		}
		System.out.println();
		System.out.println("==============연주 종료=============");
		for(Instrument instrument : e) {
			instrument.playStop();
		}
		System.out.println();
	}
	private static void summary(Instrument[] e) {
		int keyboard = 0, percussion = 0, wind=0;
		System.out.println("==============연주 악기 목록=============");
		for(Instrument instrument : e) {
			System.out.println(instrument);
			if(instrument instanceof Keyboard) {
				keyboard +=1;
			}else if(instrument instanceof Percussion) {
				percussion +=1;
			}else if(instrument instanceof Wind) {
				wind +=1;
			}
		}//for end
		System.out.println();
		System.out.println("==============연주 악기 수=============");
		System.out.println("## 건반악기 수 :"+ keyboard);
		System.out.println("## 관악기 수 :"+ percussion);
		System.out.println("## 타악기 수 :"+ wind);
		System.out.println("=======================================");
		
	}

}
