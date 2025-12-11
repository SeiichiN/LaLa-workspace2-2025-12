package sample2;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("data.txt");
			fw.write("HelloHello!");
			fw.close();
			System.out.println("書き込み成功");
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("エラーです。中断します。");
		}
	}

}
