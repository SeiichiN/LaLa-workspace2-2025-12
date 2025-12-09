package ex15_4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date now = new Date();
		// Tue Dec 09 10:45:30 JST 2025
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day + 100);
		Date mirai = c.getTime();
		// Thu Mar 19 11:19:01 JST 2026
		SimpleDateFormat sdf = 
				new SimpleDateFormat("西暦yyyy年MM月dd日");
		String str = sdf.format(mirai);
		System.out.println(str);
		// 西暦2026年03月19日
	}

}
