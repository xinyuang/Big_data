package TypeConverter;

import java.util.Random;
import java.util.Scanner;

public class array_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] d = new double[3];
		double data[] = new double[] {1.2, 2.3, 1.3};
		d[0] = 1.2;
		d[1] = 12.3;
		d[2] = 12.4;
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		Scanner scan = new Scanner(System.in);
		double scores[] = new double[3];
		for (int i = 0; i < scores.length; i++) {
			System.out.println("score input:");
			scores[i] = scan.nextDouble();	
		}
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int indx = rand.nextInt(3);
			System.out.println(scores[indx]);
		}
	}

}