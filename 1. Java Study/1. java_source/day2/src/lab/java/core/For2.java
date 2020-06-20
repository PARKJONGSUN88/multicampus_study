package lab.java.core;

public class For2 {

	public static void main(String[] args) {
		// 이중 for문
		for(int r=1;r<4;r++) {//행개수
			for(int c=1;c<4;c++) {
				System.out.print("("+r+","+c+")"+" ");
			}
			System.out.println();
		}
		
		for(int r=1;r<4;r++) {//행개수
			for(int c=1;c<4;c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int r=1;r<6;r++) {//행개수
			for(int c=1;c<=r;c++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for(int r=1;r<6;r++) {//행개수
			for(int c=1;c<=6-r;c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}




