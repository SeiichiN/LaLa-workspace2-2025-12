package main;

import java.util.Random;

public class Slime extends Monster {
	
	public Slime(char suffix, String name, int hp) {
		super(suffix, name, hp);
	}

	public Slime() {
		this('s', "スライム", 100);
	}
	
	public Slime(int hp) {
		this('s', "スライム", hp);
	}

	@Override
	public void attack(Player player) {
		if (this.hp <= 0) return;
		Random r = new Random();
		if (r.nextBoolean()) {
			System.out.println("\n" + name + "は" + player.name + "に毒霧攻撃を発動した!");
			int damage = 10 + new java.util.Random().nextInt(30);
			player.hp -= damage;
			System.out.println(player.name + "は" + damage + "のダメージを受けた!");
		} else {
			super.attack(player);
		}
	}

	
}
