package code15_11;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);  // Fri Dec 05 15:43:17 JST 2025
		System.out.println(now.getTime());  // 1764917085114ミリ秒
		Date past = new Date(1694984000000L);
		System.out.println(past);  // Mon Sep 18 05:53:20 JST 2023
		Date past2 = new Date();
		
	}

}
