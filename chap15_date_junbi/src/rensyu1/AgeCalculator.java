package rensyu1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = new Scanner(System.in).nextLine();
		Date birthday = getDate(birth);
		if (birthday == null) return;
		if (birthday.after(new Date())) {
			System.out.println("未来の日付です");
			return;
		}
		int age = getAge(birthday);
		System.out.println("あなたは" + age + "歳ですね");
	}

	public static Date getDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			return sdf.parse(dateTxt);
		} catch (ParseException e) {
			System.out.println("正しい日付を入力してください");
			return null;
		}
	}
	
	public static int getAge(Date birthday) {
		Calendar today = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
}
