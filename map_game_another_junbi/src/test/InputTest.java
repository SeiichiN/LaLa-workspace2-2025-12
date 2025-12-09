package test;

public class InputTest {

	public static void main(String[] args) {
		System.out.print(" > ");
		@SuppressWarnings("resource")
		char ch = new java.util.Scanner(System.in).next().charAt(0);
		System.out.println(ch);

	}

}
