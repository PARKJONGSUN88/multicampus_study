package exercise.basic.diary;

import java.util.Scanner;

public class MyDiaryTest {

	public static void main(String[] args) {
		MyDiary[] my = new MyDiary[] {
				new MyDiary("데이터", 1, 5, "레스토랑"),
				new MyDiary("야근", 2, 3 ),
				new MyDiary("시험", 1, 7, "열공"),
				new MyDiary("OPEN API", 5, 13, "IT전문가 교육시작"),
				new MyDiary("영화", 4, 20, "어밴져스")
		};
		 
		
		while(true) {
			System.out.print("## 월 입력(종료:-1)=>");
			int inputNumber = getUserInput();
			if(inputNumber==-1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			for(int i=0;i<my.length;i++) {
				int cnt = 1;
				if(my[i].getMonth()==inputNumber) {
					System.out.print(cnt++ +". " +my[i].getMonth()+"월 ");
					System.out.print(my[i].getDay()+"일 : ");
					System.out.print(my[i].getTitle());
					if(my[i].getDesc()!=null) {
						System.out.print(", "+my[i].getDesc());
					}
					System.out.println();
				}
					
				}//for end
			}//while end			
		}//main end
	 
	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	

}
