package com.itstart.demo1;

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Animal.type);
		Animal.cry();
		Animal a = new Animal("mouse");
		a.show();
		a.setType("啮齿动物");
		System.out.println(Animal.type);
	}

}
