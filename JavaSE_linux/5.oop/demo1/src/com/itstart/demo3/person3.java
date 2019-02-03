package com.itstart.demo3;

public class person3 {
	private String name;
	private int age = 12;
	private char sex = 'x';
	private double weight = 70.8;
	private double height = 1.72;
	
	//constructor overload
	public person3() {
		System.out.println("zero input");
	}
	 public person3(String _name, char _sex) {
		 System.out.println("two inputs");
		 setName(_name);
		 setSex(_sex);
	 }

	 public person3(String _name, char _sex, int _age) {
		 System.out.println("three inputs");
		 setName(_name);
		 setSex(_sex);
		 age = _age;
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
