package code15_4;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		useSB();  // 10
		// notUseSB();  // 3250
		long end = System.currentTimeMillis();
		System.out.println
		  ("処理にかかった時間は" + (end - start) + "ミリ秒でした");
	}
	
	public static void notUseSB() {
		String s = "";
		for (int i = 0; i < 100000; i++) {
			s = s + "Java";
		}
		// System.out.println(s);
	}
	
	public static void useSB() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append("Java");
		}
		String s = sb.toString();
		// System.out.println(s);
	}

}
