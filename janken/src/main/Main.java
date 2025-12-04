package main;

import player.Com;
import player.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.selectHand();
		user.printHand();
		
		Com com = new Com();
		com.selectHand();
		com.printHand();
		
		GameManager gm = new GameManager();
		gm.judge(user, com);
	}

}
