package ex15_3;

public class Main {

	public static void main(String[] args) {
		String pattern1 = ".+";
		String pattern2 = "A\\d\\d?";
		if ("A3".matches(pattern2)) {
			System.out.println("match!");
		} else {
			System.out.println("NOt match!");
		}
		String pattern3 = "U[A-Z]{2,4}";
		if ("UADG".matches(pattern3)) {
			System.out.println("match!");
		} else {
			System.out.println("NOt match!");
		}
	}

}
