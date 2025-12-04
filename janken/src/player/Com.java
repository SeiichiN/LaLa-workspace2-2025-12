package player;

import java.util.Random;

public class Com extends Player {
	
	public Com() {
		super("コム");
	}

	@Override
	public void selectHand() {
		int hand = new Random().nextInt(3);
		super.setHand(hand);
	}

}
