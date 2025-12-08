package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;

public class CheckDate {
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("誕生日を入力してください (yyyy/MM/dd)");
		String date1 = SC.nextLine();
		if (isValidDate(date1)) {
			System.out.println("正しい日付です");
		} else {
			System.out.println("日付が正しくありません");
		}

	}

	public static boolean isValidDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			Date d = sdf.parse(dateTxt);
			if (d == null) return false;
			if (d.after(new Date())) {
				System.out.println("未来の日付です");
				return false;
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean isValidDateNew(String dateTxt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd")
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateTxt, dtf);
		} catch(DateTimeParseException e) {
			return false;
		}
		return true;
	}
}
