package unsafe;

import java.util.Date;

public class Main {
    private static final Date sharedDate = new Date();

	public static void main(String[] args) {
        // スレッドA：Date を読み続ける
        new Thread(() -> {
            while (true) {
                System.out.println("A reads: " + sharedDate.getTime());
            }
        }).start();

        // スレッドB：Date を書き換え続ける
        new Thread(() -> {
            while (true) {
                sharedDate.setTime(System.currentTimeMillis());
            }
        }).start();
	}

}
