package ex14_2;

public class Hero {
	public static int money = 1000;
	String name;
	int hp;
	
	public void printMoney1() {
		System.out.println("1.所持金は" + money + "円");
	}
	public void printMoney2() {
		System.out.println("2.所持金は" + this.money + "円");
	}
	public void printMoney3() {
		System.out.println("3.所持金は" + Hero.money + "円");
	}
}
