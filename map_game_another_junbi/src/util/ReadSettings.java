package util;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ReadSettings {
	public final int YSIZE;
	public final int XSIZE;
	public final int NUM_GOBLIN;
	public final int NUM_SLIME;
	public final int NUM_POTION;
	public final String NAME;
	
	public ReadSettings() {
		Properties prop = new Properties();
		try (Reader reder = new InputStreamReader(
				new FileInputStream("player.properties"),
				StandardCharsets.UTF_8)) {
			prop.load(reder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.YSIZE = Integer.parseInt(prop.getProperty("ysize"));
		this.XSIZE = Integer.parseInt(prop.getProperty("xsize"));
		this.NUM_GOBLIN = Integer.parseInt(prop.getProperty("goblin"));
		this.NUM_SLIME = Integer.parseInt(prop.getProperty("slime"));
		this.NUM_POTION = Integer.parseInt(prop.getProperty("potion"));
		this.NAME = prop.getProperty("name");
	}
	
}
