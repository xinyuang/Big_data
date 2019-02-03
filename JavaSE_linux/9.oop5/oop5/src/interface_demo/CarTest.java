package interface_demo;
/**
 * 抽象接口的调用测试
 * @author xinyu
 *
 */
public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Polymorphism 多态允许基类的引用指向子类的对象
		Engine v4 = new V4Engine();
		// 继承，重写，父类 指向子类 
		Car byd = new BYD(v4);
		byd.run();
		Engine v8 = new V8Engine();
		Car bmw = new BMW(v8);
		bmw.run();
		// 多态核心-- 动态绑定
	}

}
