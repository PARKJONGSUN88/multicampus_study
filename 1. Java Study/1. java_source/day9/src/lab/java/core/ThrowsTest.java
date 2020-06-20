package lab.java.core;

import java.io.IOException;

public class ThrowsTest {
    public void methodA() throws IOException {
    	methodB();
    	System.out.println("methodA processed");
    }
    public void methodB() throws IOException {
    	methodC();
    	System.out.println("methodB processed");
    }
    public void methodC() throws IOException{
    	//processing 코드....
    	//if(특정조건체크) 더 이상 processing이 어려운 조건이라서
    	//예외를 던져서 호출한 쪽에 메시지를 줘서 예외처하도록 하려함
    	if(true) throw  new IOException("오류원인인....");
    	System.out.println("methodC processed");
    }
	public static void main(String[] args) throws IOException {
		ThrowsTest test = new ThrowsTest();
		test.methodA();

	}

}
