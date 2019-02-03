package com.itstart.demo3;

public class extendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student stu = new student();
		stu.setStdNum("1819");
		stu.setName("Gxy");
		System.out.println(stu.getName() + stu.getStdNum());
		teacher tc = new teacher();
		tc.eat();
	}

}
