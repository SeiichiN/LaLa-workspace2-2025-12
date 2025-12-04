package rensyu;

public class Main {

	public static void main(String[] args) {
		Goblin g1 = new Goblin("ゴブリン", 100);
		Goblin g2 = new Goblin("ゴブリン", 80);
		
		System.out.println(g1);
		System.out.println(g2);
		if (g1.equals(g2)) {
			System.out.println("同じゴブリンです");
		} else {
			System.out.println("違うゴブリンです");
		}

	}

}
