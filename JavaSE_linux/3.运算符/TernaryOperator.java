/**
 *@author Gxy
 *@version 1.0
 */
public class TernaryOperator{
	public static void main(String[] args) {
		int a,b,c;
		a = 2;
		b = 3;
		c = a < b ? a++ : ++b;
		// c = a++ ? ++b
		System.out.println("c = " + c);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		//4, 2,4
	}
	
}