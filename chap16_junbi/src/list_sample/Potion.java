package list_sample;

public class Potion extends Item {
	int recovHp = 100;
	
	public Potion(String name) {
		super(name);
	}
	public Potion() {
		this("ポーション");
	}

}
