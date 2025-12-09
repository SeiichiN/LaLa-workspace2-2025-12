package ex15_5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		// 2025-12-09
		// int day = now.getDayOfMonth();
		LocalDate mirai = now.plusDays(100);
		// 2026-03-19
		DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
		String str = mirai.format(dtf);
		System.out.println(str);
		// 西暦2026年03月19日
	}

}
