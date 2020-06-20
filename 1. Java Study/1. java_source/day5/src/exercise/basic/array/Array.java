package exercise.basic.array;

import java.util.Random;

public class Array {
  private String title;
  private int row;
  private int col;
  private int[][] array;
  
  public Array(String title, int row, int col) {
	  this.title = title;
	  this.row = row;
	  this.col = col;
	  this.array = new int[row][col];
  }
  public int getRow() {
	  return this.row;
  }
  public void setRow(int row) {
	  this.row = row;
  }
  public int getCol() {
	  return this.col;	  
  }
  public int[][] getArray(){
	  return this.array;
  }
  public void setArray(int[][] array) {
	  this.array = array;
  }
  private int getRandomNumber() {
	  Random rand = new Random();
	  int randomNumber = rand.nextInt(row*col)+1;
	  return randomNumber;
  }
  public void makeArrayData() {
	  for(int r=0;r<row;r++) { //array.length==row
		  for (int c=0;c<col;c++){ //array[r].length==col
			  array[r][c] = getRandomNumber();
		  }
	  }
  }
  
  public void printArray() {
	  System.out.println("## "+title+" Array 출력");
	  for(int r=0;r<row;r++) { //array.length==row
		  for (int c=0;c<col;c++){ //array[r].length==col
			  System.out.printf("%3d", array[r][c]);  
		  }
		  System.out.println();
	  }
  }
  public void findMatchNumber(Array src, Array desc) {	  
	  int count = 0;
		for(int r=0;r<src.getArray().length;r++) {
	    	for(int c=0;c<src.getArray()[r].length;c++) {
	    		if(src.getArray()[r][c]==desc.getArray()[r][c]) {
	    			count++;   
	    			System.out.print("일치하는 숫자 : ["+r+"]["+c+"]="+src.getArray()[r][c]+",");
	    		}
	    	}
	    	System.out.println();
		}
		System.out.println("일치하는 숫자 갯수 :"+count);
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
