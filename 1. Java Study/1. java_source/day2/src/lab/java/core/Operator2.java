package lab.java.core;

public class Operator2 {

	public static void main(String[] args) {
		// shift연산자 (<<, >>, >>>)
        int a = 3;
        //<<왼쪽으로 비트를 이동시키고, 오른쪽 비트는 0으로 채웁니다.
        // X<<Y는 X*2^Y의 결과와 같습니다.
        System.out.println(a<<5);
        int b = 256;
        //>>는 오른쪽으로 비트를 이동시키고, 왼쪽비트는 sign비트로 채웁니다.
        //X>>Y는 X/2^Y의 결과와 같습니다.
        System.out.println(b>>3);
        System.out.println(-b>>3);
        
      //>>>는 오른쪽으로 비트를 이동시키고, 왼쪽비트는 무조건 0로 채웁니다.
      //결과는 항상 양수
        System.out.println(b>>>3);
        System.out.println(-b>>>3);
        
        //b = b+4;
        b+=4;
        System.out.println(b);
        
        
        
	}

}






