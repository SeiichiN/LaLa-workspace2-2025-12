package hashmap.ng;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<Person, Integer> map = new HashMap<>();
		Person p1 = new Person("Taro");
		Person p2 = new Person("Taro");
		map.put(p1, 1);
		map.put(p2, 2);
		// entrySetを使う
		System.out.println("要素数:" + map.size());
		for (Map.Entry<Person, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey().name + ":" + entry.getValue());
		}
		// keySet()を使う
		for (Person person : map.keySet()) {
			Integer v = map.get(person);
			System.out.println(person.name + ":" + v);
		}

	}

}
