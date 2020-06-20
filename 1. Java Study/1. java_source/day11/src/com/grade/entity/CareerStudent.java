package com.grade.entity;

public class CareerStudent extends Student{
    private int careerYears;
    
	public CareerStudent(String studentNo, String studentName, int[] gradeArr, int careerYears) {
		super(studentNo, studentName, gradeArr);
		this.careerYears = careerYears;
	}	

	public int getCareerYears() {
		return careerYears;
	}

	public void setCareerYears(int careerYears) {
		this.careerYears = careerYears;
	}

	@Override
	public boolean isPass() {		 
		boolean pass = false;
		if(getAverage()>=80) {
			pass = true;
		}
		return pass;
	}

}
