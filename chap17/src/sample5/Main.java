package sample5;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String str = "hello";
		sub(str);
		System.out.println("処理完了");
	}
	
	public static void sub(String str) {
		try {
			subsub(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void subsub(String str) throws IOException {
	    FileWriter fw = new FileWriter("data.txt");
	    fw.write(str);
		System.out.println("書き込み成功");
	}

}
