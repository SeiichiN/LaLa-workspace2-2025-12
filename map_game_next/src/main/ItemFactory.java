package main;

public class ItemFactory {
	public static Item createItem(char type) {
		Item item = switch (type) {
		case 'p' -> new Potion();
		case 'e' -> new Ether();
		default -> null;
		};
		return item;
	}
}
