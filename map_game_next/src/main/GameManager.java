package main;

import java.util.Scanner;

import util.InputUtil;

public class GameManager {
	public final int YSIZE;
	public final int XSIZE;
	char[][] map;
	private boolean isEnd = false;
	public final InputUtil util = new InputUtil();
	
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
			y = new java.util.Random().nextInt(this.YSIZE);
			x = new java.util.Random().nextInt(this.XSIZE);
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

	public void buttle(Player p) {
		char ch = this.map[p.py][p.px];
		Monster m = MonsterFactory.createMonster(ch);
		if (m == null) return;
		do {
			char ch2 = util.getChar("a:攻撃 e:逃げる > ");
			if (ch2 == 'e') {
				break;
			}
			if (ch2 == 'a') {
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
			}
		} while (p.hp > 0 && m.hp > 0);
	}
}
