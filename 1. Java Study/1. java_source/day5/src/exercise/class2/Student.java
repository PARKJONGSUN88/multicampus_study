package exercise.class2;


public class Student {//클래스 선언
//속성 선언	
private String studentId;
private int c;
private int linux;
private int java;

//객체 생성을 위한 초기화를 수행하는 생성자 메소드
public Student() { }
public Student(String studentId, int c, int linux, int java ) {
	this.studentId = studentId;
	this.c = c;
	this.linux = linux;
	this.java = java;
}

//기능을 수행하는 멤버 메서드
public String getStudentId() {
	return this.studentId;
}
public void setStudentId(String studentId) { 
	this.studentId = studentId;
}
public int getC() {
	return this.c;
}
public void setC(int c) {
	this.c = c;
}
public int getLinux() {
	return this.linux;
}
public void setLinux(int linux) {
	this.linux = linux;
}
public int getJava() {
	return this.java;
}
public void setJava(int java) {
	this.java = java;
}

public int getTotal() {
	return c+java+linux;
	//return getC()+getLinux()+getJava();
}

@Override
public String toString() {	
	return  "C: "+getC()+"점,"+" Linux: "+getLinux()+"점,"
              +" Java: "+getJava()+"점";
}



}//class end











