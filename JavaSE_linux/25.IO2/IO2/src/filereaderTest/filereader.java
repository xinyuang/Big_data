package filereaderTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class filereader {
	public static void main(String[] args) {
		File file = new File("test.txt");
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] cs = new char[3];
			int len;
			while((len = reader.read(cs) )!= -1) {
				System.out.println(len);
				String str = new String(cs, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
