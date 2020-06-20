package exercise.inheritance;

public class Parent {
	private int cash;
	private int building;
	private int apartment;

	public Parent(int cash, int building, int apartment) {
		super();
		this.cash = cash;
		this.building = building;
		this.apartment = apartment;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getApartment() {
		return apartment;
	}

	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public void printStatus() {
       System.out.println("현금:"+cash+", 아파트:"+apartment+", 빌딩:"+building);
	}
}
