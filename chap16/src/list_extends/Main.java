package list_extends;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Hero h = new Hero("ミナト");
		final List<Hero> list = new ArrayList<>();
		list.add(h);
		// listの中身は変更できない
		System.out.println(list.get(0).getName());  

	}

}
