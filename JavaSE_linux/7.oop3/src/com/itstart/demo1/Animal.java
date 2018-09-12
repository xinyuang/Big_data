package com.itstart.demo1;

public class Animal {
	private String name;
	static String type ="animal";
	Animal(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.println("name" + name + ",type:" + type);
	}
	
	public static void cry() {
		System.out.println("type:" + type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		Animal.type = type;
	}
	
}
