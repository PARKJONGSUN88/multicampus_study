package com.workshop3.test;

import com.workshop3.biz.TravelBiz;
import com.workshop3.entity.Travel;
import com.workshop3.util.TravelUtil;

public class TravelTest {

	public static void main(String[] args) {
		TravelBiz biz = new TravelBiz();
		
		 while(true) {
			 printMenu();
			 System.out.print("## 메뉴 입력:");
			 String menu = TravelUtil.getUserInput();
			 if(menu.equals("9")) {
				 break;
			 }else {
			     switch(menu) {
			     case "1" : 
			    	 biz.printTravelListTitle();
			    	 biz.printAllTravels();
			    	 break;
			     case "2" : 
			    	 biz.printTravelListTitle();
			    	 biz.printIndividualTravels();
			    	 break;
			     case "3" : 
			    	 biz.printTravelListTitle();
			    	 biz.printPackageTravels();
			    	 break;
			     case "4" : 
			    	 System.out.println("여행 상품을 예약합니다");
			    	 System.out.print("여행 코드 입력:");
			    	 String travelCode = TravelUtil.getUserInput();
			    	 System.out.print("예약 인원 입력:");
			    	 int reserveCount = Integer.parseInt(TravelUtil.getUserInput());
			    	 Travel reservedTravel = null;
			    	 reservedTravel =biz.reserveTravel(travelCode, reserveCount);
			    	 if( reservedTravel.getMaxPeople()- reservedTravel.getReserved() >= reserveCount) {
			    		 reservedTravel.setReserved( reservedTravel.getReserved()+reserveCount);
			    		 System.out.println("예약이 완료 되었습니다");
			    		 biz.printTravelListTitle();
			    		 reservedTravel.printTravelInfo();
			    	 }else {
			    		 System.out.print("예약 가능 인원이 초과되었습니다.");
			    		 System.out.print("(예약 가능 인원:");
			    		 System.out.print(reservedTravel.getMaxPeople()- reservedTravel.getReserved()+"명)\n");
			    	 }
			     }
			 }//if end
		 }//while end

	}
	public static void printMenu() {
		System.out.println("========<메뉴>========");
		System.out.println("1.전체 여행 상품 조회");
		System.out.println("2.개별자유여행 상품 조회");
		System.out.println("3.패키지 여행 상품 조회");
		System.out.println("4.여행 상품 예약");
		System.out.println("9.종료");
		System.out.println("=====================");
	}

}
