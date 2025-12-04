package rensyu;

public class Goblin {
	String name;
	int hp;
	
	public Goblin(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		return "名前:" + name + " HP:" + hp;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; } 
		if (o instanceof Goblin g) {
			if (this.name.equals(g.name) && this.hp == g.hp) {
				return true;
			}
		}
		return false;
	}
	
}
