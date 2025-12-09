package main;

public class Potion extends Item {
	public int recoveryHp = 100;
	
	public Potion() {
		this('p', "ポーション");
	}
	
	public Potion(char suffix, String name) {
		super(suffix, name);
	}

}
