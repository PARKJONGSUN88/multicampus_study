package lab.java.core;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[][] array1 =new int[3][4]; 
		int[][] array2 =new int[3][4];  
		for(int r=0;r<array1.length;r++) {
	    	for(int c=0;c<array1[r].length;c++) {
	    		array1[r][c] = (int)(Math.random()*12+1);
	    		array2[r][c] = (int)(Math.random()*12+1);
	    	}
		}
		
		System.out.println("####첫번째 배열####");
		for(int r=0;r<array1.length;r++) {
	    	for(int c=0;c<array1[r].length;c++) {
	    		System.out.printf("%2d ", array1[r][c] );	    		
	    	}
	    	System.out.println();
		}
		
		System.out.println("####두번째 배열####");
		for(int r=0;r<array2.length;r++) {
	    	for(int c=0;c<array2[r].length;c++) {
	    		System.out.printf("%2d ", array2[r][c] );	   		
	    	}
	    	System.out.println();
		}
	    	
		 
		int count = 0;
		for(int r=0;r<array1.length;r++) {
	    	for(int c=0;c<array1[r].length;c++) {
	    		if(array1[r][c]==array2[r][c]) {
	    			count++;   
	    			System.out.print("일치하는 숫자 : ["+r+"]["+c+"]="+array1[r][c]+",");
	    		}
	    	}
	    	System.out.println();
		}
		System.out.println("요소의 위치와 값이 동일한 개수 :"+count);

	}//main end
}//class end
