package tools;

import java.util.Scanner;

public class InputUtil {
	Scanner sc = new Scanner(System.in);
	/**
	 * 一文字を入力するメソッド
	 * @param prompt 文字列 "wsad:移動 b:戦う t:取る u:使う q:終了 > "
	 * @return char
	 */
	public char getChar(String prompt) {
		System.out.print(prompt);
		char ch = ' ';
		try {
			ch = sc.nextLine().charAt(0);
		} catch (StringIndexOutOfBoundsException e) {
			;
		}
		return ch;
	}
}
