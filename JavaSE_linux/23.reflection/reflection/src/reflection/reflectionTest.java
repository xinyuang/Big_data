package reflection;

public class reflectionTest {
	public static void main(String[] args) {
		student stu1 = new student();
		//方法1： Object->getClass()
		Class stuClass = stu1.getClass();
		System.out.println(stuClass.getName());
		System.out.println(stuClass.getPackageName());
		
		//方法2： 用.class属性
		Class stuClass2 = student.class;
		System.out.println(stuClass == stuClass2);
		
		//方法3：
		
		try {
			Class stuClass3 = Class.forName("reflection.student");
			System.out.println(stuClass == stuClass3);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
