package player;

public abstract class Player {
	private String name;
	private int hand;
	private String[] jhands = {"グー", "チョキ", "パー"};
	
	public Player(String name) {
		this.name = name;
	}
	
	public abstract void selectHand();
	
	public void printHand() {
		System.out.println
		  (this.name + "は" + jhands[hand]);
	}
	public void setHand(int hand) {
		this.hand = hand;
	}
	public int getHand() { 
		return this.hand;
	}
	public String getName() {
		return this.name;
	}
}
