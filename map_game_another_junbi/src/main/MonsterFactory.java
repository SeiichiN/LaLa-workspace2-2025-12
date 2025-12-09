package main;

public class MonsterFactory {

	public static Monster createMonster(char type) {
		return switch (type) {
		case 'g' -> new Goblin();
		case 's' -> new Slime();
		default -> null;
		};
	}
}
