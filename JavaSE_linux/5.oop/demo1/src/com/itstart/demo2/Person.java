package com.itstart.demo2;

public class Person {
	String name;
	int age = 12;
	char sex = 'M';
	double weight = 70.8;
	double height = 1.72;

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
		System.out.println( "name: " + name + " sex: " + sex);
	}
}
