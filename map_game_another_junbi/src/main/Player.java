package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.InputUtil;
import util.Utility;

public class Player {
	public String name = "プレイヤー";
	public int py;
	public int px;
	public final int MAX_HP;
	public int hp;
	public final int HP_RECOVERY_PER_MOVE;
	private final GameManager gm;
	private List<Item> items = new ArrayList<>();
	
	public Player(String name, GameManager gm) {
		this.name = name;
		this.gm = gm;
		this.MAX_HP = 100;
		this.hp = this.MAX_HP;
		this.HP_RECOVERY_PER_MOVE = 2;
		setRandomPos();
	}
	
	private void setRandomPos() {
		Random r = new Random();
		py = r.nextInt(gm.YSIZE);
		px = r.nextInt(gm.XSIZE);
	}
	
	public void command() {
		char ch = InputUtil.getChar("wsad:移動 b:戦う t:取る u:使う i:情報 q:終了 > ");
		switch (ch) {
			case 'w' -> moveUp();
			case 's' -> moveDown();
			case 'a' -> moveLeft();
			case 'd' -> moveRight();
			case 'b' -> gm.battle(this);
			case 't' -> this.take();
			case 'u' -> this.use();
			case 'i' -> this.printInfo();
			case 'q' -> this.setEndTrue();
		}
	}
	
	private void hpRecoveryUp() {
		hp = Math.min(MAX_HP, hp + HP_RECOVERY_PER_MOVE);
	}
	
	public void moveUp() {
		py = Math.max(0, py - 1);
		hpRecoveryUp();
	}
	
	public void moveDown() {
		py = Math.min(gm.YSIZE - 1, py + 1);
		hpRecoveryUp();
	}
	
	public void moveLeft() {
		px = Math.max(0, px - 1);
		hpRecoveryUp();
	}
	
	public void moveRight() {
		px = Math.min(gm.XSIZE - 1, px + 1);
		hpRecoveryUp();
	}
	
	public void setEndTrue() {
		this.gm.isEnd = true;
	}
	
	public void printInfo() {
		System.out.println("HP:" + this.hp + "/" + this.MAX_HP);
		printItems();
	}
	
	public void attack(Monster m) {
		if (this.hp <= 0) return;
		System.out.println("\n" + name + "は" + m.name + "を攻撃した!");
		int damage = Utility.RND.nextInt(30);
		m.hp -= damage;
		System.out.println(m.name + "は" + damage + "のダメージを受けた!");
	}
	
	public void look() {
		char ch = gm.map[py][px];
		String msg = switch(ch) {
		case 'g' -> "ゴブリンが現れた！";
		case 's' -> "スライムが現れた！";
		case 'p' -> "ポーションがあった！";
		default -> "何も見当たらない";
		};
		System.out.println(msg);
	}
	
	public void take() {
		char ch = gm.map[py][px];
		Item item = null;
		switch (ch) {
		case 'p' -> item = new Potion();
		}
		if (item == null) return;
		System.out.println(this.name + "は" + item.name + "を手に入れた!");
		this.items.add(item);
		gm.map[py][px] = '.';
	}
	
	public void printItems() {
		System.out.print("持ち物: ");
		if (items.size() == 0) {
			System.out.println("なし");
			return;
		}
		for (int i = 0; i < items.size(); i++) {
			System.out.print(i + 1 + ":" + items.get(i).name + " ");
		}
		System.out.println();
	}
	
	public Item selectItem() {
		printItems();
		int index = 0;
		while (true) {
			char ch = InputUtil.getChar("選択>");
			index = ch - '0';
			if (index >= 1 && index <= items.size()) break;			
		}
		Item item = items.get(index - 1);
		return item;
	}
	
	public void usePotion(Item item) {
		int nowHP = this.hp;
		if (item instanceof Potion) {
			Potion p = (Potion) item;
			this.hp = Math.min(this.hp + p.recoveryHp, this.MAX_HP);
			System.out.println("HPが" + (this.hp - nowHP) + "回復した!");
			items.remove(item);
		}
	}
	
	public void use() {
		if (this.items.size() == 0) {
			System.out.println("持ち物がありません");
			return;
		}
		Item item = selectItem();
		System.out.println(this.name + "は" + item.name + "を使った!");
		switch (item.suffix) {
		case 'p' -> usePotion(item);
		}
	}
	
}
