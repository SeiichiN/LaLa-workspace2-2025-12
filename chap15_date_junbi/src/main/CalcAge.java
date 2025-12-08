package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcAge {
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = SC.nextLine();
		Date birthday = getDate(birth);
		if (birthday == null) {
			System.out.println("日付を正しく入力してください");
			return;
		}
		if (birthday.after(new Date())) {
			System.out.println("未来の日付は指定できません");
			return;
		}
		int age = getAge(birthday);
		System.out.println("あなたは" + age + "歳です");

	}
	
	private static int getAge(Date birthday) {
		Calendar today = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
	
	private static Date getDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			return sdf.parse(dateTxt);
		} catch (ParseException e) {
			return null;
		}
	}

}
