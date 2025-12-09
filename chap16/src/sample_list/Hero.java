package sample_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hero {
	String name;
	int hp = 100;
	int mp = 50;
	List<Item> items = new ArrayList<>();
	
	public Hero() {
		this.name = "ヒーロー";
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
			for (Item i : items) {
				System.out.print(i.name + " ");
			}
		} else {
			System.out.print("なし");
		}
		System.out.println();  // 改行
	}
	
	public void take(Item item) {
		this.items.add(item);
		System.out.println
		  (this.name + "は持ち物に" + item.name + "を追加した");
	}
	
	private Item selectItem() {
		for (int i = 0; i < items.size(); i++) {
			System.out.print((i+1) + "." + items.get(i).name + " ");
		}
		System.out.println();
		System.out.print("番号で選択してください > ");
		int no = new Scanner(System.in).nextInt();
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
		System.out.println
		  (this.name + "は" + item.name + "を使った");
		useItem(item);
		items.remove(item);
	}
}
