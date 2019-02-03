package serialization;

import java.io.Serializable;

public class student implements Serializable{
	private String name;
	private int age;
	public student() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "student [name = " + name + "age = " + age + "]";
	}
}