package tree_set;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<String> words = new TreeSet<>();
		words.add("うし");
		words.add("あんこ");
		words.add("えいが");
		words.add("いぬ");
		for (String s : words) {
			System.out.print(s + "→");
		}
	}

}
