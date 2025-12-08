package unsafe2;

public class WriteThread extends Thread {
	@Override
	public void run() {
		while (true) {
			Main.sharedDate.setTime(System.currentTimeMillis());
		}
	}

}
