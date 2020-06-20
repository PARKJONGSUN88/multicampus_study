package lab.java.core;

public class RecursiveTest {
    public void method(int n) { //¿Á±Õ ∏ﬁº≠µÂ
    	if(n==0) 
    		return;
    	System.out.println(n);
    	method(--n); //¿Á±Õ»£√‚
    }
	public static void main(String[] args) {
		RecursiveTest test = new RecursiveTest();
		test.method(10);

	}

}
