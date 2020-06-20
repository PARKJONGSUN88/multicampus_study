package com.workshop2.test;

import com.wokshop2.entity.Movie;

public class MovieTest {

	public static void main(String[] args) {
		Movie[] movies = new Movie[] {
			new Movie("반지의 제왕-반지 원정대", "피터 잭슨", "판타지, 모험", "일라이저 우드", 2001, 178, "12세 관람가"),
			new Movie("트랜스포머:패자의 역습", "마이클 베이", "SF, 액션", "샤이아 라보프", 2009, 149 ),
			new Movie("러브 액츄얼리", "리처드 커티스", "멜로, 드라마", "앨런 릭맨 등", 2003, 134, "15세 관람가"),
			new Movie("쿵푸 팬더", "마크 오스본", "애니메이션", "잭 블랙", "전체 관람가")
		};
		System.out.println("<<전체 영화 정보 조회>>");
		printTitle();
		for(Movie m : movies) {
			System.out.print(m);				
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("<<2005년 이전 개봉작 조회>>");
		printTitle();
		for(Movie m : movies) {
			if(m.getReleaseYear()<2005&&m.getReleaseYear()!=0) {
			System.out.print(m);
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("<<애니메이션 조회>>");
		printTitle();
		 
		for(Movie m : movies) {
			if(m.getGenre().contentEquals("애니메이션")) {
			System.out.print(m);
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("<<런타임 140분 영화 조회>>");
		printTitle();
		for(Movie m : movies) {
			if(m.getRunTime()>=140	&& m.getRunTime()!=0) {
			System.out.print(m);
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	}//main end
	
	public static void printTitle() {
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("\t제목\t\t\t감독\t\t장르\t\t주연\t\t개봉년도  런타임\t등급");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	}
	

}
