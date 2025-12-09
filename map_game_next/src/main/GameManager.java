package main;

import java.util.Random;

import util.Factory;
import util.InputUtil;

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
		Random rnd = new Random();
		int y, x;
		do {
			y = rnd.nextInt(this.YSIZE);
			x = rnd.nextInt(this.XSIZE);
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
	
	public void battle(Player p) {
		char ch = this.map[p.py][p.px];
		Monster m = Factory.createMonster(ch);
		if (m == null) return;
		while (p.hp > 0 && m.hp > 0) {
			p.attack(m);
			m.attack(p);
			System.out.println(p.name + ":" + p.hp + " " + m.name + ":" + m.hp);
			if (m.hp <= 0) {
				System.out.println(m.name + " を倒した!");
				this.map[p.py][p.px] = '.';
			}
			if (p.hp <= 0) {
				System.out.println(p.name + " は倒れた!");
				this.setEnd(true);
			}
			if (isRunAway()) {
				break;
			}
		}
	}
	
	private boolean isRunAway() {
		while (true) {
			char ch2 = InputUtil.getChar("a:攻撃 e:逃げる > ");
			if (ch2 == 'e') {
				return true;
			}
			else if (ch2 == 'a') {
				return false;
			} else {
				System.out.println("aかeを入力してください");
			}
		}
		
	}
}
