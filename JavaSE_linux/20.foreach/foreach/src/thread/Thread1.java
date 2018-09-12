package thread;
/**
 * Thread类继承实现线程的调用
 * @author xinyu
 *
 */
public class Thread1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 1; i <=10; i++) {
			System.out.println("run-->" + i);
		}
	}
}
