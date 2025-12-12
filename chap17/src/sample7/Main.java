package sample7;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		try {
			p.setAge(-128);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
