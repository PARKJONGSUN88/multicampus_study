package lab.java.core;

public class MethodTest2 {
	public void method(String b, int...c) {
		System.out.println(c.length);
		for(int num : c) {
			System.out.println(num);
		}
	}
	 
	public static void main(String[] args) {
		MethodTest2 test = new MethodTest2();
		test.method("java", 5, 6,7, 8);
		test.method("java");
		int[] nums = new int[] {100, 200, 300, 400, 500};
		test.method("java", nums);
		
	}

}




