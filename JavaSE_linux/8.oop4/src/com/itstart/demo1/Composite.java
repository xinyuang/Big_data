package com.itstart.demo1;
/**
 *  
 * 综合测试
 * @version 1.0
 * @author xinyu
 *
 */
public class Composite {
	private static int a = 1;
	//
	static {
		System.out.println("static block");
	}
	{
		System.out.println("constructor block");
	}
	public Composite() {
		System.out.println("constructor function");
	}
	
	
}
