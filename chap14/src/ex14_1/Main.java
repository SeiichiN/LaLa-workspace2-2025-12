package ex14_1;

public class Main {

	public static void main(String[] args) {
		
		Account a1 = new Account("   4649  ", 1592);
		System.out.println(a1);
		Account a2 = new Account(" 4649", 1890);
		System.out.println(a2);
		if (a1.equals(a2)) {
			System.out.println("同じ口座");
		} else {
			System.out.println("違う口座");
		}
	}

}
