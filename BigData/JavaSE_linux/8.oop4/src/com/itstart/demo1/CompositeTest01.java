package com.itstart.demo1;

public class CompositeTest01 {
	static {
		System.out.println("主类构造代码块");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Composite cp = new Composite();
		System.out.println("main function");
	}
	static {
		System.out.println("主类构造代码块2");
	}
}
