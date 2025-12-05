package code15_5;

public class Main {

	public static void main(String[] args) {
		String name1 = "A0023456";
		String name2 = "A002345b";
		if (isValidPlayerName(name1)) {
			System.out.println("正しい名前です");
		} else {
			System.out.println("不正な名前です");
		}

	}
	public static boolean isValidPlayerName(String name) {
		return name.matches("[A-Z][A-Z0-9]{7}");
	}
	
	public static boolean isValidPlayerNameOld(String name) {
		if (name.length() != 8) {
			return false;
		}
		char first = name.charAt(0);
		if (!(first >= 'A' && first <= 'Z')) {
			return false;
		}
		for (int i = 1; i < 8; i++) {
			char c = name.charAt(i);
			if (!((c >= 'A' && c <= 'Z') || 
				  (c >= '0' && c <= '9'))) {
						return false;
					}
		}
		return true;
	}

}
