package exercise.basic.diary;

public class MyDiary {
private String title;
private int month;
private int day;
private String desc;

public MyDiary(String title, int month, int day) {
	this.title = title;
	this.month = month;
	this.day = day;
	
}
public MyDiary(String title, int month, int day, String desc) {
	this(title, month, day); //다른 생성자를 호출 
	this.desc = desc;
}
public String getTitle() {
	return this.title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getMonth() {
	return this.month;
}
public void setMonth(int month) {
	this.month = month;
}

public int getDay() {
	return this.day;
}

public void setDay(int day) {
	this.day = day;
}

public String getDesc() {
	return this.desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}


}
