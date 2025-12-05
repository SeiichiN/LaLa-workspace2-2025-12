package code15_9;

public class Main {

	public static void main(String[] args) {
		Hero[] heros = new Hero[3];
		heros[0] = new Hero("minato", "hero", 280);
	    heros[1] = new Hero("asaka", "witch", 32000);
		heros[2] = new Hero("sugawara", "sage", 41000);
		
		final String FORMAT = "%-9s %-13s 所持金%,6d\n";
		for (Hero hero : heros) {
			System.out.printf(FORMAT, hero.getName(), hero.getJob(), hero.getGold());
		}
	}
	// String s = String.format(FORMAT, hero.getName(), hero.getJob(), hero.getGold());
	// System.out.println(s);

}
