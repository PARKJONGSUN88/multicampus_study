package lab.java.core;

public class For3 {

	public static void main(String[] args) {
		// 구구단 가로로 출력하기
		for(int su = 1;su<10;su++) {
			for (int dan=2;dan<10;dan++) {
				System.out.printf("%dX%d=%2d  ", dan, su, (dan*su));
			}
			System.out.println();
		}
	}//main end

}//class end
