package unsafe2;

public class ReadThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("A reads: " + Main.sharedDate.getTime());
		}
	}
}
