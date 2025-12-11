package ex16_3;

import java.util.HashMap;
import java.util.Map;

import ex16_2.Hero;

public class Main {

	public static void main(String[] args) {
		Hero h1 = new Hero("斎藤");
		Hero h2 = new Hero("鈴木");
		Map<Hero, Integer> hMap = new HashMap<>();
		hMap.put(h1, 3);
		hMap.put(h2, 7);
		for (Hero h : hMap.keySet()) {
			int value = hMap.get(h);
			System.out.println(h.getName() + "の倒した敵=" + value);
		}

	}

}
