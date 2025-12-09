package ex15_3;

public class Main {

	public static void main(String[] args) {
		String pattern1 = ".+";
		// isMatch("123", pattern1);
		String pattern2 = "A[0-9]{1,2}";
		// isMatch("A34", pattern2);
		// isMatch("A5", pattern2);
		// isMatch("A5B", pattern2);
		String pattern3 = "U[A-Z]{1,3}";
		isMatch("UABC", pattern3);
		isMatch("UABCD", pattern3);
	}
	
	public static void isMatch(String target, String pattern) {
		if (target.matches(pattern)) {
			System.out.println("マッチしました");
		} else {
			System.out.println("マッチしません");
		}
		
	}

}
