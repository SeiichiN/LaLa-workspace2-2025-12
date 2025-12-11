package set_extends;

public class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Person p) {
			if (this.name.equals(p.name))
				return true;
		}
		return false;
	}
}
