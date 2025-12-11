package sample6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		sub();
	}
	
	public static void sub() {
		try {
			subsub();
		} catch (InputMismatchException e) {
			System.out.println("Error");
		}
	}
	public static void subsub() {
		System.out.print("数字 > ");
		int num = new Scanner(System.in).nextInt();
	}

}
