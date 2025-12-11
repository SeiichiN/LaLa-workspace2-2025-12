package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import util.Factory;
import util.InputUtil;

public class Player {
	String name;
	int py;
	int px;
	int hp;
	int mp;
	GameManager gm;
	Random rnd = new Random();
	List<Item> items = new ArrayList<>();
	
	public Player(GameManager gm) {
		this.gm = gm;
		this.name = "プレーヤー";
		this.hp = 100;
		this.mp = 50;
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
		case 'e' -> "エーテルがあった！";
		default -> "";
		};
		System.out.println(s);
	}
	
	public void command() {
		char ch = InputUtil.getChar("wsad:移動 b:戦う t:取る u:使う i:状態 q:終了 > ");
		switch (ch) {
		case 'w' -> moveUp();
		case 's' -> moveDown();
		case 'a' -> moveLeft();
		case 'd' -> moveRight();
		case 'b' -> this.gm.battle(this);
		case 't' -> take();
		case 'u' -> use();
		case 'i' -> status();
		case 'q' -> endGame();
		}
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
	
	public void attack(Monster m) {
		if (this.hp < 0) return;
		System.out.println(this.name + " は " + m.name + " を攻撃した!");
		int damage = rnd.nextInt(30) + 1;
		m.hp -= damage;
		System.out.println(m.name + " に " + damage + " ポイントのダメージ!");
	}
	
	private void endGame() {
		System.out.println("終了します");
		gm.setEnd(true);
	}

	public void status() {
		System.out.print(this.name + " ");
		System.out.print("HP:" + this.hp);
		System.out.println(" MP:" + this.mp);
		printItemList();
	}

	private void printItemList() {
		System.out.print("持ち物 ");
		if (this.items.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				System.out.print((i+1) + "." + items.get(i).name + " ");
			}
		} else {
			System.out.print("なし");
		}
		System.out.println();  // 改行
	}

	public void take() {
		char ch = gm.map[py][px];
		Item item = gm.factory.createItem(ch);
		if (item == null) return;
		this.items.add(item);
		System.out.println
		  (this.name + "は持ち物に" + item.name + "を追加した");
		gm.map[py][px] = '.';
	}

	private Item selectItem() {
		printItemList();
		if (this.items.size() == 0) return null;
		int no = InputUtil.getNum("番号で選択してください > ");
		return items.get(no - 1);
	}

	/**
	 * アイテムがポーションならHPを回復する。
	 * エーテルならMPを回復する
	 * @param item
	 */
	private void useItem(Item item) {
		if (item instanceof Potion p) {
			this.hp += p.recovHp;
			if (this.hp > 100) this.hp = 100;
		} else if (item instanceof Ether e) {
			this.mp += e.recovMp;
			if (this.mp > 50) this.mp = 50;
		}
	}

	public void use() {
		// 1:ポーション 2:エーテル 3:ポーション
		// どれを使いますか？ > 
		Item item = selectItem();
		if (item == null) return;
		System.out.println
		  (this.name + "は" + item.name + "を使った");
		useItem(item);
		items.remove(item);
	}
}
