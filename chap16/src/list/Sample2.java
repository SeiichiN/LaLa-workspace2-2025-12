package list;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>(); 
		names.add("たなか");  // 0
		names.add("すずき");  // 1
		names.add("さいとう");  // 2
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		for (String s : names) {
			System.out.println(s);
		}
	}

}
