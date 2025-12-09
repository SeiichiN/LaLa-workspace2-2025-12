package sample_list;

public class Main {

	public static void main(String[] args) {
		Hero h = new Hero();
		h.hp -= 40;
		h.mp -= 20;
		h.status();
		h.take(new Potion());
		h.take(new Ether());
		h.take(new Potion());
		h.use();
		h.status();
	}

}
