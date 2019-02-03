package com.itstart.demo2;

public class person2 {
	private String name;
	private int age = 12;
	private char sex = 'x';
	private double weight = 70.8;
	private double height = 1.72;
	//constructor has no 'void'
	public person2() {
		System.out.println("call constructor");
		
	}
	public void person2() {
		System.out.println("fake constructor");
		
	}
	public void setName(String N) {
		name = N;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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

	public String getName() {
		System.out.println(name);
		return name;
	}
	public void eat() {
		System.out.println(name + "is eating");
	}

	public void work() {
		System.out.println(name + " is working");
	}

	public void study() {
		System.out.println(name + " is studying");
	}

	public void sleep() {
		System.out.println(name + " is sleeping");
	}

	public void show() {
		System.out.println("name: " + name + " sex: " + sex);
	}
}
