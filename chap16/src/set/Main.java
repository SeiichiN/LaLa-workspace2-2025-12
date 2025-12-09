package set;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<String> colors = new HashSet<>();
		// colors.add("赤");
		colors.add("青");
		colors.add("黄");
		colors.add("赤");
		System.out.println("色は" + colors.size() + "種類");
		for (String s : colors) {
			System.out.print(s + "→");
		}
	}

}
