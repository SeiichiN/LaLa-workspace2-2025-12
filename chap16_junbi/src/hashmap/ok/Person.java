package hashmap.ok;

public class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof Person p) {
			return this.name.equals(p.name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
