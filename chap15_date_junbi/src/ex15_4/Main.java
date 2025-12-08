package ex15_4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date today = new Date();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(today);
		int day = c1.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		c1.set(Calendar.DAY_OF_MONTH, day + 100);
		System.out.println(c1);
		Date d = c1.getTime();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("西暦yyyy年MM月dd日");
		String dateTxt = sdf.format(d);
		System.out.println(dateTxt);
	}

}
