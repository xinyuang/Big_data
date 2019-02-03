package set3;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("hunter");
		array.add("young");
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		ArrayList<Person> arrayPer = new ArrayList<Person>();
		
		arrayPer.add(new Person("hunter", 18));
		arrayPer.add(new Person("young", 28));
		arrayPer.add(new Person("Zhao", 38));
		for (int i = 0; i < arrayPer.size(); i++) {
			System.out.println(arrayPer.get(i));
		}
	}
}
