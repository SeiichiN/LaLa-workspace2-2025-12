package ex15_5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate d = today.plusDays(100);
		DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
		String dateTxt = d.format(dtf);
		System.out.println(dateTxt);
	}

}
