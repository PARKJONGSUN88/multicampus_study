package lab.java.core;

public class CalcTest {

	public static void main(String[] args) {
		Calc c = new Calc();//객체 생성
		int x=5, y=10;
		int result = c.plus(x, y);//10+5
		System.out.println(x+"+"+y+"="+result);
		//10-5
		System.out.println(x+"-"+y+"="+c.minus(x, y));
		//10*5
		System.out.println(x+"X"+y+"="+c.multiply(x, y));
		//10/5
		System.out.println(x+"/"+y+"="+c.div(x, y));
		//10%5 결과 출력
		System.out.println(x+"%"+y+"="+c.mod(x, y));
		

	}

}
