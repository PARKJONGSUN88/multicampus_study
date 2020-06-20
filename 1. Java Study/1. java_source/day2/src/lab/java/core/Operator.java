package lab.java.core;

public class Operator {

	public static void main(String[] args) {
		// 논리연산자 &&, || : 조건표현식 && 조건표현식 
		System.out.println((3>4 || 'B'>'A'));
        //short circuit 연산자 &&, ||
		//조건표현식1 && 조건표현식2의 경우 조건표현식1이 false이면 조건표현식2는 수행안함
		//조건표현식1 || 조건표현식2의 경우 조건표현식1이 true이면  조건표현식2는 수행안함
		String s = new String("java"); //객체 생성
		String st = null;  //객체 선언만하고, 생성 안함
		System.out.println(st !=null && st.length()==0);
		System.out.println(st ==null && st.length()==0);
	}

}
