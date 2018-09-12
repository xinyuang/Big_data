package com.itstart.demo3;

public class Person {
	private String name;
	private int age;
	private double height;
	
	Person() {
		
	}
	
	public void eat() {
		System.out.println("father eating");
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
