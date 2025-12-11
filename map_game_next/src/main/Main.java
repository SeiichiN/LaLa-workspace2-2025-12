package main;

public class Main {

	public static void main(String[] args) {
		GameManager gm = new GameManager();

		gm.setPosition('g');
		gm.setPosition('g');
		gm.setPosition('s');
		gm.setPosition('p');
		gm.setPosition('e');
		Player player = new Player(gm);
		gm.printMap(player);

		while(true) {
			player.look();
			player.command();
			if (gm.isEnd()) {
				break;
			}
			gm.printMap(player);
		}
		
	}

}
