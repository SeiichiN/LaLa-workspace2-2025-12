package rensyu;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AgeCalculatorWithTime {

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = new Scanner(System.in).nextLine();
		LocalDate birthday = getDate(birth);
		if (birthday == null) return;
		if (birthday.isAfter(LocalDate.now())) {
			System.out.println("未来の日付は指定できません");
			return;
		}
		int age = getAge(birthday);
		System.out.println("年齢は" + age + "歳です");
	}
	
	public static int getAge(LocalDate birthday) {
		Period p = Period.between(birthday, LocalDate.now());
		return p.getYears();
	}

	/**
	 * 日付文字列から日付オブジェクトを返す
	 * @param dateTxt 文字列
	 * @return LocalDateオブジェクト
	 */
	public static LocalDate getDate(String dateTxt) {
		DateTimeFormatter fmt =
				DateTimeFormatter.ofPattern("yyyy/MM/dd");
				  		// .withResolverStyle(ResolverStyle.STRICT);
		LocalDate d = null;
		try {
			d = LocalDate.parse(dateTxt, fmt);
		} catch (DateTimeParseException e) {
			System.out.println("正しい日付ではありません");
			return null;
		}
		return d;
	}
}
