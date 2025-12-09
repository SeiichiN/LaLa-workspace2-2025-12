package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sample3 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>(); 
		names.add("たなか");  // 0
		names.add("すずき");  // 1
		names.add("さいとう");  // 2
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String s = it.next(); 
			System.out.println(s);
		}
	}

}
