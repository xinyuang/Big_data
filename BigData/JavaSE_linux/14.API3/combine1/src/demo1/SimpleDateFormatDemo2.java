package demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		function();
	}
	public static void function() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2018-7-24");
		System.out.println(date);
	}
}
