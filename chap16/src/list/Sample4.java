package list;

import java.util.LinkedList;
import java.util.List;

public class Sample4 {

	public static void main(String[] args) {
		
		List<String> names = new LinkedList<>(); 
		names.add("たなか");  // 0
		names.add("すずき");  // 1
		names.add("さいとう");  // 2
		for (String s : names) {
			System.out.println(s);
		}
	}

}
