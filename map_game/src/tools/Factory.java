package tools;

import main.Ether;
import main.Item;
import main.Potion;

public class Factory {
	public static Item createItem(char ch) {
		Item item = switch(ch) {
		case 'p' -> new Potion();
		case 'e' -> new Ether();
		default -> null;
		};
		return item;
	}
}
