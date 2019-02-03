package com.itstart.demo4;

public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person4 p4 = new person4("xinyu", 'F', 19);
		System.out.println(p4);
		person4 p5 = new person4("GM", 'M', 109);
		System.out.println(p5);
		System.out.println(p4);
		person4 p6 = new person4();
		p6.thisTest("tz", 'F');
	}

}
