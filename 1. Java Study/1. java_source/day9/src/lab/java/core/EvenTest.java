package lab.java.core;

public class EvenTest {

	public static void main(String[] args) {
		System.out.println("main start");
		int num = -1;
		try {
		    num = Integer.parseInt(args[0]);
		    System.out.println("other statement processing...");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열관련 예외 처리");
		}catch(NumberFormatException e) {
			System.out.println("숫자 형식관련 예외 처리");
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}finally {
			System.out.println("resource 정리");
		}
		if(num%2==0 && num>0) {
			System.out.println(args[0]+"은 짝수");
		}else if(num%2==1 && num>0){
			System.out.println(args[0]+"은 홀수");
		}
		
		System.out.println("main end");
	}

}
