package multitask_priority;
/**
 * 守护线程
 * @author xinyu
 *
 */
public class MyDaemon implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("守护线程");
		}
	}

}
