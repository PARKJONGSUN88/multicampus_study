package com.workshop3.entity;

public class Travel {
	private String travelCode;
	private String cityName;
	private String flight;
	private int travelType;
	private int maxPeople;
	private int reserved;
	public static final int INDIVIDUAL = 0;
	public static final int PACKAGE = 1;
	 

	public Travel(String travelCode, String cityName, String flight, int travelType, int maxPeople) {
		super();
		this.travelCode = travelCode;
		this.cityName = cityName;
		this.flight = flight;
		this.travelType = travelType;
		this.maxPeople = maxPeople;
		reserved =0;
	}

	public String getTravelCode() {
		return travelCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getFlight() {
		return flight;
	}

	public String getTravelType() {
		String st = null;
		if(travelType==INDIVIDUAL) {
			st = "개별자유여행"	;
		}else if(travelType==PACKAGE) {
			st= "패키지여행"	;
		}
		return st;
	}

	public int getMaxPeople() {
		return maxPeople;
	}
	public int getReserved() {
		return reserved;
	}
  
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public void printTravelInfo() {
		System.out.print(getTravelCode()+"\t");
		System.out.print(getCityName()+"\t  ");
		System.out.print(getFlight()+"\t   ");
		System.out.print(getTravelType()+"\t");
		System.out.print(getMaxPeople()+"\t");
		System.out.print(getReserved()+"\n");
	}
}
