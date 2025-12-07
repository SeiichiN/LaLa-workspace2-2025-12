package rensyu1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class AgeCalculatorWithTime {
	public static final DateTimeFormatter DTF = 
			DateTimeFormatter.ofPattern("yyyy/MM/dd")
				.withResolverStyle(ResolverStyle.STRICT);
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = SC.nextLine();
		LocalDate birthday = getDate(birth);
		if (birthday == null) return;
		if (birthday.isAfter(LocalDate.now())) {
			System.out.println("未来の日付は指定できません");
			return;
		}
		int age = getAge(birthday);
		System.out.println("あなたは" + age + "歳です");

	}
	
	private static int getAge(LocalDate birthday) {
		return Period.between(birthday, LocalDate.now()).getYears();
	}
	
	private static LocalDate getDate(String dateTxt) {
		try {
			return LocalDate.parse(dateTxt, DTF);
		} catch (DateTimeParseException e) {
			System.out.println("日付を正しく入力してください");
			return null;
		}
	}

}
