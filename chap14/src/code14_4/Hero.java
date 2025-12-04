package code14_4;

public class Hero {
	public String name;
	public int hp;
	
	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Hero h) {
			if (this.name.equals(h.name)) {
				return true;
			}
		}
		return false;
	}
	

}
