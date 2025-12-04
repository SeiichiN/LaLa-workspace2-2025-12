package main;

import java.util.Random;
import java.util.Scanner;

public class Player {
	String name;
	int py;
	int px;
	GameManager gm;
	Random rnd = new Random();
	Scanner sc = new Scanner(System.in);
	
	public Player(GameManager gm) {
		this.gm = gm;
		this.name = "プレーヤー";
		py = rnd.nextInt(gm.YSIZE);
		px = rnd.nextInt(gm.XSIZE);
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
		System.out.print
		  ("wsad:移動 b:戦う t:取る u:使う q:終了 > ");
		char ch = sc.nextLine().charAt(0);
		switch (ch) {
		case 'w' -> moveUp();
		case 's' -> moveDown();
		case 'a' -> moveLeft();
		case 'd' -> moveRight();
		case 'q' -> endGame();
		}
	}
	
	private void moveUp() {
		py--;
		if (py < 0) py = 0;
	}
	
	private void moveDown() {
		py++;
		if (py >= gm.YSIZE) py = gm.YSIZE - 1;
	}
	
	private void moveLeft() {
		px--;
		if (px < 0) px = 0;
	}
	
	private void moveRight() {
		px++;
		if (px >= gm.XSIZE) px = gm.XSIZE - 1;
	}
	
	private void endGame() {
		System.out.println("終了します");
		gm.setEnd(true);
	}
}
