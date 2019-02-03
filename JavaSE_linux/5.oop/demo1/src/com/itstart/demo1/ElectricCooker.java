package com.itstart.demo1;

public class ElectricCooker {
	String brand;
	int volume;
	int price;
	String color;

	public void cook() {
		System.out.println(brand + " - cooking");
	}

	public void open() {
		System.out.println(brand + " - open");
	}

	public void sout() {
		System.out.println(brand + " - cook soup");
	}

	public void close() {
		System.out.println(brand + " - close");
	}
}
