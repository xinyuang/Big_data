package ifelse;

import java.util.Scanner;

public class iftest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("月份");
		int month = scan.nextInt();
		System.out.println("输入的月份" + month);
		if (month == 12 || month == 1 || month == 2) {
			System.out.println("winter");
		} else if (month == 3 || month == 4 || month == 5) {
			System.out.println("spring");
		} else if (month == 6 || month == 7 || month == 8) {
			System.out.println("summer");
		} else if (month == 9 || month == 10 || month == 11) {
			System.out.println("summer");
		} else {
			System.out.println("???");
		}
		int number = scan.nextInt();
		switch(number) {
		case 10086:
			System.out.println("移动");
			break;
		case 10000:
			System.out.println("电信");
			break;	
		case 10010:
			System.out.println("联通");
			break;	
		default:
			System.out.println("unknown");
			break;
		}
	}
}