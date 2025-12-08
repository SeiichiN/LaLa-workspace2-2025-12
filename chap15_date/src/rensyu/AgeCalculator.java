package rensyu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String birth = new Scanner(System.in).nextLine();
		Date birthday = getDate(birth);
		if (birthday.after(new Date())) {
			System.out.println("未来の日付は指定できません");
			return;
		}
		if (birthday != null) {
			int age = getAge(birthday);
			System.out.println("年齢は" + age + "歳です");
		}
	}
	
	/**
	 * 日付オブジェクトを受け取って、年齢を計算する
	 * @param birthday Dateオブジェクト
	 * @return 年齢(整数)
	 */
	public static int getAge(Date birthday) {
		Calendar today = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <
				birth.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
	
	/**
	 * 日付の文字列を受け取って、日付オブジェクトを返す
	 * @param dateTxt ("yyyy/MM/dd")
	 * @return Dateインスタンス
	 */
	public static Date getDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		Date d = null;
		try {
			d = sdf.parse(dateTxt);
		} catch (ParseException e) {
			// System.out.println(e.getMessage());
			System.out.println("正しい日付ではありません");
			return null;
		}
		return d;
	}

}
