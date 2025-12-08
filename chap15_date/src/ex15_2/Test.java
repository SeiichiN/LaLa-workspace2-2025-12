package ex15_2;

public class Test {

	public static void main(String[] args) {
		String folder = "c:\\javadev\\";
		String file = "readme.txt";
		String pathName = makePathName(folder, file);
		System.out.println(pathName);
	}

	public static String makePathName(String folder, String file) {
		if (folder.endsWith("\\")) {
			folder.replace("\\", "");
		}
		return folder + "\\" + file;
	}
}
