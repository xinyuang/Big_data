package multitask_priority;
/**
 * 线程优先级
 * @author xinyu
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println("highest" + Thread.MAX_PRIORITY);
		System.out.println("lowest" + Thread.MIN_PRIORITY);
		System.out.println("default" + Thread.NORM_PRIORITY);
		ThreadTest thtest = new ThreadTest();
		Thread th = new Thread(thtest);
		System.out.println(th.getPriority());
		Thread th2 = new Thread(thtest);
		th.setName("THREAD1");
		th2.setName("thead2");
		th2.setPriority(10);
		th.start();
		th2.start();
		
	}
}
