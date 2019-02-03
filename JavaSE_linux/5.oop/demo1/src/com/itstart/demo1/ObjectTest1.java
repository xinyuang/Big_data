package com.itstart.demo1;

public class ObjectTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectricCooker cooker1 = new ElectricCooker();
		cooker1.brand = "aroma";
		cooker1.color = "black";
		cooker1.price = 300;
		cooker1.volume = 50;
		cooker1.open();
		cooker1.cook();	
		cooker1.close();
	}

}
