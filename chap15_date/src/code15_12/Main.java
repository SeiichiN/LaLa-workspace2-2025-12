package code15_12;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2023, 8, 18, 5, 53, 20);
		c.set(Calendar.MONTH, 9);
		Date d = c.getTime();
		System.out.println(d);    // Wed Oct 18 05:53:20 JST 2023
		// 2023/10/18
		Date now = new Date();
		c.setTime(now);
		int y = c.get(Calendar.YEAR);
		System.out.println("今年は" + y + "年です");
		System.out.println(now);  // Fri Dec 05 16:10:02 JST 2025
	}

}
