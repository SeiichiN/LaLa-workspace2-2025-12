package sample4;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String str = "hello";
		String file = "data.txt";
		
		try (FileWriter fw = new FileWriter(file);) {
			fw.write(str);
			System.out.println("書き込み成功");
		} catch(IOException e) {
			System.out.println("書き込みが失敗したよ");
		} catch(NullPointerException e) {
			System.out.println("nullだよ");
		}
	}

}
