package main;

public class Hero {
	public static final int MONEY = 1000;
	static {
		showSelf();
	}
	{
		printSelf();
	}
	String name;
	int hp;
	
	public Hero() {
		this.name = "勇者";
		this.hp = 100;
	}
	
	public static void showSelf() {
		System.out.println("Heroクラスです");
		System.out.println("MONEYは" + Hero.MONEY + "円です");
	}
	public void printSelf() {
		System.out.println("this.nameは" + this.name + "です");
	}
	public String toString() {
		return name + ":" + hp;
	}
}
