package code15_14;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

	public static void main(String[] args) {
		
		Instant i1 = Instant.now();
		// 2025-12-08T02:49:07.712577500Z
		
		Instant i2 = Instant.ofEpochMilli(1600705425827L);
		// 2020-09-21T16:23:45.827Z
		long l = i2.toEpochMilli();
		// 1600705425827
		
		ZonedDateTime z1 = ZonedDateTime.now();
		// 2025-12-08T12:04:32.029158500+09:00[Asia/Tokyo]
		
		ZonedDateTime z2 = 
				ZonedDateTime.of(2023,1,2,3,4,5,6, ZoneId.of("Asia/Tokyo"));
		// 2023-01-02T03:04:05.000000006+09:00[Asia/Tokyo]
		
		Instant i3 = z2.toInstant();
		// 2023-01-01T18:04:05.000000006Z
		
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));
		// 2023-01-01T18:04:05.000000006Z[Europe/London]
		
		System.out.println("東京:" + 
		   z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		// 東京:2023JANUARY2

		System.out.println("ロンドン:" + 
				   z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
		// ロンドン:2023JANUARY1
		
		if (z2.isEqual(z3)) {
			System.out.println("同じ瞬間です");  // 表示される
		}
}

}
