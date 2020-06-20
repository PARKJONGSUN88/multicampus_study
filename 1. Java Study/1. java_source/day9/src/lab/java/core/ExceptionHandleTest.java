package lab.java.core;

public class ExceptionHandleTest {
    
	public void checkTall(double tall) throws AbnormalValueException {
		//중학생 키 범위가 140이상 180이하 여부를 체크해서
		//범위가 아니면예외를 던집니다
		if(tall<140) throw new AbnormalValueException("140보다 작습니다");
		if(tall>180) throw new AbnormalValueException("180보다 큽니다");
	}
	
	public static void main(String[] args) {
		double[] talls = new double[] { 155.5,163.2,170.4,149.5,
				128,168,189.5,166,172,169,158,173};
		ExceptionHandleTest  test = new ExceptionHandleTest();
        //키값의 범위를 체크해서
		//예외 발생하면 예외처리합니다. => 작년도 키 평균값으로 보정합니다.
		//올해의 중학생 평균 키값을 출력합니다.
		for(int i=0;i<talls.length;i++) {
			try {
			     test.checkTall(talls[i]);
			}catch(AbnormalValueException e) {
				System.out.println(e.getMessage()+", 작년도 키값으로 보정합니다.");
				talls[i] = e.getOldTall();				
			}
		}
		double hap = 0.0;
		for(double tall : talls)
			hap += tall;
		System.out.println("올해 중학생 평균 키는 "+(hap/talls.length)+"cm입니다.");
		
		}//main end

}//class 

 