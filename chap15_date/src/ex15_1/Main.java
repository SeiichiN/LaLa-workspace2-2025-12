package ex15_1;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 100; i++) {
			sb.append(i).append(",");
		}
		String s = sb.toString();
		System.out.println(s);
		String[] ss = s.split(",");
	}

}
