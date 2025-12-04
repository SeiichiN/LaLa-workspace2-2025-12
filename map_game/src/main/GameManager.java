package main;

public class GameManager {
	public final int YSIZE;
	public final int XSIZE;
	char[][] map;
	private boolean isEnd = false;
	
	public GameManager(int ysize, int xsize) {
		this.YSIZE = ysize;
		this.XSIZE = xsize;
		this.map = new char[YSIZE][XSIZE];
		initMap();
	}
	
	public GameManager() {
		this(5, 5);
	}
	
	public void initMap() {
		for (int y = 0; y < YSIZE; y++) {
			for (int x = 0; x < XSIZE; x++) {
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
		for (int y = 0; y < YSIZE; y++) {
			for (int x = 0; x < XSIZE; x++) {
				if (y == p.py && x == p.px) {
					System.out.print("|" + '@');
				} else {
					System.out.print("|" + map[y][x]);
				}
			}
			System.out.println("|");
		}		
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean isEnd() {
		return isEnd;
	}
}
