package util;

import java.util.Scanner;

public class InputUtil {
	public static final Scanner SC = new Scanner(System.in);
	
	public static char getChar(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = SC.nextLine();
			if (input.length() == 1) {
				return input.charAt(0);
			}
		}
	}
	
	public static String getStr(String prompt) {
		String input = "";
		while(input.isEmpty()) {
			System.out.print(prompt);
			input = SC.nextLine();
		}
		return input;
	}
	
	public static String getNumStr(String prompt) {
		String input = "";
		while (input.isEmpty()) {
			System.out.print(prompt);
			input = SC.nextLine();
			if (isNum(input)) break;
		}
		return input;
	}
	
	private static boolean isNum(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
