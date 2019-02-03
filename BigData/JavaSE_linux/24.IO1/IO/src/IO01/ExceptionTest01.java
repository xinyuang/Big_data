package IO01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = 10;
			int b = 0;
			float c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("wrong");
		}
		
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			
					
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			FileInputStream fis2 = new FileInputStream("a.txt");
			fis2.read();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("wrong1");
		} catch (IOException e) {
			System.out.println("wrong2");
		} finally {
			System.out.println("wrong3");
		}
		
		try {
			System.out.println("frey");
			FileInputStream fis3 = new FileInputStream("a.txt");
			fis3.read();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			System.out.println("finally");
		}
		
	    
	}

}
