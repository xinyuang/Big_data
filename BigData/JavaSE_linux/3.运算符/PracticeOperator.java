/**
 *@author Gxy
 *@version 1.0
 */
public class PracticeOperator{
	public static void main(String[] args) {
		int a,b,c;
		a = 1;
		b = a++*(++a);
		// 1 * 3 = 3, a = 3
		c = a++*(++a);
		// 3 * 5 = 15 a = 5
		// c = a++ ? ++b
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		//5,6,15
		int j = 0;
		for (int i = 0; i < 10; i++) {
			j++;
			
		}
		System.out.println("j = " + j);
	}
	
}