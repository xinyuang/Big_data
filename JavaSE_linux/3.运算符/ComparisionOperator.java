import java.util.Scanner;
/**
 *@author Gxy;
 *@version 1.0
 *
 */
 
 public class ComparisionOperator{
	 public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.print("_请输入赵三身高：");
		//System.out.print("input height1：");
		 int height_1 = scan.nextInt();
		 System.out.print("_\n请输入李四身高：");
		//System.out.print("_\ninput height2：");
		 int height_2 = scan.nextInt();
		/* System.out.println("Ais higher than B？" + (height_1 > height_2));
		 System.out.println("A is shorter？" + (height_1 < height_2));
		 System.out.println("A is >= B？" + (height_1 >= height_2));
		 System.out.println("A <= B?" + (height_1 <= height_2));
		 System.out.println("A == B?" + (height_1 == height_2)); */
		 System.out.println("A赵三比李四高？" + (height_1 > height_2));
		 System.out.println("A赵三比李四矮？" + (height_1 < height_2));
		 System.out.println("A赵三有李四高？" + (height_1 >= height_2));
		 System.out.println("A赵三有李四矮？" + (height_1 <= height_2));
		 System.out.println("A赵三李四一样高？" + (height_1 == height_2)); 
	 }

 }