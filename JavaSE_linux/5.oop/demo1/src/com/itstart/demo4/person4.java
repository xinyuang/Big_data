package com.itstart.demo4;

public class person4 {
	private String name;
	private int age = 12;
	private char sex = 'x';
	private double weight = 70.8;
	private double height = 1.72;

	// constructor overload
	public person4() {
		System.out.println("zero input");
	}

	public person4(String _name, char _sex) {
		System.out.println("two inputs");
		setName(_name);
		setSex(_sex);
	}

	public person4(String _name, char _sex, int _age) {
		System.out.println("three inputs");
		setName(_name);
		setSex(_sex);
		age = _age;
		System.out.println(this);
	}
	
	public void thisTest(String name, char sex) {
		this.name = name;
		this.setSex(sex);
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

	public char getSex() {
		return sex;
	}

	public void setSex(char s) {
		if (s == 'M' || s == 'F') {
			sex = s;
			System.out.println("set successfully!");
		} else {
			System.out.println("failed to set sex");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
