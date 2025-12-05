package ex14_2;

import java.util.Random;

//
// 練習問題 8.6
//
public class Cleric {
	String name;
	int hp = 50;
	static final int MAX_HP = 100;
	int mp = 10;
	static final int MAX_MP = 50;
	
	/**
	 * 祈った秒数をもとにMPを回復する
	 * @param sec 秒を指定する
	 * @return 実際に回復したMPの数
	 */
	public int pray(int sec) {
		int nowMp = this.mp;
		Random rnd = new Random();
		int recovery = sec * rnd.nextInt(3);
		int newMp = Math.min(nowMp + recovery, Cleric.MAX_MP);
		System.out.println(this.name + "は" + sec + "秒祈った");
		System.out.println("MPが" + (newMp - nowMp) + "回復した");
		return newMp - nowMp;
	}
	
	public void selfAid() {
		this.mp -= 5;
		this.hp = Cleric.MAX_HP;
		System.out.println
		  (this.name + "はセフルエイドという魔法を使った");
		System.out.println("HPが回復した");
		System.out.println("MPを5消費した");
	}
}
