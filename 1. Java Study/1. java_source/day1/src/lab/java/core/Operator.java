package lab.java.core;

public class Operator {

	public static void main(String[] args) {
		// 단항연산자 : +, -(sign 연산자), (), ++, --, !(not), ~(1의보수)
        int num = -3;
        System.out.println((-num));
        int a = 5, b = 7;
        System.out.println(++a + ++b);//선위 연산자는 다른 연산자보다 먼저 수행됨
        System.out.println("a="+a + ", b=" +b);
        System.out.println(a++ + b++);//후위 연산자은 모든 다른 연산후에 다음 코드로 넘어가기 직전에 ++연산 수행
        System.out.println("a="+a + ", b=" +b);
        System.out.println(!false);
        //System.out.println(!num);
        System.out.println(~num);
	}

}
