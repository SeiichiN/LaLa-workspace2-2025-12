package main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalcAgeNew {

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = new Scanner(System.in).nextLine();
		LocalDate birthday = getDate(birth);
		if (birthday == null) {
			System.out.println("日付を正しく入力してください");
			return;
		}
		int age = getAge(birthday);
		System.out.println("あなたは" + age + "歳です");

	}
	
	private static int getAge(LocalDate birthday) {
		LocalDate today = LocalDate.now();
		int age = Period.between(birthday, today).getYears();
		return age;
	}
	
	private static LocalDate getDate(String dateTxt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate d = null;
		try {
			d = LocalDate.parse(dateTxt, dtf);
		} catch (DateTimeParseException e) {
			return null;
		}
		return d;
	}

}
