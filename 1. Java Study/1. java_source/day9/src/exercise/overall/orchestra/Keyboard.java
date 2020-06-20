package exercise.overall.orchestra;

public class Keyboard implements Instrument {

	@Override
	public void playStart() {
		 System.out.println(this.toString()+" 연주 시작");

	}

	@Override
	public void playStop() {
		System.out.println(this.toString()+"연주 종료");
	}

	@Override
	public String toString() {		 
		return "건반악기";
	}
	

}
