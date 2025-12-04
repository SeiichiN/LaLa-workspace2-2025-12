package code14_9;

public class Main {

	public static void main(String[] args) {
		Hero.setRandomMoney();
		System.out.println(Hero.money);
		Hero h1 = new Hero("ミナト", 100);
		System.out.println(h1.money);       

	}

}
