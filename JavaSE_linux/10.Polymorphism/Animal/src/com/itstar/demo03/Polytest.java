package com.itstar.demo03;

public class Polytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal1; 
		animal1 = new Giraffe();
		animal1.eat();
		// cannot use run method animal3.run();

		//Giraffe animal3 = (Giraffe) animal1;
		((Giraffe) animal1).run();
		
	}

}
