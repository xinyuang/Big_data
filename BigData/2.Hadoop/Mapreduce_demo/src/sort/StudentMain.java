package sort;

import java.util.Arrays;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		s1.setStuID(1);
		s1.setAge(24);
		s1.setStuName("Tom");
		
		Student s2 = new Student();		
		s2.setStuID(2);
		s2.setAge(20);
		s2.setStuName("Marry");

		Student s3 = new Student();
		s3.setStuID(3);
		s3.setAge(19);
		s3.setStuName("Mike");
		
		Student[] list = {s1, s2, s3};
		Arrays.sort(list);
		
		for(Student s:list) {
			System.out.println(s);
		}
	}

}
