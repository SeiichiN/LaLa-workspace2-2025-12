package ex16_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Hero h1 = new Hero("斎藤");
		Hero h2 = new Hero("鈴木");
		List<Hero> heros = new ArrayList<>();
		heros.add(h1);
		heros.add(h2);
		for (Hero h : heros) {
			System.out.println(h.getName());
		}

	}

}
