package ex15_2;

public class Main {

	public static void main(String[] args) {
		String folder1 = "c:\\javadev";
		String folder2 = "c:\\user\\";
		String file = "readme.txt";
		String pathName = makePathName(folder2, file);
		System.out.println(pathName);
	}
	
	public static String makePathName(String folder, String file) {
		if (folder.endsWith("\\")) {
			folder = folder.replace("\\", "");
		}
		return folder + "\\" + file;
	}

}
