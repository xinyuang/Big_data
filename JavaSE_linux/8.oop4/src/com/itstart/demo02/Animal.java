package com.itstart.demo02;

/**
 * 
 * 测试父类 super 的用途
 * 
 * @version 1.0
 * @author xinyu
 *
 */
public class Animal {
	private String name = "Animal";
	private int age;
	public String color;
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	//
	public Animal() {
		System.out.println("父类无参构造");
	}

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("父类2参数构造");
	}

	public void sleep() {
		System.out.println(name + " is sleeping");
	}

	public void run() {
		System.out.println(name + " is running");
	}

	public void eat() {
		System.out.println(name + "is eating");
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

}
