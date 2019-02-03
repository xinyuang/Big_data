package demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMain {
	public static void main(String[] args) {
		Mybusiness obj = new MybusinessImpl();
		
		Mybusiness proxy = (Mybusiness) Proxy.newProxyInstance(TestMain.class.getClassLoader(),
				               obj.getClass().getInterfaces(),
				               new InvocationHandler() {
								
								@Override
								public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
									// TODO Auto-generated method stub
									if(method.getName().equals("method1")) {
										System.out.println("----proxy---");
									} else {
										return method.invoke(obj, args);
									}
									return null;
								}
							});
		
		proxy.method1();
		proxy.method2();
	}
}
