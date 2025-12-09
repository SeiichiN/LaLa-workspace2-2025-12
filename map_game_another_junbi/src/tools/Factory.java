package tools;

import main.Goblin;
import main.Item;
import main.Monster;
import main.Potion;
import main.Slime;

public class Factory {

	public static Monster createMonster(char type) {
		return switch (type) {
		case 'g' -> new Goblin();
		case 's' -> new Slime();
		default -> null;
		};
	}
	
	public static Item createItem(char type) {
		return switch (type) {
		case 'p' -> new Potion();
		default -> null;
		};
	}
}
