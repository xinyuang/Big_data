package poi;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class poi {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("test1.docx");
		FileInputStream is = new FileInputStream(file);
		XWPFDocument docx = new XWPFDocument(is);
		String text = docx.getText();
		System.out.println(text);
		docx.close();
	}

}