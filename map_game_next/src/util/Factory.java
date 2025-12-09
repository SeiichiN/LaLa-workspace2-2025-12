package util;

import main.Ether;
import main.Goblin;
import main.Item;
import main.Monster;
import main.Potion;
import main.Slime;

public class Factory {
	public static Item createItem(char type) {
		Item item = switch (type) {
		case 'p' -> new Potion();
		case 'e' -> new Ether();
		default -> null;
		};
		return item;
	}
	
	public static Monster createMonster(char type) {
		Monster m = switch (type) {
		case 's' -> new Slime();
		case 'g' -> new Goblin();
		default -> null;
		};
		return m;
	}

	
}
