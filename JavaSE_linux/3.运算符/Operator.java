/**
 *演示变量自增自减
 *@author Gxy
 *@version 1.0
 *
 */

public class Operator{
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		b = a++;
		c = ++a;
		d = --a;
		e = a--;
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);		
		
	}
	
	
	
}