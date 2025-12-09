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
	
	public static int getNum(String prompt) {
		while (true) {
			System.out.print(prompt);
			if (SC.hasNextInt()) {
				int num = SC.nextInt();
				return num;
			} else {
				System.out.println("数値を入力してください");
				SC.next();
			}
			
		}
	}
}
