package main;

import player.Com;
import player.User;

public class GameManager {
	
	public void judge(User user, Com com) {
		int u = user.getHand();
		int c = com.getHand();
		if (u == c) {
			System.out.println("あいこです");
		} else if ((u + 1) % 3 == c) {
			System.out.println(user.getName() + "の勝ちです");
		} else {
			System.out.println(com.getName() + "の勝ちです");
		}
	}
}
