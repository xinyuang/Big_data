package multitask_priority;
/**
 * 实现Runnable
 * 
 */
public class ThreadTest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("run====" + i);
		}
		
	}

}
