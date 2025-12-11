package set_extends;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Person> pSet = new HashSet<>();
		Person p1 = new Person("Taro");
		Person p2 = new Person("Jiro");
		Person p3 = new Person("Taro");
		if (p1.equals(p3)) System.out.println("同じ");
		System.out.println("p1.hashCode:" + p1.hashCode());
		System.out.println("p3.hashCode:" + p3.hashCode());
		
		pSet.add(p1);
		pSet.add(p2);
		pSet.add(p3);
		System.out.println("要素数:" + pSet.size());

	}

}
