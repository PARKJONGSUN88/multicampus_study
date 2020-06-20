package com.grade.entity;

import java.util.Arrays;

import com.grade.util.CommonUtil;

public abstract class Student {
	private String studentNo;
	private String studentName;
	private int[] gradeArr;

	public Student(String studentNo, String studentName, int[] gradeArr) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.gradeArr = gradeArr;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int[] getGradeArr() {
		return gradeArr;
	}

	public void setGradeArr(int[] gradeArr) {
		this.gradeArr = gradeArr;
	}

	public int getTotal() {
		int sum = 0;
		for (int jumsu : gradeArr)
			sum += jumsu;
		return sum;
	}

	public double getAverage() {
		double total = getTotal();

		return CommonUtil.round(total / gradeArr.length);
	}

	public abstract boolean isPass();

	@Override
	public String toString() {
		String str = "";
		for (int jumsu : gradeArr) {
			str += jumsu + "   ";
		}
		str += getTotal() + "   ";
		str += getAverage() + "   ";

		return str;
	}

}
