package lab.java.core;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		//0<= N <1
		int rnum = (int)(Math.random()*100+1);
		Random r = new Random();
		int rnum2 = r.nextInt(100)+1; //0~99
		System.out.println(rnum);
		System.out.println(rnum2);

	}

}
