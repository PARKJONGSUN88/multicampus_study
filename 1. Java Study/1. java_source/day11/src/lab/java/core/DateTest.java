package lab.java.core;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date now  = new Date(cal.getTimeInMillis());
		System.out.println(now);
		System.out.println(cal);
		
        Date d = new Date();
        cal.setTime(d);
        System.out.println(d);
        System.out.println(cal);
	}

}
