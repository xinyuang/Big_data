package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestMain {
	public static void main(String[] args) throws IOException {
		Student s = new Student();
		s.setStuID(1);
		s.setStuName("Tom");
		
		OutputStream out = new FileOutputStream("C:\\Users\\xinyu\\Dropbox\\gg\\Job_hunting\\big data\\BigData\\2.Hadoop\\tmp\\student.oos");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		
		oos.writeObject(s);
		
		oos.close();
		out.close();
	}
}
