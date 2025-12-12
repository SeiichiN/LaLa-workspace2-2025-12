package ex17_3;

import java.util.Scanner;

public class GetNumber {
	static final Scanner SC = new Scanner(System.in);

	public int get() {
		int num = 0;
		while (true) {
			System.out.print("数字を入力してください > ");
			String numTxt = SC.nextLine();
			try {
				num = Integer.parseInt(numTxt);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("数字ではありません");
			}
		}
	}

	
}
