package lab.java.core;

public class ArrayTest4 {
    
	public static void main(String[] args) {
		int[] array = new int[10];

		for (int r = 0; r < array.length; r++) {
			array[r] = (int) (Math.random() * 100 + 1);
		}
		
		for (int r = 0; r < array.length; r++) {
			System.out.print(array[r]+" ");
		}
		System.out.println();

	}// main end
}// class end
