package com.itstar.demo1;

public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//抽象类不能直接实例化
		/*Printer p = new Printer();*/
		HPprinter HP = new HPprinter();
		HP.print();
		Cannonprinter CA = new Cannonprinter();
		CA.print();
		
	}

}