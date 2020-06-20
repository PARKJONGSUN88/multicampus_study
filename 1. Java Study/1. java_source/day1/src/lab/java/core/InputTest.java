package lab.java.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {

	public static void main(String[] args) throws IOException{
		System.out.print("태어난 년도를 입력하세요:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String year = br.readLine();
		int age = 2019-Integer.parseInt(year); //문자열을 정수로 변환
		System.out.print("Your age is "+ age);

	}

}




