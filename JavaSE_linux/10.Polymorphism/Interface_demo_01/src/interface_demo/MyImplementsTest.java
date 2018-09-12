package interface_demo;
/**
 * 实现多个接口
 * @author xinyu
 *
 */
public class MyImplementsTest implements Interface01, interface02{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("01");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("02");
	}
	
	public static void main(String[] args) {
		MyImplementsTest test = new MyImplementsTest();
		test.test();
		test.run();
	}
}
