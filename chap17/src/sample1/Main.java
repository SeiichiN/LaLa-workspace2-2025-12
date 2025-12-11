package sample1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			System.out.println("ごめんね");
			// e.printStackTrace();
		}
		System.out.print("数字 > ");
		try {
			int num = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字をいれてね");
		}

	}

}
