package sample7;

public class Person {
	int age;
	
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("年齢は０以上の数を指定すべきです。指定値=" + age);
		} 
		this.age = age;
		
	}
}
