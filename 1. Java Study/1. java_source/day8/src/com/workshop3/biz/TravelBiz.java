package com.workshop3.biz;

import com.workshop3.entity.Travel;

public class TravelBiz {
	private Travel[] travels;

	public TravelBiz() {
		travels = new Travel[5];
		travels[0] = new Travel("TRV001", "뮌휀", "독일항공", Travel.INDIVIDUAL, 10);
		travels[1] = new Travel("TRV002", "프라하", "에어프랑스", Travel.INDIVIDUAL, 7);
		travels[2] = new Travel("TRV003", "LA", "델타항공", Travel.PACKAGE, 12);
		travels[3] = new Travel("TRV004", "후쿠오카", "대한항공", Travel.INDIVIDUAL, 15);
		travels[4] = new Travel("TRV005", "상해", "남방항공", Travel.PACKAGE, 10);
		
	}

	public void printAllTravels() {
        for(Travel t : travels) {
        	t.printTravelInfo();
        }
	}

	public void printIndividualTravels() {
		 for(Travel t : travels) {
			 if(t.getTravelType().equals("개별자유여행")) {
	        	t.printTravelInfo();
			 }
	     }
	}

	public void printPackageTravels() {
		for(Travel t : travels) {
			 if(t.getTravelType().equals("패키지여행")) {
	        	t.printTravelInfo();
			 }
	     }
	}

	public Travel reserveTravel(String travelCode, int reserveCount) {
        Travel reservedTravel = null;
        for(Travel t : travels) {
			 if(t.getTravelCode().equals(travelCode)) {				
				 reservedTravel = t;
				
	        }//outer if end
        }//for end
        return reservedTravel;
	}

	public void printTravelListTitle() {
      System.out.println("-------------------------------------------------------------------");
      System.out.println("여행코드\t도시명\t항공편\t\t여행유형\t\t최대예약가능인원  예약");
      System.out.println("-------------------------------------------------------------------");
      
	}
}
