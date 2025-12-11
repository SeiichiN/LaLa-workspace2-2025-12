package ex17_1;

public class Main {

	public static void main(String[] args) {
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("例外発生");
			System.out.println("------------------");
			e.printStackTrace();
			System.out.println("------------------");
		}
		System.out.println("処理終了");

	}

}
