package list_sample;

import java.util.ArrayList;
import java.util.List;

public class Hero {
	String name;
	int hp = 100;
	int mp = 50;
	List<Item> items = new ArrayList<Item>();
	
	public Hero(String name) {
		this.name = name;
	}
	
	public void showStatus() {
		System.out.print("名前:" + name);
		System.out.print(" HP:" + hp);
		System.out.print(" MP:" + mp);
		System.out.println();
		showItems();
	}
	
	public void takeItem(Item item) {
		items.add(item);
	}
	
	public void useItem() {
		showItems();
		Item item = selectItem();
		if(item instanceof Potion p) {
			hp += p.recovHp;
		} else if(item instanceof Ether e) {
			mp += e.recovMp;
		}
		items.remove(item);
		System.out.println(name + "は" + item.name + "を使った");
	}
	
	private void showItems() {
		System.out.print("持ち物 ");
		for(int i = 0; i < items.size(); i++) {
			System.out.print(i+1 + ":" + items.get(i).name + " ");
		}
		System.out.println();
	}
	
	private Item selectItem() {
		System.out.print("アイテムを選択してください > ");
		int no = new java.util.Scanner(System.in).nextInt();
		Item item = items.get(no - 1);
		return item;
	}
}
