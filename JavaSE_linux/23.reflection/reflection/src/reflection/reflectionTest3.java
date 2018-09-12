package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class reflectionTest3 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		//1先获得stuClass 对象
		Class stuClass = Class.forName("reflection.student");
		Field[] fieldArray = stuClass.getFields();
		for(Field f : fieldArray) {
			System.out.println(f);
		}
		System.out.println("-----------------");
		Field[] fieldArray2 = stuClass.getDeclaredFields();
		for(Field f : fieldArray2) {
			System.out.println(f);
		}
		
		//使用成员变量
		Field f = stuClass.getDeclaredField("phoneNum");
		System.out.println(f);
		Field f2 = stuClass.getDeclaredField("name");
		System.out.println(f2);
		f2.setAccessible(true);
		f.setAccessible(true);
		Object obj = stuClass.getDeclaredConstructor().newInstance();
		f2.set(obj, "Monkey");
		f.set(obj, "1234");
		System.out.println(obj);
	}
}
