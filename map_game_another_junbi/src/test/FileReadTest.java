package test;

import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("player.properties");
		int input = fr.read();
		while (input != -1) {
			System.out.print((char) input);
			input = fr.read();
		}
		fr.close();
	}

}
