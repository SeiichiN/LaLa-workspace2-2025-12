package main;

public abstract class Item {
	public String name;
	public char suffix;
	
	public Item(char suffix, String name) {
		this.suffix = suffix;
		this.name = name;
	}
}
