package code15_16;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter fmt =
			DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ldate =
				LocalDate.parse("2024/09/22", fmt);
		// 2024-09-22
		LocalDate ldatep = ldate.plusDays(1000);
		// 2027-06-19
		String str = ldatep.format(fmt);
		// 2027/06/19
		System.out.println("1000日後は" + str);
		// 1000日後は2027/06/19
		
		LocalDate now = LocalDate.now();
		// 2025-12-08
		if (now.isAfter(ldatep)) {
			System.out.println("本日は、その日より未来です");
		}

	}

}
