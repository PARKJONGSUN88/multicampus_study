package exercise.class2.BaseBall;

import java.util.Random;

public class BaseBall {
	public static int player = 0;
	public static int outCount = 0;
	public static int strike = 0;
	public static int ball = 0;

	public static void getStatus() {
		System.out.println(outCount + "아웃, " + strike + "스트라이크, " + ball + " 볼");		
	}

	public static boolean isStrike() {
		Random r = new Random(2);
		boolean result = false;
		if (r.nextInt() == 1)
			result = true;
		return result;
	}
}
