package OutPut02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class outputStream01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "test tset set";
		File f = new File("test.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			fos.write(str.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

		}
		
	}

}
