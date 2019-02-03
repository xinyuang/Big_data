package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("a.txt");
		System.out.println(file.exists());
		System.out.println(file);
		System.out.println(file.isDirectory());
		File file2 = new File("C:\\");
		File[] files = file2.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				System.out.println(f.getName());				
			}

		}
		test01();
		test02();
	}
	
	public static void test01() {
		File f = new File("a.txt.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void test02() throws IOException {
		File f = new File("a.txt.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);		
			int data = fis.read();
			while(data != -1) {
				System.out.println((char)data);
				data = fis.read();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
