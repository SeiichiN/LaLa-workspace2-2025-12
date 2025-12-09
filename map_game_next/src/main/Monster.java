package main;

import java.util.Random;

public abstract class Monster {
	public String name;
	public int hp;
	private Random rnd = new Random();
	
	public Monster(String name) {
		this.name = name;
		this.hp = 100;
	}
	
	public void attack(Player p) {
		if (this.hp < 0) return;
		System.out.println(this.name + " は " + p.name + " を攻撃した!");
		int damage = rnd.nextInt(30) + 1;
		if (damage < 0) damage = 0;
		p.hp -= damage;
		System.out.println(p.name + " に " + damage + " ポイントのダメージ!");
		
	}
}
