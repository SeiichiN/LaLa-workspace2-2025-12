package code14_9;

public class Hero {
	static int money;
	
	String name;
	int hp;
	
	public Hero(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public static void setRandomMoney() {
		Hero.money = (int)(Math.random() * 1000);
	}
}
