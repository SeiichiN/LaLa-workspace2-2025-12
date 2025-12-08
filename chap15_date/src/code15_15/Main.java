package code15_15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

	public static void main(String[] args) {
		LocalDateTime l1 = LocalDateTime.now();
		// 2025-12-08T12:35:02.904498100
		LocalDate l1B = LocalDate.now();
		// 2025-12-08
		LocalDateTime l2 = LocalDateTime.of(2024,1,1,9,5,0,0);
		// 2024-01-01T09:05
		LocalDate l2B = LocalDate.of(2024,1,1);
		// 2024-01-01
		
		ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
		// 2024-01-01T09:05Z[Europe/London]
		LocalDateTime l3 = z1.toLocalDateTime();
		// 2024-01-01T09:05
		System.out.println(l3);

	}

}
