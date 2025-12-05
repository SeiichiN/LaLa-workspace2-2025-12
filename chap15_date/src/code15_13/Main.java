package code15_13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f =
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = f.parse("2023/09/18 05:53:20");
		System.out.println(d);  // Mon Sep 18 05:53:20 JST 2023
		
		Date now = new Date();
		String s = f.format(now);
		System.out.println("現在は" + s + "です");   // 現在は2025/12/05 16:20:22です

	}

}
