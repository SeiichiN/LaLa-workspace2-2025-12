package hashset.ng;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		Person p1 = new Person("Taro");
		Person p2 = new Person("Taro");
		System.out.println("p1.hashCode() " + p1.hashCode());
		System.out.println("p2.hashCode() " + p2.hashCode());
		set.add(p1);
		set.add(p2);

		System.out.println("要素数:" + set.size());
	}

}
