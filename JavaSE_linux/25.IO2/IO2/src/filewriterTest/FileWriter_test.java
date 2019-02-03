package filewriterTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_test {
    public static void main(String[] args) {
		File file = new File("writer.txt");
		String str = "wersdfsdfsdf";
		String str2 = "gooooooooood";
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.append(str);
			//writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
