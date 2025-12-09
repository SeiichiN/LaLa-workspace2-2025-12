package main;

public class MonsterFactory {
	public static Monster createMonster(char type) {
		Monster m = switch (type) {
		case 's' -> new Slime();
		case 'g' -> new Goblin();
		default -> null;
		};
		return m;
	}
}
