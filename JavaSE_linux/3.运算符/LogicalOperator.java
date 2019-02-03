/**
 *
 *
 */
 
 public class LogicalOperator{
	 public static void main(String[] args) {
		 int i = 1;
		 boolean flag = 5 < 2 & i++ < 4;
		 System.out.println("i = " + i);
		 System.out.println("Flag = " + flag);
		 // &&具有短路功能
		 int j = 1;
		 boolean flag1 = 5 < 2 && j++ < 4;
		 System.out.println("j = " + j);
		 System.out.println("Flag1 = " + flag1);
		 //
		 int k = 1;
		 boolean flag2 = 5 > 2 | k++ < 4;
		 System.out.println("k = " + k);
		 System.out.println("Flag2 = " + flag2);
		 // ||具有短路功能
		 int l = 1;
		 boolean flag3 = 5 > 2 || l++ < 4;
		 System.out.println("l = " + l);
		 System.out.println("Flag3 = " + flag3);
		 
		 boolean flag4 = true;
		 System.out.println("flag4 = " + flag4);
		 System.out.println("flag4 = " + !flag4);
	 }
	 
 }