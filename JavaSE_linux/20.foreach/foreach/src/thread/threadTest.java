package thread;

public class threadTest {
	
	public static void main(String[] args) {
		/* 父类
		 * 父类指向子类的对象，继承，重写
		 */
		Thread th = new Thread1();
		threadRunnable th2 = new threadRunnable();
		Thread thd = new Thread(th2);
		th.start();
		thd.start();
		for(int j = 1; j <=10; j++) {
			System.out.println("main-->" + j);
		}

		
	}
}
