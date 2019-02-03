package multitask_priority;
/**
 * 守护线程
 * @author xinyu
 *@version 1.0
 */
public class DeamonThreadTEST {
	public static void main(String[] args) {
		ThreadTest thtest = new ThreadTest();
		Thread th = new Thread(thtest);
		th.setName("用户线程");
		MyDaemon daemon = new MyDaemon();
		Thread dth = new Thread(daemon);
		dth.setDaemon(true);
		dth.setName("守护线程");
		
		dth.start();
		th.start();
	}

	
}
