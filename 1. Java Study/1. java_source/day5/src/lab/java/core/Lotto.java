package lab.java.core;

import java.util.Random;

public class Lotto {
   public final static int LOTTO_NUM_CNT = 6;
   
   public int[] generateLottoNumbers() {
	   int[] lotto = new int[LOTTO_NUM_CNT];//로또 번호 저장할 배열방 준비
		for(int i=0;i<lotto.length;i++){
			   lotto[i] = getRandomNumber();
			   for(int j=0;j<i;j++){
			      if(lotto[i] == lotto[j]){
			        i--;
			        break;
			    }
			}
		}
		return lotto;
   }
   public void displayLottoNumbers(int[] lottoNumbers) {
	   System.out.println("<< Lotto >>");
	   for(int num : lottoNumbers) {
		   System.out.print(num +" ");
	   }
   }
   public void sortLottoNumbers(int[] lottoNumbers) {
	   for(int i=0;i<lottoNumbers.length-1;i++){
		   boolean changed = false;
		   for(int j=0;j<lottoNumbers.length-1-i;j++) {
			   if(lottoNumbers[j]>lottoNumbers[j+1]) {
				   int temp = lottoNumbers[j];
				   lottoNumbers[j] = lottoNumbers[j+1];
				   lottoNumbers[j+1] = temp;
				   changed = true;
			   }
		   }//inner for and
		   if (!changed) break;		   
	   }//outer for end
   }
   private int getRandomNumber() {
	   Random rand = new Random();
	   int randomNumber = rand.nextInt(45)+1;
	   return randomNumber;
   }
   
}
