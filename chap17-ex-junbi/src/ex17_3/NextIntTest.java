package ex17_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextIntTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (num == 0) {
			System.out.print("整数を入力してください > ");
			try {
				num = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("整数ではありません");
			}
		}
		System.out.println("入力された整数は" + num + "です");			

	}

}
