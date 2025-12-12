package ex17_1;

public class Main {

	public static void main(String[] args) {
		
		String s = null;
		try {
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerExcdptionをcatchしました");
			System.out.println("スタックトレース（ここから）ーー");
			e.printStackTrace();
			System.out.println("スタックトレース（ここまで）ーー");
		}

	}

}
