package com.itstart.demo02;

public class Tiger extends Animal{
	public String name = "tiger";
	public Tiger() {
		//super("tiger1", 2);
		//name = super.getName(); // name = super.name;
		System.out.println("子类无参构造");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
