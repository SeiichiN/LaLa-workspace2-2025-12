package main;

import util.Utility;

public abstract class Monster {
	public String name;
	public int hp;
	public char suffix;
	
	public Monster(char suffix, String name, int hp) {
		this.name = name;
		this.suffix = suffix;
		this.hp = hp;
	}
	
	public void attack(Player player) {
		if (this.hp <= 0) return;
		System.out.println("\n" + name + "は" + player.name + "を攻撃した!");
		int damage = Utility.RND.nextInt(30);
		player.hp -= damage;
		System.out.println(player.name + "は" + damage + "のダメージを受けた!");
	}
}
