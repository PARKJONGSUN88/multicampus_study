package lab.java.core;

public class ArrayTest {

	public static void main(String[] args) {
		int[][] nums; //배열 선언
		int nums2[][];
		int[] nums3[];
		nums = new int[5][5];//배열 생성
		nums[0][0] = (int)(Math.random()*12+1);
		
		nums2 = new int[5][];
		//nums3 = new int[ ][5];
		nums3 = new int[][] {{1, 2, 3},
			{4, 5, 6, 7}, {8, 9, 10, 11, 12}}; // 배열의 요소 초기화
	    System.out.println(nums3.length);//2차원구조의 행개수, 1차원 배열의 개수
	    System.out.println(nums3[0].length);//첫번째 1차원 배열의 요소 개수
	    System.out.println(nums3[1].length);//두번째 1차원 배열의 요소 개수
	    System.out.println(nums3[2].length);//세번째 1차원 배열의 요소 개수
	    
	    for(int r=0;r<nums3.length;r++) {
	    	for(int c=0;c<nums3[r].length;c++) {
	    		System.out.print(nums3[r][c]+" ");
	    	}
	    	System.out.println();
	    }

	}

}
