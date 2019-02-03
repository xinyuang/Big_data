package IO01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Throws {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		FileInputStream fis2 = new FileInputStream("a.txt");
		fis2.read();
	}
}
