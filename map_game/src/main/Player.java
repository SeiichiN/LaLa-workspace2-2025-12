package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tools.Factory;
import tools.InputUtil;
import tools.Settings;

public class Player {
	String name;
	int py;
	int px;
	GameManager gm;
	List<Item> items = new ArrayList<>();
	Random rnd = new Random();
	
	public Player(GameManager gm) {
		this.gm = gm;
		this.name = "プレーヤー";
		py = rnd.nextInt(Settings.YSIZE);
		px = rnd.nextInt(Settings.XSIZE);
	}
	
	public void look() {
		char ch = gm.map[py][px];
		String s = switch (ch) {
		case '.' -> "何も見当たらない";
		case 'g' -> "ゴブリンが現れた！";
		case 's' -> "スライムが現れた！";
		case 'p' -> "ポーションがあった！";
		default -> "";
		};
		System.out.println(s);
	}
	
	public void command() {
		char ch = new InputUtil().getChar
				("wsad:移動 b:戦う t:取る u:使う q:終了 > ");
		
		switch (ch) {
		case 'w' -> moveUp();
		case 's' -> moveDown();
		case 'a' -> moveLeft();
		case 'd' -> moveRight();
		case 'b' -> gm.battle(this);
		case 't' -> take();
		case 'q' -> endGame();
		}
	}
	
	public void take() {
		char ch = this.gm.map[py][px];
		Item item = Factory.createItem(ch);
		this.items.add(item);
		this.gm.map[py][px] = '.';
	}
	
	private void moveUp() {
		py--;
		if (py < 0) py = 0;
	}
	
	private void moveDown() {
		py++;
		if (py >= Settings.YSIZE) py = Settings.YSIZE - 1;
	}
	
	private void moveLeft() {
		px--;
		if (px < 0) px = 0;
	}
	
	private void moveRight() {
		px++;
		if (px >= Settings.XSIZE) px = Settings.XSIZE - 1;
	}
	
	private void endGame() {
		System.out.println("終了します");
		gm.setEnd(true);
	}
}
