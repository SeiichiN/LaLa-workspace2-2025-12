package util;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class SettingUtil {
	private ReadSettings rs = new ReadSettings();

	public void execute() {
		printProperties();
		char ch = InputUtil.getChar("変更しますか? (y/n) > ");
		if (ch == 'y') {
			saveProperties();
		}
	}
	
	public void printProperties() {
		System.out.println("現在の設定");
		System.out.println("1. マップの行数:" + rs.YSIZE);
		System.out.println("2. マップの列数:" + rs.XSIZE);
		System.out.println("3. ゴブリンの数:" + rs.NUM_GOBLIN);
		System.out.println("4. スライムの数:" + rs.NUM_SLIME);
		System.out.println("5. ポーションの数:" + rs.NUM_POTION);
		System.out.println("6. プレイヤーの名前:" + rs.NAME);
	}
	
	public void saveProperties() {
		String ysize = "" + InputUtil.getNumStr("マップの行数 > ");
		String xsize = "" + InputUtil.getNumStr("マップの列数 > ");
		String goblin = "" + InputUtil.getNumStr("コゴブリンの数 > ");
		String slime = "" + InputUtil.getNumStr("スライムの数 > ");
		String potion = "" + InputUtil.getChar("ポーションの数 > ");
		String name = InputUtil.getStr("プレイヤーの名前 > ");

		Properties prop = new Properties();
		prop.setProperty("ysize", ysize);
		prop.setProperty("xsize", xsize);
		prop.setProperty("goblin", goblin);
		prop.setProperty("slime", slime);
		prop.setProperty("potion", potion);
		prop.setProperty("name", name);
		
		try (Writer writer = new OutputStreamWriter(
				new FileOutputStream("player.properties"), "UTF-8")) {
			prop.store(writer, "Player Settings");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("設定を保存しました");
		
	}

}
