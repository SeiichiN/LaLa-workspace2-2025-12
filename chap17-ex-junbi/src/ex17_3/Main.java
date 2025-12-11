package ex17_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num = getNumber();
		System.out.println("入力された整数は" + num + "です");
	}
	
	public static int getNumber() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.print("整数を入力してください > ");
			String numTxt = sc.nextLine();
			try {
				num = Integer.parseInt(numTxt);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("整数ではありません");
			}
		}
	}

}
