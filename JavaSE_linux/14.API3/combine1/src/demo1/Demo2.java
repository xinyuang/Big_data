package demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo2 {
		public static void main(String[] args) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
			String date = sdf.format(new Date());
			System.out.println(date);
		}
}