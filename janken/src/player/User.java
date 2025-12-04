package player;

import java.util.Scanner;

public class User extends Player {
	Scanner sc = new Scanner(System.in);

	public User() {
		super("ユーザー");
	}
	
	@Override
	public void selectHand() {
		System.out.print
		  ("選択 0:グー 1:チョキ 2:パー >");
		int hand = sc.nextInt(3);
		super.setHand(hand);
	}

}
