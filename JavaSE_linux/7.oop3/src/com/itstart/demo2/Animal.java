package com.itstart.demo2;

public class Animal {
	private String name;
	private static String type;
	static {
		type ="animal";
		System.out.println("构造代码块执行");
	}
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
