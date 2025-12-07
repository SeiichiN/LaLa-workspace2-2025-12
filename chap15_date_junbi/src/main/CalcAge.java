package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcAge {

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = new Scanner(System.in).nextLine();
		Date birthday = getDate(birth);
		if (birthday == null) {
			System.out.println("日付を正しく入力してください");
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
		int birthMonth = birth.get(Calendar.MONTH);
		int todayMonth = today.get(Calendar.MONTH);
		if (birthMonth > todayMonth) {
			age--;
		}
		if (birthMonth == todayMonth) {
			int birthDay = birth.get(Calendar.DAY_OF_MONTH);
			int todayDay = today.get(Calendar.DAY_OF_MONTH);
			if (birthDay > todayDay) {
				age--;
			}
		}
		
		return age;
	}
	
	private static Date getDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		Date d = null;
		try {
			d = sdf.parse(dateTxt);
		} catch (ParseException e) {
			return null;
		}
		return d;
	}

}
