package list;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {

	public static void main(String[] args) {
		
		List<Integer> points = new ArrayList<>();
		points.add(10);  // オートボクシング
		points.add(80);
		points.add(75);
		for (int i : points) {  // オートアンボクシング
			System.out.println(i);
		}

	}

}
