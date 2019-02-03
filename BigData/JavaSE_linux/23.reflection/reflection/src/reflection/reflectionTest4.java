package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获得方法并调用
 * @author xinyu
 *
 */
public class reflectionTest4 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class stuClass = Class.forName("reflection.student");
		Method[] method = stuClass.getDeclaredMethods();
		for (Method m : method) {
			System.out.println(m);
		}
		Object obj = stuClass.getDeclaredConstructor().newInstance();
		
		Method m = stuClass.getDeclaredMethod("show", String.class);
		m.setAccessible(true);
		m.invoke(obj, "xinyu");
	}
}
