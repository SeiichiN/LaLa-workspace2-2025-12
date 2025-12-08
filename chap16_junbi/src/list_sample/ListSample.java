package list_sample;

public class ListSample {

	public static void main(String[] args) {
		Hero hero = new Hero("勇者");
		hero.hp -= 50;
		hero.mp -= 20;
		hero.takeItem(new Potion());
		hero.takeItem(new Potion());
		hero.takeItem(new Ether());
		hero.takeItem(new Ether());
		hero.showStatus();
		hero.useItem();
		hero.showStatus();
	}

}
