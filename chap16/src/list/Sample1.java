package list;

import java.util.ArrayList;
import java.util.List;

public class Sample1 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>(); 
		names.add("たなか");  // 0
		names.add("すずき");  // 1
		names.add("さいとう");  // 2
		System.out.println(names.get(1));  // すずき
	}

}
