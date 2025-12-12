package main;

import tools.Settings;

public class GameManager {
	char[][] map;
	private boolean isEnd = false;
	
	public GameManager() {
		this.map = new char[Settings.YSIZE][Settings.XSIZE];
		initMap();
	}
	
	public void initMap() {
		for (int y = 0; y < Settings.YSIZE; y++) {
			for (int x = 0; x < Settings.XSIZE; x++) {
				map[y][x] = '.';
			}
		}		
	}
	
	public void setPosition(char c) {
		int y, x;
		do {
			y = new java.util.Random().nextInt(5);
			x = new java.util.Random().nextInt(5);
		} while(map[y][x] != '.');
		map[y][x] = c;		
	}
	

	
	public void printMap(Player p) {
		for (int y = 0; y < Settings.YSIZE; y++) {
			for (int x = 0; x < Settings.XSIZE; x++) {
				if (y == p.py && x == p.px) {
					System.out.print("|" + '@');
				} else {
					System.out.print("|" + map[y][x]);
				}
			}
			System.out.println("|");
		}		
	}
	
	public void battle(Player p) {
		char m = this.map[p.py][p.px];
		/*
		Monster mon = switch (m) {
		case 'g' -> new goblin();
		case 's' -> new Slime();
		default -> new Object();
		}
		p.attack(mon);
		mon.attack(p);
		*/
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean isEnd() {
		return isEnd;
	}
}
