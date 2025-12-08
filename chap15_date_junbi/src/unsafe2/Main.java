package unsafe2;

import java.util.Date;

public class Main {
    public static final Date sharedDate = new Date();

	public static void main(String[] args) {
        Thread t1 = new ReadThread();
        Thread t2 = new WriteThread();
		t1.start();
		t2.start();
	}

}
