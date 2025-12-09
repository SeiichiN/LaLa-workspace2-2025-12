package main;

public class Goblin extends Monster {
	
	public Goblin(char suffix, String name, int hp) {
		super(suffix, name, hp);
	}

	public Goblin() {
		this('g', "ゴブリン", 100);
	}
	
	public Goblin(int hp) {
		this('g', "ゴブリン", hp);
	}
	
}
