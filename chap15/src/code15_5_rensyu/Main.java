package code15_5_rensyu;

public class Main {

	public static void main(String[] args) {
		String email = "abc234@wanaha.com";
		if (isValidMail(email)) {
			System.out.println("正しいメルアドです");
		} else {
			System.out.println("不正なメルアドです");
		}
	}
	
	private static boolean isValidMail(String address) {
		return address.matches(".+@.+\\..+");
	}
}
